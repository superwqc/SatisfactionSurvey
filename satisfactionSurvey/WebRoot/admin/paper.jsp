<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>Paper page</title>
    
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
  	  	  	url:"/satisfactionSurvey/paper/find.do",
  	  	  	fitColumns:true,
  	  	  	singleSelect:true,
  	  		columns:[[    
	  	  	        {field:'pid',title:'编号',width:100},  
	  	  			{field:'title',title:'标题',width:100},  
	  	  	        {field:'pubdate',title:'发布日期',width:100},
	  	  	  		{
	  	  	  	  		field:'status',title:'状态',width:100,
	  	  	  	  		formatter:function(a){
	  	  	  	  			return a==0?'冻结':'激活';
	  	  	  	  		}
	  	  	  	  	},
	  	  	  		{
	  	  	  			field:'user',title:'用户',width:100,
	  	  	  			formatter:function(a){
	  	  	  				return a.realname;
	  	  	  			}

	  	  	  		},
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
			  		  	  	    var row= $("#tt").datagrid("getSelected");
			  		  	  	    if(row==null){
				  		  	  	    $.messager.show({
					  		  	  	    title:"删除",
					  		  	  	    msg:"必须选择一行删除"
					  		  	  	    });
				  		  	  	    }else{
					  		  	  	    $.ajax({
						  		  	  	    type:"post",
						  		  	  	    url:"/satisfactionSurvey/paper/delete.do",
						  		  	  	    data:{pid:row.pid},
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
					  		  	  	    title:"修改",
					  		  	  	    msg:"必须选择一行修改"
					  		  	  	    });
					  		  	 }
				  		  	  	    else{
				  		  	  	  	$("#du").window("open");
	    	  	  	  	  	     	$("#du form").form("load",row);
				  		  	  	    }
			  		  	  	    }	

				  			 },
				  			 {
					  			 text:"激活",
					  			 iconCls:"icon-ok",
					  			 handler:function(){
					  				var row=$("#tt").datagrid("getSelected");
				  		  	  	    if(row==null){
				  		  	  	  	$.messager.show({
					  		  	  	    title:"激活",
					  		  	  	    msg:"必须选择一行激活"
					  		  	  	    });
					  			 	}
				  		  	  	    else{
					  		  	  	    $.ajax({
						  		  	  	    type:"post",
						  		  	  	    url:"/satisfactionSurvey/paper/active.do",
						  		  	  	    data:{pid:row.pid},
						  		  	  	    success:function(){
							  		  	  	    $("#tt").datagrid("reload");
							  		  	  	    }


						  		  	  	    
						  		  	  	    });
					  		  	  	    }
				  			 }

					  			 },
				  			 {
					  				text:"冻结",
						  			 iconCls:"icon-no",
						  			 handler:function(){
					  				var row=$("#tt").datagrid("getSelected");
				  		  	  	    if(row==null){
				  		  	  	  	$.messager.show({
					  		  	  	    title:"冻结",
					  		  	  	    msg:"必须选择一行冻结"
					  		  	  	    });
					  			 	}
				  		  	  	    else{
					  		  	  	    $.ajax({
						  		  	  	    type:"post",
						  		  	  	    url:"/satisfactionSurvey/paper/frozen.do",
						  		  	  	    data:{pid:row.pid},
						  		  	  	    success:function(){
							  		  	  	    $("#tt").datagrid("reload");
							  		  	  	    }


						  		  	  	    
						  		  	  	    });
					  		  	  	    }

					  				 
						  			 
						  			 }
						  	},

						  	{
							  	text:"分配问题",
							  	handler:function(){
							  	

							  	var row=$("#tt").datagrid("getSelected");
			  		  	  	    if(row==null){
			  		  	  	  	$.messager.show({
				  		  	  	    title:"分配问题",
				  		  	  	    msg:"必须选择一行分配"
				  		  	  	    });
				  			 	}
			  		  	  	    else{
			  		  	  	 	 $("#da").window("open");
			  		  	  	 	 $("#da #a").html("");//清空覆盖
			  		  	  		 $("#da #a").append("问卷标题&nbsp;:&nbsp;");
			  		  	  	 	$("#da #a").append(row.title);
			  		  	  		$("#da #a").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			  		  	  		 $("#da #a").append("调查对象&nbsp;:&nbsp;");
			  		  	  		 $("#da #a").append(row.user.realname);
			  		  	  	    
				
		

				  		  	  		//准备所有问题
			  		  	  	$.ajax({
								type:"post",
								url:"/satisfactionSurvey/paper/addQuestionToPaperUI.do",
								data:{pid:row.pid},
								//接受服务器发挥的数据
								dataType:"json",
								success:function(json) {

									$("#a,#b,#c").html("");
									
									// 给第一部分填内容
									$("#a").html(json.part1);
									// 给第二部分填内容
									for(var i = 0; i < json.part2.length; i++) {
										var checkbox = $("<input type='checkbox' name='qid' value='"+json.part2[i].qid+"' />");
										$("#da #b").append(checkbox);
										$("#da #b").append(json.part2[i].content);
									}
									// 给第三部分填内容
									for(var i = 0; i < json.part3.length; i++) {
										var checkbox = $("<input type='checkbox' name='qid' value='"+json.part3[i].qid+"' />");
										$("#da #c").append(checkbox);
										$("#da #c").append(json.part3[i].content);
								}
								}
							});
				  		  	  	    


				  		  	  		
				  		  	  	    }


							  	}

							  	}
		  	]
	  	  	    

  	  	  	});

		$("#ds").window({
			title:"添加问卷",
			width:300,
			height:200,
			modal:true,
			closed:true

		});
		$("#du").window({
			title:"修改问卷",
			width:300,
			height:200,
			modal:true,
			closed:true

		});
		$("#da").window({
			title:"分配问题",
			width:400,
			height:300,
			modal:true,
			closed:true

		});

		$("#btns").click(function(){
			$.ajax({
				type:"post",
				url:"/satisfactionSurvey/paper/save.do",
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
				url:"/satisfactionSurvey/paper/update.do",
				data:$("#du form").serialize(),
				success:function(){
					$("#du").window("close");
					$("#du form").form("reset");
					$("#tt").datagrid("reload");
					}
				});

			});

		$("#i1").combobox({
			width:160,
			url:"/satisfactionSurvey/user/findAll.do",
			textField:"realname",
			valueField:"uid"
			});
		$("#i2").combobox({
			width:160,
			url:"/satisfactionSurvey/user/findAll.do",
			textField:"realname",
			valueField:"uid"
			});
		
	});

  </script>
  
  
  
  
  <body>
  	<table id="tt">
  	</table>
  	<div id="ds" title="添加问卷">
		<form style="padding:10px 20px 10px 40px;">
			<p>标题: <input name="title"></p>
			<p>对象: <input id="i1" name="user.uid"></p>
			<div style="padding:5px;text-align:center;">
				<button id="btns" type="button">确认添加</button>
			</div>
		</form>
	</div>
	<div id="du" title="修改问卷">
		<form style="padding:10px 20px 10px 40px;">
			<input type="hidden" name="pid">
			<p>标题: <input name="title"></p>
			<p>对象: <input id="i2" name="user.uid"></p>
			<div style="padding:5px;text-align:center;">
				<button id="btnu" type="button">确认修改</button>
			</div>
		</form>
	</div>
	<div id="da" title="修改问卷">
			<div id="a" style="margin-top: 8px"></div>
			<hr>
			<div id="b"  style="margin-top: 30px"></div>
			<hr>
			<div id="c"  style="margin-top: 30px"></div>
	
		
	</div>
  </body>
</html>
  