<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@include file="../../include/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
       <%@include file="../../include/layout.jsp"%>
  </head>
  
  <body>
    <div class="container">
       
       <c:if test="${!empty error }">
         <div class="alert alert-block alert-error fade in">
            <button data-dismiss="alert" class="close" type="button">×</button>
            <h4 class="alert-heading">
                  <c:if test='${"1" eq error }'>
                                                      用户名或密码错误！
                  </c:if> 
                  <c:if test='${"2" eq error }'>
                                                      账户己停用！
                  </c:if> 
                  <c:if test='${"3" eq error }'>
                                                     认证失败！
                  </c:if> 
            </h4>
            <p>请输入正确的用户名和密码，如有其它疑问请找管理员！</p>
          </div>
       </c:if>
       
      <form action="login" method="post" class="offset4" style="margin-top:100px">
         <fieldset>
             <label>
                                              登陆名：
                 <input type="text" name="username" placeholder="请输入登陆名..."/>
             </label>
             <label>
                                              密&nbsp;&nbsp;&nbsp;&nbsp;码：
                 <input type="password" name="password" placeholder="请输入密码..."/>
             </label>
             <label class="checkbox">
                 <input type="checkbox" name="remeberme"/>记住我
             </label>
             <button type="submit" class="btn offset2">登陆</button>
         </fieldset>
      </form>

    </div> <!-- /container -->
  </body>
</html>
