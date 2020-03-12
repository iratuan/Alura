package br.com.caelum.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.caelum.gerenciador.acoes.Executavel;
import br.com.caelum.models.Usuario;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<String> rotasPublicas = new ArrayList<String>();

	public IndexServlet() {
		rotasPublicas.add("Login");
		rotasPublicas.add("ValidaUsuario");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acaoParam = request.getParameter("acao");
		String nomeClasse = "br.com.caelum.gerenciador.acoes." + acaoParam;
		String destino = null;

		try {
			Class classe = Class.forName(nomeClasse);
			Executavel acao = (Executavel) classe.newInstance();
			destino = acao.executa(request, response);
		} catch (Exception e) {
			System.out.println("Um erro ocorreu: " + e.getMessage());
		}

		String[] tipoEndereco = destino.split(":");
		if (tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(tipoEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEndereco[1]);
		}

	}

}
