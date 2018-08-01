<div class="modal fade" id="modal_search">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-color-info">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h3 class="modal-title color-white">Search Customer</h3>
			</div>
			<div class="modal-body">
				<form id="frmSearchCustomer">
					<input name="roleId" type="hidden">
					<div class="row">
						<div class="col-md-2">
							<div class="form-group">
								<label>Customer Code</label>
								<input name="customerCode" type="text" class="form-control" placeholder="Customer Code">
							</div>
						</div>
						<div class="col-md-5">
							<div class="form-group">
								<label>Customer Name</label>
								<input name="customerName" type="text" class="form-control" placeholder="Customer Name">
							</div>
						</div>
						<div class="col-md-5">
							<div class="form-group">
								<label>Customer Surname</label>
								<input name="customerSurname" type="text" class="form-control" placeholder="Customer Surname">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">
						</div>
						<div class="col-md-5">
							<div class="form-group">
								<label>Customer Email</label>
								<input name="customerEmail" type="text" class="form-control" placeholder="Customer Email">
							</div>
						</div>
						<div class="col-md-5">
							<div class="form-group">
								<label>Customer Mobile</label>
								<input name="customerMobile" type="text" class="form-control" placeholder="Customer Mobile">
							</div>
						</div>
					</div>
					<div class="row text-center">
						<button id="btnClearFrm" type="button" class="btn btn-default btn-flat">Clear</button>
						<button id="btnSearchCustomer" type="button" class="btn btn-info btn-flat">Search</button>
					</div>
				</form>
				
				<div class="box">
					<div class="box-body">
						<table id="tableCustomer" class="display nowrap" cellspacing="0" width="100%"></table>
					</div>
					 <div class="box-footer">
		             <div class="row text-center">
			         	<button id="btnClose" type="button" class="btn btn-default btn-flat">Cancel</button>
			         	<button id="btnSelect" type="submit" class="btn btn-info btn-flat">Choose</button>
			         </div>
			        </div>
				</div>
				
			</div>
		</div>
	</div>
</div>
