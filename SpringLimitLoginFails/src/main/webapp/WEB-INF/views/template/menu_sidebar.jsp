<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<security:authentication var="profile" property="principal" />
  <aside class="main-sidebar">
    <section class="sidebar">
      <div class="user-panel">
        <div class="pull-left image">
          <img src="${pageContext.request.contextPath}/resources/libs/admin-lte2/img/user.png" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${profile.username}</p>
          <a href="">Role : ${profile.roleName}</a>
        </div>
      </div>
     
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        <security:authorize access="hasAnyAuthority('TR001')">
        <li class="treeview menu-index"><a href="${pageContext.request.contextPath}/main"><i class="fa fa-globe " style="height: 20px;"></i> <span>Main</span></a></li>
        </security:authorize>
        <security:authorize access="hasAnyAuthority('TR002','TR003')">
        <li class="treeview menu-role" >
          <a href="#">
            <i class="fa fa-briefcase" style="height: 20px;"></i>
            <span>Role Management</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right" ></i>
            </span>
          </a>
          <ul class="treeview-menu">
          	<security:authorize access="hasAnyAuthority('TR003')">
         	<li class="role"><a href="${pageContext.request.contextPath}/role"><i class="fa fa-circle-o"></i>Roles</a></li>
            </security:authorize>
            <security:authorize access="hasAnyAuthority('TR002')">
            <li class="permission"><a href="${pageContext.request.contextPath}/permission"><i class="fa fa-circle-o"></i>Assign Permission</a></li>
         	</security:authorize>
          </ul>
        </li>
        </security:authorize>
        <security:authorize access="hasAnyAuthority('TR004')">
        <li class="treeview menu-setting"><a href="${pageContext.request.contextPath}/setting"><i class="glyphicon glyphicon-cog" style="height: 20px;"></i> <span>Setting</span></a></li>
       	</security:authorize>
       </ul>
         
    </section>
  </aside>