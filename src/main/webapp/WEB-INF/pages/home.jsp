<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div>
 <p>Welcome to Cricket Ranking Maintanence Page. This page will provide u, ranking details.<br>
     In progress, Players information  
 </p>
 </div>
  <div>
    ${message}<br>
  </div>
  <div>
  <a href="${pageContext.request.contextPath}/team/add">Add New Team</a>
  </div>
  <div>
  <a href="${pageContext.request.contextPath}/team/list">Team List</a>
  </div>
  
  
  
</body>
</html>