
<%@page import="membermodel.MemberDTO"%>
<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%MemberDTO member = (MemberDTO)session.getAttribute("member"); %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Aerial by HTML5 UP</title>
		<meta charset="EUC-KR" />
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<link rel="stylesheet" href="assetsmessage/css/main.css" />
		
	</head>
	<style>
	
	</style>
	<body style="text-align: center;">

		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<ul class="actions vertical">
							<li><h5>ȸ����������</h5></li>
								<form action="../UpdateCon" method="post">
									<li>������ ID : <%= member.getId() %> </li>
									<li><input type="password" name="pw" placeholder="PW�� �Է��ϼ���" style="width: 500px; margin: 0 auto;"></li>
									<li><input type="text"     name="name" placeholder="�̸��� �Է��ϼ���" style="width: 500px; margin: 0 auto;"></li>
									<li><input type="text"     name="tel" placeholder="��ȭ��ȣ�� �Է��ϼ���" style="width: 500px; margin: 0 auto;"></li>
									<li><input type="text"     name="address" placeholder="���ּҸ� �Է��ϼ���" style="width: 500px; margin: 0 auto;"></li>
									<li><input type="submit" value="Update" class="button fit" style="width: 500px; margin: 0 auto;"></li>
								</form>
						</ul>
					</nav>			
			</div>
		<!-- Scripts -->
			<script src="assetsmessage/js/jquery.min.js"></script>
			<script src="assetsmessage/js/jquery.scrolly.min.js"></script>
			<script src="assetsmessage/js/jquery.scrollex.min.js"></script>
			<script src="assetsmessage/js/skel.min.js"></script>
			<script src="assetsmessage/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assetsmessage/js/main.js"></script>
	</body>
</html>
