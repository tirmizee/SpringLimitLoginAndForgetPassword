<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions"   prefix = "fn" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<security:authentication var="profile" property="principal" />
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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/admin-lte2/css/skins/_all-skins.min.css">
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
<body class="hold-transition ${profile.skinClass} sidebar-mini">
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
						<img class="profile-user-img img-responsive img-circle" src="${pageContext.request.contextPath}/file/resource/img/profile" alt="User profile picture">
		
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
							The European languages are members of the same family. Their separate existence is a myth.
							For science, music, sport, etc, Europe uses the same vocabulary. The languages only differ
							in their grammar, their pronunciation and their most common words. Everyone realizes why a
							new common language would be desirable: one could refuse to pay expensive translators. To
							achieve this, it would be necessary to have uniform grammar, pronunciation and more common
							words. If several languages coalesce, the grammar of the resulting language is more simple
							and regular than that of the individual languages.
						</div>
						<div class="tab-pane" id="edit_profile">
							<form  id="frmChangeProfile" action="${pageContext.request.contextPath}/api/image/changeProfile" method="post" class="form-horizontal" enctype="multipart/form-data">
								<div class="row">
									<div class="col-md-4 col-md-offset-4">
										<div class="form-group ">
											<img id="imgPreview" class="profile-user-img-custom img-responsive img-circle" src="${pageContext.request.contextPath}/file/resource/img/profile">
											<br>
											<input name="imgProfile" type="file" accept="image/*"  class="form-control ">
											
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="inputName" class="col-sm-2 control-label">Name</label>
									<div class="col-sm-9">
										<input name="name" type="text" class="form-control" placeholder="Name">
									</div>
								</div>
								<div class="form-group">
									<label for="inputName" class="col-sm-2 control-label">email</label>
									<div class="col-sm-9">
										<input type="email" class="form-control"  placeholder="Name">
									</div>
								</div>
				                <div class="form-group">
				                    <div class="col-sm-offset-2 col-sm-10">
				                   		<button id="btnSave" type="button" class="btn btn-danger">Save</button>
				                     </div>
			                	</div>
			                	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />	
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
	
	var handleButtonSave = function(){
		$('#btnSave').on('click', function(){
			var $form_data = $('#frmChangeProfile')
			AjaxManager.UploadData(new FormData($form_data[0]),'api/image/updateProfile',
				function(response){
			
				},function (jqXHR, textStatus, errorThrown) {

				}
			);
		});
	}
	
	return {
		init : function(){
			handleInputImageProfile();
			handleButtonSave();
		}
	};
	
}();

$(document).ready(function() {
	Profile.init();
});
</script>
</body>
</html>