package service;

public class JDBCConnectorProxy implements service.JDBCConnector {
  private String _endpoint = null;
  private service.JDBCConnector jDBCConnector = null;
  
  public JDBCConnectorProxy() {
    _initJDBCConnectorProxy();
  }
  
  public JDBCConnectorProxy(String endpoint) {
    _endpoint = endpoint;
    _initJDBCConnectorProxy();
  }
  
  private void _initJDBCConnectorProxy() {
    try {
      jDBCConnector = (new service.JDBCConnectorServiceLocator()).getJDBCConnector();
      if (jDBCConnector != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)jDBCConnector)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)jDBCConnector)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (jDBCConnector != null)
      ((javax.xml.rpc.Stub)jDBCConnector)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public service.JDBCConnector getJDBCConnector() {
    if (jDBCConnector == null)
      _initJDBCConnectorProxy();
    return jDBCConnector;
  }
  
  public boolean insertUser(java.lang.String email, java.lang.String password, java.lang.String fname, java.lang.String lname, java.lang.String lastLoginTime) throws java.rmi.RemoteException{
    if (jDBCConnector == null)
      _initJDBCConnectorProxy();
    return jDBCConnector.insertUser(email, password, fname, lname, lastLoginTime);
  }
  
  public boolean verifyUser(java.lang.String email, java.lang.String password) throws java.rmi.RemoteException{
    if (jDBCConnector == null)
      _initJDBCConnectorProxy();
    return jDBCConnector.verifyUser(email, password);
  }
  
  public boolean setProfileDetails(java.lang.String email, java.lang.String ebayHandle, java.lang.String fname, java.lang.String lname, java.lang.String dob, java.lang.String contact, java.lang.String location) throws java.rmi.RemoteException{
    if (jDBCConnector == null)
      _initJDBCConnectorProxy();
    return jDBCConnector.setProfileDetails(email, ebayHandle, fname, lname, dob, contact, location);
  }
  
  public boolean addItemToUserCart(java.lang.String buyerEmail, int itemId) throws java.rmi.RemoteException{
    if (jDBCConnector == null)
      _initJDBCConnectorProxy();
    return jDBCConnector.addItemToUserCart(buyerEmail, itemId);
  }
  
  public boolean removeItemFromCart(java.lang.String buyerEmail, int itemId) throws java.rmi.RemoteException{
    if (jDBCConnector == null)
      _initJDBCConnectorProxy();
    return jDBCConnector.removeItemFromCart(buyerEmail, itemId);
  }
  
  public int getUserId(java.lang.String email) throws java.rmi.RemoteException{
    if (jDBCConnector == null)
      _initJDBCConnectorProxy();
    return jDBCConnector.getUserId(email);
  }
  
  public boolean addItem(java.lang.String itemName, java.lang.String itemDescription, float itemPrice, int qty, int qtyLeft, int bidFlag, java.lang.String shippingFrom, java.lang.String listDate, java.lang.String auctionEndDate, float bidPrice, int sellerId) throws java.rmi.RemoteException{
    if (jDBCConnector == null)
      _initJDBCConnectorProxy();
    return jDBCConnector.addItem(itemName, itemDescription, itemPrice, qty, qtyLeft, bidFlag, shippingFrom, listDate, auctionEndDate, bidPrice, sellerId);
  }
  
  public boolean addBidToItem(java.lang.String bidUser, int itemId, float bidAmount) throws java.rmi.RemoteException{
    if (jDBCConnector == null)
      _initJDBCConnectorProxy();
    return jDBCConnector.addBidToItem(bidUser, itemId, bidAmount);
  }
  
  public boolean checkOutCart(int qty, int qtyLeft, int itemId, java.lang.String buyerEmail, java.lang.String userEmail, java.lang.String boughtDate, float soldPrice) throws java.rmi.RemoteException{
    if (jDBCConnector == null)
      _initJDBCConnectorProxy();
    return jDBCConnector.checkOutCart(qty, qtyLeft, itemId, buyerEmail, userEmail, boughtDate, soldPrice);
  }
  
  
}