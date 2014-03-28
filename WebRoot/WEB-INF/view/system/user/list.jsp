<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../../../include/taglibs.jsp" %>
      <table id="grid"></table>
      
      <div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="javascript:void(0)" id="toInsert" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
			<a href="javascript:void(0)" id="toEdit" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:void(0)" id="toDelete" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div>
		<div>
			日期: <input class="easyui-datebox" id="startTime" name="startTime" data-options="formatter:dateFormatter,parser:dateParser" style="width:120px">
			到: <input class="easyui-datebox" id="endTime" name="endTime" data-options="formatter:dateFormatter,parser:dateParser" style="width:120px">
			启用:
			<select class="easyui-combobox" id="used" name="used" panelHeight="auto" style="width:50px">
				<option value="1">是</option>
				<option value="0">否</option>
			</select>
			<a href="javascript:void(0)" id="query" class="easyui-linkbutton" iconCls="icon-search">查&nbsp;&nbsp;询</a>
		</div>
	  </div>
	  
	
	  <div id="cmenus" class="easyui-menu" style="width:120px;">
	     <shiro:hasRole name="admin">
             <div data-options="iconCls:'icon-off'"><span id="powerOff">启用</span></div>
             <div data-options="iconCls:'icon-star-empty'">
                <span>添加角色</span>
                <div id="roles" style="width:150px;">
                     <c:set var="print" value="0"></c:set>
                     <c:forEach items="${values.roles}"  var="role">
                         <c:forEach items="${values.user_roles}" var="urole_name">
                              <c:if test='${urole_name eq role.name}'>
                                  <div data-options="iconCls:'icon-ok-sign'" id="${role.id}"  onclick="updateRole('${role.id}','delete')">${role.title}</div>
                                  <c:set var="print" value="1"></c:set>            
                              </c:if>
                         </c:forEach>
                         
                          <c:if test='${print eq "0"}'>
                              <div id="${role.id}" onclick="updateRole('${role.id}','insert')">${role.title}</div>
                         </c:if>
                         <c:if test='${print ne "0"}'>
                             <c:set var="print" value="0"></c:set>
                         </c:if>
                         
                     </c:forEach>
                </div>
             </div>
             <div data-options="iconCls:'icon-leaf'">
                 <span>添加资源</span>
                 <div id="resources" style="width:150px;">
                     <c:set var="print" value="0"></c:set>
                     <c:forEach items="${values.resources}"  var="res">
                         <c:forEach items="${values.user_resources}" var="ures_name">
                              <c:if test='${ures_name eq res.name}'>
                                  <div data-options="iconCls:'icon-ok-sign'" id="${res.id}" onclick="updateResource('${res.id}','delete')">${res.title}</div>
                                  <c:set var="print" value="1"></c:set>         
                              </c:if>
                         </c:forEach>
                         <c:if test='${print eq "0"}'>
                              <div id="${res.id}" onclick="updateResource('${res.id}','insert')">${res.title}</div>
                         </c:if>
                         <c:if test='${print ne "0"}'>
                             <c:set var="print" value="0"></c:set>
                         </c:if>
                     </c:forEach>
                 </div>
             </div>
             <div class="menu-sep"></div>
             <div id="resetPassword" data-options="iconCls:'icon-plus-sign'">重置密码</div>
             <div class="menu-sep"></div>
             <div id="delete" data-options="iconCls:'icon-trash'">删除</div>
          </shiro:hasRole>
    </div>
    
