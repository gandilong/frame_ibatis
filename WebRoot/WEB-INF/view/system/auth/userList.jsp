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
	
	<div id="tb" style="padding:5px;height:auto">
		<div>
			日期 从: <input class="easyui-datebox" id="startTime" data-options="formatter:dateFormatter,parser:dateParser" style="width:120px" />
			至: <input class="easyui-datebox" id="endTime" data-options="formatter:dateFormatter,parser:dateParser" style="width:120px" />
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="query()" >查&nbsp;&nbsp;询</a>
		</div>
	</div>
	
     
     <script type="text/javascript">
		$(function(){
		
		    //初始化数据列表
			$('#userGrid').datagrid({
			    title:'用户列表',
			    iconCls:'icon-user',
			    fit:true,
			    striped:true,
			    sortName:'id',
			    sortOrder:'desc',
			    collapsible:false,
			    toolbar:'#tb',
			    singleSelect:true,
			    loadMsg:'数据加载中...',
			    remoteSort:true,
			    idField:'id',
			    url:'system/auth/userData',
			    pagination:true,
			    rownumbers:true,
			    toolbar:[{
			        text:'新增',
			        iconCls:'icon-add',
			        handler:function(){
			            $('#system').layout('panel','center').panel('refresh','system/auth/userForm');
			        }
			    },'-',{
			        text:'编辑',
			        iconCls:'icon-edit',
			        handler:function(){
			        
			        }
			    },'-',{
			        text:'删除',
			        iconCls:'icon-remove',
			        handler:function(){
			        
			        }
			    }]
			});
			
			
			var p = $('#userGrid').datagrid('getPager');
		    $(p).pagination({
		          displayMsg:'显示 {from} 到 {to} 共 {total} 条'
		    });
			
			
		});
		
		//查询方法
		function query(){
		    $('#userGrid').datagrid('load',{startTime:$('#startTime').datebox('getValue'),endTime:$('#endTime').datebox('getValue')});
		}
		
      </script>