<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../../include/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>公司内部管理系统</title>
        <%@include file="../../../include/layout.jsp" %>
        <%@include file="../../../include/easyui.jsp" %>
        <script type="text/javascript" src="${ctx}/tools/script/system/system.js"></script>
        
    </head> 
    
    <body id="application" class="easyui-layout">
         <!-- 顶部模块 -->
         <div data-options="region:'north',border:false,fit:false,minHeight:60,maxHeight:60,href:'header?model=${values.model}'" style="height:60px;overflow-y:hidden;background:url('${ctx}/tools/easyui/themes/header_bg_highlight.png') repeat-x;padding:10px"></div>
         
         <!-- 左边菜单 -->
	     <div id="west" data-options="region:'west',split:true,minWidth:200,maxWidth:200,title:'系统管理'" style="width:200px;padding:0px;">
	         <div class="easyui-accordion"  data-options="fit:true">
	             <c:if test='${"project" eq values.model}'>
	                <div title="项目管理" data-options="iconCls:'icon-plugin'" style="overflow:auto;">
	                    <ul class="nav nav-list" style="font-size:14px;color:black;padding:5px;margin:5px">
	                     <shiro:hasPermission name="system_syslog">
	                        <li class="btn btn-block" id="projectManager"  href="application/project/list">项目管理<label class="icon-chevron-right"></label></li>
	                     </shiro:hasPermission>
	                     
	                     <shiro:hasPermission name="system_user">
	                        <li class="btn btn-block" id="projectManager"  href="application/task/list?status=1">任务管理<label class="icon-chevron-right"></label></li>
	                     </shiro:hasPermission>
	                     
	                     <shiro:hasPermission name="system_user">
	                        <li class="btn btn-block" id="projectManager"  href="application/bug/list?status=1">Bug管理<label class="icon-chevron-right"></label></li>
	                     </shiro:hasPermission>
	                     
	                    </ul>
	                </div>
	             </c:if>
	             <c:if test='${"person" eq values.model}'>
	                <div title="人事管理" data-options="iconCls:'icon-plugin'" style="overflow:auto;">
	                    <ul class="nav nav-list" style="font-size:14px;color:black;padding:5px;margin:5px">
	                       <shiro:hasPermission name="system_syslog">
	                            <li class="btn btn-block" id="deptManager"  href="application/dept/list">部门管理<label class="icon-chevron-right"></label></li>
	                       </shiro:hasPermission>
	                       <shiro:hasPermission name="system_syslog">
	                            <li class="btn btn-block" id="deptManager"  href="application/person/list">员工管理<label class="icon-chevron-right"></label></li>
	                       </shiro:hasPermission>
	                       <shiro:hasPermission name="system_user">
	                            <li class="btn btn-block" id="vacationManager"  href="project/vacation/list?status=1">请假管理<label class="icon-chevron-right"></label></li>
	                       </shiro:hasPermission>
	                     
	                       <shiro:hasPermission name="system_user">
	                            <li class="btn btn-block" id="travelManager"  href="project/bug/list?status=1">出差管理<label class="icon-chevron-right"></label></li>
	                       </shiro:hasPermission>
	                    </ul>
	                </div>
	             </c:if>
			 </div>
	     </div>
	     
	     <!-- 右边区域 -->
	     <div data-options="region:'east',split:true,minWidth:150,maxWidth:250,collapsed:true,title:'选项列表'" style="width:200px;padding:10px;"></div>
	     
	     <!-- 底部区域 -->
	     <div data-options="region:'south',border:false,minHeight:10,maxHeight:30" style="height:30px;background:#A9FACD;padding:5px;">
	                      天航软件开发者邮箱：gandilong@yeah.net，QQ:2790318173
	     </div>
	     
	     
	     <!-- 中心内容 -->
	     <c:if test='${"project" eq values.model}'>
	         <div id="center" data-options="region:'center',title:'数据',iconCls:'icon-th',href:'application/project/list'" style="overflow:auto"></div>
	     </c:if>
	     <c:if test='${"person" eq values.model}'>
	         <div id="center" data-options="region:'center',title:'数据',iconCls:'icon-th',href:'application/dept/list'" style="overflow:auto"></div>
	     </c:if>
    </body>
    
    
</html>

