<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  
      <table id="userGrid" data-options="rownumbers:true,singleSelect:true,autoRowHeight:false,pagination:true,pageSize:1">
		<thead>
			<tr>
				<th field="id" width="80">编号</th>
				<th field="user_name" width="100">用户名</th>
				<th field="login_name" width="80">账号</th>
				<th field="create_time" width="80" align="right">创建时间</th>
			</tr>
		</thead>
	</table>
     
     <script type="text/javascript">
		$(function(){
			$('#userGrid').datagrid({
			    title:'用户列表',
			    iconCls:'icon-save',
			    fit:true,
			    collapsible:false,
			    sortName:'id',
			    sortOrder:'desc',
			    remoteSort:true,
			    idField:'id',
			    url:'system/auth/userData',
			    pagination:true,
			    rownumbers:true
			});
		});
      </script>