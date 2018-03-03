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
					        <h3 class="box-title">Nuevo Producto</h3>
					        <div class="box-tools pull-right">
					            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
					            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
					        </div>
					    </div>	    
					     
			            <div class="box-body">
			
			
							   
							   <form:form action="${actionurl}" method="post" modelAttribute="producto">
							   	  <!--  modelAttribute="project"  -->
								<div class="form-group">
									<form:input path="idProducto" type="hidden"/>
								    <label for="name">Nombre Producto</label>
								    <form:textarea class="form-control" path="nombreproducto" name="nombreproducto"/>
								    <font color="red"> <form:errors path="nombreproducto"></form:errors></font>
								</div>
				                		
								<div class="form-group">
								    <label for="name">Precio</label>
								    <form:textarea class="form-control" path="precio" name="precio"/>
								    <font color="red"> <form:errors path="precio"></form:errors></font>		                        								    
								</div>
								
								
								<div class="form-group">
									
								    <label for="name">Categorias</label>
								    <form:select class="form-control" path="categorias.idcategoria" name="categorias.idcategoria">
										<form:options items="${categorias}" itemLabel="nombrecategoria" itemValue="idcategoria"/>							    
								    </form:select>
								    <font color="red"> <form:errors path="categorias"></form:errors></font>
								</div>
								
								<div class="form-group">
									
								    <label for="name">Proveedores</label>
								    <form:select class="form-control" path="proveedores.idproveedor" name="proveedores.idproveedor">
										<form:options items="${proveedores}" itemLabel="nombrecompania" itemValue="idproveedor"/>							    
								    </form:select>
								    <font color="red"> <form:errors path="proveedores"></form:errors></font>
								</div>
								
								<div class="form-group">
								    <label for="name">Stock</label>
								    <form:textarea class="form-control" path="stock" name="stock"/>
								    <font color="red"> <form:errors path="stock"></form:errors></font>
								</div>
								
								<div class="form-group">
								    <label for="name">Suspendido</label>
								    <form:textarea class="form-control" path="suspendido" name="suspendido"/>
								    <font color="red"> <form:errors path="suspendido"></form:errors></font>
								</div>
								
							    <div class="box-footer">
							        <div class="form-actions">
							            <form:button name="btn_graba_usu" class="btn btn-primary">Grabar</form:button>
							        </div>
							    </div>		
							    						    		
				                		                			   	  
							   </form:form>
							
						    </div>
		        		</div>
		        
		        
		        </section>
		        
	        </div>
	       
	</div> 
	<%@ include file="../partials/scripts.jsp" %>

<script type="text/javascript">
	$(document).ready(function() {
		$('#categorias').select2();
		var oTable = $('#editTable').DataTable();
		
		
	});
</script>				
	    	       
</body>
</html>
