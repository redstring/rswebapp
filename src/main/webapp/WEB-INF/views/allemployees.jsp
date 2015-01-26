<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>University Enrollments</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
<a href="${pageContext.request.contextPath}/api">Home_page</a><br/> <br/>

	<h2>List of Employees</h2>	
	<table>
		<tr>
			<td>NAME</td><td>Joining Date</td><td>Salary</td><td>SSN</td>
		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
			<td>${employee.name}</td>
			<td>${employee.joiningDate}</td>
			<td>${employee.salary}</td>
			<td><a href="<c:url value='/api/emp/delete?ssn=${employee.ssn}' />">${employee.ssn}</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/api/emp/new' />">Add New Employee</a>
</body>
</html>