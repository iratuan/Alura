<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Livro</title>
</head>
<body>

	<h1>Cadastro de livros</h1>
	<form action="gravar" method="POST">
		<p>
			Titulo: <input type="text" name="titulo" />
		</p>
		<p>
			Descrição: <input type="text" name="descricao" />
		</p>
		<p>
			Paginas: <input type="text" name="paginas" />
		</p>

		<input type="submit" value="Salvar" />
	</form>
</body>
</html>