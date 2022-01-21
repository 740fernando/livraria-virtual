<jsp:include page ="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>Lista de Livros</h3>

<c:if test="${livros.size()==0}">
	<br><h4>Nao existem livros cadastrados !</h4><br>
</c:if>
<c:if test="${livros.size() >0}">
	<table>
		<c:forEach var="l" items="${livros}">
			<tr>
				<td>${l.titulo}</td>
				<td>${l.autor}</td>
				<td><A href="LivroForm.action?id=${l.id}">Alterar</A> | <A href="ExcluirLivro.action?id=${l.id}" onclick="return confirm('Deseja realmente excluir ${l.titulo}?');">Excluir</A></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

<A href="LivroForm.action">Cadastrar Novo Livro</A>

<jsp:include page="footer.jsp" />