package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.modelo.Projeto;
import junit.framework.Assert;

public class CarrinhoTest {

	private HttpServer server;
	private Client client;
	private WebTarget target;
	private ClientConfig config = new ClientConfig();

	@Before
	public void startServer() {
		this.server = Servidor.start();
		config.register(new LoggingFilter());
		client = ClientBuilder.newClient(config);
		target = client.target("http://localhost:8080");
	}

	@After
	public void stopServer() {
		server.stop();
		client.close();
	}

	@Test
	public void testaQueBuscarUmCarrinhoTrazOCarrinhoEsperado() {
		Carrinho carrinho = target.path("/carrinhos/1").request().get(Carrinho.class);
		Assert.assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
	}

	@Test
	public void testaAdicaoDeUmCarrinho() {

		Carrinho carrinho = new Carrinho();
		carrinho.adiciona(new Produto(314l, "Tablet", 999, 1));
		carrinho.setRua("Rua Vergueiro");
		carrinho.setCidade("São Paulo");
		String xml = carrinho.toXML();

		Entity<String> entity = Entity.entity(xml, MediaType.APPLICATION_XML);
		Response response = target.path("/carrinhos").request().post(entity);
		Assert.assertEquals(201, response.getStatus());

		String location = response.getHeaderString("Location");
		String conteudo = client.target(location).request().get(String.class);
		Assert.assertTrue(conteudo.contains("Rua Vergueiro"));
	}

	@Test
	public void testeRemocaoCarrinho() {
		Response response = target.path("/carrinhos/1/produtos/6237").request().delete();
		Assert.assertEquals(response.getStatus(), 200);
	}

	@Test 
	public void testeAlteracaoCarrinho() {
		
		String produtoXML = "<br.com.alura.loja.modelo.Produto>      <preco>60.0</preco>      <id>3467</id>      <nome>Jogo de esporte</nome>      <quantidade>1</quantidade> </br.com.alura.loja.modelo.Produto>";
		Produto produto = (Produto) new XStream().fromXML(produtoXML);
		System.out.println(produto.getPreco());

		Entity<Produto> entity = Entity.entity(produto, MediaType.APPLICATION_XML);
		//TODO: Response response = target.path("/carrinhos/1/produtos/3467").request().put(entity);
		
	}

}
