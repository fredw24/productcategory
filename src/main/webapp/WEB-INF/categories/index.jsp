<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Category</title>
</head>
<body>
<h1>List of Category</h1>
<c:forEach items="${categories}" var="category">
<a href="/category/${category.id}">${category.name}</a><br>


</c:forEach>

<a href="/category/create">Add New Category</a>



</body>
</html>