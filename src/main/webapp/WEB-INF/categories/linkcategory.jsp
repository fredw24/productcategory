<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category to Product</title>
</head>
<body>
<h1>${category.name}</h1>


<c:forEach var="product" items="${products}">
            <h3>${product.name}</h3>
</c:forEach>

<form:form action="/category/link/" method="post" modelAttribute="category">

	<p>
		<form:input path="id" type="hidden" value="${product.id}"/>
		
        <form:label path="products">List of Products:</form:label>
        <form:errors path="products"/>
        <form:select path="products">
	        <c:forEach var="notProduct" items="${notProducts}">
	            <option value="${notProduct.id}">${notProduct.name}</option>
	        </c:forEach>
        </form:select>
        
    </p> 
    <button>Link It</button>


</form:form>
</body>
</html>