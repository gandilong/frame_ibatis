<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  
      <table id="grid"></table>
     
<script type="text/javascript">
$(function(){
			$('#grid').datagrid({
			    title:'资源列表',
			    iconCls:'icon-leaf',
			    fit:true,
			    collapsible:false,
			    singleSelect:true,
			    loadMsg:'数据加载中...',
			    sortName:'id',
			    sortOrder:'desc',
			    remoteSort:true,
			    idField:'id',
			    url:'system/resource/listData',
			    pagination:true,
			    rownumbers:true,
			    columns:[[
			              {field:'id',title:'编号',width:80,hidden:true},
			              {field:'name',title:'标记',width:120,sortable:true},
			              {field:'title',title:'名称',width:120,sortable:false}
			              ]],
			    toolbar:'#tb'
			});
			
			
			var p = $('#grid').datagrid('getPager');
		    $(p).pagination({
		          displayMsg:'显示 {from} 到 {to} 共 {total} 条'
		    });
});
</script>