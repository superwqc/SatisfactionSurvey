<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>Home page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script src="/satisfactionSurvey/admin/jquery-easyui-1.5.1/jquery.min.js"></script>
	<script src="/satisfactionSurvey/admin/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
	<script src="/satisfactionSurvey/admin/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" href="/satisfactionSurvey/admin/jquery-easyui-1.5.1/themes/default/easyui.css"/>
	<link rel="stylesheet" href="/satisfactionSurvey/admin/jquery-easyui-1.5.1/themes/icon.css"/>
  	
  	
  	<script>
  		$(function(){
  	  		//注意标点
  	  		$("#tt").datagrid({
				url:"/satisfactionSurvey/roles/find.do",
				fitColumns:true,
				singleSelect:true,
				columns:[[
							//注意属性一一对应
				          {field:'rid',title:'编号',width:100},
				          {field:'rname',title:'角色名',width:100},
						]],
				toolbar:[
				       {
					         text:"添加",
					         iconCls:"icon-add",
					         handler:function(){
					         	$("#ds").window("open");
					         }
					    },
					    {
					         text:"删除",
					         iconCls:"icon-remove",
					         handler:function(){
					         	//获取选中的行
					         	var row=$("#tt").datagrid("getSelected");
					         	if(row==null){
						         	$.messager.show({
							         	title:"删除角色",
							         	msg:"必须要选择一行",
							         	});
						        }
					         	else{
					         		$.ajax({
							         	type:"post",
							         	url:"/satisfactionSurvey/roles/delete.do",
							         	data:{rid:row.rid},
					         		    success:function(){
				  		  	  	  		$("#tt").datagrid("reload");
				  		  	  	  	  }
							       });
								}
					         }
					    },
					    {
						    text:"修改",
					         iconCls:"icon-edit",
					         handler:function(){
					         	var row=$("#tt").datagrid("getSelected");
					         	if(row==null){
						         	$.messager.show({
							         	title:"修改角色",
							         	msg:"必须要选择一行",
							         	});
						         }else{
							         $("#du").window("open");
							         $("#du form").form('load',row);
							         }
					         }
					    },
					]
  	  	  		});
			//窗口
  	  		$("#ds,#du").window({
  	  	  		width:300,
  	  	  		height:150,
  	  	  		closed:true,
  	  	  		modal:true
  	  	  	});
  	  	  	//添加按钮
  	  		$("#btns").click(function(){
  	  	  		$.ajax({
  	  	  	  		type:"post",
  	  	  	  		url:"/satisfactionSurvey/roles/save.do",
  	  	  	  		data:$("#ds form").serialize(),
	  	  	  		success:function(){
  		  	  	  		$("#ds").window("close");
  		  	  	  		$("#ds form").form('reset');
  		  	  	  		$("#tt").datagrid("reload");
  		  	  	  	  }
  	  	  	  	});
  	  	  	});
  	  	  	//修改按钮
  	  		$("#btnu").click(function(){
	  	  		$.ajax({
	  	  	  		type:"post",
	  	  	  		url:"/satisfactionSurvey/roles/update.do",
	  	  	  		data:$("#du form").serialize(),
  	  	  			success:function(){
	  	  	  			$("#du").window("close");
		  	  	  		$("#du form").form('reset');
		  	  	  		$("#tt").datagrid("reload");
		  	  	  	  }
	  	  	  		});
	  	  		});


  	  		
  	  		});
  	</script>
  </head>
<body>  
	<table id="tt">
	</table>
	<div id="ds" title="添加角色">
		<form style="padding:10px 20px 10px 40px;">
			<p>Role: <input id="i1" name="rname"></p>
			<div style="padding:5px;text-align:center;">
				<button id="btns" type="button">确认添加</button>
			</div>
		</form>
	</div>
	<div id="du" title="修改角色">
		<form style="padding:10px 20px 10px 40px;">
			<p><input type="hidden" name="rid"></p>
			<p>Role: <input name="rname"></p>
			<div style="padding:5px;text-align:center;">
				<button id="btnu" type="button">确认修改</button>
			</div>
		</form>
	</div>





</body> 
</html>