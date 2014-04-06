<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../include/taglibs.jsp" %>
<div class="container">
        <div class="span6">    
           <form id="fm" class="form-horizontal" action="system/dict/formSave" method="post">
               <fieldset>
                   <hr/>
                       <input type="hidden" id="id" name="id" value="${values.id}"/>
                       <input type="hidden" id="parent" name="parent" value="${values.parent}"/>
		           <div class="control-group">
		               <label class="control-label" for="title">字典名称：</label>
		               <div class="controls">
		                     <input placeholder="请输入字典名称" class="input-xlarge" type="text" id="title" name="title" value="${values.title}" />
		                     <p class="help-block">可以是中文或英文名</p>
		               </div>
		           </div>
		
		          <div class="control-group">
		                <label class="control-label" for="name">字典标记：</label>
		                <div class="controls">
		                    <input placeholder="请输入字典标记" class="input-xlarge" type="text" id="named" name="name" value="${values.name}"/>
		                    <p class="help-block">由字母，数字组成</p>
		                </div>
		        </div>
		        <c:if test='${!empty values.parent and "0" ne values.parent}'>
			        <div class="control-group">
			            <label class="control-label" for="code">字典值：</label>
			            <div class="controls">
			                <input placeholder="请输入字典值" class="input-xlarge" type="text" id="code" name="code" value="${values.code}" />
			                <p class="help-block">由数字组成</p>
			            </div>
			        </div>
		       </c:if>
		        <div class="control-group">
		            <label class="control-label" for="opt">备注：</label>
		            <div class="controls">
		                <textarea rows="3" cols="90" class="input-xlarge" name="opt">${values.opt}</textarea>
		            </div>
		        </div>
		        
		        <div class="control-group">
		            <div class="controls">
		                <button type="submit" class="btn btn-primary">保存</button>
		                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                <button class="btn" onclick="closeLayer();">关闭</button>
		            </div>
		        </div>
		    </fieldset>
		  </form>
       </div>
</div>

<script type="text/javascript">
<!--

     function closeLayer(){
          layer.close(layer.index);
     }

     $(function() {
       $("#fm").validate({
           rules:{
               title:{required:true,minlength:1,maxlength:9},
               name:{required:true,minlength:1,maxlength:12,lettersonly:true,remote:{
                    url: "system/dict/exist",     //后台处理程序
                    type: "post",               //数据发送方式
                    dataType: "json",           //接受数据格式   
                    data: { //要传递的数据
                        name: function() {
                             var id=$.trim($('#id').val());
                             if(''!=id&&parseInt(id)>0){
                                 return 'undefined';
                             }
                             return $("#named").val();
                        }
                    }
               }}
           },
           messages:{
               name:{
                   lettersonly:'只能输入小写字母！',
                   remote:'该字典己存在！'
               }
           },
           submitHandler:function(form){
               $.ajax({
                   type: "POST",
                   url: "system/dict/formSave",
                   data: $("#fm").serialize(),
                   success: function(msg){
                      closeLayer();
                      $('#system').layout('panel','center').panel('refresh','system/dict/list?parent='+$('#parent').val());
                   }
               });
               
           }
       });
     });
//-->
</script>
