<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  
      <table id="grid"></table>
     
      <div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="javascript:void(0)" id="toInsert" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
			<%-- 
			<a href="javascript:void(0)" id="toEdit" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:void(0)" id="toBack" class="easyui-linkbutton" iconCls="icon-undo" plain="true">退回</a>
			--%>
			<a href="javascript:void(0)" id="toSave" class="easyui-linkbutton" iconCls="icon-save" plain="true">保存</a>
			<a href="javascript:void(0)" id="toDelete" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div>
	  </div>
     
<script type="text/javascript">
     
     var editIndex= undefined;
     
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
			    pageSize:30,
			    pageList:[15,30,50],
			    idField:'id',
			    url:'system/role/listData',
			    pagination:true,
			    rownumbers:true,
			    toolbar:'#tb',
			    columns:[[
			              {field:'id',title:'编号',width:80,hidden:true},
			              {field:'name',title:'标记',width:120,sortable:true,editor:{type:'text',options:{required:true}}},
			              {field:'title',title:'名称',width:120,sortable:false,editor:{type:'text',options:{required:true}}}
			              ]],
			    onDblClickRow:function(rowIndex,rowData){
			        if(undefined!=editIndex&&editIndex!=rowIndex){
                        toBack();
                    }
                    editIndex=rowIndex;
                    $('#grid').datagrid('beginEdit',editIndex);
			    },
			    onClickRow:function(rowIndex,rowData){
			        if(editIndex!=rowIndex){
			            toBack();
			        }
			    },
			    onAfterEdit:function(rowIndex,rowData,changes){
			         if(''==rowData.name||''==rowData.title){
			            layer.alert('数据不能为空！',8,'提示');
			            toBack();
			            return false;
			        }
			        $.ajax({
                       type: "POST",
                       url: "system/role/formSave",
                       data: "id="+rowData.id+"&name="+rowData.name+"&title="+rowData.title,
                       success: function(msg){
                          if("0"==msg){
                              $('#grid').datagrid('reload');
                              editIndex= undefined;
                          }else{
                             alert('保存失败！');
                          }
                          
                       }
                   });
			    }
			    
			});//grid end
			
			
			var p = $('#grid').datagrid('getPager');
		    $(p).pagination({
		          displayMsg:'显示 {from} 到 {to} 共 {total} 条'
		    });
		    
		    
		    $('#toInsert,#toEdit,#toDelete,#toBack,#toSave').click(function(){
		         var btnId=$(this).attr('id');
		         if('toInsert'==btnId){
		             toInsert();
		         }else if('toEdit'==btnId){
		             toUpdate();
		         }else if('toDelete'==btnId){
		             toDelete();
		         }else if('toBack'==btnId){
		             toBack();
		         }else if('toSave'==btnId){
		             toSave();
		         }
		    });
});

        
        
         function toInsert(){
             if(toSave()){//新增前，先把上一条正在编辑或新增的记录给保存掉
                 $('#grid').datagrid('appendRow',{id:'0'});
			     editIndex = $('#grid').datagrid('getRows').length-1;
			     $('#grid').datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex);
			 }
         }
         
         
         //no used
         function toUpdate(){
             var row=$('#grid').datagrid('getSelected');
             if(null==row||!row){
                 layer.alert('请选择记录！', 8,'提示');
                 return false;
             }
             
             if(undefined!=editIndex&&editIndex!=$('#grid').datagrid('getRowIndex',row)){
                 toBack();
                 editIndex=$('#grid').datagrid('getRowIndex',row);
             }
             if(undefined==editIndex){
                 editIndex=$('#grid').datagrid('getRowIndex',row);
             }
             
             $('#grid').datagrid('beginEdit',editIndex);
         }
         
         function toDelete(){
             var row=$('#grid').datagrid('getSelected');
             if(null==row||!row){
                 layer.alert('请选择记录！', 8,'提示');
                 return false;
             }
             var rIndex=$('#grid').datagrid('getRowIndex',row);
             $.ajax({
                   type: "POST",
                   url: "system/role/formDelete",
                   data: "id="+row.id,
                   success: function(msg){
                      if('0'==msg){
                         $('#grid').datagrid('deleteRow',rIndex);
                      }else{
                         layer.alert('删除失败了！', 8,'提示');
                      }
                   }
              });
         }
         
         function toSave(){
             if (editIndex == undefined){return true};
             if ($('#grid').datagrid('validateRow', editIndex)){
                $('#grid').datagrid('endEdit', editIndex);
			} else {
				return false;
			}
         }
         
         //退回上一步
         function toBack(){
             if(undefined!=editIndex){
                $('#grid').datagrid('rejectChanges');
             }
			 editIndex = undefined;
         }

      </script>