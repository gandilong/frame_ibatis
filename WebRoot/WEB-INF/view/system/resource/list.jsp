<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  
      <table id="resourceGrid">
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
			$('#resourceGrid').datagrid({
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
			    rownumbers:true
			});
		});
      </script>