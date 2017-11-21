<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GuestBook</title>
</head>
<body>
<table border=1>
	<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Message</th>
	</tr>
<c:forEach items="${persons}" var="per">
     <tr>
	<th>${per.ID}</th>
	<th>${per.name}</th>
	<th>${per.message}</th>
	<td><a href=SLEdit?id=${per.ID}>Edit</a></td>
	<td><a href=SLDel?id=${per.ID}>Delete</a></td>
</tr>
    </c:forEach>
</table>
		<br>
<a href=SLAdd>Leave your message</a></br>
</body>
</html>