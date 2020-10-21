package projeto.testes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import projeto.factories.ConexaoFactory;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		ConexaoFactory connFactory = new ConexaoFactory();
		Connection conn = connFactory.getConnection();

		Statement statement = conn.createStatement();
		String strQuery = "select * from produtos";
		statement.execute(strQuery);

		ResultSet results = statement.getResultSet();

		while (results.next()) {
			System.out.println("id:" + results.getString("id"));
			System.out.println("Nome:" + results.getString("nome"));
			System.out.println("Descricao:" + results.getString("descricao"));
		}

		conn.close();
	}

}
