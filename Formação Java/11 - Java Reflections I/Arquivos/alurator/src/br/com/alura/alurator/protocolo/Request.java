package br.com.alura.alurator.protocolo;

import java.util.HashMap;
import java.util.Map;

public class Request {

	private String nomeController;
	private String nomeMetodo;
	private Map<String, Object> queryParams;

	public Request(String url) {
		// Processa a requisicao executando o metodo
		// da classe em questao

		String[] partesURL = url.replaceFirst("/", "").split("[?]");
		String[] controleMetodo = partesURL[0].split("/");

		// Torna a primeira letra maiuscula + completa com o restante da string e
		// concatena com Controller
		this.nomeController = Character.toUpperCase(controleMetodo[0].charAt(0)) + controleMetodo[0].substring(1)
				+ "Controller";
		this.nomeMetodo = controleMetodo[1];

		queryParams = partesURL.length > 1 ? new QueryParamsBuilder().withParams(partesURL[1]).build()
				: new HashMap<String, Object>();

	}

	public String getNomeControle() {

		return nomeController;
	}

	public String getNomeMetodo() {

		return nomeMetodo;
	}

	public Map<String, Object> getQueryParams() {
		return queryParams;
	}
}
