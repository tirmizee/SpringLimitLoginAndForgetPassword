<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/admin-lte2/css/AdminLTE.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/admin-lte2/css/skins/skin-green.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/validate-form-master/css/formValidation.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/jquery.dataTables.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/buttons.dataTables.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/colReorder.dataTables.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/responsive.dataTables.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/bootstrap-toggle/css/bootstrap-toggle.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/sweetalert2/css/sweetalert2.min.css">
 
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
  <script src="${pageContext.request.contextPath}/resources/libs/sweetalert2/js/sweetalert2.all.js"></script>
  
  <style>
     .modal-lg{
     	width:90%;
     	margin: 3% auto;
     }
   
     .bg-color-orange{
     	background-color: #ffc107;
     }
     .bg-color-green{
     	background-color:#00a65a ;
     }
     .color-white{
     	color:#ffffff !important;
     }
     .modal-title{
     	font-size: 20px;
     	color: #3a3a3a;
     }
     .toggle.ios, .toggle-on.ios, .toggle-off.ios { border-radius: 20px}
  	 .toggle.ios .toggle-handle { border-radius: 20px; }
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
          TROO2
          <small>role page</small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i> Home </a></li>
          <li class="active">Role</li>
        </ol>
        
      </section><!-- Content Header (Page header) -->

	  
	<section class="content">
		<div class="box box-default">
			<div class="box-header with-border">
				<h3 class="box-title">Manage Role</h3>
				<div class="box-tools pull-right">
					<button type="button" class="btn btn-box-tool" data-widget="collapse">
						<i class="fa fa-minus"></i>
					</button>
				</div>
			</div><!-- /.box-header -->
	
			<div class="box-body">
				<div class="container-fluid row">
					<!-- <button type="button" class="btn  btn-success btn-sm pull-right">Warning</button> -->
					<a class="btn btn-social btn-openid pull-right">
		            	<i class="glyphicon glyphicon-plus"></i> Add new Role
		            </a>
				</div>
				<form id="frmRole" role="form">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>Role Name</label>
								<input name="roleName" type="text" class="form-control" placeholder="Role Name...">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>Role Description</label>
								<input name="roleDesc" type="text" class="form-control" placeholder="Role Description...">
							</div>
						</div>
					</div>
					
					<div class="row text-center">
						<button id="btnClearRole" type="button" class="btn btn-default">Clear</button>
						<button id="btnSearch" type="submit" class="btn btn-success">Search</button>
					</div>
				</form>
			</div>
			<div class="box-footer">
	        	
	        </div>
		</div>
	
		<div class="box">
			<div class="box-body">
				<table id="tableRole" class="cell-border display nowrap" cellspacing="0" width="100%"></table>
			</div>
		</div>
	</section><!-- /.content -->
    </div><!-- /.content-wrapper -->

   <jsp:include page="../../template/footer.jsp" />

  <div class="control-sidebar-bg"></div>

</div><!-- ./wrapper -->


<div class="modal fade" id="modalPermission">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header bg-color-orange">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
          <label id="titleModalPermission" class="modal-title"></label>
      </div>
      <div class="modal-body">
        <form id="frmPermission" role="form">
        	<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label>Permission Code</label>
						<input name="perCode" type="text" class="form-control" placeholder="Permission Code...">
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label>Permission Name</label>
						<input name="perName" type="text" class="form-control" placeholder="Permission Name...">
					</div>
				</div>
			</div>
			<div class="row text-center">
				<button id="btnClearPermission" type="button" class="btn btn-default">Clear</button>
				<button id="btnSearchPermission" type="button" class="btn btn-warning">Search</button>
			</div>
		</form>
		
		<div class="box">
			<div class="box-body">
				<table id="tablePermission" class="display nowrap" cellspacing="0" width="100%"></table>
			</div>
		</div>
		
      </div>
      <!-- <div class="modal-footer">
        <button type="button" class="btn btn-warning">Save changes</button>
      </div> -->
    </div>
  </div>
</div>

 <jsp:include page="role_modal_create.jsp" />
 <jsp:include page="role_modal_edit.jsp" />
 
<script src="${pageContext.request.contextPath}/resources/scripts/Common.js"></script>

