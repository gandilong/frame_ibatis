<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="include/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <%@include file="include/layout.jsp"%>
      <style type="text/css">
      body {
        padding-top: 20px;
        padding-bottom: 40px;
      }

      /* Custom container */
      .container-narrow {
        margin: 0 auto;
        max-width: 700px;
      }
      .container-narrow > hr {
        margin: 30px 0;
      }

      /* Main marketing message and sign up button */
      .jumbotron {
        margin: 60px 0;
        text-align: center;
      }
      .jumbotron h1 {
        font-size: 72px;
        line-height: 1;
      }
      .jumbotron .btn {
        font-size: 21px;
        padding: 14px 24px;
      }

      /* Supporting marketing content */
      .marketing {
        margin: 60px 0;
      }
      .marketing p + h4 {
        margin-top: 28px;
      }
    </style>
    
   
</head>

<body>
 <div class="container-narrow">

      <div class="masthead">
        <ul class="nav nav-pills pull-right">
          <li class="active"><a href="web/system/user/login">登陆</a></li>
          <li><a href="javascript:void(0)">框架介绍</a></li>
          <li><a href="javascript:void(0)">联系</a></li>
        </ul>
        <h3 class="muted">myframe</h3>
      </div>

      <hr>

      <div class="jumbotron">
        <h1>经典Web框架!</h1>
        <p class="lead">该框架采用最新的企业级框架Spring,Mybatis和Apache的Shiro，它们的组合将为我们书写无限辉煌的历史！</p>
        <a class="btn btn-large btn-success" href="web/main">开始使用</a>
         
      </div>

      <hr>

      <div class="footer">
        <p>&copy; author:gandilong</p>
      </div>

    </div> <!-- /container -->
</body>
</html>
