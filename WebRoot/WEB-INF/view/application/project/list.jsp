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
		    项目名称：<input type="text" name="title" style="width:150px;height:15px" />
		    项目代码：<input type="text" name="code" style="width:100px;height:15px"/>
			日期: <input class="easyui-datebox" id="startTime" name="startTime" data-options="formatter:dateFormatter,parser:dateParser" style="width:120px">
			到: <input class="easyui-datebox" id="endTime" name="endTime" data-options="formatter:dateFormatter,parser:dateParser" style="width:120px">
			状态:
			<select class="easyui-combobox" id="status" name="status" panelHeight="auto" style="width:80px">
				<option value="0">筹备中</option>
				<option value="1">开发中</option>
				<option value="2">测试中</option>
				<option value="3">维护中</option>
			</select>
			<a href="javascript:void(0)" id="query" class="easyui-linkbutton" iconCls="icon-search">查&nbsp;&nbsp;询</a>
		</div>
	  </div>

	  <div id="cmenus" class="easyui-menu" style="width:120px;">
	     <shiro:hasRole name="admin">
	         <div id="resetPassword" data-options="iconCls:'icon-plus-sign'">开始开发</div>
             <div class="menu-sep"></div>
             <div id="delete" data-options="iconCls:'icon-trash'">删除</div>
          </shiro:hasRole>
    </div>
    
<script type="text/javascript">
$(function(){
		
		//初始化数据列表
		$('#grid').datagrid({
			    title:'项目列表',
			    iconCls:'icon-globe',
			    fit:true,
			    striped:true,
			    sortName:'createTime',
			    sortOrder:'desc',
			    collapsible:false,
			    singleSelect:true,
			    loadMsg:'数据加载中...',
			    remoteSort:true,
			    pageSize:30,
			    pageList:[15,30,50],
			    queryParams:{pageNow:1,pageSize:30},
			    idField:'id',
			    url:'application/project/listData',
			    pagination:true,
			    rownumbers:true,
			    columns:[[
			              {field:'id',title:'编号',width:80,hidden:true},
			              {field:'title',title:'项目名称',width:160,sortable:false},
			              {field:'code',title:'项目代码',width:100,sortable:true},
			              {field:'person',title:'项目负责人',width:120,sortable:true},
			              {field:'createTime',title:'创建时间',width:160,sortable:true},
			              {field:'opt',title:'备注',width:360,sortable:false}
			              ]],
			    toolbar:'#tb',
			    onRowContextMenu:function(e,rowIndex, rowData){
			                        e.preventDefault();
			                        
			                      			                        
			                        $('#grid').datagrid("selectRow",rowIndex);
			                       
			                      			                        
			                        $('#delete').click(function(){
			                              toDelete(rowData);
			                        });//右键删除 添加点击事件
			                        
			                        
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
		    $('#project').layout('panel','center').panel('refresh','application/project/form');
		}
		
		//修改方法
		function toUpdate(){
		    var row=$('#grid').datagrid('getSelected');
		    if(null==row||!row){
		        layer.alert('请选择记录！', 8,'提示');
		        return false;
		    }
			$('#project').layout('panel','center').panel('refresh','system/user/form?id='+row.id);
		}
		
		
		//删除一条记录
		function toDelete(p_row){
		    var row=$('#grid').datagrid('getSelected');
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
		


		
      </script>