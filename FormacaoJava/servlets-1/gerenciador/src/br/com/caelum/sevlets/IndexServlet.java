package br.com.caelum.sevlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.acao.AdicionaEmpresa;
import br.com.caelum.gerenciador.acao.EditaEmpresa;
import br.com.caelum.gerenciador.acao.ExcluiEmpresa;
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
		String destino = null;
		
		switch (acaoParam) {
		
		case "empresa/lista":
			acao = new ListaEmpresas();
			destino = acao.executa(request, response);
			break;
			
		case "empresa/formulario":
			acao = new AdicionaEmpresa();
			destino =  acao.executa(request, response);
			break;
			
		case "empresa/salva":
			acao = new SalvaEmpresa();
			destino =  acao.executa(request, response);
			break;
			
		case "empresa/edita":
			acao = new EditaEmpresa();
			destino =  acao.executa(request, response);
			break;	
			
		case "empresa/exclui":
			acao = new ExcluiEmpresa();
			destino = acao.executa(request, response);
			break;

		default:
			destino =  "redirec:empresa/lista"; 
			break;			
		}
		
		
		String[] tipoEndereco = destino.split(":");
		if(tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(tipoEndereco[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(tipoEndereco[1]);
		}

	}

}