<script>
var Permission = function(){
	
	var DatatableRole = {};
	var DatatablePermission = {};
	var searchRole = {};
	var searchPermission = {};
	
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
	
	var _callApiUpdatePermission = function(params){
		AjaxManager.PostData(params ,"api/permission/createRoleMapPermission",
			function(response){
				if (response) {
					swal({ type  : 'success',  
						   title : 'Update permission success.', 
						   text  : 'Go To Login Page', 
						   showConfirmButton : false, 
						   timer: 2000  
					}).then(function() {
						DatatablePermission.ajax.reload();
					});
				}
			},
			function(jqXHR, textStatus, errorThrown){
				var error = JSON.parse(jqXHR.responseText);
  			    Swal.Error('Warning message', error.errorDescription );
  			    DatatablePermission.ajax.reload();
			}
		);
	}
	
	var _callApiDeletePermission = function(params){
		AjaxManager.PostData(params ,"api/permission/deleteRoleMapPermission",
			function(response){
				if (response) {
					swal({ type  : 'success',  
						   title : 'Update permission success.', 
						   text  : 'Go To Login Page', 
						   showConfirmButton : false, 
						   timer: 2000  
					}).then(function() {
						DatatablePermission.ajax.reload();
					});
				}
			},
			function(jqXHR, textStatus, errorThrown){
				var error = JSON.parse(jqXHR.responseText);
  			    Swal.Error('Warning message', error.errorDescription );
  			    DatatablePermission.ajax.reload();
			}
		);
	}
	
	var _callApiCretaeRole = function(params){
		AjaxManager.PostData(params ,"api/role/create",
			function(response){
				if (response) {
					swal({ type  : 'success',  
						   title : 'Create role success.', 
						   text  : '', 
						   showConfirmButton : false, 
						   timer: 2000  
					}).then(function() {
						DatatableRole.ajax.reload();
						$('#modal_create_role').modal('hide');
					});
				}
			},
			function(jqXHR, textStatus, errorThrown){
				var error = JSON.parse(jqXHR.responseText);
  			    Swal.Error('Warning message', error.errorDescription );
  			 	DatatableRole.ajax.reload();
			}
		);
	}
	
	var _callApiEditRole = function(params){
		AjaxManager.PostData(params ,"api/role/edit",
			function(response){
				if (response) {
					swal({ type  : 'success',  
						   title : 'Edit role success.', 
						   text  : '', 
						   showConfirmButton : false, 
						   timer: 2000  
					}).then(function() {
						DatatableRole.ajax.reload();
						$('#modal_edit_role').modal('hide');
					});
				}
			},
			function(jqXHR, textStatus, errorThrown){
				var error = JSON.parse(jqXHR.responseText);
  			    Swal.Error('Warning message', error.errorDescription );
  			 	DatatableRole.ajax.reload();
			}
		);
	}
	
	var _callApiDeleteRole = function(params){
		AjaxManager.GetData({} ,"api/role/delete/" + params,
			function(response){
				if (response) {
					swal({ type  : 'success',  
						   title : 'Create role success.', 
						   text  : '', 
						   showConfirmButton : false, 
						   timer: 2000  
					}).then(function() {
						DatatableRole.ajax.reload();
					});
				}
			},
			function(jqXHR, textStatus, errorThrown){
				var error = JSON.parse(jqXHR.responseText);
  			    Swal.Error('Warning message', error.errorDescription );
  			    DatatableRole.ajax.reload();
			}
		);
	}
	
	var _callApiGetRole = function(params){
		AjaxManager.GetData({} ,"api/role/get/" + params,
			function(response){
				if (response) {
					$('#frmEditRole input[name="roleId"]').val(response.roleId);
					$('#frmEditRole input[name="roleName"]').val(response.roleName);
					$('#frmEditRole textarea[name="roleDesc"]').val(response.roleDesc);
				}
			},
			function(jqXHR, textStatus, errorThrown){
				var error = JSON.parse(jqXHR.responseText);
  			    Swal.Error('Warning message', error.errorDescription );
  			    DatatableRole.ajax.reload();
			}
		);
	}
	
	var handleActiveMenu = function () {
		 $('ul.sidebar-menu > li.menu-role').addClass('active');
	}
	
	var handleDataTableRole = function(){
		
		var btnSetting = '<button href="#" data-btn-name="btnSetting" type="button" class="btn btn-warning" data-toggle="tooltip" title="Assign Permission"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span></button>';
		var btnEdit = '<button href="#" data-btn-name="btnEdit" type="button" class="btn btn-success" data-toggle="tooltip" title="Edit Role!"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button>';
		var btnDelete = '<button href="#"  data-btn-name="btnDelete" type="button" class="btn btn-danger" data-toggle="tooltip" title="Delete Role !"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>';
		
		DatatableRole = $('#tableRole').DataTable({
			processing   : true,
			serverSide   : true,
			responsive   : false,
			select       : true,
			searching    : false,
			scrollX      : true,
			deferRender  : true,
			ajax: {
				url: 'api/role/findAll',
				type: "POST",
				contentType: 'application/json',
				headers: {
	                'X-CSRF-TOKEN' : AjaxManager.CsrfToken 
	            },
				data: function (d) {
					d.search = searchRole;
					return JSON.stringify(d);
				}
			},
			columns: [
				{ data: null            , title: "Order" },
				{ data: "roleId"        , title: ""},
				{ data: "roleName"      , title: "Role Name" },
				{ data: "roleDesc"      , title: "Role Description" },
				{ data: "createDate"    , title: "create Date" },
				{ data: null            , title: "Action" }
			],
			columnDefs: [
				{
					targets   : 0,
					width     : "10%",
					orderable : false,
					render    : function (data, type, row, meta) {
						return meta.settings._iDisplayStart + meta.row + 1;
					}
				},
				{
					targets   : 1,
					"visible" : false
				},
				{
					targets   : 5,
					width     : "10%",
					className : "dt-center",
					orderable : false,
					render    : function (data, type, row, meta) {
						return btnDelete + ' ' + btnEdit + ' ' + btnSetting;
					}
				}
			],
			order: [[1, 'asc']]
		});
		
	}
	
	var handleButtonSettingRole = function(){
		// handle button setting for data table
		$(document).on('click', 'button[data-btn-name="btnSetting"]', function () {
			var data = DatatableRole.row($(this).parents('tr')).data();
			$('#modalPermission').modal('show');
			$('#frmPermission')[0].reset();
			$('#titleModalPermission').text('Assign Permissions Role : ' + data.roleName);
			searchPermission.roleId = data.roleId;
			searchPermission.perCode = '';
			searchPermission.perName = '';
		});
	}
	
	var handleButtonEditRole = function(){
		$('#btnEditRole').on('click',function(){
			var option = alertOption();
			option.text = 'edit role ';
			swal(option).then((result) => {
				if (result.value) {
					var params = {};
					params.roleId = $('#frmEditRole input[name="roleId"]').val();
					params.roleName =  $('#frmEditRole input[name="roleName"]').val();
					params.roleDesc =  $('#frmEditRole textarea[name="roleDesc"]').val();
					_callApiEditRole(params);
			  	}
			});
		});
	}
	
	var handleButtonShowModalEditRole = function(){
		$(document).on('click', 'button[data-btn-name="btnEdit"]', function () {
			var data = DatatableRole.row($(this).parents('tr')).data();
			$('#modal_edit_role').modal('show');
			_callApiGetRole(data.roleId);
		});
	}
	
	var handleButtonDeleteRole = function(){
		$(document).on('click', 'button[data-btn-name="btnDelete"]', function () {
			var data = DatatableRole.row($(this).parents('tr')).data();
			var option = alertOption();
			option.text = 'delete role ' + data.roleName;
			swal(option).then((result) => {
				if (result.value) {
					_callApiDeleteRole(data.roleId);
			  	}
			});
		});
	}
	
	var handleDataTablePermission = function(){
		
		DatatablePermission = $('#tablePermission').DataTable({
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
				url: 'api/permission/findAllByRole',
				type: "POST",
				contentType: 'application/json',
				headers: {
	                'X-CSRF-TOKEN' : AjaxManager.CsrfToken 
	            },
				data: function (d) {
					d.search = searchPermission;
					return JSON.stringify(d);
				}
			},
			columns: [
				{ data: null            , title: "Order" },
				{ data: "perId"         , title: "" },
				{ data: "perCode"       , title: "Permission Code" },
				{ data: "perName"       , title: "Permission Name" },
				{ data: "createDate"    , title: "Create Date" },
				{ data: "status"        , title: "Status" }
			],
			columnDefs: [
				{
					targets   : 0,
					width     : "10%",
					orderable : false,
					render    : function (data, type, row, meta) {
						return meta.settings._iDisplayStart + meta.row + 1;
					}
				},
				{
					targets   : 1,
					"visible" : false
				},
				{
					targets   : 5,
					render    : function (data, type, row, meta) {
						var check = data === 'A' ? 'checked' : '';
						var disabled = row.perCode === 'TR001' ? 'disabled' : '';
						return '<input type="checkbox" ' + check + ' data-toggle="toggle" data-on="Active" data-off="Inactive" data-onstyle="success" data-offstyle="danger" data-style="ios"  data-size="small" '+ disabled +'>';
					}
				}
			],
			order: [[1, 'asc']]
		});
		
		$(document).on('change', '#tablePermission input[type="checkbox"]', function (event) {
			event.preventDefault();
			var data = DatatablePermission.row($(this).parents('tr')).data();
			var params = {
				"roleId" : searchPermission.roleId,
				"perId"  : data.perId
			};
			if ($(this).prop('checked')) {
				_callApiUpdatePermission(params);
			} else {
				_callApiDeletePermission(params);
			}
			
		});
	}
	
	var handleButtonShowModalCreateRole = function(){
		$('a.btn.btn-social.btn-openid ').on('click', function(event){
			$('#modal_create_role').modal();
		});
	}
	
	var handleButtonSearchRole = function(){
		$('#btnSearch').on('click', function(event){
			event.preventDefault();
			searchRole.roleName = $('input[name="roleName"]').val();
			searchRole.roleDesc = $('input[name="roleDesc"]').val();
			DatatableRole.ajax.reload();
		});
	}
	
	var handleButtonSearchPermission = function(){
		$('#btnSearchPermission').on('click', function(event){
			event.preventDefault();
			searchPermission.perCode = $('input[name="perCode"]').val();
			searchPermission.perName = $('input[name="perName"]').val();
			DatatablePermission.ajax.reload();
		});
	}
	
	var handleModalEditRole = function(){
		$('#modal_edit_role').on('hidden.bs.modal', function (event) {
			$('#frmEditRole')[0].reset();
		});
	}
	
	var handleModalPermission = function(){
		$('#modalPermission').on('shown.bs.modal', function (event) {
			DatatablePermission.ajax.reload();
		});
	}
	
	var handleModalCreateRole = function(){
		$('#modal_create_role').on('shown.bs.modal', function (event) {
			$('#frmCreateRole')[0].reset();
		});
	}
	
	var handleButtonCreateRole = function(){
		$('#btnCreateRole').on('click',function(){
			var params = {};
			var option = alertOption();
			option.text = 'Create new role.';
			params.roleName = $('#frmCreateRole input[name="roleName"]').val();
			params.roleDesc = $('#frmCreateRole textarea[name="roleDesc"]').val();
			swal(option).then((result) => {
				if (result.value) {
					_callApiCretaeRole(params);
			  	}
			});
		});
	}
	
	var handleButtonClearTableRole = function(){
		$('#btnClearRole').on('click', function(event){
			$('#frmRole')[0].reset();
		});
	} 
	
	var handleButtonClearTablepermission = function(){
		$('#btnClearPermission').on('click', function(event){
			$('#frmPermission')[0].reset();
		});
	}
	
	return {
		init : function() {
			handleActiveMenu();
			handleDataTableRole();
			handleDataTablePermission();
			handleModalPermission();
			handleModalCreateRole();
			handleModalEditRole();
			handleButtonDeleteRole();
			handleButtonSettingRole();
			handleButtonEditRole();
			handleButtonCreateRole();
			handleButtonShowModalEditRole();
			handleButtonShowModalCreateRole();
			handleButtonSearchRole();
			handleButtonSearchPermission();
			handleButtonClearTableRole();
			handleButtonClearTablepermission();
		}
	}
}();

$(document).ready(function() {
	Permission.init();
});
</script>
</body>
</html>