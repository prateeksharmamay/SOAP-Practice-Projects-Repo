<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleJDBCConnectorProxyid" scope="session" class="service.JDBCConnectorProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleJDBCConnectorProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleJDBCConnectorProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleJDBCConnectorProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        service.JDBCConnector getJDBCConnector10mtemp = sampleJDBCConnectorProxyid.getJDBCConnector();
if(getJDBCConnector10mtemp == null){
%>
<%=getJDBCConnector10mtemp %>
<%
}else{
        if(getJDBCConnector10mtemp!= null){
        String tempreturnp11 = getJDBCConnector10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String email_1id=  request.getParameter("email16");
            java.lang.String email_1idTemp = null;
        if(!email_1id.equals("")){
         email_1idTemp  = email_1id;
        }
        String password_2id=  request.getParameter("password18");
            java.lang.String password_2idTemp = null;
        if(!password_2id.equals("")){
         password_2idTemp  = password_2id;
        }
        String fname_3id=  request.getParameter("fname20");
            java.lang.String fname_3idTemp = null;
        if(!fname_3id.equals("")){
         fname_3idTemp  = fname_3id;
        }
        String lname_4id=  request.getParameter("lname22");
            java.lang.String lname_4idTemp = null;
        if(!lname_4id.equals("")){
         lname_4idTemp  = lname_4id;
        }
        String lastLoginTime_5id=  request.getParameter("lastLoginTime24");
            java.lang.String lastLoginTime_5idTemp = null;
        if(!lastLoginTime_5id.equals("")){
         lastLoginTime_5idTemp  = lastLoginTime_5id;
        }
        boolean insertUser13mtemp = sampleJDBCConnectorProxyid.insertUser(email_1idTemp,password_2idTemp,fname_3idTemp,lname_4idTemp,lastLoginTime_5idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(insertUser13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
case 26:
        gotMethod = true;
        String email_6id=  request.getParameter("email29");
            java.lang.String email_6idTemp = null;
        if(!email_6id.equals("")){
         email_6idTemp  = email_6id;
        }
        String password_7id=  request.getParameter("password31");
            java.lang.String password_7idTemp = null;
        if(!password_7id.equals("")){
         password_7idTemp  = password_7id;
        }
        boolean verifyUser26mtemp = sampleJDBCConnectorProxyid.verifyUser(email_6idTemp,password_7idTemp);
        String tempResultreturnp27 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(verifyUser26mtemp));
        %>
        <%= tempResultreturnp27 %>
        <%
break;
case 33:
        gotMethod = true;
        String email_8id=  request.getParameter("email36");
            java.lang.String email_8idTemp = null;
        if(!email_8id.equals("")){
         email_8idTemp  = email_8id;
        }
        String ebayHandle_9id=  request.getParameter("ebayHandle38");
            java.lang.String ebayHandle_9idTemp = null;
        if(!ebayHandle_9id.equals("")){
         ebayHandle_9idTemp  = ebayHandle_9id;
        }
        String fname_10id=  request.getParameter("fname40");
            java.lang.String fname_10idTemp = null;
        if(!fname_10id.equals("")){
         fname_10idTemp  = fname_10id;
        }
        String lname_11id=  request.getParameter("lname42");
            java.lang.String lname_11idTemp = null;
        if(!lname_11id.equals("")){
         lname_11idTemp  = lname_11id;
        }
        String dob_12id=  request.getParameter("dob44");
            java.lang.String dob_12idTemp = null;
        if(!dob_12id.equals("")){
         dob_12idTemp  = dob_12id;
        }
        String contact_13id=  request.getParameter("contact46");
            java.lang.String contact_13idTemp = null;
        if(!contact_13id.equals("")){
         contact_13idTemp  = contact_13id;
        }
        String location_14id=  request.getParameter("location48");
            java.lang.String location_14idTemp = null;
        if(!location_14id.equals("")){
         location_14idTemp  = location_14id;
        }
        boolean setProfileDetails33mtemp = sampleJDBCConnectorProxyid.setProfileDetails(email_8idTemp,ebayHandle_9idTemp,fname_10idTemp,lname_11idTemp,dob_12idTemp,contact_13idTemp,location_14idTemp);
        String tempResultreturnp34 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(setProfileDetails33mtemp));
        %>
        <%= tempResultreturnp34 %>
        <%
break;
case 50:
        gotMethod = true;
        String buyerEmail_15id=  request.getParameter("buyerEmail53");
            java.lang.String buyerEmail_15idTemp = null;
        if(!buyerEmail_15id.equals("")){
         buyerEmail_15idTemp  = buyerEmail_15id;
        }
        String itemId_16id=  request.getParameter("itemId55");
        int itemId_16idTemp  = Integer.parseInt(itemId_16id);
        boolean addItemToUserCart50mtemp = sampleJDBCConnectorProxyid.addItemToUserCart(buyerEmail_15idTemp,itemId_16idTemp);
        String tempResultreturnp51 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addItemToUserCart50mtemp));
        %>
        <%= tempResultreturnp51 %>
        <%
break;
case 57:
        gotMethod = true;
        String buyerEmail_17id=  request.getParameter("buyerEmail60");
            java.lang.String buyerEmail_17idTemp = null;
        if(!buyerEmail_17id.equals("")){
         buyerEmail_17idTemp  = buyerEmail_17id;
        }
        String itemId_18id=  request.getParameter("itemId62");
        int itemId_18idTemp  = Integer.parseInt(itemId_18id);
        boolean removeItemFromCart57mtemp = sampleJDBCConnectorProxyid.removeItemFromCart(buyerEmail_17idTemp,itemId_18idTemp);
        String tempResultreturnp58 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(removeItemFromCart57mtemp));
        %>
        <%= tempResultreturnp58 %>
        <%
