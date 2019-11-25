<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="../includes/login.jsp" %>
	<form action='<c:url value="/index?acao=SalvaEmpresa/>' method="post">
		<label>Nome: <input type="text" name="nome" /></label> 
		<label>Data abertura: <input
			type="text" name="dataAbertura"  /></label>
		<input type="submit" value="Enviar">
	</form>
</body>
</html>
