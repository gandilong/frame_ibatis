<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container" style="margin:16px">
    <div class="row-fluid">
        <div class="span6 offset3">    
           <form id="fm" class="form-horizontal" action="system/user/formSave" method="post">
               <fieldset>
                   <legend class="text-info">用户信息</legend>
		           <div class="control-group">
		               <label class="control-label" for="userName">用户名：</label>
		               <div class="controls">
		                     <input placeholder="请输入用户名" class="input-xlarge" type="text" id="userName" name="userName" />
		                     <p class="help-block">可以是中文或英文名</p>
		               </div>
		           </div>
		
		          <div class="control-group">
		                <label class="control-label" for="loginName">登陆账号：</label>
		                <div class="controls">
		                    <input placeholder="请输入登陆账号" class="input-xlarge" type="text" id="loginName" name="loginName"/>
		                    <p class="help-block">由字母，数字或下划线组成</p>
		                </div>
		        </div>
		        
		        <div class="control-group">
		            <label class="control-label" for="loginPass">登陆密码：</label>
		            <div class="controls">
		                <input placeholder="请输入登陆密码" class="input-xlarge" type="password" id="loginPass" name="loginPass"/>
		                <p class="help-block">由字母，数字或下划线组成</p>
		            </div>
		        </div>
		        
		        <div class="control-group">
		            <label class="control-label" for="reloginPass">确认密码：</label>
		            <div class="controls">
		                <input placeholder="请再输一次密码" class="input-xlarge" type="password" id="reloginPass" name="reloginPass" required/>
		                <p class="help-block">请保持两次密码一致</p>
		            </div>
		        </div>
		        
		        <div class="control-group">
		            <label class="control-label" for="email">邮箱：</label>
		            <div class="controls">
		                <input placeholder="请输入邮箱地址" class="input-xlarge" type="email" id="email" name="email"/>
		                <p class="help-block">该项不是必填的</p>
		            </div>
		        </div>
		        
		        <div class="control-group">
		            <label class="control-label">是否：</label>
		            <div class="controls">
		                <label class="checkbox">
		                    <input value="1" type="checkbox" id="used" name="used"/>
		                                                     启用
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

<<script type="text/javascript">
<!--
     $(function() {
       $("#fm").validate({
           rules:{
               userName:{required:true,minlength:2,maxlength:9},
               loginName:{required:true,minlength:2,maxlength:12},
               loginPass:{required:true,minlength:6,maxlength:16},
               reloginPass:{required:true,minlength:6,maxlength:16,equalTo:'#loginPass'},
               email:{required:false,email:true}
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













<%-- 
<div class="container" style="margin:16px">
    <div class="row-fluid">
        <div class="span6 offset3">       
            <form id="fm" class="form-horizontal" style="overflow:auto">
                 <div class="control-group input-prepend">
                     <label for="userName" class="add-on"><span class="icon-asterisk"></span>用户名：</label>
                     <input id="userName" type="text" name="userName" size="120" width="120" placeholder="请输入用户名" required />
                 </div>
                 <div class="control-group input-prepend">
                     <label class="add-on" for="loginName"><span class="icon-asterisk"></span>登陆名：</label>
                     <input id="loginName" type="text" name="loginName" placeholder="请输入由字母和数字组成的登陆名" required/>
                 </div>
                 <div class="control-group input-prepend">
                     <label class="add-on" for="loginPass"><span class="icon-asterisk"></span>登陆密码：</label>
                     <input id="loginPass" type="password" name="loginPass"  placeholder="请输入登陆密码" required/>
                 </div>
                 <div class="control-group input-prepend">
                     <label class="add-on" for="reloginPass"><span class="icon-asterisk"></span>确认密码：</label>
                     <input id="reloginPass" type="password" name="reloginPass" placeholder="请再次输入登陆密码" required/>
                 </div>
                  <div class="control-group input-prepend">
                     <label class="add-on" for="email">邮&nbsp;&nbsp;&nbsp;&nbsp;箱：</label>
                     <input id="email" type="text" name="email" placeholder="请输邮箱地址"/>
                 </div>
                 <div class="control-group input-prepend">
                     <label class="add-on" for="used">是否启用：</label>
                     <div class="make-switch">
                         <input id="used" name="used" type="checkbox" class="btn" />
                     </div>
                 </div>
                 <div class="control-group">
                     <label class="control-label" for="inputPassword">启用</label>
                     <div class="controls">
                         <input type="submit" id="submit" class="btn btn-primary" value="提交">
                     </div>
                 </div>
    </form>
        </div>
    </div>
</div>
--%>
