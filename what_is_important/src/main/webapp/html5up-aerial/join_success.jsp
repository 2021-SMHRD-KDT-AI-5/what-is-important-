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
							<li><h1>ȯ���մϴ�!</h1></li>
							<li>ȸ�������� �����մϴ�.</li>
							<!-- request������ ����� ȸ������ �� �̸����� ����Ͻÿ�. -->
							<li>what is important?�� ���ο� ID�� <%=request.getAttribute("id") %>�Դϴ�.</li>
							<li><button onclick='location.href="index.jsp"'>�����ϱ�</button></li>
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