break;
case 64:
        gotMethod = true;
        String email_19id=  request.getParameter("email67");
            java.lang.String email_19idTemp = null;
        if(!email_19id.equals("")){
         email_19idTemp  = email_19id;
        }
        int getUserId64mtemp = sampleJDBCConnectorProxyid.getUserId(email_19idTemp);
        String tempResultreturnp65 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getUserId64mtemp));
        %>
        <%= tempResultreturnp65 %>
        <%
break;
case 69:
        gotMethod = true;
        String itemName_20id=  request.getParameter("itemName72");
            java.lang.String itemName_20idTemp = null;
        if(!itemName_20id.equals("")){
         itemName_20idTemp  = itemName_20id;
        }
        String itemDescription_21id=  request.getParameter("itemDescription74");
            java.lang.String itemDescription_21idTemp = null;
        if(!itemDescription_21id.equals("")){
         itemDescription_21idTemp  = itemDescription_21id;
        }
        String itemPrice_22id=  request.getParameter("itemPrice76");
        float itemPrice_22idTemp  = Float.parseFloat(itemPrice_22id);
        String qty_23id=  request.getParameter("qty78");
        int qty_23idTemp  = Integer.parseInt(qty_23id);
        String qtyLeft_24id=  request.getParameter("qtyLeft80");
        int qtyLeft_24idTemp  = Integer.parseInt(qtyLeft_24id);
        String bidFlag_25id=  request.getParameter("bidFlag82");
        int bidFlag_25idTemp  = Integer.parseInt(bidFlag_25id);
        String shippingFrom_26id=  request.getParameter("shippingFrom84");
            java.lang.String shippingFrom_26idTemp = null;
        if(!shippingFrom_26id.equals("")){
         shippingFrom_26idTemp  = shippingFrom_26id;
        }
        String listDate_27id=  request.getParameter("listDate86");
            java.lang.String listDate_27idTemp = null;
        if(!listDate_27id.equals("")){
         listDate_27idTemp  = listDate_27id;
        }
        String auctionEndDate_28id=  request.getParameter("auctionEndDate88");
            java.lang.String auctionEndDate_28idTemp = null;
        if(!auctionEndDate_28id.equals("")){
         auctionEndDate_28idTemp  = auctionEndDate_28id;
        }
        String bidPrice_29id=  request.getParameter("bidPrice90");
        float bidPrice_29idTemp  = Float.parseFloat(bidPrice_29id);
        String sellerId_30id=  request.getParameter("sellerId92");
        int sellerId_30idTemp  = Integer.parseInt(sellerId_30id);
        boolean addItem69mtemp = sampleJDBCConnectorProxyid.addItem(itemName_20idTemp,itemDescription_21idTemp,itemPrice_22idTemp,qty_23idTemp,qtyLeft_24idTemp,bidFlag_25idTemp,shippingFrom_26idTemp,listDate_27idTemp,auctionEndDate_28idTemp,bidPrice_29idTemp,sellerId_30idTemp);
        String tempResultreturnp70 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addItem69mtemp));
        %>
        <%= tempResultreturnp70 %>
        <%
break;
case 94:
        gotMethod = true;
        String bidUser_31id=  request.getParameter("bidUser97");
            java.lang.String bidUser_31idTemp = null;
        if(!bidUser_31id.equals("")){
         bidUser_31idTemp  = bidUser_31id;
        }
        String itemId_32id=  request.getParameter("itemId99");
        int itemId_32idTemp  = Integer.parseInt(itemId_32id);
        String bidAmount_33id=  request.getParameter("bidAmount101");
        float bidAmount_33idTemp  = Float.parseFloat(bidAmount_33id);
        boolean addBidToItem94mtemp = sampleJDBCConnectorProxyid.addBidToItem(bidUser_31idTemp,itemId_32idTemp,bidAmount_33idTemp);
        String tempResultreturnp95 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addBidToItem94mtemp));
        %>
        <%= tempResultreturnp95 %>
        <%
break;
case 103:
        gotMethod = true;
        String qty_34id=  request.getParameter("qty106");
        int qty_34idTemp  = Integer.parseInt(qty_34id);
        String qtyLeft_35id=  request.getParameter("qtyLeft108");
        int qtyLeft_35idTemp  = Integer.parseInt(qtyLeft_35id);
        String itemId_36id=  request.getParameter("itemId110");
        int itemId_36idTemp  = Integer.parseInt(itemId_36id);
        String buyerEmail_37id=  request.getParameter("buyerEmail112");
            java.lang.String buyerEmail_37idTemp = null;
        if(!buyerEmail_37id.equals("")){
         buyerEmail_37idTemp  = buyerEmail_37id;
        }
        String userEmail_38id=  request.getParameter("userEmail114");
            java.lang.String userEmail_38idTemp = null;
        if(!userEmail_38id.equals("")){
         userEmail_38idTemp  = userEmail_38id;
        }
        String boughtDate_39id=  request.getParameter("boughtDate116");
            java.lang.String boughtDate_39idTemp = null;
        if(!boughtDate_39id.equals("")){
         boughtDate_39idTemp  = boughtDate_39id;
        }
        String soldPrice_40id=  request.getParameter("soldPrice118");
        float soldPrice_40idTemp  = Float.parseFloat(soldPrice_40id);
        boolean checkOutCart103mtemp = sampleJDBCConnectorProxyid.checkOutCart(qty_34idTemp,qtyLeft_35idTemp,itemId_36idTemp,buyerEmail_37idTemp,userEmail_38idTemp,boughtDate_39idTemp,soldPrice_40idTemp);
        String tempResultreturnp104 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(checkOutCart103mtemp));
        %>
        <%= tempResultreturnp104 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>