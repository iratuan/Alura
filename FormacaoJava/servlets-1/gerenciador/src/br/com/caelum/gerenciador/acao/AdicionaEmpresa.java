package br.com.caelum.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.models.Banco;
import br.com.caelum.models.Empresa;

public class AdicionaEmpresa implements Gerenciavel {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "forward:/WEB-INF/empresa/formulario.jsp";
	}

}
