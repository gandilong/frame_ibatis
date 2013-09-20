<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  
      <table id="userGrid">
		<thead>
			<tr>
				<th field="id" width="80" data-options="sortable:true">编号</th>
				<th field="user_name" width="150" align="center">用户名</th>
				<th field="login_name" width="120" align="center">账号</th>
				<th field="create_time" width="180" align="center" data-options="sortable:true">创建时间</th>
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
			    singleSelect:true,
			    loadMsg:'数据加载中...',
			    remoteSort:true,
			    tools:[{
			       iconCls:'icon-add',
			       handler:function(){
			          alert('ddd');
			       }
			    },{
			       iconCls:'icon-add',
			       handler:function(){
			          alert('ddd');
			       }
			    }],
			    idField:'id',
			    url:'system/auth/userData',
			    pagination:true,
			    rownumbers:true
			});
		});
      </script>