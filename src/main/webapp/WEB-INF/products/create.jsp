<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Product</title>

<link rel="stylesheet" type="text/css" href="css/style.css">

<style>
	textarea{
		resize: none;
	}
</style>
</head>
<body>
<h1>Create Product</h1>

<form:form action="/product" method="post" modelAttribute="product">
    <p>
        <form:label path="name">Name:</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p> 
    
    <p>
        <form:label path="description">Description:</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p> 
    
    <p>
        <form:label path="price">Price:</form:label>
        <form:errors path="price"/>
        <form:input type="number" path="price"/>
    </p> 
    
    <input type="submit" value="Submit"/>
</form:form>  

</body>
</html>