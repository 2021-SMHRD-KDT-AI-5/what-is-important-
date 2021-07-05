<%@page import="java.util.ArrayList"%>
<%@page import="membermodel.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<% MemberDTO member = (MemberDTO)session.getAttribute("member"); %>

<!DOCTYPE HTML>
<html>
	<head>
		<title>Aerial by HTML5 UP</title>
		<meta charset="EUC-KR" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css" integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">
		<!-- login,join -->
		<link rel="icon" type="image/png" href="assetslogin/images/icons/favicon.ico"/>
		<link rel="stylesheet" type="text/css" href="assetslogin/vendor/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="assetslogin/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="assetslogin/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
		<link rel="stylesheet" type="text/css" href="assetslogin/vendor/animate/animate.css">
		<link rel="stylesheet" type="text/css" href="assetslogin/vendor/css-hamburgers/hamburgers.min.css">
		<link rel="stylesheet" type="text/css" href="assetslogin/vendor/animsition/css/animsition.min.css">
		<link rel="stylesheet" type="text/css" href="assetslogin/vendor/select2/select2.min.css">
		<link rel="stylesheet" type="text/css" href="assetslogin/vendor/daterangepicker/daterangepicker.css">
		<link rel="stylesheet" type="text/css" href="assetslogin/css/util.css">
		<link rel="stylesheet" type="text/css" href="assetslogin/css/main.css">
		
		

</head>

