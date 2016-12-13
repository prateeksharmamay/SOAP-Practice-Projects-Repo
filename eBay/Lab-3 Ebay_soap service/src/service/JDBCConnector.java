package service;
import java.sql.*;

public class JDBCConnector implements iMySqlService{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/ebay";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "system123#";
	   
	   // Function
	   private Connection createConnection() {
	   Connection conn = null;
	   
	   try{
		  
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      System.out.println("Connected to database...");
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
		   return conn;
	   }
	}//end createConnection
	   
	private void closeConnections(Connection conn, PreparedStatement stmt){
		System.out.println("Closing Connection");
		try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	}

	@Override
	public boolean insertUser(String email, String password,String fname, String lname, String lastLoginTime) {
		
		Connection conn = createConnection();
		PreparedStatement stmt = null;
		/*
		//With Connection Pooling
		Connection con = JDBCConnectorwithPooling.getDBInstance().getConnection();
	    PreparedStatement pstmt = null;*/
	    	
		boolean userInserted = false;
		System.out.println("Checking if user Exist...");
	      
	      
	      try{
	    	  String getUser = "select * from user where email = '"+email+"'";
	    	  stmt = conn.prepareStatement(getUser);
	    	  
		      ResultSet rs = stmt.executeQuery(getUser);
		      
		      if(rs.next() == true){
		    	  userInserted = false;
		    	  System.out.println("User Exist");
		      }
		      else{
		    	  System.out.println("New User...");
		    	  String insertUser = " insert into user (fname, lname, email, password) values (?, ?, ?, ?)";
		    	  
		    	  stmt = conn.prepareStatement(insertUser);
		    	  stmt.setString(1, fname);
		    	  stmt.setString(2, lname);
		    	  stmt.setString(3, email);
		    	  stmt.setString(4, password);
		    	  stmt.execute();
		    	  userInserted = true;
		    	  System.out.println("User Inserted...");
		    	  
		    	  
		    	  System.out.println("Inserting User Entry in last login table...");
		    	  String insertUserLastLogin = " insert into user_last_login (userEmail, lastLoginTime) values (?, ?)";
		    	  
		    	  stmt = conn.prepareStatement(insertUserLastLogin);
		    	  stmt.setString(1, email);
		    	  stmt.setString(2, lastLoginTime);
		    	  stmt.execute();
		    	  System.out.println("User Login Time Inserted...");
		      }
		      
		      //STEP 6: Clean-up environment
		      /*
		      //With Connection Pooling
		      MySqlConnect.returnConnectionToPool(con);*/
		      rs.close();
	      }catch (Exception e) {
			System.out.println("Error :"+e);
	      }finally {
	    	  closeConnections(conn,stmt);
	      }
		return userInserted;
	}

	@Override
	public boolean verifyUser(String email, String password) {
		/*
		//With Connection Pooling
		Connection con = JDBCConnectorwithPooling.getDBInstance().getConnection();
	    PreparedStatement pstmt = null;*/
		Connection conn = createConnection();
		PreparedStatement stmt = null;
		
		boolean validLogin = false;
		System.out.println("Checking User Login...");
	      
	      
	      try{
	    	  String verifyUser = "select * from user where email = '"+email+"' and password = '"+password+"'";
	    	  stmt = conn.prepareStatement(verifyUser);
	    	  
		      ResultSet rs = stmt.executeQuery(verifyUser);
		      
		      if(rs.next() == true){
		    	  validLogin = true;
		    	  System.out.println("Valid Login");
		      }
		      else{
		    	  validLogin = false;
		    	  System.out.println("Incorrect Login");
		      }
		      
		      //STEP 6: Clean-up environment
		      /*
		      //With Connection Pooling
		      MySqlConnect.returnConnectionToPool(con);*/
		      rs.close();
	      }catch (Exception e) {
			System.out.println("Error :"+e);
	      }finally {
	    	  closeConnections(conn,stmt);
	      }
		return validLogin;
	}

