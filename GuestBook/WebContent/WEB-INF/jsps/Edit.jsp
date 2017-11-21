<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method=post action=SLEdit>
				Name:<Input type=text name=Name value=${person.name}></Input><br>
				Message:<textarea name=message cols=50 rows=4>${person.message}</textarea> 
				<input type='hidden' name='id' value=${person.ID}></input>
				<input type=submit name=submit value=add ></input><br>
</form>
</body>
</html>