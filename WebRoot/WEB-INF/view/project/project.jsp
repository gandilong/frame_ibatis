<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../../include/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>项目Bug管理系统</title>
        <%@include file="../../../include/layout.jsp" %>
        <%@include file="../../../include/easyui.jsp" %>
        <script type="text/javascript" src="${ctx}/tools/script/system/system.js"></script>
        
    </head> 
    
    <body id="system" class="easyui-layout">
         <!-- 顶部模块 -->
         <div data-options="region:'north',border:false,fit:false,minHeight:60,maxHeight:60,href:'header?model=project'" style="height:60px;overflow-y:hidden;background:url('${ctx}/tools/easyui/themes/header_bg_highlight.png') repeat-x;padding:10px"></div>
         
         <!-- 左边菜单 -->
	     <div id="west" data-options="region:'west',split:true,minWidth:200,maxWidth:200,title:'系统管理'" style="width:200px;padding:0px;">
	         <div class="easyui-accordion"  data-options="fit:true">
	                <div title="项目列表" data-options="iconCls:'icon-plugin'" style="overflow:auto;">
	                    <ul class="nav nav-list" style="font-size:14px;color:black;padding:5px;margin:5px">
	                     <shiro:hasPermission name="system_syslog">
	                        <li class="btn btn-block" id="projectManager"  href="project/project/list?status=0">筹备中项目<label class="icon-chevron-right"></label></li>
	                     </shiro:hasPermission>
	                     
	                     <shiro:hasPermission name="system_user">
	                        <li class="btn btn-block" id="projectManager"  href="project/project/list?status=1">开发中项目<label class="icon-chevron-right"></label></li>
	                     </shiro:hasPermission>
	                     
	                     <shiro:hasPermission name="system_role">
	                         <li class="btn btn-block" id="projectManager"  href="project/project/list?status=2">测试中项目<label class="icon-chevron-right"></label></li>
	                     </shiro:hasPermission>
	                     
	                    </ul>
	                </div>
			 </div>
	     </div>
	     
	     <!-- 右边区域 -->
	     <div data-options="region:'east',split:true,minWidth:150,maxWidth:250,collapsed:true,title:'选项列表'" style="width:200px;padding:10px;">east region</div>
	     
	     <!-- 底部区域 -->
	     <div data-options="region:'south',border:false,minHeight:10,maxHeight:30" style="height:30px;background:#A9FACD;padding:5px;">
	                      天航软件开发者:gandilong
	     </div>
	     
	     
	     <!-- 中心内容 -->
	     <div id="center" data-options="region:'center',title:'数据',iconCls:'icon-th'" style="overflow:auto"></div>
    </body>
    
    
</html>

