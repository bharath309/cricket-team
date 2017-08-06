<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Rating</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="team" items="${teams}">
				<tr>
					<td>${team.id}</td>
					<td>${team.name}</td>
					<td>${team.rating}</td>
					<td>
					 <a href="${pageContext.request.contextPath}/team/edit/${team.id}"> Edit</a><br>
					 <a href="${pageContext.request.contextPath}/team/delete/${team.id}"> Delete</a><br>
					</td>
				</tr>
				
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>