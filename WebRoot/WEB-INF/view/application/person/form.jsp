<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../../../include/taglibs.jsp" %>
<div class="row-fluid">
        <div class="span12">    
           <form id="fm" class="form-horizontal" action="system/user/formSave" method="post">
               <fieldset>
                   <legend class="text-info" style="font-size:16px;font-weight: bolder">员工表单</legend>
                   <input type="hidden" id="id" name="id" value="${values.id}">
		           <div class="control-group">
		               <div class="controls">
		                     <label class="control-label" for="title">项目名称：</label>
		                     <input placeholder="请输入项目名称" class="input-xlarge" type="text" id="title" name="title" value="${values.title}" />
		               </div>
		           </div>
		
		          <div class="control-group">
		                <div class="controls">
		                    <label class="control-label" for="code">项目代码：</label>
		                    <input placeholder="请输入项目代码" class="input-xlarge" type="text" id="code" name="code" value="${values.code}"/>
		                </div>
		        </div>
		        <div class="control-group">
		            <div class="controls input-append">
		                <label class="control-label" for="person">项目负责人：</label>
		                <input placeholder="请选择" class="input-xlarge" type="text" id="person" name="person" value="${values.person}" />
		                <button class="btn" type="button" onclick="selection()"><span class="icon-user" id="personSelect"></span></button>
		            </div>
		            
		        </div>
		        
		        <div class="control-group">
		            <div class="controls input-append">
		                <label class="control-label" for="devPerson">开发人员：</label>
		                <textarea id="devPerson" name="devPerson" rows="3" cols="90" class="input-xlarge">${values.devPerson}</textarea>
		                <button class="btn" type="button" onclick="selection()"><span class="icon-user" id="personSelect"></span></button>
		            </div>
		        </div>
		        
		        <div class="control-group">
		            <div class="controls  input-append">
		                <label class="control-label" for="testPerson">测试人员：</label>
		                <textarea id="testPerson" name="testPerson" rows="3" cols="120" class="input-xlarge">${values.testPerson}</textarea>
		                <button class="btn" type="button" onclick="selection()"><span class="icon-user" id="personSelect"></span></button>
		            </div>
		        </div>
		        
		        <div class="control-group">
		            <div class="controls">
		                <label class="control-label" for="status">项目状态：</label>
		                <label>
		                       <select name="status">
		                           <option value="0"  <c:if test='${0 eq values.status or empty values.status}'>selected="selected"</c:if> >筹备</option>
		                           <option value="1" <c:if test='${1 eq values.status}'> selected="selected" </c:if>>开发</option>
		                           <option value="2" <c:if test='${2 eq values.status}'> selected="selected" </c:if>>测试</option>
		                           <option value="3" <c:if test='${3 eq values.status}'> selected="selected" </c:if>>准备</option>
		                       </select>
		                </label>
		            </div>
		        </div>
		        <div class="control-group">
		            <div class="controls">
		                <label class="control-label" for="opt">备注：</label>
		                 <textarea  name="opt" rows="3" cols="90" class="input-xlarge"></textarea>
		            </div>
		        </div>
		        <div class="control-group offset3">
		            <div class="controls">
		                <button type="submit" class="btn btn-primary">保存</button>
		                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                <button class="btn" onclick="back();">返回</button>
		            </div>
		        </div>
		    </fieldset>
		  </form>
       </div>
    </div>
</div>

<script type="text/javascript">
<!--
 
     function back(){
          $('#project').layout('panel','center').panel('refresh','project/project/list');
     }

     function selection(){
         layer.alert({title:'dd'});
     }


     $(function() {
        
       //表单验证
       $("#fm").validate({
           rules:{
               title:{required:true,minlength:2,maxlength:16},
               code:{required:true,minlength:2,maxlength:12,lettersonly:true,remote:{
                    url: "project/project/exist",     //后台处理程序
                    type: "post",               //数据发送方式
                    dataType: "json",           //接受数据格式   
                    data: { //要传递的数据
                        code: function() {
                             var id=$.trim($('#id').val());
                             if(''!=id&&parseInt(id)>0){
                                 return 'undefined';
                             }
                             return $("#code").val();
                        }
                    }
               }},
               person:{required:true,minlength:6,maxlength:16},
               devPerson:{required:true,minlength:6,maxlength:126},
               testPerson:{required:true,minlength:6,maxlength:106}
           },
           messages:{
               loginName:{
                   lettersonly:'只能输入小写字母！',
                   remote:'该项目代码己存在！'
               }
           },
           submitHandler:function(form){
               $.ajax({
                   type: "POST",
                   url: "project/project/toInsert",
                   data: $("#fm").serialize(),
                   success: function(msg){
                      $('#project').layout('panel','center').panel('refresh','project/project/list');
                   }
               });
               
           }
       });
     });
//-->
</script>