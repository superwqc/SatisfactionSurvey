<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>User page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script src="/satisfactionSurvey/admin/jquery-easyui-1.5.1/jquery.min.js"></script>
	<script src="/satisfactionSurvey/admin/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
	<script src="/satisfactionSurvey/admin/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" href="/satisfactionSurvey/admin/jquery-easyui-1.5.1/themes/default/easyui.css"/>
	<link rel="stylesheet" href="/satisfactionSurvey/admin/jquery-easyui-1.5.1/themes/icon.css"/>
  </head>
  
  <script>
  		$(function(){
  	  		$("#tt").datagrid({
  	  	  		url:"/satisfactionSurvey/user/find.do",
  	  	  		fitColumns:true,
  	  	  		singleSelect:true,
  	  	  		pagination:true,
  	  	  		pageList:[5,10,15,20],
  	  	  		pageSize:5,
  	  	  		columns:[[    
	  	  	  	        {field:'uid',title:'编号',width:100},  
	  	  	  	        
	  	  	  	  		{field:'account',title:'账户',width:100},
	  	  	  	 		{field:'password',title:'密码',width:100},  
	  	  	  			{
	  	  	  	  	        field:'roles',title:'角色',width:100,
	  	  	  	  	        formatter:function(a){
	  	  	  	  	        	return a.rname;
	  	  	  	  	        }
	  	  	  	  	     } 
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
		  	  	  	             var row = $("#tt").datagrid("getSelected");
		  	  	  	             if(row==null){
			  	  	  	             $.messager.show({
				  	  	  	             title:"删除",
				  	  	  	             msg:"必须选择一行删除",
				  	  	  	             });
			  	  	  	             }
		  	  	  	             else{
			  	  	  	             $.ajax({
				  	  	  	             type:"post",
				  	  	  	             url:"/satisfactionSurvey/user/delete.do",
				  	  	  	             data:{uid:row.uid},
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
  	  	  	  	  	     	var row= $("#tt").datagrid('getSelected');
  	  	  	  	  	     	if(row==null){
	    	  	  	  	  	     	$.messager.show({
		    	  	  	  	  	     	title:"修改",
		    	  	  	  	  	     	msg:"必须选择一行修改!"
		    	  	  	  	  	     });
	    	  	  	  	  	     	}
  	  	  	  	  	     	else{
	    	  	  	  	  	     	$("#du").window("open");
	    	  	  	  	  	     	$("#du form").form("load",row);
	    	  	  	  	  	     	
	    	  	  	  	  	    }
  	  	  	  	  	   		}
    	  	  	  	  	  }

		  		  	  ]
  	  	  		});

  	  	$("#ds").window({
  	  	  	title:"添加用户",
  	  	  	width:350,
  	  	  	height:250,
  	  	  	closed:true,
  	  	  	modal:true,
  	 	});
  	  	$("#du").window({
	  	  	title:"修改用户",
	  	  	width:350,
	  	  	height:250,
	  	  	closed:true,
	  	  	modal:true,
	 	});
	 	

  	 	$("#is").combobox({
  	 		width:160,
	  	  	url:"/satisfactionSurvey/roles/findAll.do",
	  	  	textField:"rname",
	  	  	valueField:"rid"
  	  	});
  	 	$("#iu").combobox({
  	 		width:160,
	  	  	url:"/satisfactionSurvey/roles/findAll.do",
	  	  	textField:"rname",
	  	  	valueField:"rid"
  	  	});

  	  	$("#btns").click(function(){	
  	  	  	$.ajax({
  	  	  	  	type:"post",
  	  	  	  	url:"/satisfactionSurvey/user/save.do",
  	  	  	  	  	data:$("#ds form").serialize(),
  	  	  	  	  	success:function(){
	  	  	  	  	$("#ds").window("close");
	  	  	  	  	$("#ds form").form("reset");
	  	  	  	  	$("#tt").datagrid("reload");
  	  	  	  	}

  	  	  	  	});

  	  	  	});

  	 	 $("#btnu").click(function(){	
  	  	 	 $.ajax({
  	  	  	 	 type:"post",
  	  	  	 	 url:"/satisfactionSurvey/user/update.do",
  	  	  	 	 data:$("#du form").serialize(),
  	  	  	 	 success:function(){
	  	  	  	 	$("#du").window("close");
	  	  	  	  	$("#du form").form("reset");
	  	  	  	  	$("#tt").datagrid("reload");

  	  	  	  	 	 }



  	  	  	 	 });

	  	  	});
  	  		
  	  		



 });

  	
  	  
  
  
  
  
  
  
  
  
  
  </script>
  
  <body>
  	<table id="tt">
  	</table>
  	<div id="ds" title="添加用户">
		<form style="padding:10px 20px 10px 40px;">
			<p>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户: <input name="account"></p>
			<p>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码: <input  name="password"></p>
			<p>真实姓名: <input name="realname"></p>
			<p>角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色: <input  id="is" name="roles.rid"></p>
			<div style="padding:5px;text-align:center;">
				<button id="btns" type="button">确认添加</button>
			</div>
		</form>
	</div>
	<div id="du" title="添加用户">
		<form style="padding:10px 20px 10px 40px;">
			<p><input type="hidden" name="uid"></p>
			<p>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户: <input name="account"></p>
			<p>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码: <input  name="password"></p>
			<p>真实姓名: <input name="realname"></p>
			<p>角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色: <input  id="iu" name="roles.rid"></p>
			<div style="padding:5px;text-align:center;">
				<button id="btnu" type="button">确认添加</button>
			</div>
		</form>
	</div>
  	
  	
  
  
  </body>
</html>
