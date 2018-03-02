<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
holas
		<c:if test="${listaProducto != null}">
		<table border="1">
			<tr>
				<th>IdProducto</th>
				<th>NombreProducto</th>
				<th>IdProveedor</th>
			</tr>
			<c:forEach items="${listaProducto}" var="r">
				<tr>
					<td>${r.idProducto}</td>
					<td>${r.nombreproducto}</td>
					<td>${r.idProveedor}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>