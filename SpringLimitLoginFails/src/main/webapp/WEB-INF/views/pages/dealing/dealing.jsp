<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<security:authentication var="profile" property="principal" />
<!DOCTYPE>
<html>
<head>
  <meta name="rootUrl" content="${pageContext.request.contextPath}"/>
  <meta name="_csrf" content="${_csrf.token}"/>
  <meta name="_csrf_header" content="${_csrf.headerName}"/>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/datatables/css/select.dataTables.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/bootstrap-toggle/css/bootstrap-toggle.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/sweetalert2/css/sweetalert2.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/waitme/css/waitMe.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/libs/viewer/css/viewer.css">
 
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
  <script src="${pageContext.request.contextPath}/resources/libs/datatables/js/dataTables.select.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/bootstrap-toggle/js/bootstrap-toggle.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/sweetalert2/js/sweetalert2.all.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/waitme/js/waitMe.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/viewer/js/viewer.js"></script>
  
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
  	 
  	 .input-group-disabled{
     	background-color: #eeeeee !important;
     }
     
     .color-white{
     	color:#ffffff !important;
     }
     
     .bg-color-info{
     	background-color: #00c0ef;
     }
     
     .bg-color-primary{
     	background-color: 337ab7;
     }
     
     .profile-user-img {
     	width: 150px !important;
     }
     
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
          <small>dealing page</small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i> Home </a></li>
          <li class="active">dealing</li>
        </ol>
        
      </section><!-- Content Header (Page header) -->

	  
	<section class="content">
	
		<div class="box box-default">
			<div class="box-header with-border">
				<h3 class="box-title">Information</h3>
				<div class="box-tools pull-right">
					<a type="button" class="btn btn-box-tool" data-widget="collapse">
						<i class="fa fa-minus"></i>
					</a>
				</div>
			</div><!-- /.box-header -->
	
			<div class="box-body">
				<form id="frmInfo">
					<div class="row">
						<div class="col-md-3">
							<div class="form-group">
								<label>Customer Code</label>
								<div class="input-group">
									<span class="input-group-addon input-group-disabled"><i class="fa fa-user"></i></span>
									<input name="customerCode" type="text" class="form-control" placeholder="" readonly>
									<span class="input-group-btn">
				                    	<button id="btnTrigerModal" type="button" class="btn btn-info btn-flat"><b>Search</b></button>
				                    </span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>Customer Name</label>
								<div class="input-group">
									<span class="input-group-addon input-group-disabled"><i class="fa fa-user"></i></span>
									<input name="customerName" type="text" class="form-control" placeholder="" readonly>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>Customer Surname</label>
								<div class="input-group">
									<span class="input-group-addon input-group-disabled"><i class="fa fa-user"></i></span>
									<input name="customerSurname" type="text" class="form-control" placeholder="" readonly>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>Customer Mobile</label>
								<div class="input-group">
									<span class="input-group-addon input-group-disabled"><i class="fa fa-phone"></i></span>
									<input name="customerMobile" type="text" class="form-control" placeholder="" readonly>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>Customer Email</label>
								<div class="input-group">
									<span class="input-group-addon input-group-disabled"><i class="fa fa-envelope"></i></span>
									<input name="customerEmail" type="text" class="form-control" placeholder="" readonly>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-3">
							<div class="form-group">
								<label>Product Code</label>
								<div class="input-group">
									<span class="input-group-addon input-group-disabled"><i class="fa fa-user"></i></span>
									<input name="productCode" type="text" class="form-control" placeholder="" readonly>
									<span class="input-group-btn">
				                    	<button id="btnTrigerModalProduct" type="button" class="btn btn-primary btn-flat"><b>Search</b></button>
				                    </span>
								</div>
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label>Product Name</label>
								<div class="input-group">
									<span class="input-group-addon input-group-disabled"><i class="fa fa-user"></i></span>
									<input name="productName" type="text" class="form-control" placeholder="" readonly>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>Product Price</label>
								<div class="input-group">
									<span class="input-group-addon input-group-disabled"><i class="fa fa-user"></i></span>
									<input name="productPrice" type="text" class="form-control" placeholder="" readonly>
								</div>
							</div>
						</div>
					</div>
					
				</form>
			</div>
		</div>
	
		<div class="box box-default">
			<div class="box-header with-border">
				<h3 class="box-title">Address Information</h3>
				<div class="box-tools pull-right">
					<button type="button" class="btn btn-box-tool" data-widget="collapse">
						<i class="fa fa-minus"></i>
					</button>
				</div>
			</div><!-- /.box-header -->
	
			<div class="box-body">
				<form id="frmAddress" role="form">
					<div class="row">
						<div class="col-md-3">
							<div class="form-group">
								<label>Province</label>
								<select name="province" class="form-control">
				                 </select>
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label>District</label>
								<select name="district" class="form-control" disabled>
				                 </select>
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label>Sub District</label>
								<select name="subDistrict" class="form-control" disabled>
				                 </select>
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label>Post Code</label>
								<input name="postCode" type="text" class="form-control" placeholder="" readonly>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="box-footer">
	        	<div class="row text-center">
					<button id="btnClearAll" type="button" class="btn btn-default  btn-flat">Clear</button>
					<button id="btnSave" type="submit" class="btn btn-success  btn-flat">Search</button>
				</div>
	        </div>
		</div>
		
		
	</section><!-- /.content -->
	
    </div><!-- /.content-wrapper -->

   <jsp:include page="../../template/footer.jsp" />

  <div class="control-sidebar-bg"></div>

