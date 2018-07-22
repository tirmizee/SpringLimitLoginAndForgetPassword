<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="modal_edit_member">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-color-green">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h3 class="modal-title color-white">Edit Member</h3>
			</div>
			<div class="modal-body">
				<form id="frmEditMember" role="form">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>Username</label>
								<div class="input-group">
									<span class="input-group-addon input-group-disabled">@</span>
									<input name="username" type="text" class="form-control" placeholder="Username..." disabled>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>Email</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
									<input name="email" type="text" class="form-control" placeholder="Email...">
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>Role</label>
								<select name="roleId" style="width:100%" class="select2 form-control">
									<c:forEach items="${roles}" var="role">
				                    <option value="${role.roleId}">${role.roleName}</option>
				                    </c:forEach>
				                 </select>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
				                <label>Credentials Expired Date</label>
				                <div class="input-group date">
				                	<div class="input-group-addon">
				                    	<i class="fa fa-calendar"></i>
				                  	</div>
				                  	<input name="credentialsExpiredDate" type="text" class="form-control pull-right" >
				                </div>
				            </div>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button id="btnSaveMember" type="button" class="btn btn-success">Save</button>
			</div>
		</div>
	</div>
</div>
