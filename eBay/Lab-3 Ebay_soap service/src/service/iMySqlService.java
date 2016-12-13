package service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface iMySqlService {

	@WebMethod
	boolean insertUser(String email, String password,String fname, String lname, String lastLoginTime);
	
	@WebMethod
	boolean verifyUser(String email, String password);
	
	@WebMethod
	boolean setProfileDetails(String email, String ebayHandle,String fname, String lname, String dob, String contact, String location);
	
	@WebMethod
	boolean addItemToUserCart(String buyerEmail, int itemId);
	
	@WebMethod
	boolean removeItemFromCart(String buyerEmail, int itemId);
	
	@WebMethod
	int getUserId(String email);
	
	@WebMethod
	boolean addItem(String itemName, String itemDescription, float itemPrice, int qty, int qtyLeft, int bidFlag, String shippingFrom, String listDate, String auctionEndDate, float bidPrice, int sellerId);
	
	@WebMethod
	boolean addBidToItem(String bidUser,int itemId,float bidAmount);
	
	@WebMethod
	boolean checkOutCart(int qty, int qtyLeft, int itemId, String buyerEmail, String userEmail, String boughtDate, float soldPrice);
}
