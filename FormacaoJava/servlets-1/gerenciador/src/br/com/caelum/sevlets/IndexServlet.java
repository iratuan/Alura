package br.com.caelum.sevlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.acao.AdicionaEmpresa;
import br.com.caelum.gerenciador.acao.AtualizaEmpresa;
import br.com.caelum.gerenciador.acao.EditaEmpresa;
import br.com.caelum.gerenciador.acao.Gerenciavel;
import br.com.caelum.gerenciador.acao.ListaEmpresas;
import br.com.caelum.gerenciador.acao.SalvaEmpresa;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acaoParam = request.getParameter("acao");
		
		Gerenciavel acao = null;
		
		switch (acaoParam) {
		
		case "empresa/lista":
			acao = new ListaEmpresas();
			acao.executa(request, response);
			break;
			
		case "empresa/formulario":
			acao = new AdicionaEmpresa();
			acao.executa(request, response);
			break;
			
		case "empresa/salva":
			acao = new SalvaEmpresa();
			acao.executa(request, response);
			break;
			
		case "empresa/edita":
			acao = new EditaEmpresa();
			acao.executa(request, response);
			break;
			
		case "empresa/atualiza":
			acao = new AtualizaEmpresa();
			acao.executa(request, response);
			break;
			
		case "empresa/exclui":
			acao = new AtualizaEmpresa();
			acao.executa(request, response);
			break;

		default:
			response.sendRedirect("empresa/lista"); 
			break;			
		}

	}

}
