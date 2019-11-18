package br.com.caelum.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.models.Banco;
import br.com.caelum.models.Empresa;

public class SalvaEmpresa implements Gerenciavel {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (Boolean.parseBoolean(request.getParameter("atualiza")) == true) {
			int empresaId = Integer.parseInt(request.getParameter("id"));
			Empresa empresa = Banco.encontraEmpresa(empresaId);
			empresa.setNome(request.getParameter("nome"));
			try {
				empresa.setDataAbertura(request.getParameter("dataAbertura"));
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
		} else {
			Empresa empresa = new Empresa(request.getParameter("nome"), request.getParameter("dataAbertura"));
			Banco.adicionaEmpresa(empresa);

		}
		response.sendRedirect("index?acao=empresa/lista");
	}
}
