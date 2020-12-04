package projeto.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import projeto.factories.ConexaoFactory;

public class TestaInsercao {
	public static void main(String[] args) throws SQLException {
		ConexaoFactory connFactory = new ConexaoFactory();
		Connection conn = connFactory.getConnection();

		String strSQL = "insert into produtos (nome, descricao) values ('mouse','mouse sem fio')";
		PreparedStatement statement = conn.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
		statement.execute();

		ResultSet resultados = statement.getGeneratedKeys();

		while (resultados.next()) {
			System.out.println("ID " + resultados.getInt(1));
		}
	}
}
