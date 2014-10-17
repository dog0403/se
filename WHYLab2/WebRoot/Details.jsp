<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Details.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<table>
  		<thead>
  		<tr>
  		<td>ISBN</td>
  		<td>Title</td>
  		<td>AuthorID</td>
  		<td>Publisher</td>
  		<td>PublishDate</td>
  		<td>Price</td>
  		<td>Name</td>
  		<td>Age</td>
  		<td>Country</td>
  		</tr>
  		</thead>
  		<tbody>
  		<tr>
  		<td><s:property value="ISBN"/></td>
  		<td><s:property value="Title"/></td>
  		<td><s:property value="AuthorID"/></td>
  		<td><s:property value="Publisher"/></td>
  		<td><s:property value="PublisherDate"/></td>
  		<td><s:property value="Price"/></td>
  		<td><s:property value="Name"/></td>
  		<td><s:property value="Age"/></td>
  		<td><s:property value="Country"/></td>
  		</tr>
  		</tbody>
  	
  	</table>
  </body>
</html>
