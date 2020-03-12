package br.com.caelum.gerenciador.acoes;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.models.Banco;
import br.com.caelum.models.Empresa;

public class Login implements Executavel {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "forward:/WEB-INF/usuario/login.jsp";
	}

}
