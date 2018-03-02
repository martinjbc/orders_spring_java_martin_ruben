<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-static-top">
  <!-- Sidebar toggle button-->
  <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
    <span class="sr-only">Toggle navigation</span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
  </a>

  <div class="navbar-custom-menu">
  	<ul class="nav navbar-nav">
  		<li>
  			<a href="<c:url value="/logout" />" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
  		</li>	
  	</ul>
  </div>
</nav>  