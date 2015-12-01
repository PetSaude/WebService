package br.com.petsaude.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMysql {

	private static final String URL = "jdbc:mysql://mysql03.labsolucoes.hospedagemdesites.ws/";
	private static final String DATA_BASE="labsolucoes2";
	private static final String USER = "labsolucoes2";
	private static final String SENHA = "petsaude2015";
	
	public static Connection obtemConexao()throws SQLException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return DriverManager.getConnection(URL+DATA_BASE, USER, SENHA);
	}
}
