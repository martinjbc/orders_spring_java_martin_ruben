<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
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


					<div class="row">
					    <div class="col-lg-12">
					        <div class="ibox float-e-margins">
					            <div class="ibox-title">
					                <h5><a href="#">PEDIDOS</a></h5>
					            </div>
					            <div class="ibox-content">
					            
									<div class="table-responsive">
					                    <table id="editTable" class="table table-striped table-bordered table-hover dataTables-example" >
					                    <thead>
					                    <tr>
					                        <th>CLIENTE</th>
					                        <th>DIRECCION</th>
					                        <th>FECHA PEDIDO</th>
					                        <th>FECHA ENTREGA</th>
					                        <th>DESTINATARIO</th>
					                        <th></th>
					                    </tr>
					                    </thead>
					                    <tbody>
					                    <c:choose>
									        <c:when test="${orders.size()==0}">
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
									        	<c:forEach items="${orders}" var="order">	                    
								                    <tr class="gradeX">
								                        <td>${order.cliente.nombrecompania}</td>
								                        <td>${order.direcciondestinatario}</td>
								                        <td>${order.fechapedido}</td>
								                        <td class="center">${order.fechaentrega}</td>
								                        <td class="center">${order.destinatario}</td>
								                        <td class="center"><a href="<c:url value="/pedidos/edit/id/${order.idpedido}"/>">ver detalle</a></td>
								                    </tr>
							                    </c:forEach>
							               </c:otherwise>
							            </c:choose>        
					                    </tbody>
					                    <tfoot>
						                    <tr>
						                        <th>CLIENTE</th>
						                        <th>DIRECCION</th>
						                        <th>FECHA PEDIDO</th>
						                        <th>FECHA ENTREGA</th>
						                        <th>DESTINATARIO</th>
						                        <th></th>
					                        </tr>
					                    </tfoot>
					                    </table>
				                        </div>
				
					            </div>
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
            /* Init DataTables */
            var oTable = $('#editTable').DataTable();

            /* Apply the jEditable handlers to the table */
            /*
            oTable.$('td').editable( '../example_ajax.html', {
                "callback": function( sValue, y ) {
                    var aPos = oTable.fnGetPosition( this );
                    oTable.fnUpdate( sValue, aPos[0], aPos[1] );
                },
                "submitdata": function ( value, settings ) {
                    return {
                        "row_id": this.parentNode.getAttribute('id'),
                        "column": oTable.fnGetPosition( this )[2]
                    };
                },

                "width": "90%",
                "height": "100%"
            } );
			*/

        });
</script>		       
</body>
</html>
