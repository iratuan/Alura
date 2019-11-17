package br.com.caelum.sevlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.models.*;

@WebServlet("/empresa/edita")
public class EditaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer empresaId = Integer.parseInt(request.getParameter("id"));
		Empresa empresa = Banco.encontraEmpresa(empresaId);		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/empresa/editar.jsp");
		request.setAttribute("empresa", empresa);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int empresaId = Integer.parseInt(request.getParameter("id"));
		Empresa empresa = Banco.encontraEmpresa(empresaId);
		response.sendRedirect("lista");
	}

}
