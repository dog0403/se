<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>QueryResult</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
  Result of ${Name}
  <form action="delete">
  <table align="center" border="1">
    <caption><h3>查询结果</h3></caption> <br>
    <tr>
    	<td>作者：<div type="text" /></div></td>
    	<td>书名：<div type="text" /></div></td>
    	<td>操作1：<div type="text"/></div></td>
    	<td>操作2：<div type="text"/></div></td>
    </tr>
    <tr>
    	<td><s:property value="Name"/></td>
    	<td><s:property value="Title"/></td>
    	<td colspan="1">
    	<a href='<s:url action="delete"><s:param name="ISBN" value="ISBN" /></s:url>'>删除</a>
    	</td>
    	<td colspan="1">
    	<a href='<s:url action="detail"><s:param name="ISBN" value="ISBN" /></s:url>'>详情</a>
    	</td>
    </tr>
    
    
    
    </table>
    </form>
  </body>
</html>