<script type="text/javascript">
$(function(){
		
		    //初始化数据列表
		$('#grid').datagrid({
			    title:'用户列表',
			    iconCls:'icon-user',
			    fit:true,
			    striped:true,
			    sortName:'id',
			    sortOrder:'desc',
			    collapsible:false,
			    singleSelect:true,
			    loadMsg:'数据加载中...',
			    remoteSort:true,
			    pageSize:30,
			    pageList:[15,30,50],
			    queryParams:{pageNow:1,pageSize:30},
			    idField:'id',
			    url:'system/user/listData',
			    pagination:true,
			    rownumbers:true,
			    columns:[[
			              {field:'id',title:'编号',width:80,hidden:true},
			              {field:'userName',title:'用户名',width:120,sortable:false},
			              {field:'loginName',title:'登陆账号',width:120,sortable:true},
			              {field:'email',title:'邮箱',width:180,sortable:true},
			              {field:'used',title:'状态',width:90,sortable:true,formatter:function(value,row,index){if(0==value){return '停用';}else{return '启用';}}},
			              {field:'createTime',title:'创建时间',width:160,sortable:true}
			              ]],
			    toolbar:'#tb',
			    onRowContextMenu:function(e,rowIndex, rowData){
			                        e.preventDefault();
			                        $('#grid').datagrid("selectRow",rowIndex);
			                       
			                        if(1==rowData.used){
			                            $('#powerOff').text('停用');
			                            
			                        }else{
			                            $('#powerOff').text('启用');
			                        }
			                        $('#powerOff').click(function(){
			                               used(rowData);
			                        });
			                        
			                        
			                        $('#delete').click(function(){
			                              toDelete(rowData);
			                        });//右键删除 添加点击事件
			                        
			                        $('#resetPassword').click(function(){
			                               resetPassword(rowData);
			                        });//右键重置密码 添加点击事件
			                        
			                        $('#cmenus').menu('show', {
                                       left:e.pageX,
                                       top:e.pageY
                                    });
                                    
			                     }//onRowContextMenu fun end
			});
			
			
			var p = $('#grid').datagrid('getPager');
		    $(p).pagination({
		          pageSize:30,
		          beforePageText: '第',
		          afterPageText: '页    共 {pages} 页',
		          displayMsg:'显示 {from} 到 {to} 共 {total} 条',
		          onSelectPage:function(pageNumber,pageSize){
				      $('#grid').datagrid("reload",{pageNow:pageNumber,pageSize:pageSize});
			      },
			      onBeforeRefresh:function(pageNumber,pageSize){
				      $('#grid').datagrid("reload",{pageNow:pageNumber,pageSize:pageSize});
			      },
			      onChangePageSize:function(pageSize){
				      $('#grid').datagrid("reload",{pageNow:1,pageSize:pageSize});
			      }
		    });
		    
		    
		    $('#toInsert,#toEdit,#toDelete,#query').click(function(){
		         var btnId=$(this).attr('id');
		         if('toInsert'==btnId){
		             toInsert();
		         }else if('toEdit'==btnId){
		             toUpdate();
		         }else if('toDelete'==btnId){
		             toDelete();
		         }else if('query'==btnId){
		             query();
		         }
		    });
			
});
		
		//查询方法
		function query(){
		    var params={};
		    if(''!=$('#startTime').datebox('getValue')){
		        params.startTime=$('#startTime').datebox('getValue');
		    }
		    if(''!=$('#endTime').datebox('getValue')){
		       params.endTime=$('#endTime').datebox('getValue');
		    }
		    
		    params.used=$('#used').combobox('getValue');
		    
		    $('#grid').datagrid('load',params);
		}
		
		//新增方法
		function toInsert(){
		    $('#system').layout('panel','center').panel('refresh','system/user/form');
		}
		
		//修改方法
		function toUpdate(){
		    var row=$('#grid').datagrid('getSelected');
		    if(null==row||!row){
		        layer.alert('请选择记录！', 8,'提示');
		        return false;
		    }
			$('#system').layout('panel','center').panel('refresh','system/user/form?id='+row.id);
		}
		
		
		//删除一条记录
		function toDelete(p_row){
		    var row=$('#grid').datagrid('getSelected');
		    if(null!=p_row&&p_row){
		         row=p_row;
		    }
		    if(null==row||!row){
		        layer.alert('请选择记录！', 8,'提示');
		        return false;
		    }
		    $.ajax({
               type: "POST",
               url: "system/user/formDelete",
               data: "id="+row.id,
               success: function(msg){
                   $('#grid').datagrid('reload');
               }
           });
		}
		
		//重置密码
		function resetPassword(row){
		    if(null==row||!row){
		        layer.alert('请选择记录！', 8,'提示');
		        return false;
		    }
		        $.ajax({
                  type: "POST",
                  url: "system/user/resetPassword",
                  data: "id="+row.id,
                  success: function(msg){
                     $('#grid').datagrid('reload');
                  }
               });
		    
		}
		
		function used(row){
		    if(null==row||!row){
		        layer.alert('请选择记录！', 8,'提示');
		        return false;
		    }
		
		    $.ajax({
               type: "POST",
               url: "system/user/used",
               data: "id="+row.id+"&used="+row.used,
               success: function(msg){
                   $('#grid').datagrid('reload');
               }
           });
		}
		
		function updateRole(roleId,opt){
		    var row=$('#grid').datagrid('getSelected');
		    if(null==row||!row){
		        layer.alert('请选择记录！', 8,'提示');
		        return false;
		    }
		    
		       $.ajax({
                   type: "POST",
                   url: "system/user/updateRole",
                   data: "uid="+row.id+"&rid="+roleId+"&opt="+opt,
                   success: function(msg){
                       $('#grid').datagrid('reload');
                   }
               });
		}
		
		function updateResource(resId,opt){
		      var row=$('#grid').datagrid('getSelected');
		    if(null==row||!row){
		        layer.alert('请选择记录！', 8,'提示');
		        return false;
		    }
		    
		       $.ajax({
                   type: "POST",
                   url: "system/user/updateResource",
                   data: "uid="+row.id+"&resid="+resId+"&opt="+opt,
                   success: function(msg){
                       $('#grid').datagrid('reload');
                   }
               });
		}
		
		
      </script>