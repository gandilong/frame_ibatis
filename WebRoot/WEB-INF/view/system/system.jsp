<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../../include/taglibs.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="../../../include/layout.jsp" %>
        <%@include file="../../../include/easyui.jsp" %>
    </head> 
    
    <body class="easyui-layout">
         <div data-options="region:'north',border:false,minHeight:60,maxHeight:60">
                   <%@include file="../../../include/header.jsp"%>    
         </div>
	     <div data-options="region:'west',split:true,minWidth:150,maxWidth:250,title:'West'" style="width:200px;padding:10px;">west content</div>
	     <div data-options="region:'east',split:true,minWidth:150,maxWidth:250,collapsed:true,title:'选项列表'" style="width:200px;padding:10px;">east region</div>
	     <div data-options="region:'south',border:false,minHeight:50,maxHeight:50" style="height:50px;background:#A9FACD;padding:10px;">
	         天航软件开发者:gandilong
	     </div>
	     <div data-options="region:'center',title:'Center',href:'index'"></div>
    </body>
    
    
</html>

