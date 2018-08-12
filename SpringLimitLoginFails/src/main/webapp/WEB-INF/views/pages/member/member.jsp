<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<security:authentication var="profile" property="principal" />
<!DOCTYPE>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="_csrf" content="${_csrf.token}"/>
  <meta name="_csrf_header" content="${_csrf.headerName}"/>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="shortcut icon" href="favicon.ico">

  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/bootstrap/css/bootstrap.min.css" >
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/ionicons/css/ionicons.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/select2/css/select2.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/bootstrap-datepicker/css/bootstrap-datepicker.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/admin-lte2/css/AdminLTE.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/admin-lte2/css/skins/_all-skins.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/validate-form-master/css/formValidation.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/jquery.dataTables.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/buttons.dataTables.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/colReorder.dataTables.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/responsive.dataTables.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/bootstrap-toggle/css/bootstrap-toggle.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/sweetalert2/css/sweetalert2.min.css">
 
  <script src="${pageContext.request.contextPath}/resources/libs/bootstrap/js/jquery-3.2.1.min.js" ></script>
  <script src="${pageContext.request.contextPath}/resources/libs/bootstrap/js/bootstrap.min.js" ></script>
  <script src="${pageContext.request.contextPath}/resources/libs/select2/js/select2.full.min.js" ></script>
  <script src="${pageContext.request.contextPath}/resources/libs/bootstrap-datepicker/js/bootstrap-datepicker.min.js" ></script>
  <script src="${pageContext.request.contextPath}/resources/libs/admin-lte2/js/app.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/validate-form-master/js/formValidation.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/validate-form-master/js/formValidation.popular.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/validate-form-master/js/framework/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/datatables/js/jquery.dataTables.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/datatables/js/dataTables.buttons.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/datatables/js/dataTables.colReorder.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/datatables/js/dataTables.responsive.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/bootstrap-toggle/js/bootstrap-toggle.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/sweetalert2/js/sweetalert2.all.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/sweetalert2/js/promise.min.js"></script>
  
  <style>
     .modal-lg{
     	width:80%;
     	margin: 3% auto;
     }
     .modal-header {
     	background-color: #ffc107;
     }
     .modal-title{
     	font-size: 20px;
     	color: #3a3a3a;
     }
     .bg-color-green{
     	background-color:#10c572 ;
     }
     .bg-color-sky{
    	 background-color:#00c0ef ;
     }
     .color-white{
     	color:#ffffff !important;
     }
     .input-group-disabled{
     	background-color: #eeeeee !important;
     }
     .profile-user-img {
     	width: 200px !important;
     }
     .profile-user-img-origin {
     	width: 50px !important;
     }
     .toggle.ios, .toggle-on.ios, .toggle-off.ios { border-radius: 20px}
  	 .toggle.ios .toggle-handle { border-radius: 20px; }
  </style>
  
  <title><spring:message code="app.title"/></title>
