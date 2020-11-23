package br.com.alura.alurator.protocolo;

public class Request {

	private String nomeController;

	public Request(String url) {
		// Processa a requisicao executando o metodo
		// da classe em questao

		String[] partesURL = url.replaceFirst("/", "").split("/");

		// Torna a primeira letra maiuscula + completa com o restante da string e
		// concatena com Controller
		this.nomeController = Character.toUpperCase(partesURL[0].charAt(0)) + partesURL[0].substring(1) + "Controller";

	}

	public String getNomeControle() {

		return nomeController;
	}
}
