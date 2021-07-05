<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Aerial by HTML5 UP</title>
		<meta charset="EUC-KR" />
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<link rel="stylesheet" href="assetsmessage/css/main.css" />
	</head>
	
	<style>
		#Update > ul.actions {
			margin-top:10%;
		}
	</style>
	<body style="text-align: center;">

		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<ul class="actions vertical">
							<li><h1>환영합니다!</h1></li>
							<li>회원가입을 축하합니다.</li>
							<!-- request영역에 저장된 회원정보 중 이메일을 출력하시오. -->
							<li>what is important?의 새로운 ID는 <%=request.getAttribute("id") %>입니다.</li>
							<li><button onclick='location.href="index.jsp"'>시작하기</button></li>
						</ul>
					</nav>			
			</div>
		<!-- Scripts -->
			<script src="assetsmessage/js/jquery.min.js"></script>
			<script src="assetsmessage/js/jquery.scrolly.min.js"></script>
			<script src="assetsmessage/js/jquery.scrollex.min.js"></script>
			<script src="assetsmessage/js/skel.min.js"></script>
			<script src="assetsmessage/js/util.js"></script>
			<script src="assetsmessage/js/main.js"></script>
	</body>
</html>

