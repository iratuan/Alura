package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

public class PublicaEstoqueWS {

	public static void main(String[] args) {
		
		EstoqueWs implementacaoWS = new EstoqueWs();
		String URL = "http://localhost:9000/estoquews";

		System.out.println("EstoqueWS rodando: " + URL);

		// associando URL com a implementacao
		Endpoint.publish(URL, implementacaoWS);
	}
}