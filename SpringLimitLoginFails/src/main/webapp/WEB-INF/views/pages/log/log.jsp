<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
  </style>
  
  <title><spring:message code="app.title"/></title>
</head>
<body class="hold-transition ${profile.skinClass} sidebar-mini">
  <div class="wrapper">

    <jsp:include page="../../template/header.jsp" />
    <jsp:include page="../../template/menu_sidebar.jsp" />

    <div class="content-wrapper">
      
      <section class="content-header">
        <h1>
          TR004
          <small>log page</small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i> Home </a></li>
          <li class="active">log</li>
        </ol>
        
      </section><!-- Content Header (Page header) -->

	  
	<section class="content">
		<div class="box box-default">
			<div class="box-header with-border">
				<h3 class="box-title">Search Log</h3>
				<div class="box-tools pull-right">
					<button type="button" class="btn btn-box-tool" data-widget="collapse">
						<i class="fa fa-minus"></i>
					</button>
				</div>
			</div><!-- /.box-header -->
	
			<div class="box-body">
				<form id="frmAttemp" role="form">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>Username</label>
								<input name="username" type="text" class="form-control" placeholder="Username...">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>Attempts</label>
								<select name="attempts" class="form-control">
									<option value="" selected>All</option>
				                	<option value="0">0</option>
				                    <option value="1">1</option>
				                    <option value="2">2</option>
				                    <option value="3">3</option>
				                 </select>
							</div>
						</div>
					</div>
					
					<div class="row text-center">
						<button id="btnClear" type="button" class="btn btn-default">Clear</button>
						<button id="btnSearch" type="button" class="btn btn-warning">Search</button>
					</div>
				</form>
			</div>
		</div>
	
		<div class="box">
			<div class="box-body">
				<table id="tableAttemp" class="display nowrap" cellspacing="0" width="100%"></table>
			</div>
		</div>
		
	</section><!-- /.content -->
	
    </div><!-- /.content-wrapper -->

   <jsp:include page="../../template/footer.jsp" />

  <div class="control-sidebar-bg"></div>

</div><!-- ./wrapper -->

<script src="${pageContext.request.contextPath}/resources/scripts/Common.js"></script>
<script>
var Log = function(){
	
	var DataTable = {};
	var Search = {};
	
	var handleActiveMenu = function () {
		 $('ul.sidebar-menu > li.menu-setting').addClass('active');
	}
	
	var handleDataTable = function(){
		DataTable = $('#tableAttemp').DataTable({
			processing   : true,
			serverSide   : true,
			responsive   : false,
			select       : true,
			searching    : false,
			scrollX      : true,
			deferRender  : true,
			ajax: {
				url: 'api/attemp/findByCriteria',
				type: "POST",
				contentType: 'application/json',
				headers: {
	                'X-CSRF-TOKEN' : AjaxManager.CsrfToken 
	            },
				data: function (d) {
					d.search = Search;
					return JSON.stringify(d);
				}
			},
			columns: [
				{ data: null                 	 , title : "Order" },
				{ data: "username"             	 , title : "Username"},
				{ data: "attempts"            	 , title : "Attemp" },
				{ data: "lastModified"           , title : "Last Modified Date" },
			],
			columnDefs: [
				{
					targets   : 0,
					width     : "10%",
					orderable : false,
					render    : function (data, type, row, meta) {
						return meta.settings._iDisplayStart + meta.row + 1;
					}
				}
			],
			order: [[1, 'asc']]
		});
	}
	
	var handleButtonClearForm = function(){
		$('#btnClear').on('click', function(event){
			$('#frmAttemp')[0].reset();
		});
	}
	
	var handleButtonSearch = function(){
		$('#btnSearch').on('click', function(event){
			Search.username = $('#frmAttemp input[name="username"]').val();
			Search.attempts = $('#frmAttemp select[name="attempts"]').val();
			DataTable.ajax.reload();
		});
	}
	
	return {
		init : function(){
			handleActiveMenu();
			handleDataTable();
			handleButtonClearForm();
			handleButtonSearch();
		}
	};
	
}();

$(document).ready(function() {
	Log.init();
});
</script>
</body>
</html>