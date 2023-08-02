<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Save User!</h1>
	<form:form action="SaveUser" modelAttribute="user">
    Name:<form:input path="name"/><br> <br>
       Email:<form:input path="email"/><br> <br>
       Password:<form:input path="user_password"/><br> <br>
		<form:button>Save</form:button>
	</form:form>
</body>
</html>