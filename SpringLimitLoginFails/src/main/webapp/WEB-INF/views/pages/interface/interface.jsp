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
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
  <script src="${pageContext.request.contextPath}/resources/libs/sweetalert2/js/promise.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/waitme/js/waitMe.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/viewer/js/viewer.js"></script>
  <script src="${pageContext.request.contextPath}/resources/libs/chart/js/Chart.bundle.js"></script>
  
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
          TR006
          <small>user interface page</small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i> Home </a></li>
          <li class="active">user interface</li>
        </ol>
        
      </section><!-- Content Header (Page header) -->

	  
	<section class="content">
	
		<div class="row">
			<div class="col-md-6">
				<div class="box box-primary">
					<div class="box-header with-border">
						<i class="glyphicon glyphicon-list-alt"></i>
				
						<h3 class="box-title">Template</h3>
				
						<div class="box-tools pull-right">
							<button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
						</div>
					</div>
					<form class="form-horizontal">
						<div class="box-body">
							<div class="form-group">
								<div class="col-md-12 col-centered" align="center">
									<img id="skinImage" class="img-responsive " src="${pageContext.request.contextPath}/file/resource/img/skin/${profile.skinImage}">
									<label id="skinLabel">${profile.skinClass}</label>
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-2 control-label">Skin</label>
								<div class="col-sm-10">
									<select name="skin" class="form-control"></select>
								</div>
							</div>
						</div>
						<div class="box-footer">
							<div class="row-fluid pull-right">
								<button id="saveSkin" type="button" class="btn btn-primary">Change</button>
							</div>
							
						</div>
					</form>
				</div>
				<div class="nav-tabs-custom">
					<ul class="nav nav-tabs pull-right">
						<li class="active"><a href="#tab_1-1" data-toggle="tab" aria-expanded="false">Tab 1</a></li>
						<li class=""><a href="#tab_2-2" data-toggle="tab" aria-expanded="false">Tab 2</a></li>
						<li class=""><a href="#tab_3-2" data-toggle="tab" aria-expanded="true">Tab 3</a></li>
						<li class="pull-left header"><i class="fa fa-th"></i> Custom Tabs</li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="tab_1-1">
							<canvas id="pieChart"></canvas>
						</div>
						<div class="tab-pane" id="tab_2-2">
							<canvas id="doughnutChart"></canvas>
						</div>
						<div class="tab-pane " id="tab_3-2">
							Lorem Ipsum is simply dummy text of the printing and typesetting industry.
							Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
							when an unknown printer took a galley of type and scrambled it to make a type specimen book.
							It has survived not only five centuries, but also the leap into electronic typesetting,
							remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset
							sheets containing Lorem Ipsum passages, and more recently with desktop publishing software
							like Aldus PageMaker including versions of Lorem Ipsum.
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="box box-primary">
					<div class="box-header with-border">
						<i class="fa fa-bar-chart-o"></i>
				
						<h3 class="box-title">Full Width Area Chart</h3>
				
						<div class="box-tools pull-right">
							<button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
						</div>
					</div>
					<div class="box-body">
						<canvas id="chart"></canvas>
					</div>
				</div>
				<div class="box box-primary">
					<div class="box-header with-border">
						<i class="fa fa-bar-chart-o"></i>
				
						<h3 class="box-title">Chart Group</h3>
				
						<div class="box-tools pull-right">
							<button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
						</div>
					</div>
					<div class="box-body">
						<canvas id="chartMulti"></canvas>
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
var Interface = function(){
	
	// init variable
	var selectedSkin = $('#skinLabel').text();
	
	var _alertOption = function(){
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
	
	var handleActiveMenu = function () {
		 $('ul.sidebar-menu > li.menu-setting').addClass('active');
	}
	
	var handleSelectSkin = function(){
		$('select[name="skin"]').select2({
			placeholder: 'Change Skin',
			ajax: {
			    url : 'api/skin/findByTerm',
			    delay : 250,
			    type : 'POST',
			    contentType : 'application/json',
			    headers : {
	                'X-CSRF-TOKEN' : AjaxManager.CsrfToken  
	            },
	            data : function (params) {
	            	params.page = params.page || 0;
	            	params.size = 5;
	                return JSON.stringify(params);
	            },
			    processResults : function (data , params) {
			    	return {
		                results : $.map(data.content, function (item) {
		                    return {
		                    	id   : item.skinId,
		                    	text : item.skinClass,
		                    	image : item.skinImage
		                    }
		                }),
	                    pagination: {
	                        more : !data.last
	                    }
		            };
			    }
			  },
			  cache : true
		}).on('select2:select', function (e) {
			var data = e.params.data;
			var urlImage = AjaxManager.RootUrl + '/file/resource/img/skin/' + data.image;
			$('#skinImage').attr('src',urlImage);  
			$('body').removeClass(selectedSkin).addClass(data.text);
			$('#skinLabel').text(data.text);
			selectedSkin = data.text;
		});
		
		$('select[name="skin"]').find('*').filter(function() {
	    	console.log($(this).text());
	  	});
	}
	
	var _callApiUpdateSkin = function(){
		var param =  $('select[name="skin"]').val();
		AjaxManager.GetData({} ,"api/skin/holder/update/" + param,
			function(response){
				if (response) {
					Swal.Success('แจ้งเตือน','บันทึกข้อมูลสำเร็จ');
				}
			},
			function(jqXHR, textStatus, errorThrown){
				var error = JSON.parse(jqXHR.responseText);
  			    Swal.Error('Warning message', error.errorDescription );
			}
		); 
	}
	
	var handleButtonSaveSkin = function(){
		$('#saveSkin').on('click',function(){
			var option = _alertOption();
			option.text = 'change skin';
			swal(option).then( function(result) {
				if (result.value) {
					_callApiUpdateSkin();
			  	} 
			});
		});
	}
	
	var handleChart = function(){
	  	
		var ctx  = $('#chart').get(0).getContext('2d');
		var myChart = new Chart(ctx, {
		    type: 'bar',
		    data: {
		        labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
		        datasets: [
		        	{
			            label: 'votes',
			            data: [
			            	_randomScalingFactor(20),
			            	_randomScalingFactor(20),
			            	_randomScalingFactor(20),
			            	_randomScalingFactor(20),
			            	_randomScalingFactor(20),
			            	_randomScalingFactor(20)
			            ],
			            backgroundColor: [
			                'rgba(255, 99, 132, 0.6)',
			                'rgba(54, 162, 235, 0.6)',
			                'rgba(255, 206, 86, 0.6)',
			                'rgba(75, 192, 192, 0.6)',
			                'rgba(153, 102, 255, 0.6)',
			                'rgba(255, 159, 64, 0.6)'
			            ]
			        }
		        ]
		    },
		    options: {
		        scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
		    }
		});
	    
	}
	
	var handleChartMulti = function(){
		var ctx  = $('#chartMulti').get(0).getContext('2d');
		var myChart = new Chart(ctx, {
		    type: 'bar',
		    data: {
		        labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
		        datasets: [
		        	{
			            label: 'Blue',
			            data: [
			            	_randomScalingFactor(20),
			            	_randomScalingFactor(20),
			            	_randomScalingFactor(20),
			            	_randomScalingFactor(20),
			            	_randomScalingFactor(20),
			            	_randomScalingFactor(20)
			            ],
			            backgroundColor: [
			            	'rgba(54, 162, 235, 0.6)',
			                'rgba(54, 162, 235, 0.6)',
			                'rgba(54, 162, 235, 0.6)',
			                'rgba(54, 162, 235, 0.6)',
			                'rgba(54, 162, 235, 0.6)',
			                'rgba(54, 162, 235, 0.6)'
			            ]
			        },
			        {
			            label: 'Orange',
			            data: [
			            	_randomScalingFactor(20),
			            	_randomScalingFactor(20),
			            	_randomScalingFactor(20),
			            	_randomScalingFactor(20),
			            	_randomScalingFactor(20),
			            	_randomScalingFactor(20)
			            ],
			            backgroundColor: [
			            	'rgba(255, 159, 64, 0.6)',
			            	'rgba(255, 159, 64, 0.6)',
			            	'rgba(255, 159, 64, 0.6)',
			            	'rgba(255, 159, 64, 0.6)',
			            	'rgba(255, 159, 64, 0.6)',
			                'rgba(255, 159, 64, 0.6)'
			            ]
			        }
		        ]
		    },
		    options: {
		        scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
		    }
		});
	}
	
	var _randomScalingFactor = function(length) {
		return Math.round(Math.random() * length);
	};
	
	var handleChartPie = function(){
		
		window.chartColors = {
			red: 'rgb(255, 99, 132)',
			orange: 'rgb(255, 159, 64)',
			yellow: 'rgb(255, 205, 86)',
			green: 'rgb(75, 192, 192)',
			blue: 'rgb(54, 162, 235)',
			purple: 'rgb(153, 102, 255)',
			grey: 'rgb(201, 203, 207)'
		};
		
		var config = {
			type: 'pie',
			data: {
				datasets: [{
					data: [
						_randomScalingFactor(100),
						_randomScalingFactor(100),
						_randomScalingFactor(100),
						_randomScalingFactor(100),
						_randomScalingFactor(100),
					],
					backgroundColor: [
						window.chartColors.red,
						window.chartColors.orange,
						window.chartColors.yellow,
						window.chartColors.green,
						window.chartColors.blue,
					],
					label: 'Dataset 1'
				}],
				labels: [
					'Red',
					'Orange',
					'Yellow',
					'Green',
					'Blue'
				]
			},
			options: {
				responsive: true
			}
		};
		
		var ctx = document.getElementById('pieChart').getContext('2d');
		var pieChart = new Chart(ctx, config);
	}
	
	var handleChartDoughnut = function(){
		
		window.chartColors = {
			red: 'rgb(255, 99, 132)',
			orange: 'rgb(255, 159, 64)',
			yellow: 'rgb(255, 205, 86)',
			green: 'rgb(75, 192, 192)',
			blue: 'rgb(54, 162, 235)',
			purple: 'rgb(153, 102, 255)',
			grey: 'rgb(201, 203, 207)'
		};
		
		var config = {
			type: 'doughnut',
			data: {
				datasets: [{
					data: [
						_randomScalingFactor(100),
						_randomScalingFactor(100),
						_randomScalingFactor(100),
						_randomScalingFactor(100),
						_randomScalingFactor(100),
					],
					backgroundColor: [
						window.chartColors.red,
						window.chartColors.orange,
						window.chartColors.yellow,
						window.chartColors.green,
						window.chartColors.blue,
					],
					label: 'Dataset 1'
				}],
				labels: [
					'Red',
					'Orange',
					'Yellow',
					'Green',
					'Blue'
				]
			},
			options: {
				responsive: true,
				legend: {
					position: 'top',
				},
				title: {
					display: true,
					text: 'Chart.js Doughnut Chart'
				},
				animation: {
					animateScale: true,
					animateRotate: true
				}
			}
		};	
		
		var ctx = document.getElementById('doughnutChart').getContext('2d');
		var doughnutChart = new Chart(ctx, config);
	}
	
	return {
		init : function(){
			handleActiveMenu();
			handleSelectSkin();
			handleButtonSaveSkin();
			handleChart();
			handleChartPie();
			handleChartMulti();
			handleChartDoughnut();
		}
	};
	
}();

$(document).ready(function() {
	'use strict';
	Interface.init();
});
</script>
</body>
</html>