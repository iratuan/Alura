package br.com.alura.alurator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.Reflexao;

public class Alurator {

	private String pacoteBase;

	public Alurator(String pacoteBase) {
		this.pacoteBase = pacoteBase;
	}

	public Object executa(String url) {

		Request request = new Request(url);
		String nomeController = request.getNomeControle();
		String nomeMetodo = request.getNomeMetodo();
		Map<String, Object> params = request.getQueryParams();
		Object retorno = new Reflexao()
				.refleteClasse(pacoteBase + nomeController)
				.criaInstancia()
				.getMetodo(nomeMetodo, params)				
				.invocar();
		return retorno;

	}
}
