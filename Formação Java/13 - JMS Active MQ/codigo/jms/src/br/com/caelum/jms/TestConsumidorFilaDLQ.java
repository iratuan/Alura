package br.com.caelum.jms;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestConsumidorFilaDLQ {

	public static void main(String[] args) {

		try {
			InitialContext context = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
			Connection conn = factory.createConnection();
			conn.start();

			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination fila = (Destination) context.lookup("DLQ");
			MessageConsumer consumer = session.createConsumer(fila);

			consumer.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message message) {
					System.out.println(message);
				}
			});

			new Scanner(System.in).nextLine();

			session.close();
			conn.close();
			context.close();
		} catch (JMSException | NamingException e) {
			e.printStackTrace();
		}
	}
}
