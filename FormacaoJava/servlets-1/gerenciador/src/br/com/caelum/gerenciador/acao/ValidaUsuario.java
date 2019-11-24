package br.com.caelum.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.caelum.models.Banco;
import br.com.caelum.models.Empresa;
import br.com.caelum.models.Usuario;

public class ValidaUsuario implements Executavel {
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");

		Usuario usuario = Banco.buscaUsuario(nome);

		if (usuario != null) {
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			return "redirec:index?acao=empresa/lista";
		}
		return null;
	}
}
