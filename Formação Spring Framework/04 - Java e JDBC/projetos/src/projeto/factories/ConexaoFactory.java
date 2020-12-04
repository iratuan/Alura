package projeto.factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public Connection getConnection() throws SQLException {
		String strConn = "jdbc:mysql://localhost:3308/alura_jdbc?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "";
		return DriverManager.getConnection(strConn, user, password);
	}

}
