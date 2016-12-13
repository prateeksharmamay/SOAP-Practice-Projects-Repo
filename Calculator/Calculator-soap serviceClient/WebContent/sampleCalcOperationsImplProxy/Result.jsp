<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleCalcOperationsImplProxyid" scope="session" class="calculator.CalcOperationsImplProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleCalcOperationsImplProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleCalcOperationsImplProxyid.getEndpoint();
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
        sampleCalcOperationsImplProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        calculator.CalcOperationsImpl getCalcOperationsImpl10mtemp = sampleCalcOperationsImplProxyid.getCalcOperationsImpl();
if(getCalcOperationsImpl10mtemp == null){
%>
<%=getCalcOperationsImpl10mtemp %>
<%
}else{
        if(getCalcOperationsImpl10mtemp!= null){
        String tempreturnp11 = getCalcOperationsImpl10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String num1_1id=  request.getParameter("num116");
        float num1_1idTemp  = Float.parseFloat(num1_1id);
        String num2_2id=  request.getParameter("num218");
        float num2_2idTemp  = Float.parseFloat(num2_2id);
        float add13mtemp = sampleCalcOperationsImplProxyid.add(num1_1idTemp,num2_2idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(add13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
case 20:
        gotMethod = true;
        String num1_3id=  request.getParameter("num123");
        float num1_3idTemp  = Float.parseFloat(num1_3id);
        String num2_4id=  request.getParameter("num225");
        float num2_4idTemp  = Float.parseFloat(num2_4id);
        float divide20mtemp = sampleCalcOperationsImplProxyid.divide(num1_3idTemp,num2_4idTemp);
        String tempResultreturnp21 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(divide20mtemp));
        %>
        <%= tempResultreturnp21 %>
        <%
break;
case 27:
        gotMethod = true;
        String num1_5id=  request.getParameter("num130");
        float num1_5idTemp  = Float.parseFloat(num1_5id);
        String num2_6id=  request.getParameter("num232");
        float num2_6idTemp  = Float.parseFloat(num2_6id);
        float multiply27mtemp = sampleCalcOperationsImplProxyid.multiply(num1_5idTemp,num2_6idTemp);
        String tempResultreturnp28 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(multiply27mtemp));
        %>
        <%= tempResultreturnp28 %>
        <%
break;
case 34:
        gotMethod = true;
        String num1_7id=  request.getParameter("num137");
        float num1_7idTemp  = Float.parseFloat(num1_7id);
        String num2_8id=  request.getParameter("num239");
        float num2_8idTemp  = Float.parseFloat(num2_8id);
        float substract34mtemp = sampleCalcOperationsImplProxyid.substract(num1_7idTemp,num2_8idTemp);
        String tempResultreturnp35 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(substract34mtemp));
        %>
        <%= tempResultreturnp35 %>
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