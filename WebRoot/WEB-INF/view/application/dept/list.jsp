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
		    部门名称：<sub><input type="text" id="title" name="title" style="width:150px;height:12px" /></sub>
		    部门代码：<sub><input type="text" id="code" name="code" style="width:100px;height:12px"/></sub>
			<a href="javascript:void(0)" id="query" class="easyui-linkbutton" iconCls="icon-search">查&nbsp;&nbsp;询</a>
		</div>
	  </div>

<script type="text/javascript">
$(function(){
		
		//初始化数据列表
		$('#grid').treegrid({
			    title:'部门列表',
			    iconCls:'icon-th-large',
			    fit:true,
			    animate:true,
			    treeField:'title',
			    striped:true,
			    sortName:'id',
			    sortOrder:'desc',
			    collapsible:false,
			    singleSelect:true,
			    loadMsg:'数据加载中...',
			    remoteSort:true,
			    idField:'id',
			    url:'application/dept/tree',
			    rownumbers:true,
			    columns:[[
			              {field:'title',title:'部门名称',width:160,sortable:false},
			              {field:'code',title:'部门代码',width:100,sortable:true},
			              {field:'personName',title:'部门经理',width:120,sortable:false},
			              {field:'opersonName',title:'部门助理',width:120,sortable:false},
			              {field:'phone',title:'电话',width:150,sortable:false},
			              {field:'opt',title:'备注',width:250,sortable:false},
			              ]],
			    toolbar:'#tb'
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
		    params.title=$('#title').val();
		    params.code=$('#code').val();
		    
		    $('#grid').treegrid('load',params);
		}
		
		//新增方法
		function toInsert(){
		    $('#application').layout('panel','center').panel('refresh','application/dept/form');
		}
		
		//修改方法
		function toUpdate(){
		    var row=$('#grid').treegrid('getSelected');
		    if(null==row||!row){
		        layer.alert('请选择记录！', 8,'提示');
		        return false;
		    }
			$('#application').layout('panel','center').panel('refresh','application/dept/form?id='+row.id);
		}
		
		
		//删除一条记录
		function toDelete(p_row){
		    var row=$('#grid').treegrid('getSelected');
		    if(null==row||!row){
		        layer.alert('请选择记录！', 8,'提示');
		        return false;
		    }
		    $.ajax({
               type: "POST",
               url: "system/user/formDelete",
               data: "id="+row.id,
               success: function(msg){
                   $('#grid').treegrid('reload');
               }
           });
		}
		


		
      </script>