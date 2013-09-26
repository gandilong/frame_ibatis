<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  
      <table id="grid"></table>
     
      <div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="javascript:void(0)" id="toInsert" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
			<a href="javascript:void(0)" id="toEdit" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:void(0)" id="toDelete" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div>
	  </div>
     
     <script type="text/javascript">
$(function(){
			$('#grid').datagrid({
			    title:'角色列表',
			    iconCls:'icon-star-empty',
			    fit:true,
			    collapsible:false,
			    singleSelect:true,
			    loadMsg:'数据加载中...',
			    sortName:'id',
			    sortOrder:'desc',
			    remoteSort:true,
			    idField:'id',
			    url:'system/role/listData',
			    pagination:true,
			    rownumbers:true,
			    columns:[[
			              {field:'id',title:'编号',width:80,hidden:true},
			              {field:'name',title:'标记',width:120,sortable:true},
			              {field:'title',title:'名称',width:120,sortable:false}
			              ]],
			    toolbar:'#tb'
			});//grid end
			
			
			var p = $('#grid').datagrid('getPager');
		    $(p).pagination({
		          displayMsg:'显示 {from} 到 {to} 共 {total} 条'
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
      </script>