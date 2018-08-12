<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE>
<html>
<head>
<META HTTP-EQUIV="REFRESH" CONTENT="${csrf_timeout_in_seconds}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/bootstrap/css/bootstrap.min.css" >
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/ionicons/css/ionicons.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/admin-lte2/css/AdminLTE.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/validate-form-master/css/formValidation.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/inputmark/css/inputmask.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/waitme/css/waitMe.min.css">

  <script src="${pageContext.request.contextPath}/resources/libs/bootstrap/js/jquery-3.2.1.min.js" ></script>
  <script src="${pageContext.request.contextPath}/resources/libs/bootstrap/js/bootstrap.min.js" ></script>
  <script src="${pageContext.request.contextPath}/resources/libs/admin-lte2/js/app.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/validate-form-master/js/formValidation.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/validate-form-master/js/formValidation.popular.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/validate-form-master/js/framework/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/inputmark/js/jquery.inputmask.bundle.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/waitme/js/waitMe.min.js"></script>

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
<title><spring:message code="app.title"/></title>
</head>
<body class="bg">
	<div class="container" >
		
	</div>	<!-- container -->
	<div class="login-box">
  <div class="login-logo">
    <a href="#"><b><font color="#00a65a">Limit</font></b>Login</a>
  </div>
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
	
    <p class="login-box-msg">Start Your Session</p>
	<form id="inFormLogin" action="login" method="post">
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon" id="sizing-addon2"><span class="glyphicon glyphicon-user"></span></span>
				<input type="text" class="form-control" name="username" placeholder="Username" aria-describedby="sizing-addon2">
			</div>
		</div>	
		
		<div class="form-group">
		 	<div class="input-group">
				<span class="input-group-addon" id="sizing-addon2"><span class="glyphicon glyphicon-lock"></span> </span>
				<input type="password" class="form-control" name="password" placeholder="Password" aria-describedby="sizing-addon2">
			</div>
		</div>
		
		<div class="form-group">
			<button type="submit" class="btn btn-success btn-block btn-flat" style="width: 100%;font-weight: 800;">Sign In</button>
	    </div>	
	    <div class="form-group">
	    	<div class="input-group pull-right">
	    		<a href="${pageContext.request.contextPath}/ForgetPassword">Forget Password</a>
	    	</div>
	    	<br>
	    	<div class="input-group pull-right">
	    		<a href="${pageContext.request.contextPath}/Register">Register a new membership</a>
	    	</div>
	    </div>	
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />			
	</form>
  </div>
  <!-- /.login-box-body -->
</div>
<script>
$(document).ready(function(){
	
	var userName = $('#errorMsg');
	
	$('#inFormLogin').formValidation({
		 framework: 'bootstrap',
	        icon: {
	            /* valid: 'glyphicon glyphicon-ok', */
	            /* invalid: 'glyphicon glyphicon-remove', */
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
	            password: {
	                validators: {
	                    notEmpty: {
	                        message: 'The password is required'
	                    },
	                    stringLength: {
	                        min: 3,
	                        max: 100,
	                        message: 'The password must be more than 6 and less than 100 '
	                    }
	                }
	            }
	        }
        
	}).on('err.field.fv', function(e, data) {
        if (data.fv.getSubmitButton()) {
            data.fv.disableSubmitButtons(false);
        }
    }).on('success.form.fv', function(event) {	  
    	$('.login-box-body').waitMe({});
	});  
}); 
</script>
</body>
</html>