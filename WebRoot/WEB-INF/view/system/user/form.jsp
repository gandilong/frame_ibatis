<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../include/taglibs.jsp" %>
<div class="container" style="margin:16px">
    <div class="row-fluid">
        <div class="span6 offset3">    
           <form id="fm" class="form-horizontal" action="system/user/formSave" method="post">
               <fieldset>
                   <legend class="text-info">用户信息</legend>
                   <input type="hidden" id="id" name="id" value="${values.id}">
		           <div class="control-group">
		               <label class="control-label" for="userName">用户名：</label>
		               <div class="controls">
		                     <input placeholder="请输入用户名" class="input-xlarge" type="text" id="userName" name="userName" value="${values.userName}" />
		                     <p class="help-block">可以是中文或英文名</p>
		               </div>
		           </div>
		
		          <div class="control-group">
		                <label class="control-label" for="loginName">登陆账号：</label>
		                <div class="controls">
		                    <input placeholder="请输入登陆账号" class="input-xlarge" type="text" id="loginName" name="loginName" value="${values.loginName}"/>
		                    <p class="help-block">由字母，数字或下划线组成</p>
		                </div>
		        </div>
		     <c:if  test="${empty values.id}">   
		        <div class="control-group">
		            <label class="control-label" for="loginPass">登陆密码：</label>
		            <div class="controls">
		                <input placeholder="请输入登陆密码" class="input-xlarge" type="password" id="loginPass" name="loginPass" value="${values.loginPass}" />
		                <p class="help-block">由字母，数字或下划线组成</p>
		            </div>
		        </div>
		        
		        <div class="control-group">
		            <label class="control-label" for="reloginPass">确认密码：</label>
		            <div class="controls">
		                <input placeholder="请再输一次密码" class="input-xlarge" type="password" id="reloginPass" name="reloginPass" value="${values.reloginPass }" />
		                <p class="help-block">请保持两次密码一致</p>
		            </div>
		        </div>
		    </c:if>
		        <div class="control-group">
		            <label class="control-label" for="email">邮箱：</label>
		            <div class="controls">
		                <input placeholder="请输入邮箱地址" class="input-xlarge" type="text" id="email" name="email" value="${values.email }" />
		                <p class="help-block">该项不是必填的</p>
		            </div>
		        </div>
		        
		        <div class="control-group">
		            <label class="control-label">启用：</label>
		            <div class="controls">
		                <label>
		                       <select name="used">
		                           <option value="0"  <c:if test='${0 eq values.used or empty values.used}'>selected="selected"</c:if> >否</option>
		                           <option value="1" <c:if test='${1 eq values.used}'> selected="selected" </c:if>>是</option>
		                       </select>
		                </label>
		            </div>
		        </div>
		        <div class="control-group">
		            <label class="control-label"></label>
		            <div class="controls">
		                <button type="submit" class="btn btn-primary">保存</button>
		            </div>
		        </div>
		    </fieldset>
		  </form>
       </div>
    </div>
</div>

<script type="text/javascript">
<!--
     $(function() {
       $("#fm").validate({
           rules:{
               userName:{required:true,minlength:2,maxlength:9},
               loginName:{required:true,minlength:2,maxlength:12,lettersonly:true,remote:{
                    url: "system/user/exist",     //后台处理程序
                    type: "post",               //数据发送方式
                    dataType: "json",           //接受数据格式   
                    data: { //要传递的数据
                              
                        loginName: function() {
                               return $("#loginName").val();
                        }
                    }
               }},
               loginPass:{required:true,minlength:6,maxlength:16},
               reloginPass:{required:true,minlength:6,maxlength:16,equalTo:'#loginPass'},
               email:{required:false,email:true}
           },
           messages:{
               loginName:{
                   lettersonly:'只能输入小写字母！',
                   remote:'该账号己存在！'
               }
           },
           submitHandler:function(form){
               $.ajax({
                   type: "POST",
                   url: "system/user/formSave",
                   data: $("#fm").serialize(),
                   success: function(msg){
                      $('#system').layout('panel','center').panel('refresh','system/user/list');
                   }
               });
               
           }
       });
     });
//-->
</script>
