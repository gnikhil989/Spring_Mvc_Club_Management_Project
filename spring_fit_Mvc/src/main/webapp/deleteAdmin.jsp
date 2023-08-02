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
<h1>Delete Admin!</h1>
	<form:form action="deleteAdminform" modelAttribute="admin">
	ID:<form:input path="id" readonly="1" /><br>
   
		<form:button>Delete</form:button>
	</form:form>
</body>
</html>