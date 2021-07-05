<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	session.invalidate();
	/* 로그아웃이 진행된 후 main.jsp로 이동 */
	response.sendRedirect("index.jsp");
	System.out.println("로그아웃");
	%>

</body>
</html>