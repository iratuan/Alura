<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<form action='<c:url value="/index?acao=ValidaUsuario"/>' method="post">
	<input type="text" name="nome" />
	<input type="text" name="senha" />
	<input type="submit" value="Logar" />
</form>
</body>
</html>