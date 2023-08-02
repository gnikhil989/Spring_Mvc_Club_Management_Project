<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View All Cities</title>
</head>
<body>
    <table border="1" style="border-collapse: collapse;">
        <tr>
            <th>Branch_ID</th>
            <th>Location_Name</th>
            <th>Choose your Location</th>
          
        </tr>
        <c:forEach var="branch" items="${branch}">
            <tr>
                <td>${branch.getId()}</td>
                <td>${branch.getLocation()}</td>
                <td><a href="location?id=${branch.getId()}">Select</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
