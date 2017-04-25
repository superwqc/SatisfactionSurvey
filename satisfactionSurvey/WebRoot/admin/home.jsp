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
  </head>
  <script>
  	$(function(){
  		$("a[title]").click(function(){
  	  		//取出中间内容
			var title = $(this).html();
			//取出属性
			var src = $(this).attr("title");
  	  		
			if($("#tt").tabs("exists",title)){
				$("#tt").tabs("select",title);
			}else{
				$("#tt").tabs("add",{
					title:title,
					closable:true,
					content:"<iframe width='99%' height='98%' frameborder='0' src='"+src+"'></iframe>"
						});
					}
			});	
  	  	});
  </script>
<body class="easyui-layout">   
    <div data-options="region:'west',title:'菜单',split:true" style="width:200px;">
		<ul class="easyui-tree">   
		    <li>   
		        <span>数据管理</span>
		        <ul>
		        	<li><a title="roles.jsp">角色管理</a></li>
		        	<li><a title="question.jsp">问题管理</a></li>
		        	<li><a title="user.jsp">用户管理</a></li>
		        	<li><a title="paper.jsp">问卷管理</a></li>
		        	<li><a title="score.jsp">分数管理</a></li>
		        </ul>   
		    </li>   
		</ul> 
    </div>   
    <div data-options="region:'center',title:'内容'" style="padding:5px;background:#eee;">
		<div id="tt" class="easyui-tabs" style="width:100%;height:100%;">   
		</div>  			    
    </div>   
</body> 
</html>