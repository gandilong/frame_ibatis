<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../include/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <head>
    <title>没有权限！</title>
	  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
        <style type="text/css">
             body { background-color: #efefef; color: #333; font-family: Georgia,Palatino,'Book Antiqua',serif;padding:0;margin:0;text-align:center; }
                p {font-style:italic;}
                div.dialog {
                   width: 490px;
                   margin: 4em auto 0 auto;
                }
                img { border:none; }
        </style>
  </head>
  
  <body>
       <div class="dialog">
          <a href="${ctx}"><img src="<c:url value="/common/images/401.png"></c:url>" /></a>
          <p>看起来你的权限不够哦！</p>
       </div>
  </body>
</html>
