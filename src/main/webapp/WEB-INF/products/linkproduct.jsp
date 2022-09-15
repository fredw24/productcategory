<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Link Product</title>
</head>
<body>
<h1>${product.name}</h1>
<h2>Price: ${product.price}</h2>
<p>Description: ${product.description}</p>

<c:forEach var="category" items="${categories}">
            <h3>${category.name}</h3>
</c:forEach>

<form:form action="/product/link/" method="post" modelAttribute="product">

	<p>
		<form:input path="id" type="hidden" value="${product.id}"/>
		
        <form:label path="categories">List of Categories:</form:label>
        <form:errors path="categories"/>
        <form:select path="categories">
	        <c:forEach var="notCategory" items="${notCategories}">
	            <option value="${notCategory.id}">${notCategory.name}</option>
	        </c:forEach>
        </form:select>
        
    </p> 
    <button>Link It</button>


</form:form>


</body>
</html>