package service;
import java.sql.*;
import java.util.Stack;
public class JDBCConnectorwithPooling 
{  
	private Connection connection; 
	private  Stack<Connection> connectionPool;

	private int poolSize = 5;
	private static JDBCConnectorwithPooling instance ;

	public static JDBCConnectorwithPooling getDBInstance(){
		if(instance == null){
			instance = new JDBCConnectorwithPooling();
		}
		return instance;
	}

	public JDBCConnectorwithPooling (){
		connectionPool = new Stack<>();
		System.out.println("filling pooll");
		for(int i=0; i<poolSize;i++){
			Connection con = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");      
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebayj","root","root");
				connectionPool.push(con);
			} catch (SQLException e) {
				System.out.println("Sql exception ");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("class not found");
				e.printStackTrace();
			}

		}
	}

	public static void returnConnectionToPool(Connection conn){
		instance.connectionPool.push(conn);
	}

	public Connection getConnection()
	{  
		if(connectionPool.size()>0){
			try 
			{   
				connection = connectionPool.pop();
				System.out.println("Connected to the DB");   
				return connection;  
			}
			catch(Exception e)
			{   
				System.out.println("Exception "+e);  
			} 
		}

		return null; 
	}
}