	@Override
	public boolean setProfileDetails(String email, String ebayHandle, String fname, String lname, String dob,
			String contact, String location) {
		
		Connection conn = createConnection();
		PreparedStatement stmt = null;
		
		boolean userUpdated = false;
		System.out.println("Update User Details...");
	      
	      
	      try{
	    	  String updateUserDetails = "Update user SET ebayHandle = ?,  fname = ?,  lname = ?,  dob = ?, contact = ?,  location = ? where email = ?";
	    	  stmt = conn.prepareStatement(updateUserDetails);
	    	  stmt.setString(1, ebayHandle);
	    	  stmt.setString(2, fname);
	    	  stmt.setString(3, lname);
	    	  stmt.setString(4, dob);
	    	  stmt.setString(5, contact);
	    	  stmt.setString(6, location);
	    	  stmt.setString(7, email);
		      stmt.execute();
		      
		      userUpdated = true;
	    	  System.out.println("User Profile Updated...");
	      }catch (Exception e) {
			System.out.println("Error :"+e);
	      }finally {
	    	  closeConnections(conn,stmt);
	      }
		return userUpdated;
	}

	@Override
	public boolean addItemToUserCart(String buyerEmail, int itemId) {
		
		Connection conn = createConnection();
		PreparedStatement stmt = null;
		
		boolean itemInsertedInCart = false;
		System.out.println("Adding Item to User Cart...");
	      
	      
	      try{
    	  	  System.out.println("Adding Item to User Cart...");
	    	  String insertItemToUserCart = " insert into users_cart (buyerEmail,itemId) values (?, ?)";
	    	  
	    	  stmt = conn.prepareStatement(insertItemToUserCart);
	    	  stmt.setString(1, buyerEmail);
	    	  stmt.setInt(2, itemId);
	    	  
	    	  stmt.execute();
	    	  itemInsertedInCart = true;
	    	  System.out.println("Item Inserted in Cart...");
	    	  
	    	  
		      //STEP 6: Clean-up environment
	      }catch (Exception e) {
			System.out.println("Error :"+e);
	      }finally {
	    	  closeConnections(conn,stmt);
	      }
		return itemInsertedInCart;
	}

	@Override
	public boolean removeItemFromCart(String buyerEmail, int itemId) {
		
		Connection conn = createConnection();
		PreparedStatement stmt = null;
		
		boolean itemInsertedInCart = false;
		System.out.println("Deleting Item from User Cart...");
	      
	      
	      try{
    	  	  System.out.println("Deleting Item from User Cart...");
	    	  String insertItemToUserCart = " delete from users_cart where users_cart.itemId = ? and users_cart.buyerEmail = ?";
	    	  
	    	  stmt = conn.prepareStatement(insertItemToUserCart);
	    	  stmt.setInt(1, itemId);
	    	  stmt.setString(2, buyerEmail);
	    	  
	    	  stmt.execute();
	    	  itemInsertedInCart = true;
	    	  System.out.println("Item Deleted from Cart...");
	    	  
	    	  
		      //STEP 6: Clean-up environment
	      }catch (Exception e) {
			System.out.println("Error :"+e);
	      }finally {
	    	  closeConnections(conn,stmt);
	      }
		return itemInsertedInCart;
	}

	@Override
	public int getUserId(String email) {

		Connection conn = createConnection();
		PreparedStatement stmt = null;
		
		int userId=0;
		System.out.println("Fetch User ID...");
	      
	      
	      try{
    	  	  System.out.println("Fetch User ID...");
	    	  String getUserId = "select userid from user where email='"+email+"'";
	    	  
	    	  stmt = conn.prepareStatement(getUserId);
	    	  
	    	  stmt.execute();
	    	  ResultSet rs = stmt.executeQuery(getUserId);
	    	  
	    	  System.out.println("User ID fetched...");
	    	  
	    	  while(rs.next() == true){
	    		  userId = rs.getInt("userid");
		    	  System.out.println("User ID:"+ userId);
		      }
	    	//STEP 6: Clean-up environment
		      rs.close();
	      }catch (Exception e) {
			System.out.println("Error :"+e);
	      }finally {
	    	  closeConnections(conn,stmt);
	      }
	      System.out.println("userId :"+userId);
		return userId;
	}

