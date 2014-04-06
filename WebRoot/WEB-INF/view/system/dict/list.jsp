<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  
      <table id="grid"></table>
      
      <div id="tb" style="padding:5px;height:auto">
          <div style="margin-bottom:5px">
			<a href="javascript:void(0)" id="toInsert" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
			<a href="javascript:void(0)" id="toUpdate" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:void(0)" id="toDelete" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
			&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" id="toInto" class="easyui-linkbutton" iconCls="icon-back" value="0" plain="true">下一级</a>
			<a href="javascript:void(0)" id="toBack" class="easyui-linkbutton" iconCls="icon-undo" plain="true">上一级</a>
		 </div>
		<div>
		       名称：<sub><input type="text" id="title" name="title" style="height:12px;width:120px;font-size:12px" /></sub>
                          标识：<sub><input type="text" id="name" name="name" style="height:12px;width:120px;font-size:12px"/></sub>
			<a href="javascript:void(0)" id="query" class="btn" iconCls="icon-search">查&nbsp;&nbsp;询</a>
		</div>
	  </div>
      
<script type="text/javascript">
$(function(){
		
		    //初始化数据列表
		$('#grid').datagrid({
			    title:'字典列表',
			    iconCls:'icon-camera',
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
			    url:'system/dict/data',
			    pagination:true,
			    rownumbers:true,
			    columns:[[
			              {field:'id',title:'编号',width:80,hidden:true},
			              {field:'title',title:'名称',width:120,sortable:false},
			              {field:'name',title:'标识',width:100,sortable:false},
			              {field:'code',title:'代码',width:90,sortable:true},
			              {field:'opt',title:'备注',width:250,sortable:false}
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
		    
		    
		    $('#query').click(function(){
		           query();
		    });
		    
		    $('#toInsert').click(function(){
		        var height=null;
		        if('0'!=$('#toInto').attr('value')){
		              height='510px';
		 	    }else{
		              height='400px';
			     }
			       $.layer({
			            type : 1,
			            title:'字典信息',
			            offset : ['50%', ''],
			            page : {
			                url :'system/dict/form?parent='+$('#toInto').attr('value')
			            },	
			            area : ['600px',height]
			        });
			     
		    });
		    
		    $('#toUpdate').click(function(){
		      
		          var row=$('#grid').datagrid('getSelected');
				  if(null==row||!row){
				        layer.alert('请选择记录！', 8,'提示');
				        return false;
				   }
		      
		           if('0'!=$('#toInto').attr('value')){
		                height='510px';
			 	    }else{
			            height='400px';
				    }
		      
		           $.layer({
			            type:1,
			            title:'字典信息',
			            offset : ['50%', ''],
			            page : {
			                url :'system/dict/form?id='+row.id
			            },	
			            area : ['600px',height]
			        });
		    });
		    
		    
		    $('#toDelete').click(function(){
		      
		          var row=$('#grid').datagrid('getSelected');
				  if(null==row||!row){
				        layer.alert('请选择记录！', 8,'提示');
				        return false;
				   }
		      
		            $.ajax({
		               type: "POST",
		               url: "system/dict/formDelete",
		               data: "id="+row.id,
		               success: function(msg){
		                   $('#grid').datagrid('reload');
		               }
		           });
		    });
		    
		    $('#toInto').click(function(){
		        
		        var row=$('#grid').datagrid('getSelected');
				  if(null==row||!row){
				        layer.alert('请选择记录！', 8,'提示');
				        return false;
				   }
		        
		        if('0'!=$('#toInto').attr('value')){
		              layer.alert('己经是最后一级了！', 8,'提示');
		 	          return;
		 	     }else{
		            $('#toInto').attr('value',row.id);
			        $('#grid').datagrid('load',{parent:row.id});
		        }
		    });
		    
		 	$('#toBack').click(function(){
		 	      if('0'==$('#toInto').attr('value')){
		 	          return;
		 	      }else{
		 	          $('#toInto').attr('value',0);
		 	          $('#grid').datagrid('load',{parent:0});
		 	      
		 	      }
		 	});		
});
		
		//查询方法
		function query(){
		    var params={};
		    
		    if(''!=$.trim($('#title').val())){
		        params.title=$('#title').val();
		    }
		    
		    if(''!=$.trim($('#name').val())){
		        params.name=$('#name').val();
		    }
		    
		    $('#grid').datagrid('load',params);
		}
		
      </script>