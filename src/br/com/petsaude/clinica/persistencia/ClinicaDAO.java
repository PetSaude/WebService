package br.com.petsaude.clinica.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.petsaude.clinica.dominio.Clinica;
import br.com.petsaude.util.ConectaMysql;
import br.com.petsaude.util.MeuProjetoException;

public class ClinicaDAO {
	  private static final ClinicaDAO instance = new ClinicaDAO();
	  
	      private ClinicaDAO() {
	          super();
	      }
	  
	      public static ClinicaDAO getInstance(){
	          return instance;
	      }
	      public ArrayList<Clinica> retrieveClinicas() throws MeuProjetoException{
	    	  
	      ArrayList<Integer> clinicaIds = new ArrayList<Integer>();
	      ArrayList<Clinica> clinicas = null;
			
			try{
				Connection con = ConectaMysql.obtemConexao();
				String queryBuscaTodos = "SELECT * FROM clinica";
				PreparedStatement ppstm = con.prepareStatement(queryBuscaTodos);
				
				ResultSet resultado = ppstm.executeQuery();
				
				while(resultado.next()){
					clinicaIds.add(resultado.getInt(1));
					
				}
				
				clinicas=new ArrayList<Clinica>();
				if(!clinicaIds.isEmpty()){
					for(int i:clinicaIds){
						clinicas.add(this.getClinica(i));
					}
				}
				
				con.close();
				
			} catch (Exception e){
					throw new MeuProjetoException("erro no servidor");			
			}
			return clinicas;
			
			
		}
	      public Clinica getClinica(int id) throws MeuProjetoException{
	    	  Clinica clinica=null;
	    	  try {
	    		  Connection con = ConectaMysql.obtemConexao();
	    		  String queryBuscaTodos = "SELECT * FROM clinica where id = ?";
	    		  PreparedStatement ppstm = con.prepareStatement(queryBuscaTodos);
	    		  ppstm.setInt(1, id);
	    		  ResultSet resultado = ppstm.executeQuery();
	  			
	  			if(resultado.next()){
	  				clinica = new Clinica();
	  				clinica.setId(resultado.getInt(1));
	  				clinica.setNome(resultado.getString(2));
	  				clinica.setEndereco(resultado.getString(3));
	  				clinica.setLatitude(resultado.getString(4));
	  				clinica.setLongitude(resultado.getString(5));
	  			}else{
	  				return clinica;
	  			}
	  			con.close();
				
			} catch (Exception e) {
				throw new MeuProjetoException("erro no servidor");
			}
	    	  return clinica;
	    	  
	      }
}