</head>
<body class="hold-transition ${profile.skinClass} sidebar-mini">
  <div class="wrapper">

    <jsp:include page="../../template/header.jsp" />
    <jsp:include page="../../template/menu_sidebar.jsp" />
    
	<input type="hidden" name="rootUrl" value="${pageContext.request.contextPath}" />		

    <div class="content-wrapper">
      
      <section class="content-header">
        <h1>
          TROO3
          <small>member page</small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i> Home ${pageContext.response.locale}</a></li>
          <li class="active">Permission</li>
        </ol>
        
      </section><!-- Content Header (Page header) -->

	<section class="content">
		<div class="box box-default">
			<div class="box-header with-border">
				<h3 class="box-title">Search Member</h3>
				<div class="box-tools pull-right">
					<button type="button" class="btn btn-box-tool" data-widget="collapse">
						<i class="fa fa-minus"></i>
					</button>
				</div>
			</div><!-- /.box-header -->
	
			<div class="box-body">
				<form id="frmMember" role="form">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>Username</label>
								<input name="username" type="text" class="form-control" placeholder="Username...">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>Email</label>
								<input name="email" type="text" class="form-control" placeholder="Email...">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3">
							<div class="form-group">
								<label>Enable</label>
								<select name="enabled" class="form-control">
									<option value="" selected>All</option>
				                	<option value="1">Yes</option>
				                    <option value="0">No</option>
				                 </select>
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label>Account Non Locked</label>
								<select name="accountNonLocked" class="form-control">
									<option value="" selected>All</option>
				                	<option value="1">Yes</option>
				                    <option value="0">No</option>
				                 </select>
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label>Account Non Expired</label>
								<select name="accountNonExpired" class="form-control">
									<option value="" selected>All</option>
				                	<option value="1">Yes</option>
				                    <option value="0">No</option>
				                 </select>
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label>Credentials Non Expired</label>
								<select name="credentialsNonExpired" class="form-control">
									<option value="" selected>All</option>
				                	<option value="1">Yes</option>
				                    <option value="0">No</option>
				                 </select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>Role</label>
								<select name="roleId" class="select2 form-control">
									<option value="" selected>All</option>
									<c:forEach items="${roles}" var="role">
				                    <option value="${role.roleId}">${role.roleName}</option>
				                    </c:forEach>
				                 </select>
							</div>
						</div>
						<div class="col-md-6">
						</div>
					</div>
					<div class="row text-center">
						<button id="btnClear" type="button" class="btn btn-default btn-flat">Clear</button>
						<button id="btnSearch" type="button" class="btn btn-primary btn-flat">Search</button>
					</div>
				</form>
			</div>
		</div>
	
		<div class="box">
			<div class="box-body">
				<table id="tableMember" class="display nowrap" cellspacing="0" width="100%"></table>
			</div>
		</div>
		
	</section><!-- /.content -->
	
    </div><!-- /.content-wrapper -->

   <jsp:include page="../../template/footer.jsp" />

  <div class="control-sidebar-bg"></div>

</div><!-- ./wrapper -->

 <jsp:include page="member_modal_edit.jsp" />
 <jsp:include page="member_modal_view.jsp" />

