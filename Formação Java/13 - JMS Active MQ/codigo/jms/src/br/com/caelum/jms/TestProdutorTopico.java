package br.com.caelum.jms;

import java.io.StringWriter;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.JAXB;

import br.com.caelum.modelo.Pedido;
import br.com.caelum.modelo.PedidoFactory;

public class TestProdutorTopico {

	public static void main(String[] args) {
		/**
		 * Caso optasse por usar properties diretamente ao invés de JNDI
		 * Properties properties = new Properties();
		 * properties.setProperty("java.naming.factory.initial",
		 * "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		 * 
		 * properties.setProperty("java.naming.provider.url",
		 * "tcp://localhost:61616"); properties.setProperty("queue.financeiro",
		 * "fila.financeiro");
		 * 
		 * InitialContext context = new InitialContext(properties);
		 * 
		 */

		try {
			InitialContext context = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
			Connection conn = factory.createConnection();
			conn.start();

			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination topico = (Destination) context.lookup("loja");

			MessageProducer producer = session.createProducer(topico);

			boolean ativo = false;
			for (int i = 0; i < 100; i++) {
				Pedido pedido = new PedidoFactory().geraPedidoComValores();
				StringWriter writer = new StringWriter();
				JAXB.marshal(pedido, writer);
				String xml = writer.toString();

				Message message = session.createTextMessage(xml);
				message.setBooleanProperty("ativo", ativo);
				producer.send(message);
				ativo = !ativo;
			}


			session.close();
			conn.close();
			context.close();
		} catch (JMSException | NamingException e) {
			e.printStackTrace();
		}
	}
}
