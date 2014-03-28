<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../include/taglibs.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <title>项目Bug管理系统</title>
        <%@include file="../../include/layout.jsp" %>
        <%@include file="../../include/easyui.jsp" %>
    </head> 
    
    <body class="easyui-layout">
          <%--style="height:60px;overflow-y:hidden;background:url('${ctx}/tools/easyui/themes/header_bg_highlight.png') repeat-x;padding:10px" --%>
         <div data-options="region:'north',border:false,fit:false,minHeight:60,maxHeight:60,href:'header'" style="height:60px;overflow-y:hidden;background:url('${ctx}/tools/easyui/themes/header_bg_highlight.png') repeat-x;padding:10px"></div>
	     <div data-options="region:'west',split:true,minWidth:150,maxWidth:250,title:'West'" style="width:200px;padding:10px;">
	         
	     </div>
	     <div data-options="region:'east',split:true,minWidth:150,maxWidth:250,collapsed:true,title:'设置'" style="width:200px;padding:10px;">
	           <shiro:principal></shiro:principal>
	          <a href="system/user/logout" class="btn"><label class="icon-off"></label>退出</a>
	     </div>
	     <div data-options="region:'south',border:false,minHeight:10,maxHeight:30" style="height:50px;background:#A9FACD;padding:10px;">
	         天航软件开发者:gandilong
	     </div>
	     <div data-options="region:'center',title:'信息展示'"></div>
    </body>
    
    
</html>

