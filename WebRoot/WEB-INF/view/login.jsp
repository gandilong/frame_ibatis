<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../include/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
       <%@include file="../../include/layout.jsp"%>
  </head>
  
  <body>
    <div class="container">
       
       <c:if test="${!empty error }">
           ${error }
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
