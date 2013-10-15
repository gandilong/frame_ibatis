<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  
      <table id="grid"></table>
      
      <div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="javascript:void(0)" id="toInsert" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
			<a href="javascript:void(0)" id="toEdit" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:void(0)" id="toDelete" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div>
		<div>
			日期: <input class="easyui-datebox" id="startTime" name="startTime" data-options="formatter:dateFormatter,parser:dateParser" style="width:120px">
			到: <input class="easyui-datebox" id="endTime" name="endTime" data-options="formatter:dateFormatter,parser:dateParser" style="width:120px">
			启用: 
			<select class="easyui-combobox" id="used" name="used" panelHeight="auto" style="width:50px">
				<option value="1">是</option>
				<option value="0">否</option>
			</select>
			<a href="javascript:void(0)" id="query" class="easyui-linkbutton" iconCls="icon-search">查&nbsp;&nbsp;询</a>
		</div>
	  </div>
      
<script type="text/javascript">
$(function(){
		
		    //初始化数据列表
		$('#grid').datagrid({
			    title:'用户列表',
			    iconCls:'icon-user',
			    fit:true,
			    striped:true,
			    sortName:'id',
			    sortOrder:'desc',
			    collapsible:false,
			    singleSelect:true,
			    loadMsg:'数据加载中...',
			    remoteSort:true,
			    pageSize:30,
			    pageList:[15,30,50],
			    queryParams:{pageNow:1,pageSize:30},
			    idField:'id',
			    url:'system/user/listData',
			    pagination:true,
			    rownumbers:true,
			    columns:[[
			              {field:'id',title:'编号',width:80,hidden:true},
			              {field:'userName',title:'用户名',width:120,sortable:false},
			              {field:'loginName',title:'登陆账号',width:120,sortable:true},
			              {field:'email',title:'邮箱',width:180,sortable:true},
			              {field:'used',title:'启用',width:90,sortable:true,formatter:function(value,row,index){if(0==value){return '否';}else{return '是';}}},
			              {field:'createTime',title:'创建时间',width:160,sortable:true}
			              ]],
			    toolbar:'#tb'
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
		    $('#system').layout('panel','center').panel('refresh','system/user/form');
		}
		
		//修改方法
		function toUpdate(){
		    var row=$('#grid').datagrid('getSelected');
		    if(null==row||!row){
		        layer.alert('请选择记录！', 8,'提示');
		        return false;
		    }
			$('#system').layout('panel','center').panel('refresh','system/user/form?id='+row.id);
		}
		
		
		//删除一条记录
		function toDelete(){
		    var row=$('#grid').datagrid('getSelected');
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