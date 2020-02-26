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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.modelo.Projeto;

public class ProjetoTest {

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
	public void testaQueAConexaoComOServidorFuncionaNoPathDeProjetos() {

		String conteudo = target.path("/projetos/1").request().get(String.class);
		Projeto projeto = (Projeto) new XStream().fromXML(conteudo);
		System.out.println(conteudo);
		Assert.assertEquals("Minha loja", projeto.getNome());
	}

	@Test
	public void testaAdicaoDeUmProjeto() {

		Projeto projeto = new Projeto(2l, "BatCaverna", 2020);
		String xml = projeto.toXML();

		Entity<String> entity = Entity.entity(xml, MediaType.APPLICATION_XML);
		Response response = target.path("/projetos").request().post(entity);
		Assert.assertEquals(201, response.getStatus());

		String location = response.getHeaderString("Location");
		String conteudo = client.target(location).request().get(String.class);
		Assert.assertTrue(conteudo.contains("BatCaverna"));
	}

	@Test
	public void testeRemocaoProjeto() {
		Response response = target.path("/projetos").path("1").request().delete();
		Assert.assertEquals(response.getStatus(), 200);
	}
}