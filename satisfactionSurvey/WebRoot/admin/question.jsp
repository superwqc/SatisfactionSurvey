<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>Question page</title>
    
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
  	  	  		url:"/satisfactionSurvey/question/find.do",
  	  	  		fitColumns:true,
  	  	  		singleSelect:true,
  	  	  		pagination:true,
  	  	  		pageList:[5,10,15,20],
  	  	  		pageSize:5,
  	  	  		columns:[[    
  	  	  	  	        {field:'qid',title:'编号',width:100},  
  	  	  	  			{field:'content',title:'内容',width:100},  
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
  	  	  	  	  	                  var row=$("#tt").datagrid("getSelected");
  	  	  	  	  	                  if(row==null){
  	  	  	  	  	  	                  $.messager.show({
  	  	  	  	  	  	  	                  title:"删除问题",
  	  	  	  	  	  	  	                  msg:"必须选择一行删除"
  	  	  	  	  	  	  	              });
  	  	  	  	  	  	             }
  	  	  	  	  	                  else{
  	  	  	  	  	  	                  $.ajax({
  	  	  	  	  	  	  	                  type:"post",
  	  	  	  	  	  	  	                  url:"/satisfactionSurvey/question/delete.do",
  	  	  	  	  	  	  	                  data:{qid:row.qid},
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
			    	  	  	  	  	     	title:"修改问题",
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
  	  	  		title:"添加问题",
  	  	  		width:300,
  	  	  		height:200,
  	  	  		closed:true,
  	  	  		modal:true,
  	  	  		});
  	  		$("#du").window({
	  	  		title:"修改问题",
	  	  		width:300,
	  	  		height:200,
	  	  		closed:true,
	  	  		modal:true,
	  	  		});

  	  		$("#ir").combobox({
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
  	  	  	  		url:"/satisfactionSurvey/question/save.do",
  	  	  	  		//传参数
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
  	  	  	  		url:"/satisfactionSurvey/question/update.do",
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
  	<div id="ds" title="添加问题">
		<form style="padding:10px 20px 10px 40px;">
			<p>内容: <input name="content"></p>
			<p>角色: <input id="ir" name="roles.rid"></p>
			<div style="padding:5px;text-align:center;">
				<button id="btns" type="button">确认添加</button>
			</div>
		</form>
	</div>
	<div id="du" title="修改问题">
		<form style="padding:10px 20px 10px 40px;">
			<p> <input type="hidden" name="qid"></p>
			<p>内容: <input name="content"></p>
			<p>角色: <input id="iu" name="roles.rid"></p>
			<div style="padding:5px;text-align:center;">
				<button id="btnu" type="button">确认修改</button>
			</div>
		</form>
	</div>
  
  
  
  
  
  
  
  
  
  
  </body>
</html>
