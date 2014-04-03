<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../../include/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>user list</title>
    <%@include file="../../../include/layout.jsp" %>
    <%@include file="../../../include/easyui.jsp" %>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
     <ul class="easyui-tree" data-options="url:'system/user/tree',method:'get',animate:true"></ul>
  </body>
</html>
