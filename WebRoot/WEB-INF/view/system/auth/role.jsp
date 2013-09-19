<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  
      <table id="roleGrid">
		<thead>
			<tr>
				<th field="id" width="80">编号</th>
				<th field="name" width="150" align="center">标记</th>
				<th field="title" width="120" align="center">名称</th>
			</tr>
		</thead>
	</table>
     
     <script type="text/javascript">
		$(function(){
			$('#roleGrid').datagrid({
			    title:'用户列表',
			    iconCls:'icon-save',
			    fit:true,
			    collapsible:false,
			    sortName:'id',
			    sortOrder:'desc',
			    remoteSort:true,
			    idField:'id',
			    url:'system/auth/roleData',
			    pagination:true,
			    rownumbers:true
			});
		});
      </script>