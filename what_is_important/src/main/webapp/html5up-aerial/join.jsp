<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%> 
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Join V14</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
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
<body>
	
	<div class="limiter">
						<div class="container-login100">
							<div class="wrap-login100 p-l-85 p-r-85 p-t-55 p-b-55">
								<form action="../JoinCon" method="post"  id="MForm" class="login100-form validate-form flex-sb flex-w">
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
									<span id="sp"></span>
									
									
										
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
									<div>
										<span id="sp1"></span></li>
									</div>
								</form>
							</div>
						</div>
					</div>
	<div id="dropDownSelect1"></div>
	
	<script src="assetslogin/vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="assetslogin/vendor/animsition/js/animsition.min.js"></script>
	<script src="assetslogin/vendor/bootstrap/js/popper.js"></script>
	<script src="assetslogin/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="assetslogin/vendor/select2/select2.min.js"></script>
	<script src="assetslogin/vendor/daterangepicker/moment.min.js"></script>
	<script src="assetslogin/vendor/daterangepicker/daterangepicker.js"></script>
	<script src="assetslogin/vendor/countdowntime/countdowntime.js"></script>
	<script src="assetslogin/js/main.js"></script>
	
	<script type="text/javascript">
				function idCheck(){
					var input = document.getElementById("input_id");
				    //alert(input.value) 실행시 : 아이디 넣고 중복체크하면 알림이 뜬다 
				    //비동기 방식으로
				    $.ajax({
				    	type : "post", //데이터 전송방식
				    	data : {'id':input.value}, //서버로 보낼 데이터
				    	url : "../IdCheckCon", //데이터를 보낼 서버페이지
				    	dataType : "text", //응답데이터 타입
				    	success : function(data){ //요청에 성공 시 실행할 함수 정의 - 가능(true),불가능(false)
				    		alert(data);
				    		document.getElementById("sp");
				    		if(data=="true"){
				    			sp.innerHTML="이미 사용 중인 ID입니다.";
				    		}else{
				    			sp.innerHTML="사용 가능한 ID입니다.";
				    		}
				    	},
				    	error : function(){ //요청에 실패 시 실행할 함수 정의
				    		alert("요청 실패!");
				    	}
				    });
				}
				var isSubmit = false;
				//event객체 : DOM과 관련된 이벤트 발생하명 관련 정보를 가지고 있는 객체
				//제이쿼리 사용
			 	$('#MFoem').submit(function(event){
					//SUBMIt 처리 되는것을 막아야함
					event.preventDefault();
					
					//html(),text()
					var rId = $('#input_id').val();
					
					
					$.ajax({
				    	type : "post", //데이터 전송방식
				    	data : {'id': input.value}, //서버로 보낼 데이터
				    	//input태그에 작성한 텍스트 가져올때 .value사용
				    	url : "../IdCheckCon01", //데이터를 보낼 서버페이지
				    	dataType : "text", //응답데이터 타입
				    	success : function(data){ //요청에 성공 시 실행할 함수 정의 - 가능(true),불가능(false)
				    		alert(data);
				    		if(data =="true"){
				    			alert(data);
				    			isSubmit = false;
				    		}else{
				    			isSubmit = true;
				    			alert(data);
				    			$('#sp1').html("ID을 확인하시오");
				    		}
				    	},
				    	error : function(){ //요청에 실패 시 실행할 함수 정의
				    		alert("요청 실패!");
				    	}
				    });
					 //isSubmit이 true인 경우에만 submit할수 있도록
					if(isSubmit){
						alert(isSubmit);
						this.submit();
					}
				}) 
				
			</script>

</body>
</html>