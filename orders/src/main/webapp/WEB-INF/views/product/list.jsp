<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
	<%@ include file="../partials/resource.jsp" %>   
	<script>
		function fn_product_delete(id){
			if(confirm("Desea Eliminar el producto "+id)==true){
		        $.ajax({
		            url: './delete/'+id,
		            type: 'get',
		            data: null,
		            success: function (data) {
		            	
		                alert(data.mensaje);
		                if(data.OK==1)
		                {
		                	location.reload();	
		                }
		                
		            },
		            error: function (err) {
		                alert("Error: " + err.responseText);
		            }
		        });
			}

		}
	</script> 
</head>
<body class="hold-transition skin-blue fixed sidebar-mini">
	<div class="wrapper">
	        <header id="header" class="main-header">
			<%@ include file="../partials/header.jsp" %> 
	        </header>
	     
	     	<aside class="main-sidebar">
	        	<section id="sidemenu" class="sidebar">
				<%@ include file="../partials/sidebar.jsp" %>
	        	</section>
	        </aside>
	        
			<div class="content-wrapper">	             
		        <section id="site-content" class="content">



						<div class="box box-primary">
						    <div class="box-header with-border">
						        <h3 class="box-title">Productos</h3>
				                <div class="pull-right box-tools">
				                    <a href="<c:url value='/productos/new'/>" class="btn btn-primary btn-sm" data-toggle="tooltip" title="" data-original-title="Nuevo Producto">
				                        <i class="fa fa-plus"></i>
				                    </a>
				                </div>
						    </div>
            				<div class="box-body">					            
									<div class="table-responsive">
					                    <table id="editTable" class="table table-striped table-bordered table-hover dataTables-example" >
					                    <thead>
					                    <tr>
					                        <th>Id Producto</th>
					                        <th>Nombre Producto</th>
					                        <th>Categorias</th>
					                        <th>Proveedores</th>
					                        <th>Precio</th>
					                        <th>Stock</th>
					                        <th></th>
					                    </tr>
					                    </thead>
					                    <tbody>
					                    <c:choose>
									        <c:when test="${lista.size()==0}">
						                    <tr>
						                        <th></th>
						                        <th></th>
						                        <th></th>
						                        <th></th>
						                        <th></th>
						                        <th></th>
						                    </tr>
						                    </c:when>				        
									        <c:otherwise>
									        	<c:forEach items="${lista}" var="lista">	                    
								                    <tr class="gradeX">
								                        <td>${lista.idProducto}</td>
								                        <td class="center">${lista.nombreproducto}</td>
								                        <td class="center">${lista.categorias.nombrecategoria}</td>
								                        <td class="center">${lista.proveedores.nombrecompania}</td>
								                        <td class="center">${lista.precio}</td>
								                        <td class="center">${lista.stock}</td>
								                        <td class="center">
								                        	<a href="<c:url value="/productos/edit/${lista.idProducto}"/>"><i class="fa fa-search"  title="Ver Detalle"/></a>
								                        	&nbsp;
								                        	<a href="javascript:void(0)" onclick="fn_product_delete(${lista.idProducto})"><i class="fa fa-minus-circle" title="Eliminar"/></a>
								                        </td>
								                    </tr>
							                    </c:forEach>
							               </c:otherwise>
							            </c:choose>        
					                    </tbody>

					                    </table>
				                  </div>
							</div>
						</div>


		        </section>
	        </div>
	        <!-- 
	        <footer id="footer">
	            <tiles:insertAttribute name="footer" />
	        </footer>-->
	</div> 
	<%@ include file="../partials/scripts.jsp" %>    
	
  <script>
        $(document).ready(function() {
			
            var oTable = $('#editTable').DataTable();
            
       });
</script>		       
</body>
</html>
