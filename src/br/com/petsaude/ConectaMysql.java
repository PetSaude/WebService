package br.com.petsaude;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMysql {

	private static final String URL = "jdbc:mysql://localhost/petsaudeWS"; 
	private static final String USER = "root";
	private static final String SENHA = "root";
	
	public static Connection obtemConexao()throws SQLException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return DriverManager.getConnection(URL, USER, SENHA);
	}
}
