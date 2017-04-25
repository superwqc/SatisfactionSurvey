<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script src="/satisfactionSurvey/admin/jquery-easyui-1.5.1/jquery.min.js"></script>
	<script src="/satisfactionSurvey/admin/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
	<script src="/satisfactionSurvey/admin/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" href="/satisfactionSurvey/admin/jquery-easyui-1.5.1/themes/default/easyui.css"/>
	<link rel="stylesheet" href="/satisfactionSurvey/admin/jquery-easyui-1.5.1/themes/icon.css"/>
  </head>
  
<body class="easyui-layout">   
    <div data-options="region:'west',title:'West',split:true" style="width:200px;">
    
    
    <ul id="tt" class="easyui-tree">   
    <li>   
        <span>Folder</span>   
        <ul>   
            <li>   
                <span>Sub Folder 1</span>   
                <ul>   
                    <li>   
                        <span><a href="#">File 11</a></span>   
                    </li>   
                    <li>   
                        <span>File 12</span>   
                    </li>   
                    <li>   
                        <span>File 13</span>   
                    </li>   
                </ul>   
            </li>   
            <li>   
                <span>File 2</span>   
            </li>   
            <li>   
                <span>File 3</span>   
            </li>   
        </ul>   
    </li>   
    <li>   
        <span>File21</span>   
    </li>   
</ul> 
    </div>   
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;"></div>   
</body> 
</html>
