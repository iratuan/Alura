<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresas</title>
</head>
<body>
<c:if test="${empresa}">
	<h1>Empresa ${empresa.nome} cadastrada com sucesso!</h1>
</c:if>
	<ul>
		<c:forEach items="${empresas}" var="empresa">
		<li>
			${ empresa.nome} - 
			<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
			<a href='<c:url value="edita"/>?id=${empresa.id}'>Editar</a> | 
			<a href='<c:url value="exclui"/>?id=${empresa.id}'>Excluir</a>
		</li>
		</c:forEach>
	</ul>
</body>
</html>
