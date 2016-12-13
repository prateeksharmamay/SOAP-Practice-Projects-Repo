/**
 * JDBCConnector.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public interface JDBCConnector extends java.rmi.Remote {
    public boolean addItem(java.lang.String itemName, java.lang.String itemDescription, float itemPrice, int qty, int qtyLeft, int bidFlag, java.lang.String shippingFrom, java.lang.String listDate, java.lang.String auctionEndDate, float bidPrice, int sellerId) throws java.rmi.RemoteException;
    public int getUserId(java.lang.String email) throws java.rmi.RemoteException;
    public boolean addBidToItem(java.lang.String bidUser, int itemId, float bidAmount) throws java.rmi.RemoteException;
    public boolean removeItemFromCart(java.lang.String buyerEmail, int itemId) throws java.rmi.RemoteException;
    public boolean checkOutCart(int qty, int qtyLeft, int itemId, java.lang.String buyerEmail, java.lang.String userEmail, java.lang.String boughtDate, float soldPrice) throws java.rmi.RemoteException;
    public boolean setProfileDetails(java.lang.String email, java.lang.String ebayHandle, java.lang.String fname, java.lang.String lname, java.lang.String dob, java.lang.String contact, java.lang.String location) throws java.rmi.RemoteException;
    public boolean insertUser(java.lang.String email, java.lang.String password, java.lang.String fname, java.lang.String lname, java.lang.String lastLoginTime) throws java.rmi.RemoteException;
    public boolean verifyUser(java.lang.String email, java.lang.String password) throws java.rmi.RemoteException;
    public boolean addItemToUserCart(java.lang.String buyerEmail, int itemId) throws java.rmi.RemoteException;
}
