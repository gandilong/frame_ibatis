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
         <!-- 顶部模块 -->
         <div data-options="region:'north',border:false,minHeight:60,maxHeight:60" style="height:60px;overflow-y:hidden;background:url('${ctx}/tools/easyui/themes/headerbg.jpg') repeat-x;padding:10px">
                   <%@include file="../../../include/header.jsp"%>    
         </div>
         
         <!-- 左边菜单 -->
	     <div id="west" data-options="region:'west',split:true,minWidth:150,maxWidth:250,title:'系统管理'" style="width:200px;padding:0px;">
	         <div class="easyui-accordion"  data-options="fit:true">
	                <div title="功能列表" data-options="iconCls:'icon-plugin'" style="overflow:auto;">
	                    <ul class="nav nav-list" style="font-size:14px;color:black;padding:5px;margin:5px">
	                        <li class="btn btn-block" id="slogManager"  href="system/slog/list">系统日志<label class="icon-chevron-right"></label></li>
	                        <li class="btn btn-block" id="userManager"  href="system/user/list">用户管理<label class="icon-chevron-right"></label></li>
	                        <li class="btn btn-block" id="roleManager"  href="system/role/list">角色管理<label class="icon-chevron-right"></label></li>
	                        <shiro:hasPermission name="system_resource">
	                            <li class="btn btn-block" id="resourceManager" href="system/resource/list">资源管理<label class="icon-chevron-right"></label></li>
	                        </shiro:hasPermission>
	                        <li class="btn btn-block" id="roleManager"  href="system/role/list">关于产品<label class="icon-chevron-right"></label></li>
	                    </ul>
	                </div>
				    <div title="关于" data-options="iconCls:'icon-ok'" style="overflow:auto;">
						  <ol class="span1">
                            <li><a href="javascript:goPage('../about.jsp')">简介</a></li>
                            <li><a href="javascript:void(0)">目录</a></li>
                            <li><a href="javascript:void(0)">功能介绍</a></li>
                            <li><a href="javascript:void(0)">安装说明</a></li>
                            <li><a href="javascript:void(0)">操作说明</a></li>
                          </ol>
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
	     <div id="center" data-options="region:'center',title:'数据',href:'index',iconCls:'icon-th'" style="overflow:auto"></div>
    </body>
    
    
</html>

