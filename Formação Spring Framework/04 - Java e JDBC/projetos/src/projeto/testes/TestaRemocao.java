package projeto.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import projeto.factories.ConexaoFactory;

public class TestaRemocao {
	public static void main(String[] args) throws SQLException {
		ConexaoFactory connFactory = new ConexaoFactory();
		Connection conn = connFactory.getConnection();

		String strSQL = "delete from produtos where nome = '' or descricao = ''";
		PreparedStatement statement = conn.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
		statement.execute();
		
		Integer linhasModificadas = statement.getUpdateCount();
		
		System.out.println("Quantidade linhas modificadas: " + linhasModificadas);
	}
}
