<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  
      <table id="roleGrid">
		<thead>
			<tr>
				<th field="id" width="80" data-options="sortable:true">编号</th>
				<th field="name" width="150" align="center" data-options="sortable:true">标记</th>
				<th field="title" width="160" align="center">名称</th>
			</tr>
		</thead>
	</table>
     
     <script type="text/javascript">
		$(function(){
			$('#roleGrid').datagrid({
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
			    rownumbers:true
			});
		});
      </script>