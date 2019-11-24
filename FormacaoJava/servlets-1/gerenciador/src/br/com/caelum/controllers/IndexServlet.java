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

import br.com.caelum.gerenciador.acao.AdicionaEmpresa;
import br.com.caelum.gerenciador.acao.EditaEmpresa;
import br.com.caelum.gerenciador.acao.ExcluiEmpresa;
import br.com.caelum.gerenciador.acao.Executavel;
import br.com.caelum.gerenciador.acao.ListaEmpresas;
import br.com.caelum.gerenciador.acao.Login;
import br.com.caelum.gerenciador.acao.SalvaEmpresa;
import br.com.caelum.gerenciador.acao.ValidaUsuario;
import br.com.caelum.models.Usuario;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<String> rotasPublicas = new ArrayList<String>();

	public IndexServlet() {
		rotasPublicas.add("login");
		rotasPublicas.add("usuario/valida");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acaoParam = request.getParameter("acao");

		Executavel acao = null;
		String destino = null;

		switch (acaoParam) {

		case "empresa/lista":
			acao = new ListaEmpresas();
			destino = acao.executa(request, response);
			break;

		case "empresa/formulario":
			acao = new AdicionaEmpresa();
			destino = acao.executa(request, response);
			break;

		case "empresa/salva":
			acao = new SalvaEmpresa();
			destino = acao.executa(request, response);
			break;

		case "empresa/edita":
			acao = new EditaEmpresa();
			destino = acao.executa(request, response);
			break;

		case "empresa/exclui":
			acao = new ExcluiEmpresa();
			destino = acao.executa(request, response);
			break;

		case "usuario/valida":
			acao = new ValidaUsuario();
			destino = acao.executa(request, response);
			break;


		default:
			acao = new Login();
			destino = acao.executa(request, response);
			break;
		}

		
		String[] tipoEndereco = destino.split(":");
				
		HttpSession session = request.getSession();
		
		boolean isValido = (session.getAttribute("usuarioLogado") != null || IndexServlet.rotasPublicas.contains(acaoParam)); 
		
		if(!isValido) {
			response.sendRedirect(request.getContextPath() + "/index?acao=login");
		}else {
			if (tipoEndereco[0].equals("forward")) {
				RequestDispatcher rd = request.getRequestDispatcher(tipoEndereco[1]);
				rd.forward(request, response);
			} else {
				response.sendRedirect(tipoEndereco[1]);
			}
		}
				
	}

}