<body class="is-preload">
<!-- Wrapper -->
   <div id="page-wrapper">
      <div id="bg"></div>

      <!-- Nav -->
      <nav id="nav">
         <ul class="navbar_menu">
            <li class="current"><a href="index.html">Home</a></li>
            <li>
               <a href="#">Dropdown</a>
               <ul>
                  <li><a href="#">Lorem ipsum dolor</a></li>
                  <li><a href="#">Magna phasellus</a></li>
                  <li>
                     <a href="#">Phasellus consequat</a>
                     <ul>
                        <li><a href="#">Lorem ipsum dolor</a></li>
                        <li><a href="#">Phasellus consequat</a></li>
                        <li><a href="#">Magna phasellus</a></li>
                        <li><a href="#">Etiam dolore nisl</a></li>
                     </ul>
                  </li>
                  <li><a href="#">Veroeros feugiat</a></li>
               </ul>
            </li>
            <li><a href="left-sidebar.html">추천</a></li>
            <li><a href="right-sidebar.html">직접선택 </a></li>
            <li><a href="no-sidebar.html">No Sidebar</a></li>
         </ul>


         <ul class="navbar_links">
            <li><a href="#"><i class="far fa-user-circle fa-2x"></i></a>
               <ul class="dropotron level-0 right">
               		<% if(member != null){ //로그인이 된 경우
						out.print("<li><a href='update.jsp'>개인정보수정</a></li>");				
						out.print("<li><a href='Logout.jsp'>로그아웃</a><li>");
					}else{ 
						out.print("<li><a href='login.jsp'>로그인</a></li>");
						out.print("<li><a href='join.jsp'>회원가입</a></li>");
					}%>
          		</ul>
            </li>   
         </ul>
      </nav>

   </div>

   <div id="main">
   
   
   
	<!-- Menu -->
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-85 p-r-85 p-t-55 p-b-55">
				<form action="LoginServiceCon.do" method="post" class="login100-form validate-form flex-sb flex-w">
					<span class="login100-form-title p-b-32">
						로그인
					</span>

					<span class="txt1 p-b-11">
						Id
					</span>
					<div class="wrap-input100 validate-input m-b-36" data-validate = "Username is required">
						<input class="input100" type="text" name="username" >
						<span class="focus-input100"></span>
					</div>
					
					<span class="txt1 p-b-11">
						Password
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate = "Password is required">
						<span class="btn-show-pass">
							<i class="fa fa-eye"></i>
						</span>
						<input class="input100" type="password" name="pass" >
						<span class="focus-input100"></span>
					</div>
					
					<div class="flex-sb-m w-full p-b-48">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
							<label class="label-checkbox100" for="ckb1">
								Remember me
							</label>
						</div>

						<div>
							<a href="#" class="txt3">
								Forgot Password?
							</a>
						</div>
					</div>

					<div class="container-login100-form-btn">
						<input type="submit" name="login" value="Login" class="login100-form-btn">
					</div>
				</form>
			</div>
		</div>
	</div>
	<div id="dropDownSelect1"></div>


                  	<div class="limiter">
						<div class="container-login100">
							<div class="wrap-login100 p-l-85 p-r-85 p-t-55 p-b-55">
								<form action="JoinServiceCon.do" method="post" class="login100-form validate-form flex-sb flex-w">
									<span class="login100-form-title p-b-32">
										회원가입
									</span>
				
									<span class="txt1 p-b-11">
										Id
									</span>
									<div class="wrap-input100 validate-input m-b-36" data-validate = "Username is required">
										<input class="input100" type="text" name="id" id="input_id" >
										<span class="focus-input100"></span>
									</div>
									
									<input type="button" value="ID중복체크" onclick="idCheck()">
									<span id="sp"></span><br>
										
									<span class="txt1 p-b-11">
										Password
									</span>
									<div class="wrap-input100 validate-input m-b-12" data-validate = "Password is required">
										<span class="btn-show-pass">
											<i class="fa fa-eye"></i>
										</span>
										<input class="input100" type="password" name="pw" >
										<span class="focus-input100"></span>
									</div>
									
									<span class="txt1 p-b-11">
										Password check
									</span>
									<div class="wrap-input100 validate-input m-b-12" data-validate = "Password is required">
										<span class="btn-show-pass">
											<i class="fa fa-eye"></i>
										</span>
										<input class="input100" type="password" name="pwcheck" >
										<span class="focus-input100"></span>
									</div>
									
									<span class="txt1 p-b-11">
										Name
									</span>
									<div class="wrap-input100 validate-input m-b-36" data-validate = "Username is required">
										<input class="input100" type="text" name="name" >
										<span class="focus-input100"></span>
									</div>
									
									<span class="txt1 p-b-11">
										Tel
									</span>
									<div class="wrap-input100 validate-input m-b-36" data-validate = "Username is required">
										<input class="input100" type="text" name="tel" >
										<span class="focus-input100"></span>
									</div>
									
									<span class="txt1 p-b-11">
										Address
									</span>
									<div class="wrap-input100 validate-input m-b-36" data-validate = "Username is required">
										<input class="input100" type="text" name="address" >
										<span class="focus-input100"></span>
									</div>
									
							
									<div class="container-login100-form-btn">
											<input type="submit" name="JoinUs" value="JoinUs" class="login100-form-btn">
									</div>
								</form>
							</div>
						</div>
					</div>
	<div id="dropDownSelect1"></div>					
					
					


      <!-- Header -->
      <header id="header">
         <h1>what is important?</h1>
         <p>인기상품</p>
         <nav>
            <ul>
               <li><a href="src/main/webapp/jh/selectPage.html"><img src="png/aircon.png" width=100 height=100></a></li>
               <li><a href="../jh/selectPage.html"><img src="png/008-fridge.png" width=100 height=100></a></li>
               <li><a href="#"><img src="png/017-microwave oven.png" width=100 height=100></a></li>
               <li><a href="#"><img src="png/033-dish washer.png" width=100 height=100></a></li>
               <li><a href="#"><img src="png/039-washing machine.png" width=100 height=100></a></li>
            </ul>
            <ul>
               <li><a href="#"><img src="png/038-vacuum cleaner.png" width=100 height=100></a></li>
               <li><a href="#"><img src="png/dry.png" width=100 height=100></a></li>
               <li><a href="#"><img src="png/sty.png" width=100 height=100></a></li>
               <li><a href="#"><img src="png/tv.png" width=100 height=100></a></li>
               <li><a href="#"><img src="png/air.png" width=100 height=100></a></li>
               </ul>
         </nav>
      </header>

      <!-- Footer -->
      <footer id="footer">
         <span class="copyright"> <a href="http://html5up.net"></a></span>
      </footer>

   </div>
   <script>
      window.onload = function () { document.body.classList.remove('is-preload'); }
      window.ontouchmove = function () { return false; }
      window.onorientationchange = function () { document.body.scrollTop = 0; }
   </script>

   <script src="assets/js/jquery.min.js"></script>
   <script src="assets/js/jquery.dropotron.min.js"></script>
   <script src="assets/js/jquery.scrolly.min.js"></script>
   <script src="assets/js/browser.min.js"></script>
   <script src="assets/js/breakpoints.min.js"></script>
   <script src="assets/js/util.js"></script>
   <script src="assets/js/main.js"></script>
   <!-- login,join -->
   <script src="assetslogin/vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="assetslogin/vendor/animsition/js/animsition.min.js"></script>
	<script src="assetslogin/vendor/bootstrap/js/popper.js"></script>
	<script src="assetslogin/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="assetslogin/vendor/select2/select2.min.js"></script>
	<script src="assetslogin/vendor/daterangepicker/moment.min.js"></script>
	<script src="assetslogin/vendor/daterangepicker/daterangepicker.js"></script>
	<script src="assetslogin/vendor/countdowntime/countdowntime.js"></script>
	<script src="assetslogin/js/main.js"></script>
	

</body>

</html>