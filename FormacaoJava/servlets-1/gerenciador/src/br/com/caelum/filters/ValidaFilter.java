package br.com.caelum.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.caelum.controllers.IndexServlet;
import br.com.caelum.models.Usuario;

@WebFilter("/index")
public class ValidaFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse sevletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) sevletResponse;
		HttpSession session = request.getSession();
		String acaoParam = request.getParameter("acao");

		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		boolean usuarioLogado = (usuario != null);
		boolean rotaPublica = IndexServlet.rotasPublicas.contains(acaoParam);

		if (!usuarioLogado && !rotaPublica) {
			response.sendRedirect(request.getContextPath() + "/index?acao=Login");
		} else {
			chain.doFilter(request, response);
		}

	}

}
