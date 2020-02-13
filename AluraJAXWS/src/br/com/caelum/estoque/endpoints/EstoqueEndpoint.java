package br.com.caelum.estoque.endpoints;

import javax.xml.ws.Endpoint;

import br.com.caelum.estoque.ws.EstoqueWs;

public class EstoqueEndpoint {

	public static void main(String[] args) {
		
		EstoqueWs service = new EstoqueWs();
		
		String url = "http://localhost:8088/estoquews";
		
		Endpoint.publish(url, service);

	}

}
