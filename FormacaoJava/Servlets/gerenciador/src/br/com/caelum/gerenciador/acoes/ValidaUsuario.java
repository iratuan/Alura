package br.com.caelum.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.caelum.models.Banco;
import br.com.caelum.models.Usuario;

public class ValidaUsuario implements Executavel {
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		HttpSession session = request.getSession();
		String destino = (String) session.getAttribute("destino");
		if(destino == null) {
			destino = "ListaEmpresas";
		}

		System.out.println("ACAO: " + destino);
		Usuario usuario = Banco.buscaUsuario(nome);

		if (usuario != null) {
			session.setAttribute("usuarioLogado", usuario);
			return "redirec:index?acao=" + destino;
		}
		return null;
	}
}
