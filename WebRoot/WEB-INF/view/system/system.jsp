<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../../include/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../../../include/layout.jsp" %>
        <%@include file="../../../include/easyui.jsp" %>
        <script type="text/javascript" src="${ctx}/tools/script/system/system.js"></script>
    </head> 
    
    <body id="system" class="easyui-layout">
         <div data-options="region:'north',border:false,minHeight:60,maxHeight:60" style="height:60px;overflow-y:hidden;background:url('${ctx}/tools/easyui/themes/headerbg.jpg') repeat-x;padding:10px">
                   <%@include file="../../../include/header.jsp"%>    
         </div>
	     <div id="west" data-options="region:'west',split:true,minWidth:150,maxWidth:250,title:'配置'" style="width:200px;padding:0px;">
	         <div class="easyui-accordion"  data-options="fit:true">
	                <div title="权限" data-options="iconCls:'icon-plugin'" style="overflow:auto;">
	                    <ul class="nav nav-list" style="font-size:14px;color:black;padding:5px;margin:5px">
	                        <li class="btn btn-block" id="userManager"  href="system/auth/userList"  >用户管理<label class="icon-chevron-right"></label></li>
	                        <li class="btn btn-block" id="roleManager"  href="system/auth/roleList">角色管理<label class="icon-chevron-right"></label></li>
	                        <li class="btn btn-block" id="resourceManager" href="system/auth/resourceList">资源管理<label class="icon-chevron-right"></label></li>
	                    </ul>
	                </div>
				    <div title="关于" data-options="iconCls:'icon-ok'" style="overflow:auto;">
						<h3 style="color:#0099FF;">Myframe框架</h3>
						<p>该框架由Gandilong搭建，任何问题皆由本人来解决。</p>
					</div>
					<div title="帮助" data-options="iconCls:'icon-help'" >
						<p>帮助手册  待写...</p> 		
					</div>
				</div>
	     </div>
	     <div data-options="region:'east',split:true,minWidth:150,maxWidth:250,collapsed:true,title:'选项列表'" style="width:200px;padding:10px;">east region</div>
	     <div data-options="region:'south',border:false,minHeight:50,maxHeight:50" style="height:50px;background:#A9FACD;padding:10px;">
	         天航软件开发者:gandilong
	     </div>
	     <div id="center" data-options="region:'center',title:'数据',href:'index',iconCls:'icon-th'"></div>
    </body>
    
    
</html>

