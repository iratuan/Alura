package br.com.alura.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;
import org.apache.camel.impl.DefaultCamelContext;

import com.thoughtworks.xstream.XStream;

public class TestaDesafio2 {

	public static void main(String[] args) throws Exception {

		final XStream xstream = new XStream();
		xstream.alias("negociacao", Negociacao.class);
		
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {

			public void configure() throws Exception {
				 from("timer://negociacoes?fixedRate=true&delay=3s&period=360s")
			      .to("http4://argentumws.caelum.com.br/negociacoes")
			      .convertBodyTo(String.class)
			      .unmarshal(new XStreamDataFormat(xstream))
			      .split(body())
			      .log("${body}")
			    .end(); //só deixa explícito que é o fim da rota
			}
		});

		context.start();
		Thread.sleep(20000);
		context.stop();

	}

}
