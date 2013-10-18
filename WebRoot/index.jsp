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
    <%-- 
    <script src="https://togetherjs.com/togetherjs-min.js"></script>
    
    
    <script type="text/javascript">
         $(function(){
              TogetherJSConfig_on= {
                     ready:function(){
                         $('#together').text('结束');
                     },
                     close:function(){
                         $('#together').text('开始');
                     }
               };
               
               TogetherJS.hub.on("visibilityChange", function (msg) {
                   var elementFinder = TogetherJS.require("elementFinder");
                   // If the element can't be found this will throw an exception:
                   var location  = elementFinder.findElement(msg.element);
                   //MyApp.changeVisibility(element, msg.isVisible);
                   TogetherJS.send({type: "visibilityChange", isVisible: isVisible, element: location});
               });
         });
    </script>
    --%>
    <script type="text/javascript">
      $(function(){
          $.ajax({
             type: "POST",
             url: "web/client/rss/",
             data: "",
             dataType:'json',
             success: function(msg){
             
                var hlwData=msg.rss_newsgn;
                var itjData=msg.rss_newssports;
                var kjttData=msg.rss_mobilepk;
                
                for(var i in hlwData){
                    $('#hlw').append('<dt><span><a href="'+hlwData[i].link+'" target="_blank">'+hlwData[i].title+'</a></span><dt><dd><p style="font-size:12px">'+hlwData[i].description+'</p></dd></dt>');
                }
                
                for(var i in itjData){
                    $('#itj').append('<dt><span><a href="'+itjData[i].link+'" target="_blank">'+itjData[i].title+'</a></span><dt><dd><p style="font-size:12px">'+itjData[i].description+'</p></dd></dt>');
                }
                
                for(var i in kjttData){
                    $('#kjtt').append('<dt><span><a href="'+kjttData[i].link+'" target="_blank">'+kjttData[i].title+'</a></span><dt><dd><p style="font-size:12px">'+kjttData[i].description+'</p></dd></dt>');
                }
                
             }
          });
      });
    </script>
    
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

      <div class="row-fluid marketing">
        
            <div class="span4">
                <h2>国内新闻</h2>
                <dl id="hlw"></dl>
            </div>
            <div class="span4">
                <h2>体育频道</h2>
                <dl id="itj"></dl>
            </div>
            <div class="span4">
                <h2>手机行情</h2>
                <dl id="kjtt"></dl>
            </div>
      </div>

      <hr>

      <div class="footer">
        <p>&copy; author:gandilong</p>
      </div>

    </div> <!-- /container -->
</body>
</html>
