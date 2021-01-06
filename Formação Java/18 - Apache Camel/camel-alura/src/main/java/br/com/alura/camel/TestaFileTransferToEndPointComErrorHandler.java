package br.com.alura.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class TestaFileTransferToEndPointComErrorHandler {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {

		
		
			public void configure() throws Exception {
				errorHandler(
					    deadLetterChannel("file:erro").
					        logExhaustedMessageHistory(true).
					        maximumRedeliveries(3).
					            redeliveryDelay(5000).
					        onRedelivery(new Processor() {            
					            @Override
					            public void process(Exchange exchange) throws Exception {
					                int counter = (int) exchange.getIn().getHeader(Exchange.REDELIVERY_COUNTER);
					                int max = (int) exchange.getIn().getHeader(Exchange.REDELIVERY_MAX_COUNTER);
					                System.out.println("Redelivery - " + counter + "/" + max );
					            }
					        })
					);
				
				from("file:pedidos?delay=5s&noop=true").
			    log("${file:name}"). //logando nome do arquivo
			    routeId("rota-pedidos").
			    delay(1000). //esperando 1 segundo
			to("validator:pedido.xsd");
			}
		});

		context.start();
		Thread.sleep(20000);
		context.stop();

	}

}
