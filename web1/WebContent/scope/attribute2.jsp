<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//attribute1.html 에서 넘긴 값 가져오기
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	
	//request 영역에 name 값과 id 값 담기
	session.setAttribute("name", name);
	session.setAttribute("id", id);
	//위에는 request로 변환시켜봄

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="attribute3.jsp" method="post">
		<div>
			<label for="">email</label>
			<input type="text" name="email"/>
		</div>
		<div>
			<label for="">집주소</label>
			<input type="text" name="home"/>
		</div>
		<div>
			<label for="">전화번호</label>
			<input type="text" name="tel"/>
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
</body>
</html>