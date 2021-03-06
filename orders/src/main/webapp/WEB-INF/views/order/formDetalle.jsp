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
					        <h3 class="box-title">Agregar Producto</h3>
					        <div class="box-tools pull-right">
					            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
					            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
					        </div>
					    </div>	    
					     
			            <div class="box-body">
			
			
						   <c:url var="actionUrl" value="${action}"/>
						   <form:form action="${actionUrl}" method="post" modelAttribute="detalle">
							<div class="form-group">
								<form:input path="pedido.idpedido" type="hidden"/>
							    <label for="name">Producto</label>
							    <form:select class="form-control" path="producto.idProducto" id="producto">
									<form:options items="${productos}" itemLabel="nombreproducto" itemValue="idProducto"/>							    
							    </form:select>
							    <font color="red"> <form:errors path="producto"></form:errors></font>
							</div>
			                		
							<div class="form-group">
							    <label for="name">Cantidad</label>
							    <form:input class="form-control" path="cantidad" name="cantidad"/>
							    <font color="red"> <form:errors path="cantidad"></form:errors></font>		                        								    
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
	        <!-- 
	        <footer id="footer">
	            <tiles:insertAttribute name="footer" />
	        </footer>-->
	</div> 
	<%@ include file="../partials/scripts.jsp" %>

<script type="text/javascript">
	$(document).ready(function() {
		$('#producto').select2();
		
		var oTable = $('#editTable').DataTable();
	});
</script>				
	    	       
</body>
</html>
