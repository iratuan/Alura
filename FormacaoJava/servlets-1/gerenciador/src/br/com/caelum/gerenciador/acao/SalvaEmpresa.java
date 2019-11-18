package br.com.caelum.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.models.Banco;
import br.com.caelum.models.Empresa;

public class SalvaEmpresa implements Gerenciavel{
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Empresa empresa = new Empresa(request.getParameter("nome"), request.getParameter("dataAbertura"));
		Banco.adicionaEmpresa(empresa);	
		request.setAttribute("empresa", empresa); 
		response.sendRedirect("index?acao=empresa/lista");
	}
}
