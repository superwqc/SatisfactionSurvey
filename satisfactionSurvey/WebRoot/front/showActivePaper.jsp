<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>Home page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	</head>
	<body>  
		<c:if test="${user == null}">
			<c:redirect url="/front/index.jsp"></c:redirect>
		</c:if>
		<c:if test="${user != null}">
			欢迎  ${user.roles.rname}  ${user.realname} 登录
		</c:if>
		<h2>问卷列表</h2>
		
		<table width="600" border="1">
			<tr>
				<td>问卷</td>
				<td>标题</td>
				<td>发布日期</td>
				<td>调查对象</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list}" var="p">
				<tr>
					<td>${p.pid}</td>
					<td>${p.title}</td>
					<td>${p.pubdate}</td>
					<td>${p.user.realname}</td>
					<td>
						<a href="/satisfactionSurvey/paper/showOnePaperUI.do?pid=${p.pid} }">我要打分</a>
					</td>
				</tr>
			</c:forEach>
		
		</table>
		

</body> 
</html>