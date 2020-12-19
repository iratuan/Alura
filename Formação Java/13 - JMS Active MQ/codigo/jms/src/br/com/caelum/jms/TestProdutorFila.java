package br.com.caelum.jms;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestProdutorFila implements ConsumidorTopicoInterface {

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
			Destination fila = (Destination) context.lookup("financeiro");

			MessageProducer producer = session.createProducer(fila);

			for (int i = 0; i < 100; i++) {
				Message message = session.createTextMessage("<livro><id>" + i + "</id><autor>Eduardo</autor></livro>");
				producer.send(message);
			}

//			new Scanner(System.in).nextLine();

			session.close();
			conn.close();
			context.close();
		} catch (JMSException | NamingException e) {
			e.printStackTrace();
		}
	}
}
