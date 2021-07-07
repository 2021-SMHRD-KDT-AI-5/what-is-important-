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
										ȸ������
									</span>
				
									<span class="txt1 p-b-11">
										Id
									</span>
									<div class="wrap-input100 validate-input m-b-36" data-validate = "Username is required">
										<input class="input100" type="text" name="id" id="input_id" >
										<span class="focus-input100"></span>
									</div>
									
									<input type="button" value="ID�ߺ�üũ" onclick="idCheck()">
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
				    //alert(input.value) ����� : ���̵� �ְ� �ߺ�üũ�ϸ� �˸��� ��� 
				    //�񵿱� �������
				    $.ajax({
				    	type : "post", //������ ���۹��
				    	data : {'id':input.value}, //������ ���� ������
				    	url : "../IdCheckCon", //�����͸� ���� ����������
				    	dataType : "text", //���䵥���� Ÿ��
				    	success : function(data){ //��û�� ���� �� ������ �Լ� ���� - ����(true),�Ұ���(false)
				    		alert(data);
				    		document.getElementById("sp");
				    		if(data=="true"){
				    			sp.innerHTML="�̹� ��� ���� ID�Դϴ�.";
				    		}else{
				    			sp.innerHTML="��� ������ ID�Դϴ�.";
				    		}
				    	},
				    	error : function(){ //��û�� ���� �� ������ �Լ� ����
				    		alert("��û ����!");
				    	}
				    });
				}
				var isSubmit = false;
				//event��ü : DOM�� ���õ� �̺�Ʈ �߻��ϸ� ���� ������ ������ �ִ� ��ü
				//�������� ���
			 	$('#MFoem').submit(function(event){
					//SUBMIt ó�� �Ǵ°��� ���ƾ���
					event.preventDefault();
					
					//html(),text()
					var rId = $('#input_id').val();
					
					
					$.ajax({
				    	type : "post", //������ ���۹��
				    	data : {'id': input.value}, //������ ���� ������
				    	//input�±׿� �ۼ��� �ؽ�Ʈ �����ö� .value���
				    	url : "../IdCheckCon01", //�����͸� ���� ����������
				    	dataType : "text", //���䵥���� Ÿ��
				    	success : function(data){ //��û�� ���� �� ������ �Լ� ���� - ����(true),�Ұ���(false)
				    		alert(data);
				    		if(data =="true"){
				    			alert(data);
				    			isSubmit = false;
				    		}else{
				    			isSubmit = true;
				    			alert(data);
				    			$('#sp1').html("ID�� Ȯ���Ͻÿ�");
				    		}
				    	},
				    	error : function(){ //��û�� ���� �� ������ �Լ� ����
				    		alert("��û ����!");
				    	}
				    });
					 //isSubmit�� true�� ��쿡�� submit�Ҽ� �ֵ���
					if(isSubmit){
						alert(isSubmit);
						this.submit();
					}
				}) 
				
			</script>

</body>
</html>