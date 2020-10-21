package projeto.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		String strConn = "jdbc:mysql://localhost:3308/alura_jdbc?useTimezone=true&serverTimezone=UTC";
		Connection conn = DriverManager.getConnection(strConn, "root", "");

		conn.close();
	}

}
