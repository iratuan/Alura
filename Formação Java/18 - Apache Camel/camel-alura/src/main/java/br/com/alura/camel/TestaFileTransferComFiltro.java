package br.com.alura.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class TestaFileTransferComFiltro {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {

			public void configure() throws Exception {
				from("file:pedidos?delay=5s&noop=true")
				.split()
					.xpath("/pedido/itens/item")
				.filter()
					.xpath("/item/formato[text()='EBOOK']")
				.log("${id} \n ${body}")
				.marshal().xmljson()
				.setHeader(Exchange.FILE_NAME, simple("${file:name.noext}-${header.CamelSplitIndex}.json"))				
				.to("file:saida");
			}
		});

		context.start();
		Thread.sleep(20000);
		context.stop();

	}

}
