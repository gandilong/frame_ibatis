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
	     <div data-options="region:'west',split:true,minWidth:150,maxWidth:250,title:'West'" style="width:200px;padding:0px;">
	         <div class="easyui-accordion"  data-options="fit:true">
				    <div title="关于" data-options="iconCls:'icon-ok'" style="overflow:auto;">
						<h3 style="color:#0099FF;">Myframe框架</h3>
						<p>该框架由Gandilong独创，任何问题皆由本人来解决。</p>
					</div>
					<div title="帮助" data-options="iconCls:'icon-help'" >
						<p>帮助手册  待写...</p> 		
					</div>
				</div>
	     </div>
	     <div data-options="region:'east',split:true,minWidth:150,maxWidth:250,collapsed:true,title:'选项列表'" style="width:200px;padding:10px;">east region</div>
	     <div data-options="region:'south',border:false,minHeight:50,maxHeight:50" style="height:50px;background:#A9FACD;padding:10px;">
	         天航软件开发者:gandilongd
	     </div>
	     <div data-options="region:'center',title:'Center',href:'index'"></div>
    </body>
    
    
</html>