	@Override
	public boolean addItem(String itemName, String itemDescription, float itemPrice, int qty, int qtyLeft, int bidFlag,
			String shippingFrom, String listDate, String auctionEndDate, float bidPrice, int sellerId) {
		
		Connection conn = createConnection();
		PreparedStatement stmt = null;
		
		boolean itemAdded = false;
		System.out.println("Adding Item to Table...");
	      
	      
	      try{
    	  	  System.out.println("Adding Item to Table...");
	    	  String addItem = " insert into item (itemName, itemDescription, itemPrice, qty, qtyLeft, bidFlag, shippingFrom, listDate, auctionEndDate, bidPrice, sellerId) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    	  
	    	  stmt = conn.prepareStatement(addItem);
	    	  stmt.setString(1, itemName);
	    	  stmt.setString(2, itemDescription);
	    	  stmt.setFloat(3, itemPrice);
	    	  stmt.setInt(4, qty);
	    	  stmt.setInt(5, qtyLeft);
	    	  stmt.setInt(6, bidFlag);
	    	  stmt.setString(7, shippingFrom);
	    	  stmt.setString(8, listDate);
	    	  stmt.setString(9, auctionEndDate);
	    	  stmt.setFloat(10, bidPrice);
	    	  stmt.setInt(11, sellerId);
	    	  
	    	  stmt.execute();
	    	  itemAdded = true;
	    	  System.out.println("Item Added in Table...");
	    	  
	    	  
		      //STEP 6: Clean-up environment
	      }catch (Exception e) {
			System.out.println("Error :"+e);
	      }finally {
	    	  closeConnections(conn,stmt);
	      }
		return itemAdded;
	}

	@Override
	public boolean addBidToItem(String bidUser, int itemId, float bidAmount) {
		
		Connection conn = createConnection();
		PreparedStatement stmt = null;
		
		boolean itemAuctionPriceUpdated = false;
		System.out.println("Updating Auction Item Bid...");
	      
	      
	      try{
	    	  String updateAuctionedItemBid = "update item set item.bidPrice = ?, item.bidUser = ? where itemId = ? and item.bidPrice < ?";
	    	  stmt = conn.prepareStatement(updateAuctionedItemBid);
	    	  stmt.setFloat(1, bidAmount);
	    	  stmt.setString(2, bidUser);
	    	  stmt.setInt(3, itemId);
	    	  stmt.setFloat(4, bidAmount);
		      stmt.execute();
		      
		      itemAuctionPriceUpdated = true;
	    	  System.out.println("Updated Auction Item Bid...");
	      }catch (Exception e) {
			System.out.println("Error :"+e);
	      }finally {
	    	  closeConnections(conn,stmt);
	      }
		return itemAuctionPriceUpdated;
	}

	@Override
	public boolean checkOutCart(int qty, int qtyLeft, int itemId, String buyerEmail, String userEmail,
			String boughtDate, float soldPrice) {
		
		Connection conn = createConnection();
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		PreparedStatement stmt3 = null;
		
		boolean updateItemsTableFlag = false;
		boolean deleteCartForUserTableFlag = false;
		boolean addToUserPurchaseHistoryFlag = false;
	      
	      try{
	    	  System.out.println(" Update Qty in Item Table...");
	    	  String updateItemsTable = "update ebay.item SET item.qtyLeft = ? where itemId = ?";
	    	  stmt1 = conn.prepareStatement(updateItemsTable);
	    	  stmt1.setFloat(1, qtyLeft);
	    	  stmt1.setInt(2, itemId);
	    	  stmt1.execute();
		      
	    	  updateItemsTableFlag = true;
	    	  System.out.println("Updated Qty in Item Table...");
	    	  //////////////////////////////////////////////////////////
	    	  System.out.println("Delete Item from Cart Table...");
	    	  String deleteCartForUser = "delete from users_cart where users_cart.buyerEmail = ?";
	    	  stmt2 = conn.prepareStatement(deleteCartForUser);
	    	  stmt2.setString(1, buyerEmail);
	    	  stmt2.execute();
		      
	    	  deleteCartForUserTableFlag = true;
	    	  System.out.println("Deleted Item from Cart Table...");
	    	  /////////////////////////////////////////////////////////
	    	  
	    	  
	    	  System.out.println(" Insert in Transaction Table...");
	    	  String addToUserPurchaseHistory = "insert into user_order_data (itemId, userEmail, qty, boughtDate, soldPrice) Values (?,?,?,?,?)";
	    	  stmt3 = conn.prepareStatement(addToUserPurchaseHistory);
	    	  stmt3.setInt(1, itemId);
	    	  stmt3.setString(2, userEmail);
	    	  stmt3.setInt(3, qty);
	    	  stmt3.setString(4, boughtDate);
	    	  stmt3.setFloat(5, soldPrice);
	    	  stmt3.execute();
		      
	    	  addToUserPurchaseHistoryFlag = true;
	    	  System.out.println("Inserted in Transaction Table...");
	    	  
	    	  
	      }catch (Exception e) {
			System.out.println("Error :"+e);
	      }finally {
	    	  closeConnections(conn,stmt1);
	      }
		
		return true;
	}
}
