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
<h1>Update Admin!</h1>
	<form:form action="updateAdminform" modelAttribute="updateAdmin">
	ID:<form:input path="id" readonly="1" /><br>
    Name:<form:input path="name"/><br>
       Email:<form:input path="email"/><br>
		<form:button>Save</form:button>
	</form:form>
</body>
</html>