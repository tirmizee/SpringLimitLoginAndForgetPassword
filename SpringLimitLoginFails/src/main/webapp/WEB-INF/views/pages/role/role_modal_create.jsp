<div class="modal fade" id="modal_create_role">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-color-orange">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h3 class="modal-title">Create Row</h3>
			</div>
			<div class="modal-body">
				<form id="frmCreateRole" role="form">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label>Role Name</label>
								<input name="roleName" type="text" class="form-control" placeholder="Role Name...">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label>Role Description</label>
								<textarea  name="roleDesc" rows="4" class="form-control" placeholder="Role Description..."></textarea>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
				<button id="btnCreateRole" type="button" class="btn btn-warning">Save</button>
			</div>
		</div>
	</div>
</div>
