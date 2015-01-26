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
	
	<h2>List of all People</h2>	
	<table>
		<tr>
			<td>irs_id</td><td>fb_id</td><td>member_type_id</td><td>firstName</td><td>lastName</td>
			    <td>userName</td><td>pictureUrl</td><td>pictureHeight</td><td>pictureWidth</td>
		        <td>--Delete--</td>
		</tr>
		<c:forEach items="${people}" var="person">
			<tr>
			<td>${person.irsId}</td>
			<td>${person.fbId}</td>
			<td>${person.memberTypeId}</td>
			<td>${person.firstName}</td>
			<td>${person.lastName}</td>
			<td>${person.username}</td>
			<td>${person.pictureUrl}</td>
			<td>${person.pictureHeight}</td>
			<td>${person.pictureWidth}</td>
			
			<td><a href="<c:url value='/api/v1/person/delete/${person.username}' />">${person.username}</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	
</body>
</html>