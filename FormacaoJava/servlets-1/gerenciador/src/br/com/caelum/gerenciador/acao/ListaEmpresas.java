package br.com.caelum.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.models.Banco;
import br.com.caelum.models.Empresa;

public class ListaEmpresas implements Gerenciavel {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Empresa> empresas = Banco.listaEmpresas();
		RequestDispatcher rd =  request.getRequestDispatcher("/WEB-INF/empresa/lista.jsp");
		request.setAttribute("empresas", empresas);
		rd.forward(request, response);
	}
}
