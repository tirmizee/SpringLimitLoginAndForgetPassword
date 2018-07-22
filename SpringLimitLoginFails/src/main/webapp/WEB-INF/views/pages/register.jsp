<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8;" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="_csrf" content="${_csrf.token}"/>
  <meta name="_csrf_header" content="${_csrf.headerName}"/>
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
	  <div class="register-box-body">
	    <p class="login-box-msg">Register a new membership</p>
	
	    <form id="formRegister"  autocomplete="off">
		  
	      <div class="form-group has-feedback">
	        <input name="username" type="text" class="form-control" placeholder="Username"  autocomplete="off" >
	        <span class="glyphicon glyphicon-user form-control-feedback"></span>
	      </div>
	      <div class="form-group has-feedback">
	        <input name="password" type="password" class="form-control" placeholder="Password" autocomplete="off">
	        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
	      </div>
	      <div class="form-group has-feedback">
		   <input name="email" type="email" class="form-control" placeholder="Email">
		   <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
		  </div>
	      <div class="row">
	        <div class="col-xs-8">
	        </div>
	        <!-- /.col -->
	        <div class="col-xs-4">
	          <button type="submit" class="btn btn-primary btn-block btn-flat">Register</button>
	        </div>
	        <!-- /.col -->
	      </div>
	    </form>
	    <a href="${pageContext.request.contextPath}" class="pull-right">Go To Login</a>
	    <br>
	  </div>
  <!-- /.login-box-body -->
</div>
<script src="${pageContext.request.contextPath}/resources/scripts/Common.js"></script>
<script>
var Register = function(){
	
	var _callServiceRegister = function(){
		var object = {
			username : $('input[name="username"]').val(),
			password : $('input[name="password"]').val(),
			email : $('input[name="email"]').val()
		};
		AjaxManager.PostData(object ,"api/member/register",
			function(response){
				$('.login-box').waitMe("hide");
				if (response) {
					var option = {
						type  : 'success',  
						title : 'Register new member completed.', 
						text  : 'Go To Login Page', 
						showConfirmButton : false, 
						timer : 2000 
					};
					swal(option).then(function() {
						window.location.href = 'http://localhost:8080/SpringLimitLoginFails/login';
					});
				}
			},
			function(jqXHR, textStatus, errorThrown){
				var error = JSON.parse(jqXHR.responseText);
				$('.login-box').waitMe("hide");
				$('#formRegister')[0].reset();
  			    Swal.Error('Warning message', error.errorDescription );
			}
		);
	}
	
	var handleInputUsername = function() {
		
	}
	
	var handleFormRegister = function(){
		$('#formRegister').formValidation({
			 framework: 'bootstrap',
		        icon: {
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        fields: {
		            username: {
		                validators: {
		                    notEmpty: {
		                        message: 'The username is required'
		                    },
		                    stringLength: {
		                        min: 3,
		                        max: 30,
		                        message: 'The username must be more than 6 and less than 30 '
		                    }
		                }
		            },
		            password : {
		                validators : {
		                    notEmpty : {
		                        message : 'The password is required'
		                    },
		                    stringLength : {
		                        min : 3,
		                        max : 100,
		                        message : 'The password must be more than 6 and less than 100 '
		                    }
		                }
		            },
		            email : {
		                validators: {
		                    notEmpty: {
		                        message: 'The email is required'
		                    },
		                    email : {
		                        message: 'The email is not valid'
		                    }
		                }
		            }
		        }
	        
		}).on('success.form.fv', function(event) {	  
	    	event.preventDefault();
	    	_callServiceRegister();
		});  
	}
	
	return {
		init : function(){
			handleInputUsername();
			handleFormRegister();
		}
	};
	
}();

$(document).ready(function(){
	Register.init();
}); 

</script>
</body>
</html>