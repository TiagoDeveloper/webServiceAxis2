package br.com.videoAula.exemploWS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMysql {
	
	private static final String URL = "jdbc:mysql://localhost/exemplows";
	private static final String USER = "root";
	private static final String PASS = "";
	
	public static Connection obterConexao() throws SQLException{
		
		
		
		return DriverManager.getConnection(URL,USER,PASS);
		
	}
	
	
}
