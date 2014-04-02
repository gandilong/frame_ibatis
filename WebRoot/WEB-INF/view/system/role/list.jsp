<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  
      <table id="grid"></table>
     
      <div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="javascript:void(0)" id="toInsert" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
			<a href="javascript:void(0)" id="toSave" class="easyui-linkbutton" iconCls="icon-save" plain="true">保存</a>
			<a href="javascript:void(0)" id="toDelete" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div>
	  </div>
	  
	  <div id="rmenus" class="easyui-menu" style="width:120px;">
             <div data-options="iconCls:'icon-leaf'">
                 <span>添加资源</span>
                 <div id="resources" style="width:150px;"></div>
             </div>
             <div class="menu-sep"></div>
             <div id="delete" data-options="iconCls:'icon-trash'">删除</div>
    </div>
     
<script type="text/javascript">
     
     var editIndex= undefined;
     
$(function(){
           var resources=eval('${values.resources}');//所有资源
           
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
			    queryParams:{pageNow:1,pageSize:30},
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
			        var reg=/[a-z_]/gi;
			        if(!reg.test(rowData.name)){
			           layer.alert('标记必须为英文字母或下划线！',8,'提示');
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
			    },
			   onRowContextMenu:function(e,rowIndex, rowData){ 
			         e.preventDefault();
			                        
			         
			          //得到该用户的资源
									    $.ajax({
											   type: "POST",
											   url: "system/resource/listRoleResources",
											   data: "rid="+rowData.id,
											   dataType:'script',
											   success: function(msg){
											        role_resource=eval(msg);
											        var samed=0;
											        var item = $('#rmenus').menu('findItem', '添加资源');  // find 'roles' item
											        for(var i in resources){
											        
											            var t=$('#rmenus').menu('findItem',resources[i].title);
									                    
											            if(t){
											                 $('#rmenus').menu('removeItem',t.target);
											             }
											        
											            for(var k in role_resource){
											                if(role_resource[k]==resources[i].name){
											                    samed=1;
											                    $('#rmenus').menu('appendItem', {
																	id:resources[i].id,
																	parent:item.target,  // the parent item element
																	text:resources[i].title,
																	iconCls:'icon-ok-sign',
																	onclick: function(){
																	    updateRole(this.id,rowData.id,'delete');
																	}
																});
											                }
											            }
											            
											            if(0==samed){
											                $('#rmenus').menu('appendItem', {
											                        id:resources[i].id,
																	parent:item.target,  // the parent item element
																	text:resources[i].title,
																	onclick: function(){
																	    updateRole(this.id,rowData.id,'insert');
																	}
																});
											            }else{
											               samed=0;
											            }
											            
											        }
													       
													       
													        $('#delete').click(function(){
									                              toDelete(rowData);
									                        });//右键删除 添加点击事件
									                        
									                        $('#rmenus').menu('show', {
						                                       left:e.pageX,
						                                       top:e.pageY
						                                    });
													       $('#grid').datagrid("selectRow",rowIndex);
											   }//two success
											});				
			         
			   
			   }//menu end
			});//grid end
			
			
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
         
         function updateRole(resId,rid,opt){
		    
		       $.ajax({
                   type: "POST",
                   url: "system/role/updateRole",
                   data: "resId="+resId+"&rid="+rid+"&opt="+opt,
                   success: function(msg){
                       $('#grid').datagrid('reload');
                   }
               });
		}

      </script>