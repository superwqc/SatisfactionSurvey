<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>打分界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<script>
		window.onload=function(){
		var aa=document.getElementsByClassName("aa");
		for ( var i = 0; i <aa.length; i++) {
			aa[i].oninput=function(){
				//判断非数字或小数
				if(isNaN(this.value || this.value.indexof('.')!= -1)){
					this.value="";

					}else{//只能0-10分
						if(this.value <0 || this.value>10){
							this.value="";

							}
						

						}
			}
			
		}



}
	
	
	
	
	</script>

  </head>
  
  <body>
  <div>
  	${p.title}     -     ${p.user.realname}		
  </div>
  
  <div>
  <form action="/satisfactionSurvey/score/save.do">
  		<input type="hidden" name="pid" value="${p.pid}">
  		<table width="600">
  			<tr>
  				<td>qid</td>
  				<td>content</td>
  				<td>打分</td>
  			</tr>
  			<c:forEach items="${p.questions}" var="q">
  				<tr>
  				<td>${q.qid}</td>
  				<td>${q.content}</td>
  				<td>
  					<input type="hidden" name="qid" value="${q.qid}">
  					<input  class="aa" name="score" size="2"/>
  				</td>
  				</tr>
  			</c:forEach>
  		</table>
  		<button type="submit">提交</button>
  	</form>
  </div>
 
  <hr>
  <div>
  <button onclick="history.back()">返回</button>
  </div>
  
  
  </body>
</html>
