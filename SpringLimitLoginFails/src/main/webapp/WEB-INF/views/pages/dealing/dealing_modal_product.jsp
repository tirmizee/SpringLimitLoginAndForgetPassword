<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal fade" id="modal_search_product">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-color-primary">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h3 class="modal-title color-white">Search Product</h3>
			</div>
			<div class="modal-body">
				<form id="frmSearchProduct">
					<input name="roleId" type="hidden">
					<div class="row">
						<div class="col-md-2">
							<div class="form-group">
								<label>Product Code</label>
								<input name="productCode" type="text" class="form-control" placeholder="Customer Code">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label>Product Name</label>
								<input name="productName" type="text" class="form-control" placeholder="Customer Name">
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label>Product Type</label>
								<select name="productType" class="form-control">
									<option value="" selected="">All</option>
				                	<option value="1">1</option>
				                    <option value="0">2</option>
				                </select>
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label>Product Price</label>
								<select name="productPrice" class="form-control">
									<option value="" selected="">All</option>
				                	<option value="1">ต่ำกว่า - 1000</option>
				                    <option value="2">1000 - 10000</option>
				                    <option value="3">10000 - 50000</option>
				                    <option value="4">50000 - 100000</option>
				                    <option value="5">100000 - ขึ้นไป</option>
				                </select>
							</div>
						</div>
					</div>
					<div class="row text-center">
						<button id="btnClearProduct" type="button" class="btn btn-default btn-flat">Clear</button>
						<button id="btnSearchProduct" type="button" class="btn btn-primary btn-flat">Search</button>
					</div>
				</form>
				
				<div class="box">
					<div class="box-body">
						<table id="tableProduct" class="display nowrap" cellspacing="0" width="100%"></table>
					</div>
					 <div class="box-footer">
		             <div class="row text-center">
			         	<button id="btnCloseProduct" type="button" class="btn btn-default btn-flat">Cancel</button>
			         	<button id="btnSelectProduct" type="submit" class="btn btn-primary btn-flat">Choose</button>
			         </div>
			        </div>
				</div>
				
			</div>
		</div>
	</div>
</div>
