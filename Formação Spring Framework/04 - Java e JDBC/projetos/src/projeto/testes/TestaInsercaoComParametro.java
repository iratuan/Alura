package projeto.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import projeto.factories.ConexaoFactory;

public class TestaInsercaoComParametro {
	public static void main(String[] args) throws SQLException {
		ConexaoFactory connFactory = new ConexaoFactory();
		Connection conn = connFactory.getConnection();

		String nome = "Novo mouse";
		String descricao = "Um mouse legal";

		PreparedStatement statement = conn.prepareStatement("insert into produtos (nome, descricao) values (?,?)", Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, nome);
		statement.setString(2, descricao);
		statement.execute();

		ResultSet resultados = statement.getGeneratedKeys();

		while (resultados.next()) {
			System.out.println("ID " + resultados.getInt(1));
		}
	}
}
