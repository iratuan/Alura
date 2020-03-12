<p>
<c:if test="${usuarioLogado != null}">
 ${usuarioLogado.nome} | <a href='<c:url value="/index?acao=Logout" />'>Logout</a>
</c:if>
<c:if test="${usuarioLogado == null}">
<a href='<c:url value="/index?acao=Login" />'>Login</a>
</c:if>
</p>