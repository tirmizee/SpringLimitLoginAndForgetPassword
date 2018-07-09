<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<security:authentication var="profile" property="principal" />
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="${pageContext.request.contextPath}/resources/libs/admin-lte2/img/user.png" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${profile.username}</p>
          <a href="">Role : ${profile.roleName}</a>
        </div>
      </div>
     
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        <li class="treeview menu-index"><a href="${pageContext.request.contextPath}/main"><i class="fa fa-globe " style="height: 20px;"></i> <span>Main</span></a></li>
        <li class="treeview menu-role" >
          <a href="#">
            <i class="fa fa-briefcase" style="height: 20px;"></i>
            <span>Role Management</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right" ></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li class="permission"><a href="${pageContext.request.contextPath}/permission"><i class="fa fa-circle-o"></i>Permission</a></li>
            <li class="role"><a href="${pageContext.request.contextPath}/admin/role"><i class="fa fa-circle-o"></i>Assign Role</a></li>
          </ul>
        </li>
       </ul>
       
         
    </section>
    <!-- /.sidebar -->
  </aside>