<script src="${pageContext.request.contextPath}/resources/scripts/Common.js"></script>
<script>
var Member = function(){
	
	var DataTable = {};
	var rowSelected = {};
	var searchMember = {};
	var rootUrl = $('input[name="rootUrl"]').val();
	
	var InitializeSelect2 = function(){
		$('.select2').select2();
	}
	
	var alertOption = function(){
		return {
			title : 'Are you sure ?',
			text  : '',
			type  : 'warning',
			showCancelButton   : true,
			reverseButtons     : true,
			confirmButtonColor : '#00a65a',
			confirmButtonText  : 'Confirm'
		};
	}
	
	var _toDate = function(dateStr){
		var arr = dateStr.split("/");
		return new Date(parseInt(arr[2]),parseInt(arr[1]),parseInt(arr[0]) + 1);
	}

	var _callApiUpdateAccountNonExpired = function(params){
		AjaxManager.PostData(params ,"api/member/updateAccountNonExpired",
			function(response){
				if (response) {
					swal({ type  : 'success',  
						   title : 'Update status account non locked success.', 
						   text  : 'Go To Login Page', 
						   showConfirmButton : false, 
						   timer: 2000  
					}).then(function() {
						DataTable.ajax.reload();
					});
				}
			},
			function(jqXHR, textStatus, errorThrown){
				var error = JSON.parse(jqXHR.responseText);
  			    Swal.Error('Warning message', error.errorDescription );
  			    DataTable.ajax.reload();
			}
		);
	}
	
	var _callApiUpdateAccountNonLocked = function(params){
		AjaxManager.PostData(params ,"api/member/updateAccountNonLocked",
			function(response){
				if (response) {
					swal({ type  : 'success',  
						   title : 'Update status account non locked success.', 
						   text  : 'Go To Login Page', 
						   showConfirmButton : false, 
						   timer: 2000  
					}).then(function() {
						DataTable.ajax.reload();
					});
				}
			},
			function(jqXHR, textStatus, errorThrown){
				var error = JSON.parse(jqXHR.responseText);
  			    Swal.Error('Warning message', error.errorDescription );
  			    DataTable.ajax.reload();
			}
		);
	}
	
	var _callApiUpdateCredentialsNonExpired = function(params){
		AjaxManager.PostData(params ,"api/member/credentialsNonExpired",
			function(response){
				if (response) {
					swal({ type  : 'success',  
						   title : 'Update status credentials non expired success.', 
						   text  : 'Go To Login Page', 
						   showConfirmButton : false, 
						   timer: 2000  
					}).then(function() {
						DataTable.ajax.reload();
					});
				}
			},
			function(jqXHR, textStatus, errorThrown){
				var error = JSON.parse(jqXHR.responseText);
  			    Swal.Error('Warning message', error.errorDescription );
  			    DataTable.ajax.reload();
			}
		);
	}
	
	var _callApiUpdateEnabled = function(params){
		AjaxManager.PostData(params ,"api/member/updateEnabled",
			function(response){
				if (response) {
					swal({ type  : 'success',  
						   title : 'Update status enabled success.', 
						   text  : 'Go To Login Page', 
						   showConfirmButton : false, 
						   timer: 2000  
					}).then(function() {
						DataTable.ajax.reload();
					});
				}
			},
			function(jqXHR, textStatus, errorThrown){
				var error = JSON.parse(jqXHR.responseText);
  			    Swal.Error('Warning message', error.errorDescription );
  			    DataTable.ajax.reload();
			}
		);
	}
	
	var _callApiUpdateMember = function(params){
		AjaxManager.PostData(params ,"api/member/update",
			function(response){
				if (response) {
					swal({ type  : 'success',  
						   title : 'Update member success.', 
						   text  : 'Go To Login Page', 
						   showConfirmButton : false, 
						   timer: 2000  
					}).then(function() {
						DataTable.ajax.reload();
						$('#modal_edit_member').modal('hide');
					});
				}
			},
			function(jqXHR, textStatus, errorThrown){
				var error = JSON.parse(jqXHR.responseText);
  			    Swal.Error('Warning message', error.errorDescription );
  			    DataTable.ajax.reload();
  			  $('#modal_edit_member').modal('hide');
			}
		);
	}
	
	var _callApiGetMember = function(params){
		AjaxManager.GetData({} ,"api/member/get/" + params,
			function(response){
				if (response) {
					$('#frmEditMember input[name="username"]').val(response.username);
					$('#frmEditMember input[name="email"]').val(response.email);
					$('#frmEditMember input[name="credentialsExpiredDate"]').datepicker('setDate', response.credentialsExpiredDate);
					$('#frmEditMember select[name="roleId"]').val(response.fkRoleId).trigger('change');
				}
			},
			function(jqXHR, textStatus, errorThrown){
				var error = JSON.parse(jqXHR.responseText);
  			    Swal.Error('Warning message', error.errorDescription );
			}
		);
	}
	
	var _callApiDeleteMember = function(params){
		AjaxManager.GetData({} ,"api/member/delete/" + params,
			function(response){
				if (response) {
					swal({ type  : 'success',  
						   title : 'delete member success.', 
						   text  : 'Go To Login Page', 
						   showConfirmButton : false, 
						   timer: 2000  
					}).then(function() {
						DataTable.ajax.reload();
						$('#modal_edit_member').modal('hide');
					});
				}
			},
			function(jqXHR, textStatus, errorThrown){
				var error = JSON.parse(jqXHR.responseText);
  			    Swal.Error('Warning message', error.errorDescription );
			}
		);
	}
	
	var _getToggleOnOff = function(bool){
		return bool ? 'on' : 'off';
	}
	
	var _toYesOrNo = function(bool){
		return bool ? 'Yes' : 'No';
	}
	
	var handleActiveMenu = function () {
		 $('ul.sidebar-menu > li.menu-member').addClass('active');
	}
	
	var handleButtonSearch = function(){
		 $('#btnSearch').on('click', function(event){
			 searchMember.username              = $('input[name="username"]').val();
			 searchMember.email                 = $('input[name="email"]').val();
			 searchMember.enabled               = $('select[name="enabled"]').val();
			 searchMember.accountNonLocked      = $('select[name="accountNonLocked"]').val();
			 searchMember.accountNonExpired     = $('select[name="accountNonExpired"]').val();
			 searchMember.credentialsNonExpired = $('select[name="credentialsNonExpired"]').val();
			 searchMember.roleId                = $('#frmMember select[name="roleId"]').val();
			 DataTable.ajax.reload();
		 });
	}
	
	var handleButtonClear = function(){
		$('#btnClear').on('click', function(){
			$('#frmMember')[0].reset();
			$('#frmMember select[name="roleId"]').select2('');
		});
	}	
	
	var handleDataTable = function(){
		
		var btnEdit = '<button data-btn-name="btnEdit" type="button" class="btn btn-success" data-toggle="tooltip" title="Edit Member !"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button>';
		var btnView = '<button data-btn-name="btnView" type="button" class="btn btn-info" data-toggle="tooltip" title="View Member !"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></button>';
		var btnDelete = '<button data-btn-name="btnDelete" type="button" class="btn btn-danger" data-toggle="tooltip" title="Delete Member !"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>';
		
		DataTable = $('#tableMember').DataTable({
			processing   : true,
			serverSide   : true,
			responsive   : false,
			select       : true,
			searching    : false,
			scrollX      : true,
			deferRender  : true,
			fnDrawCallback : function() {
	            $('input[type="checkbox"]').bootstrapToggle();
	        },
			ajax: {
				url: 'api/member/findAllPage',
				type: "POST",
				contentType: 'application/json',
				headers: {
	                'X-CSRF-TOKEN' : AjaxManager.CsrfToken 
	            },
				data: function (d) {
					d.search = searchMember;
					return JSON.stringify(d);
				}
			},
			columns: [
				{ data: null                     , title : "Action" },
				{ data: null                 	 , title : "Order" },
				{ data: null                 	 , title : "Profile" },
				{ data: "username"             	 , title : "Username"},
				{ data: "roleName"            	 , title : "Role Name" },
				{ data: "email"              	 , title : "Email" },
				{ data: "credentialsExpiredDate" , title : "Credentials Expired Date" },
				{ data: "enabled"            	 , title : "Enabled" },
				{ data: "accountNonLocked"   	 , title : "Account Non Locked" },
				{ data: "accountNonExpired"  	 , title : "Account Non Expired" },
				{ data: "credentialsNonExpired"  , title : "Credentials Non Expired" }
				
			],
			columnDefs: [
				{
					targets   : 1,
					width     : "10%",
					orderable : false,
					render    : function (data, type, row, meta) {
						return meta.settings._iDisplayStart + meta.row + 1;
					}
				},
				{
					targets   : 0,
					orderable : false,
					className : "text-center",
					render    : function (data, type, row, meta) {
						return btnDelete + ' ' + btnEdit + ' ' + btnView;
					}
				},
				{
					targets   : 2,
					orderable : false,
					className : "text-center",
					width     : "20%",
					render    : function (data, type, row, meta) {
						return '<img class="profile-user-img-origin img-responsive img-circle"  src="api/member/getImageProfile/' + row.username + '">';
					}
				},
				{
					targets   : 6,
					className : "text-center"
				},
				{
					targets   : 7,
					orderable : false,
					className : "text-center",
					render    : function (data, type, row, meta) {
						var check = data ? 'checked' : '';
						return '<input type="checkbox" name="enabled" ' + check + ' data-on="Yes" data-off="No" data-onstyle="success" data-offstyle="danger" data-style="ios" data-size="mini" >';
					}
				},
				{
					targets   : 8,
					orderable : false,
					className : "text-center",
					render    : function (data, type, row, meta) {
						var check = data ? 'checked' : '';
						return '<input type="checkbox" name="accountNonLocked" ' + check + ' data-on="Yes" data-off="No" data-onstyle="success" data-offstyle="danger" data-style="ios"  data-size="mini" >';
					}
				},
				{
					targets   : 9,
					orderable : false,
					className : "text-center",
					render    : function (data, type, row, meta) {
						var check = data ? 'checked' : '';
						return '<input type="checkbox" name="accountNonExpired" ' + check + '  data-on="Yes" data-off="No" data-onstyle="success" data-offstyle="danger" data-style="ios" data-size="mini" >';
					}
				},
				{
					targets   : 10,
					orderable : false,
					className : "text-center",
					render    : function (data, type, row, meta) {
						var check = data ? 'checked' : '';
						return '<input type="checkbox" ' + check + ' name="credentialsNonExpired" data-on="Yes" data-off="No" data-onstyle="success" data-offstyle="danger" data-style="ios" data-size="mini" >';
					}
				}
			],
			order: [[1, 'asc']]
		});
	}
	
	var handleButtonSaveMember = function(){
		$('#btnSaveMember').on('click',function(){
			var option = alertOption();
			option.text = 'update member.';
			swal(option).then(function(result){
				if (result.value) {
					var params = {};
					params.username               = $('#frmEditMember input[name="username"]').val();
					params.email                  = $('#frmEditMember input[name="email"]').val();
					params.enabled                = $('#frmEditMember input[name="enabled"]').prop('checked');
					params.accountNonLocked       = $('#frmEditMember input[name="accountNonLocked"]').prop('checked');
					params.accountNonExpired      = $('#frmEditMember input[name="accountNonExpired"]').prop('checked');
					params.credentialsNonExpired  = $('#frmEditMember input[name="credentialsNonExpired"]').prop('checked');
					params.fkRoleId               = $('#frmEditMember select[name="roleId"]').val();
					params.credentialsExpiredDate = _toDate($('#frmEditMember input[name="credentialsExpiredDate"]').val());
					_callApiUpdateMember(params);
			  	} 
			});
		});
	}
	
	var handleButtonViewMember = function(){
		$(document).on('click', '#tableMember button[data-btn-name="btnView"]', function (event) {
			var data = DataTable.row($(this).parents('tr')).data();
			$('#modal_view_member').modal();
			AjaxManager.GetData({} ,"api/member/getProfile/" + data.username,
				function(response){
					if (response) {
						$('#frmViewMember input[name="username"]').val(response.username);
						$('#frmViewMember input[name="email"]').val(response.email);
						$('#frmViewMember input[name="roleName"]').val(response.roleName);
						$('#frmViewMember input[name="enabled"]').val(_toYesOrNo(response.enabled));
						$('#frmViewMember input[name="accountNonLocked"]').val(_toYesOrNo(response.accountNonLocked));
						$('#frmViewMember input[name="accountNonExpired"]').val(_toYesOrNo(response.accountNonExpired));
						$('#frmViewMember input[name="credentialsNonExpired"]').val(_toYesOrNo(response.credentialsNonExpired));
						$('#frmViewMember input[name="credentialsExpiredDate"]').val( response.credentialsExpiredDate);
						$("#imgProfile").attr("src", rootUrl + "/api/member/getImageProfile/" + data.username);
					}
				},
				function(jqXHR, textStatus, errorThrown){
					var error = JSON.parse(jqXHR.responseText);
	  			    Swal.Error('Warning message', error.errorDescription );
				}
			);
		});
	}
	
	var handleButtonDeleteMember = function(){
		$(document).on('click', '#tableMember button[data-btn-name="btnDelete"]', function (event) {
			var data = DataTable.row($(this).parents('tr')).data();
			var option = alertOption();
			option.text = 'delete member.';
			swal(option).then(function(result){
				if (result.value) {
					_callApiDeleteMember(data.username);
			  	} 
			});
		});
	}
	
	var handleButtonEditMember = function(){
		$(document).on('click', '#tableMember button[data-btn-name="btnEdit"]', function (event) {
			var data = DataTable.row($(this).parents('tr')).data();
			$('#modal_edit_member').modal();
			_callApiGetMember(data.username);
		});
	}
	
	var handleToggleUpdateEnabled = function(){
		$(document).on('change', '#tableMember input[name="enabled"]', function (event) {
			event.preventDefault();
			
			var data = DataTable.row($(this).parents('tr')).data();
			data.enabled = $(this).prop('checked');
			rowSelected = data;
			
			var option = alertOption();
			option.text = 'update status account enabled.';
			swal(option).then(function(result){
				if (result.value) {
					_callApiUpdateEnabled(rowSelected);
			  	} else {
			  		DataTable.ajax.reload();
			  	}
			});

		});
	}
	
	var handleToggleUpdateAccountNonLocked = function(){
		$(document).on('change', '#tableMember input[name="accountNonLocked"]', function (event) {
			event.preventDefault();
		
			var data = DataTable.row($(this).parents('tr')).data();
			var option = alertOption();
			data.accountNonLocked = $(this).prop('checked');
			rowSelected = data;
			
			option.text = 'update status account non locked.';
			swal(option).then( function(result) {
				if (result.value) {
					_callApiUpdateAccountNonLocked(rowSelected);
			  	} else {
			  		DataTable.ajax.reload();
			  	}
			});
		
		});
	}
	
	var handleToggleUpdateAccountNonExpired = function(){
		$(document).on('change', '#tableMember input[name="accountNonExpired"]', function (event) {
			event.preventDefault();
		
			var data = DataTable.row($(this).parents('tr')).data();
			var option = alertOption();
			data.accountNonExpired = $(this).prop('checked');
			rowSelected = data;
			
			option.text = 'update status account non expired.';
			swal(option).then( function(result) {
				if (result.value) {
					_callApiUpdateAccountNonExpired(rowSelected);
			  	} else {
			  		DataTable.ajax.reload();
			  	}
			});
			
		});
	}
	
	var handleToggleUpdateCredentialsNonExpired = function(){
		$(document).on('change', '#tableMember input[name="credentialsNonExpired"]', function (event) {
			event.preventDefault();
		
			var data = DataTable.row($(this).parents('tr')).data();
			var option = alertOption();
			data.credentialsNonExpired = $(this).prop('checked');
			rowSelected = data;
			
			option.text = 'update status credentials non expired.';
			swal(option).then( function(result)  {
				if (result.value) {
					_callApiUpdateCredentialsNonExpired(rowSelected);
			  	} else {
			  		DataTable.ajax.reload();
			  	}
			});
		
  		});
	}
	
	var handleModalEditMember = function(){
		$('#modal_edit_member').on('hidden.bs.modal', function (event) {
			$('#frmEditMember')[0].reset();
		});
	}
	
	var handleFormEditCredentialsExpiredDate = function(){
		$('#frmEditMember input[name="credentialsExpiredDate"]').datepicker({
			autoclose: true,
			format: 'dd/mm/yyyy',
	        startDate: '+0d'
		});
	}
	
	return {
		init : function() {
			InitializeSelect2();
			handleActiveMenu();
			handleDataTable();
			handleButtonSearch();
			handleButtonClear();
			handleButtonEditMember();
			handleButtonViewMember();
			handleButtonDeleteMember();
			handleButtonSaveMember();
			handleModalEditMember();
			handleToggleUpdateEnabled();
			handleToggleUpdateAccountNonLocked();
			handleToggleUpdateAccountNonExpired();
			handleToggleUpdateCredentialsNonExpired();
			handleFormEditCredentialsExpiredDate();
		}
	};
	
}();

$(document).ready(function() {
	Member.init();
});

</script>
</body>
</html>