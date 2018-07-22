<div class="modal fade" id="modal_edit_role">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-color-green">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h3 class="modal-title color-white">Edit Row</h3>
			</div>
			<div class="modal-body">
				<form id="frmEditRole" role="form">
					<input name="roleId" type="hidden">
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
				<button id="btnEditRole" type="button" class="btn btn-success">Save</button>
			</div>
		</div>
	</div>
</div>
