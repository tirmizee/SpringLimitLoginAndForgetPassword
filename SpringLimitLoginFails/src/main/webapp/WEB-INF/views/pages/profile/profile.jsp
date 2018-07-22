<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE>
<html>
<head>
  <meta name="_csrf" content="${_csrf.token}"/>
  <meta name="_csrf_header" content="${_csrf.headerName}"/>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="shortcut icon" href="favicon.ico">

  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/bootstrap/css/bootstrap.min.css" >
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/ionicons/css/ionicons.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/admin-lte2/css/AdminLTE.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/admin-lte2/css/skins/skin-green.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/admin-lte2/css/skins/skin-yellow.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/validate-form-master/css/formValidation.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/jquery.dataTables.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/buttons.dataTables.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/colReorder.dataTables.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/responsive.dataTables.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/bootstrap-toggle/css/bootstrap-toggle.min.css">
 
  <script src="${pageContext.request.contextPath}/resources/libs/bootstrap/js/jquery-3.2.1.min.js" ></script>
  <script src="${pageContext.request.contextPath}/resources/libs/bootstrap/js/bootstrap.min.js" ></script>
  <script src="${pageContext.request.contextPath}/resources/libs/admin-lte2/js/app.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/validate-form-master/js/formValidation.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/validate-form-master/js/formValidation.popular.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/validate-form-master/js/framework/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/datatables/js/jquery.dataTables.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/datatables/js/dataTables.buttons.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/datatables/js/dataTables.colReorder.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/datatables/js/dataTables.responsive.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/bootstrap-toggle/js/bootstrap-toggle.min.js"></script>
  
  <style>
     .modal-lg{
     	width:90%;
     	margin: 3% auto;
     }
     .modal-header {
     	background-color: #ffc107;
     }
     .modal-title{
     	font-size: 20px;
     	color: #3a3a3a;
     }
     .toggle.ios, .toggle-on.ios, .toggle-off.ios { border-radius: 20px}
  	 .toggle.ios .toggle-handle { border-radius: 20px; }
  	 .profile-user-img-custom {
  	 	margin: 0 auto ;
	    width: 200px;
	    height : 200px;
	    padding: 3px;
	    border: 3px solid #d2d6de;
  	 }
  </style>
  
<title>SpringLimitLoginFails</title>
</head>
<body class="hold-transition skin-green sidebar-mini">
  <div class="wrapper">

    <jsp:include page="../../template/header.jsp" />
    <jsp:include page="../../template/menu_sidebar.jsp" />

    <div class="content-wrapper">
      
      <section class="content-header">
        <h1>
          <small>profile page</small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i> Home </a></li>
          <li class="active">profile</li>
        </ol>
        
      </section><!-- Content Header (Page header) -->

	  
	<section class="content">
		<div class="row">
			<div class="col-md-3">
		
				<div class="box box-primary">
					<div class="box-body box-profile">
						<img class="profile-user-img img-responsive img-circle" src="${pageContext.request.contextPath}/resources/libs/admin-lte2/img/rin.png" alt="User profile picture">
		
						<h3 class="profile-username text-center">Nina Mcintire</h3>
		
						<p class="text-muted text-center">Software Engineer</p>
		
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<div class="nav-tabs-custom">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#activity" data-toggle="tab" aria-expanded="true">Activity</a></li>
						<li class=""><a href="#edit_profile" data-toggle="tab" aria-expanded="false">Edit Profile</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="activity">
							
						</div>
						<div class="tab-pane" id="edit_profile">
							<form action="" method="post" class="form-horizontal" enctype="multipart/form-data">
								<div class="row">
									<div class="col-md-4 col-md-offset-4">
										<div class="form-group ">
											<img id="imgPreview" class="profile-user-img-custom img-responsive img-circle" src="${pageContext.request.contextPath}/resources/libs/admin-lte2/img/rin.png">
											<br>
											<input name="imgProfile" type="file" accept="image/*"  class="form-control ">
											
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="inputName" class="col-sm-2 control-label">Name</label>
									<div class="col-sm-9">
										<input type="email" class="form-control" id="inputName" placeholder="Name">
									</div>
								</div>
								<div class="form-group">
									<label for="inputName" class="col-sm-2 control-label">Name</label>
									<div class="col-sm-9">
										<input type="email" class="form-control" id="inputName" placeholder="Name">
									</div>
								</div>
				                <div class="form-group">
				                    <div class="col-sm-offset-2 col-sm-10">
				                   		<button type="submit" class="btn btn-danger">Save</button>
				                     </div>
			                	</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	
	</section><!-- /.content -->
	
    </div><!-- /.content-wrapper -->

   <jsp:include page="../../template/footer.jsp" />

  <div class="control-sidebar-bg"></div>

</div><!-- ./wrapper -->

<script src="${pageContext.request.contextPath}/resources/scripts/Common.js"></script>
<script>
var Profile = function(){
	
	var handleInputImageProfile = function(){
		$('input[name="imgProfile"]').on('change', function(event){
			ImagePreview.show('imgPreview',event);
		});
	}
	
	return {
		init : function(){
			handleInputImageProfile();
		}
	};
	
}();

$(document).ready(function() {
	Profile.init();
});
</script>
</body>
</html>