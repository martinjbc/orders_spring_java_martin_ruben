<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<html>
 
<head>
	<%@ include file="../partials/resource.jsp" %>    
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
					        <h3 class="box-title">Nuevo pedido</h3>
					        <div class="box-tools pull-right">
					            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
					            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
					        </div>
					    </div>	    
					     
			            <div class="box-body">
			
			
						   <c:url var="actionUrl" value="${action}"/>
						   <form:form action="${actionUrl}" method="post" modelAttribute="pedido">
						   	  <!--  modelAttribute="project"  -->
							<div class="form-group">
								<form:input path="idpedido" type="hidden"/>
							    <label for="name">Cliente</label>
							    <form:select class="form-control" path="cliente" name="cliente.idcliente">
									<form:options items="${clientes}" itemLabel="nombrecompania" itemValue="idcliente"/>							    
							    </form:select>
							    <font color="red"> <form:errors path="cliente"></form:errors></font>
							</div>
			                		
							<div class="form-group">
							    <label for="name">Dirección</label>
							    <form:textarea class="form-control" path="direcciondestinatario" name="direcciondestinatario"/>
							    <font color="red"> <form:errors path="Direcciondestinatario"></form:errors></font>		                        								    
							</div>
							
							<div class="form-group">
							    <label for="name">Destinatario</label>
							    <form:textarea class="form-control" path="destinatario" name="destinatario"/>
							    <font color="red"> <form:errors path="Destinatario"></form:errors></font>
							</div>

						    <div class="box-footer">
						        <div class="form-actions">
						            <form:button name="btn_graba_usu" class="btn btn-primary">Grabar</form:button>
						        </div>
						    </div>		
						    						    		
			                		                			   	  
						   </form:form>
						
					    </div>
					    		       
					<!--</div>-->
					
				<!-- 
		        </section>
		        
		        <section id="site-content" class="content">-->

		        
						<!--<div class="box box-primary">-->
						    <div class="box-header with-border">
						        <h3 class="box-title">PRODUCTOS</h3>
				                <div class="pull-right box-tools">
				                    <a href="<c:url value='/detalle/new/pedidoid/${pedidoId}'/>" class="btn btn-primary btn-sm" data-toggle="tooltip" title="" data-original-title="Nuevo Usuario">
				                        <i class="fa fa-plus"></i>
				                    </a>
				                </div>
						    </div>
            				<div class="box-body">
            				
            				
									<div class="table-responsive">
					                    <table id="editTable" class="table table-striped table-bordered table-hover dataTables-example" >
					                    <thead>
					                    <tr>
					                        <th>Producto</th>
					                        <th>Precio</th>
					                        <th>Cantidad</th>
					                        <th></th>
					                    </tr>
					                    </thead>
					                    <tbody>
					                    <c:choose>
									        <c:when test="${detalles.size()==0}">
						                    <tr>
						                        <th></th>
						                        <th></th>
						                        <th></th>
						                        <th></th>
						                    </tr>
						                    </c:when>				        
									        <c:otherwise>
									        	<c:forEach items="${detalles}" var="linea">	                    
								                    <tr class="gradeX">
								                        <td>${linea.producto.nombreproducto}</td>
								                        <td>${linea.preciounidad}</td>
								                        <td>${linea.cantidad}</td>
								                        <td class="center"><a href="<c:url value="/detalle/edit/pedidoid/${linea.pedido.idpedido}/productoid/${linea.producto.idProducto}"/>">ver detalle</a></td>
								                    </tr>
							                    </c:forEach>
							               </c:otherwise>
							            </c:choose>        
					                    </tbody>
					                    <tfoot>
						                    <tr>
						                        <th>Producto</th>
						                        <th>Precio</th>
						                        <th>Cantidad</th>
						                        <th></th>
					                        </tr>
					                    </tfoot>
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

<script type="text/javascript">
	$(document).ready(function() {
		$('#cliente').select2();
		
		var oTable = $('#editTable').DataTable();
	});
</script>				
	    	       
</body>
</html>
