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
	<form action='<c:url value="/index?acao=empresa/atualiza"/>' method="post">
	<input type="hidden" name="id"
			value="${ empresa.id }" />
		<label>Nome: <input type="text" name="nome"
			value="${ empresa.nome }" /></label> 
		<label>Data abertura: <input
			type="text" name="dataAbertura" value='<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>' /></label>
		<input type="submit" value="Enviar">
	</form>
</body>
</html>
