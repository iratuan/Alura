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

public class TestConsumidorFila {

	public static void main(String[] args) {
		
		try {
			InitialContext context = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
			Connection conn = factory.createConnection();
			conn.start();
			
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination fila = (Destination) context.lookup("financeiro");
			MessageConsumer consumer = session.createConsumer(fila);
			
//			Message message = consumer.receive(10000);
//			System.out.println("Recebendo MSG do Active MQ: " + message);
			
			consumer.setMessageListener(new MessageListener() {
				
				@Override
				public void onMessage(Message message) {
					TextMessage textMessage = (TextMessage) message;
					try {
						System.out.println(textMessage.getText());
					} catch (JMSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
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
