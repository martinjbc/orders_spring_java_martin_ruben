<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="sidebar-menu tree" data-widget="tree">
  <li><a href="<c:url value='/pedidos/list'/>"><i class="fa fa-book"></i> <span>Pedidos</span></a></li>
  <li><a href="<c:url value='/productos/list'/>"><i class="fa fa-book"></i> <span>Productos</span></a></li>
  <li><a href="<c:url value='/proveedores/list'/>"><i class="fa fa-book"></i> <span>Proveedores</span></a></li>
  <li><a href="<c:url value='/categorias/list'/>"><i class="fa fa-book"></i> <span>Categorias</span></a></li>
  <li><a href="<c:url value='/clientes/list'/>"><i class="fa fa-book"></i> <span>Clientes</span></a></li>
  <li><a href="<c:url value='/empleados/list'/>"><i class="fa fa-book"></i> <span>Empleados/usuarios</span></a></li>
</ul>