</div><!-- ./wrapper -->

<jsp:include page="dealing_modal_customer.jsp" />
<jsp:include page="dealing_modal_product.jsp" />

<script src="${pageContext.request.contextPath}/resources/scripts/Common.js"></script>
<script>
var Dealing = function(){
	
	var DataTableProduct = {};
	var DataTableCustomer = {};
	
	var SearchCustomer = {};
	var SearchProduct = {};
	
	var selectedProvinceId = null;
	var selectedDistrictId = null;
	
	var handleActiveMenu = function () {
 		 $('ul.sidebar-menu > li.menu-dealing').addClass('active');
	}
	
	var handleSelectProvince = function(){
		$('select[name="province"]').select2({
			placeholder: 'Search Province',
			ajax: {
			    url : 'api/province/findAll',
			    delay : 250,
			    type : 'POST',
			    contentType : 'application/json',
			    headers : {
	                'X-CSRF-TOKEN' : AjaxManager.CsrfToken 
	            },
	            data : function (params) {
	            	params.page = params.page || 0;
	            	params.size = 20;
	                return JSON.stringify(params);
	            },
			    processResults : function (data , params) {
			    	return {
		                results : $.map(data.content, function (item) {
		                    return {
		                    	id     : item.provinceId,
		                    	code   : item.provinceCode,
		                    	text   : item.provinceNameTH,
		                        textEn : item.provinceNameEN
		                    }
		                }),
	                    pagination: {
	                        more : !data.last
	                    }
		            };
			    }
			  },
			  cache : true,
			  templateResult : function (data) {
				  
				  var $template = $('<div></div>');
				  var $body_line1 = $('<span>' + data.text + '</span>');  
				  var $body_line2 = $('<small><b>' + data.textEn + '</b></small>');  
				  var $body_line3 = $('<small><b>code : </b>' + data.code + '</small>');  
				  
				  $template.append($body_line1);
				  $template.append('<br>');
				  $template.append($body_line2);
				  $template.append('<br>');
				  $template.append($body_line3);
				  
                  return $template;
			  } 
		}).on('select2:select', function (e) {
		    selectedProvinceId = e.params.data.id;
		    $('select[name="district"]').prop("disabled", false);
		    $('select[name="district"]').val([]).trigger('change');
		    $('select[name="subDistrict"]').prop("disabled", true);
		    $('select[name="subDistrict"]').val([]).trigger('change');
		    $('input[name="postCode"]').val('');
		});
	}
	
	var handleSelectDistrict = function(){
		$('select[name="district"]').select2({
			placeholder: 'Search District',
			ajax: {
			    url : 'api/district/findByTerm',
			    delay : 250,
			    type : 'POST',
			    contentType : 'application/json',
			    headers : {
	                'X-CSRF-TOKEN' : AjaxManager.CsrfToken  
	            },
	            data : function (params) {
	            	params.page = params.page || 0;
	            	params.size = 20;
	            	params.provinceId = selectedProvinceId;
	                return JSON.stringify(params);
	            },
			    processResults : function (data , params) {
			    	return {
		                results : $.map(data.content, function (item) {
		                    return {
		                    	id     : item.districtId,
		                    	code   : item.districtCode,
		                    	text   : item.districtNameTH,
		                        textEn : item.districtNameEN
		                    }
		                }),
	                    pagination: {
	                        more : !data.last
	                    }
		            };
			    }
			  },
			  cache : true,
			  templateResult : function (data) {
				  
				  var $template = $('<div></div>');
				  var $body_line1 = $('<span>' + data.text + '</span>');  
				  var $body_line2 = $('<small><b>' + data.textEn + '</b></small>');  
				  var $body_line3 = $('<small><b>code : </b>' + data.code + '</small>');  
				  
				  $template.append($body_line1);
				  $template.append('<br>');
				  $template.append($body_line2);
				  $template.append('<br>');
				  $template.append($body_line3);
				  
                  return $template;
			  } 
		}).on('select2:select', function (e) {
		    selectedDistrictId = e.params.data.id;
			$('select[name="subDistrict"]').prop("disabled", false);
			$('select[name="subDistrict"]').val([]).trigger('change');
			$('input[name="postCode"]').val('');
		});
	} 
	
	var handleSelectSubDistrict = function(){
		$('select[name="subDistrict"]').select2({
			placeholder: 'Search Sub District',
			ajax: {
			    url : 'api/subdistrict/findByTerm',
			    delay : 250,
			    type : 'POST',
			    contentType : 'application/json',
			    headers : {
	                'X-CSRF-TOKEN' : AjaxManager.CsrfToken  
	            },
	            data : function (params) {
	            	params.page = params.page || 0;
	            	params.size = 20;
	            	params.districtId = selectedDistrictId;
	                return JSON.stringify(params);
	            },
			    processResults : function (data , params) {
			    	return {
		                results : $.map(data.content, function (item) {
		                    return {
		                    	id   : item.subDistrictId,
		                    	code : item.subDistrictCode,
		                    	text : item.subDistrictName,
		                    }
		                }),
	                    pagination: {
	                        more : !data.last
	                    }
		            };
			    }
			  },
			  cache : true,
			  templateResult : function (data) {
				  
				  var $template = $('<div></div>');
				  var $body_line1 = $('<span>' + data.text + '</span>');  
				  var $body_line2 = $('<small><b>code : </b>' + data.code + '</small>');  
				  
				  $template.append($body_line1);
				  $template.append('<br>');
				  $template.append($body_line2);
				  
                  return $template;
			  } 
		}).on('select2:select', function (e) {
		    AjaxManager.GetData({} ,"api/postcode/" + e.params.data.code,
				function(response){
					if (response) {
						 $('input[name="postCode"]').val(response.zipCode);
					}
				},
				function(jqXHR, textStatus, errorThrown){}
			);
		});
	}
	
	var handleDataTableCustomer = function(){
		DataTableCustomer = $('#tableCustomer').DataTable({
			processing   : true,
			serverSide   : true,
			responsive   : false,
			select       : true,
			searching    : false,
			scrollX      : true,
			deferRender  : true,
			ajax: {
				url: 'api/customer/findByCriteria',
				type: "POST",
				contentType: 'application/json',
				headers: {
	                'X-CSRF-TOKEN' : AjaxManager.CsrfToken 
	            },
				data: function (d) {
					d.search = SearchCustomer;
					return JSON.stringify(d);
				}
			},
			columns: [
				{ data: null                  , title : "Order"},
				{ data: "customerCode"        , title : "Customer Code"},
				{ data: "customerName"        , title : "Customer Name"},
				{ data: "customerSurname"     , title : "Customer Surname" },
				{ data: "customerEmail"       , title : "Customer Email" },
				{ data: "customerMobile"      , title : "Customer Mobile" }
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
			colReorder   : {
	            fixedColumnsLeft: 1
	        },
			select: {
		   		style: 'single'
		    },
			order: [[1, 'asc']]
		}).on('dblclick', 'tbody tr', function () {
	    	var data = DataTableCustomer.row(this).data();
	    	$('input[name="customerCode"]').val(data.customerCode);
	    	$('input[name="customerName"]').val(data.customerName);
	    	$('input[name="customerSurname"]').val(data.customerSurname);
	    	$('input[name="customerMobile"]').val(data.customerMobile);
	    	$('input[name="customerEmail"]').val(data.customerEmail);
	    	$('#modal_search').modal('hide');
	    });
	}
	
	var handleDataTableProduct = function(){
		DataTableProduct = $('#tableProduct').DataTable({
			processing   : true,
			serverSide   : true,
			responsive   : false,
			select       : true,
			searching    : false,
			scrollX      : true,
			autoWidth    : false,
			ajax: {
				url: 'api/product/findByCriteria',
				type: "POST",
				contentType: 'application/json',
				headers: {
	                'X-CSRF-TOKEN' : AjaxManager.CsrfToken 
	            },
				data: function (d) {
					d.search = SearchProduct;
					return JSON.stringify(d);
				}
			},
			columns: [
				{ data: null                 , title : "Oder"},
				{ data: null                 , title : "Product"},
				{ data: "productCode"        , title : "Product Code"},
				{ data: "productName"        , title : "Product Name"},
				{ data: "productDesc"        , title : "Product Desciption"},
				{ data: "productImage"       , title : ""},
				{ data: "productPrice"       , title : ""}
			],
			columnDefs: [
				{
					targets   : 0,
					width     : "10%",
					className : "text-center",
					orderable : false,
					visible   : false,
					render    : function (data, type, row, meta) {
						return meta.settings._iDisplayStart + meta.row + 1;
					}
				},
				{
					targets   : 1,
					orderable : false,
					className : "text-center",
					width     : "20%",
					render    : function (data, type, row, meta) {
						return '<img id="imgProduct_' + data.productCode + '" class="profile-user-img img-responsive"  src="' + AjaxManager.RootUrl + '/file/resource/img/product/' + row.productImage + '">';
					}
				},
				{
					targets   : 2,
					className : "text-center",
					width     : "15%"
				},
				{
					targets   : 3,
					width     : "20%"
				},
				{
					targets   : 4,
					width     : "45%",
					render    : function (data, type, row, meta) {
						var template = '',
						    body_1 = '<span>code  : <b style="color:red">' + row.productCode + '</b></span>',
						    body_2 = '<span>name  : <b>' + row.productName + '</b></span>',
						    body_3 = '<span>price : <b style="color:green">' + row.productPrice + '</b></span>';
						template += body_1 + '<br>';
						template += body_2 + '<br>';
						template += body_3;
						return template;
					}
				},
				{
					targets   : 5,
					visible   : false
				},
				{
					targets   : 6,
					visible   : false
				}
			],
			select: {
		   		style: 'single'
		    },
			order: [[0, 'asc']]
		}).on('dblclick', 'tbody tr', function (event) {
	    	var data = DataTableProduct.row(this).data();
	    	$('input[name="productCode"]').val(data.productCode);
	    	$('input[name="productName"]').val(data.productName);
	    	$('input[name="productPrice"]').val(data.productPrice);
	    	$('#modal_search_product').modal('hide');
	    });
	}
	
	var handleButtonShowModalCustomer = function(){
		$('#btnTrigerModal').on('click', function(event){
			$('#modal_search').modal();
		});
	}
	
	var handleButtonShowModalProduct = function(){
		$('#btnTrigerModalProduct').on('click', function(event){
			$('#modal_search_product').modal();
		});
	}
	
	var handleButtonCloseModalCustomer = function(){
		$('#btnClose').on('click', function(event){
			$('#modal_search').modal('hide');
		});
	}
	
	var handleModalSearchCustomer = function(){
		$('#modal_search')
			.bind('shown.bs.modal', function (event) {
				$('#btnSearchCustomer').trigger('click');
			})
			.bind('hide.bs.modal', function (event) {
				$('#frmSearchCustomer')[0].reset();
			});
	}
	
	var handleModalSearchProduct = function(){
		$('#modal_search_product')
			.bind('shown.bs.modal', function (event) {
				$('#btnSearchProduct').trigger('click');
			})
			.bind('hide.bs.modal', function (event) {
				$('#frmSearchProduct')[0].reset();
			});
	}
	
	var handleButtonClearFormCustomer = function(){
		$('#btnClearFrm').on('click',function(event){
			$('#frmSearchCustomer')[0].reset();
		});
	}
	
	var handleButtonClearFormProduct = function(){
		$('#btnClearProduct').on('click',function(event){
			$('#frmSearchProduct')[0].reset();
		});
	}
	
	var handleButtonClearAll = function(){
		$('#btnClearAll').on('click',function(event){
			$('#frmInfo')[0].reset();
			$('#frmAddress')[0].reset();
			$('#frmAddress select[name="province"]').val([]).trigger('change');
			$('#frmAddress select[name="district"]').val([]).trigger('change');
			$('#frmAddress select[name="subDistrict"]').val([]).trigger('change');
			$('#frmAddress select[name="district"]').prop("disabled", true);
			$('#frmAddress select[name="subDistrict"]').prop("disabled", true);
		});
	}
	
	var handleButtonSearchCustomer = function(){
		$('#btnSearchCustomer').on('click',function(event){
			event.preventDefault();
			SearchCustomer.customerCode    = $('#frmSearchCustomer input[name="customerCode"]').val();
			SearchCustomer.customerName    = $('#frmSearchCustomer input[name="customerName"]').val();
			SearchCustomer.customerSurname = $('#frmSearchCustomer input[name="customerSurname"]').val();
			SearchCustomer.customerEmail   = $('#frmSearchCustomer input[name="customerEmail"]').val();
			SearchCustomer.customerMobile  = $('#frmSearchCustomer input[name="customerMobile"]').val();
			DataTableCustomer.ajax.reload();
		});
	}
	
	var handleButtonSearchProduct = function(){
		$('#btnSearchProduct').on('click',function(event){
			event.preventDefault();
			SearchProduct.productCode   = $('#frmSearchProduct input[name="productCode"]').val();
			SearchProduct.productName   = $('#frmSearchProduct input[name="productName"]').val();
			SearchProduct.productPrice  = $('#frmSearchProduct select[name="productPrice"]').val();
			console.log(JSON.stringify(SearchProduct));
			DataTableProduct.ajax.reload();
		});
	}
	
	var handleButtonSelectCustomer = function(){
		$('#btnSelect').on('click',function(event){
			var indx = DataTableCustomer.cell('.selected', 0).index();
			if(indx !== undefined){
				var data = DataTableCustomer.row( indx.row ).data();
				$('input[name="customerCode"]').val(data.customerCode);
		    	$('input[name="customerName"]').val(data.customerName);
		    	$('input[name="customerSurname"]').val(data.customerSurname);
		    	$('input[name="customerMobile"]').val(data.customerMobile);
		    	$('input[name="customerEmail"]').val(data.customerEmail);
		    	$('#modal_search').modal('hide');
			}else{
				Swal.Warning('แจ้งเตือน','กรุณากดเลือกข้อมูลก่อน');
			}
		});
	}
	
	var handleButtonSelectProduct = function(){
		$('#btnSelectProduct').on('click',function(event){
			var indx = DataTableProduct.cell('.selected', 0).index();
			if(indx !== undefined){
				var data = DataTableProduct.row( indx.row ).data();
				$('input[name="productCode"]').val(data.productCode);
		    	$('input[name="productName"]').val(data.productName);
		    	$('input[name="productPrice"]').val(data.productPrice);
		    	$('#modal_search_product').modal('hide');
		    	
			}else{
				Swal.Warning('แจ้งเตือน','กรุณากดเลือกข้อมูลก่อน');
			}
		});
	}
	
	return {
		init : function(){
			handleActiveMenu();
			handleSelectProvince();
			handleSelectDistrict();
			handleSelectSubDistrict();
			handleDataTableCustomer();
			handleDataTableProduct();
			handleButtonShowModalCustomer();
			handleButtonShowModalProduct();
			handleButtonCloseModalCustomer();
			handleButtonSearchCustomer();
			handleButtonSearchProduct();
			handleButtonClearFormCustomer();
			handleButtonClearFormProduct();
			handleButtonClearAll();
			handleButtonSelectCustomer();
			handleButtonSelectProduct();
			handleModalSearchCustomer();
			handleModalSearchProduct();
		}
	};
	
}();

$(document).ready(function() {
	Dealing.init();
});
</script>
</body>
</html>