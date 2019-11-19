package br.com.caelum.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.models.Banco;
import br.com.caelum.models.Empresa;

public class EditaEmpresa implements Gerenciavel {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer empresaId = Integer.parseInt(request.getParameter("id"));
		Empresa empresa = Banco.encontraEmpresa(empresaId);

		request.setAttribute("empresa", empresa);
		return "forward:/WEB-INF/empresa/edita.jsp";
	}

}
