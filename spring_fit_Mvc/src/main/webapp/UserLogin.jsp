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
<h1>User Login!</h1>
	<form:form action="UserLoginForm" modelAttribute="user">
    Id:<form:input path="id"/><br> <br>
       Password:<form:input path="user_password"/><br> <br>
		<form:button>Save</form:button>
	</form:form>
</body>
</html>