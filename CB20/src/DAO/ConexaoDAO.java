package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
	private Connection conexao;
	public ConexaoDAO() {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
				+ "databaseName=CB20";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			
			Connection conn = DriverManager.getConnection(connectionUrl, "sa", "123456");
			conexao = conn;
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		} catch (Exception e) {
			System.out.println("Não foi possível conectar");
		}
	}
	
	public Connection getConexao() {
		return conexao;
	}
}
