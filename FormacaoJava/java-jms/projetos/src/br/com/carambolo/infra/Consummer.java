package br.com.carambolo.infra;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.naming.InitialContext;

public class Consummer {
	public static void main(String[] args) throws Exception {

		InitialContext context = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = factory.createConnection();
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination fila = (Destination) context.lookup("financeiro");
		MessageConsumer consummer = session.createConsumer(fila,"Um grande teste");
		
		Message message = consummer.receive();
		
		System.out.println(message);
		System.out.println("Servidor up");

		new Scanner(System.in).nextLine(); // parar o programa para testar a conexao

		connection.close();
		context.close();
	}
}