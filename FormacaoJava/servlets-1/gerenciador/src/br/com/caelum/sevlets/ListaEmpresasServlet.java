package br.com.caelum.sevlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.models.Banco;
import br.com.caelum.models.Empresa;

@WebServlet("/empresa/lista")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Empresa> empresas = Banco.listaEmpresas();
		RequestDispatcher rd =  request.getRequestDispatcher("/WEB-INF/empresa/lista.jsp");
		request.setAttribute("empresas", empresas);
		rd.forward(request, response);
	}

}
