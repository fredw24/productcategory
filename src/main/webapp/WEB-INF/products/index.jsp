<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<body>
<h1>Product List</h1>

<c:forEach items="${products}" var="product">

<a href="/product/${product.id}">${product.name}</a><br>


</c:forEach>

<a href="/product/create">Add New Product</a>

</body>
</html>