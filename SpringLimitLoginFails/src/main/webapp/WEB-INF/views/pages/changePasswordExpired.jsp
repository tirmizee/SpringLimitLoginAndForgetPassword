<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8;"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/bootstrap/css/bootstrap.min.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/admin-lte2/css/AdminLTE.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/validate-form-master/css/formValidation.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/inputmark/css/inputmask.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/waitme/css/waitMe.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/sweetalert2/css/sweetalert2.min.css">

<script src="${pageContext.request.contextPath}/resources/libs/bootstrap/js/jquery-3.2.1.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/libs/bootstrap/js/bootstrap.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/libs/admin-lte2/js/app.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/validate-form-master/js/formValidation.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/validate-form-master/js/formValidation.popular.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/validate-form-master/js/framework/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/inputmark/js/jquery.inputmask.bundle.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/waitme/js/waitMe.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/libs/sweetalert2/js/sweetalert2.all.js"></script>

<style>
@font-face {
	font-family: 'Cloud-Bold';
	src: url('resources/fonts/Cloud-LightBold/Cloud-Bold.otf');
}
@font-face {
	font-family: 'passion_bold';
	src: url('resources/fonts/Passion_One/PassionOne-Bold.ttf');
}
#inFormLogin .has-error .control-label,
#inFormLogin .has-error .help-block,
#inFormLogin .has-error .form-control-feedback {
    color: red;
}

#inFormLogin .has-success .control-label,
#inFormLogin .has-success .help-block,
#inFormLogin .has-success .form-control-feedback {
    color: #18bc9c;
}
#errorMsg{
	max-width: 350px;
	margin: auto;	
}
.txt16{
	font-size: 16px;
}
.txt18{
	font-size: 18px;
}
.txt20{
	font-size: 20px;
}
.txt26{
	font-size: 26px;
}
.bg{
	background-color: #f7f7f7;
}
</style>
<title>SpringLimitLoginFails</title>
</head>
<body class="bg">
	<div class="container" >
		
	</div>	<!-- container -->
	<div class="login-box">
  <!-- /.login-logo -->
  <div class="login-box-body">
  	<c:if test="${not empty error}">
		<div id="errorMsg"  class="alert alert-danger" align="center">
		<a href="#" class="close" onclick="$('#errorMsg').hide()"> &times;</a>
			${error}
		</div>
		<br>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>
	
    <div class="login-box-msg">
    	<label>Enforce Password Change Expired</label>
    
    </div>
	<form>
	
		<div class="form-group">
		 	<div class="input-group">
				<span class="input-group-addon" id="sizing-addon2"><span class="glyphicon glyphicon-lock"></span> </span>
				<input type="password" class="form-control" name="password" placeholder="Password" aria-describedby="sizing-addon2">
			</div>
		</div>
		<div class="form-group">
		 	<div class="input-group">
				<span class="input-group-addon" id="sizing-addon2"><span class="glyphicon glyphicon-lock"></span> </span>
				<input type="password" class="form-control" name="confirmPassword" placeholder="Confirm Password" aria-describedby="sizing-addon2">
			</div>
		</div>
		
		<input name="username" type="hidden" value="${username}">	
		
		<div class="form-group">
			<button id="btnChange" type="button" class="btn btn-danger btn-block btn-flat" style="width: 100%;font-weight: 800;">Reset Password</button>
	    </div>	
	    <br>
	</form>
  </div>
  <!-- /.login-box-body -->
</div>
<script src="${pageContext.request.contextPath}/resources/scripts/Common.js"></script>
<script>

var ForcePassword = function(){
	
	var handleButtonChangePassword = function(){
		$('#btnChange').on('click' , function(){
			
			var objectData = {
				username : $('input[name="username"]').val(),
				password : $('input[name="password"]').val(),
				confirmPassword : $('input[name="confirmPassword"]').val()
			};

			AjaxManager.PostData(objectData ,"api/password/change",
				function(response){
					if (response) {
						swal({ type  : 'success',  
							   title : 'Reset Your Password Complete', 
							   text  : 'Go To Login Page', 
							   showConfirmButton : false, 
							   timer: 2000  
						}).then(function() {
							window.location.href = 'http://localhost:8080/SpringLimitLoginFails/login';
						});
					}
				},
				function(jqXHR, textStatus, errorThrown){
					var error = JSON.parse(jqXHR.responseText);
	  			    Swal.Error('Warning message', error.errorDescription );
				}
			);
		});
	}
	
	return {
		init : function(){
			handleButtonChangePassword();
		}
	};
}();

$(document).ready(function(){
	ForcePassword.init();
}); 
</script>
</body>
</html>;