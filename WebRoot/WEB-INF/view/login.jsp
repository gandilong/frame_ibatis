<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@include file="../../include/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
       <%@include file="../../include/layout.jsp"%>
       
       <script type="text/javascript">
        
           function loginError(){
		           $.layer({
					    type:1,
					    closeBtn:false,
						shadeClose:true,
					    time:6,
					    page:{html:'<table><tr><td><img src="${ctx}/tools/head_image/heimao.jpg"/></td><td align="right">登<br/>陆<br/>失<br/>败！<br/></td></tr></table>'},
					    title : false,
					    area : ['300px','200px'],
					    success : function(){ //层加载成功后进行的回调
					        layer.shift('right-bottom',1000); //浏览器右下角弹出
					    },
					    end : function(){ //层彻底关闭后执行的回调
					      
					    }
					});
		    }
        
           $(function(){
                
                var error='${values.error}';
                
                if(error&&error.length>0){
                    loginError();
                }
           
           });
           
        
       </script>
       
  </head>
  
  <body>
    <div class="container">
       <%-- 
       <c:if test="${!empty values.error }">
         <div class="alert alert-block alert-error fade in">
            <button data-dismiss="alert" class="close" type="button">×</button>
            <h4 class="alert-heading">
                  <c:if test='${"1" eq values.error }'>
                                                      用户名或密码错误！
                  </c:if> 
                  <c:if test='${"2" eq values.error }'>
                                                      账户己停用！
                  </c:if> 
                  <c:if test='${"3" eq values.error }'>
                                                     认证失败！
                  </c:if> 
            </h4>
            <p>请输入正确的用户名和密码，如有其它疑问请找管理员！</p>
          </div>
       </c:if>
       --%>
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
