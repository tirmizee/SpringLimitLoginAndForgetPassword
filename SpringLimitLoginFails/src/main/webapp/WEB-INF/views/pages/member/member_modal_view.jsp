<div class="modal fade" id="modal_view_member">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-color-sky">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h3 class="modal-title color-white">View Member</h3>
			</div>
			<div class="modal-body">
				<div class="box-body box-profile">
					<img class="profile-user-img img-responsive img-circle" src="${pageContext.request.contextPath}/resources/libs/admin-lte2/img/user.png" alt="User profile picture">
					<h3 class="profile-username text-center">Software Engineer</h3>
				</div>
				<hr>
				<form id="frmViewMember" role="form">
				
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>Username</label>
								<div class="input-group">
					                <span class="input-group-addon input-group-disabled">@</span>
					                <input name="username" type="text" class="form-control" disabled>
             					 </div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>Email</label>
								<div class="input-group" >
					                <span class="input-group-addon input-group-disabled" ><i class="fa fa-envelope"></i></span>
					                <input name="email" type="email" class="form-control" disabled>
              					</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>Role</label>
								<div class="input-group">
					                <span class="input-group-addon input-group-disabled"><i class="glyphicon glyphicon-briefcase"></i></span>
					                <input  name="roleName" type="text" class="form-control" disabled>
             					 </div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>Credentials Expired Date</label>
								<div class="input-group" >
					                <span class="input-group-addon input-group-disabled" ><i class="fa fa-calendar"></i></span>
					                <input name="credentialsExpiredDate" type="text" class="form-control" disabled>
              					</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3">
							<div class="form-group">
								<label>Enabled</label>
								<div class="input-group" >
					                <span class="input-group-addon input-group-disabled" ><i class="glyphicon glyphicon-info-sign"></i></span>
					                <input name="enabled" type="text" class="form-control" disabled>
              					</div>
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label>Account Non Locked</label>
								<div class="input-group" >
					                <span class="input-group-addon input-group-disabled" ><i class="glyphicon glyphicon-info-sign"></i></span>
					                <input name="accountNonLocked" type="text" class="form-control" disabled>
              					</div>
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label>Account Non Expired</label>
								<div class="input-group" >
					                <span class="input-group-addon input-group-disabled" ><i class="glyphicon glyphicon-info-sign"></i></span>
					                <input name="accountNonExpired" type="text" class="form-control" disabled>
              					</div>
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label>Credentials Non Expired</label>
								<div class="input-group" >
					                <span class="input-group-addon input-group-disabled" ><i class="glyphicon glyphicon-info-sign"></i></span>
					                <input name="credentialsNonExpired" type="text" class="form-control" disabled>
              					</div>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
