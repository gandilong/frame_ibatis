<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<div class="container-fluid">
   <div class="row-fluid">
     <ul class="inline">
         <li><a href="main" class="btn btn-large "><label class="icon-home"></label>首页</a></li>
         <li><a href="" class="btn btn-large "><label class="icon-briefcase"></label>项目管理</a></li>
         <li><a href="" class="btn btn-large "><label class="icon-exclamation-sign"></label>Bug管理</a></li>
         <shiro:hasRole name="admin">
             <li><a href="system" class="btn btn-large" ><label class="icon-cog"></label>系统管理</a></li>
         </shiro:hasRole>
         <li class="offset5"><label class="icon-user"></label><shiro:principal></shiro:principal></li>
         <li><a href="system/user/logout" class="btn"><label class="icon-off"></label>退出</a></li>
     </ul>
   </div>
</div>
