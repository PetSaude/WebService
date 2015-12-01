package br.com.petsaude.medico.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.petsaude.clinica.persistencia.ClinicaDAO;
import br.com.petsaude.medico.dominio.Medico;
import br.com.petsaude.usuario.dominio.Usuario;
import br.com.petsaude.util.ConectaMysql;
import br.com.petsaude.util.MeuProjetoException;

public class MedicoDAO {
	 private static final MedicoDAO instance = new MedicoDAO();
	  
     private MedicoDAO() {
         super();
     }
 
     public static MedicoDAO getInstance(){
         return instance;
      
     }
     public Medico getMedico(int id) throws MeuProjetoException{
    	 Medico retorno=null;
    	 try {
    		 Connection con = ConectaMysql.obtemConexao();
    		 String queryBuscarUsuario="SELECT * FROM usuario WHERE id = ? and CRMV != 0" ;
			PreparedStatement ppstm = con.prepareStatement(queryBuscarUsuario);
			ppstm.setInt(1,id);
			ResultSet resultado = ppstm.executeQuery();
			while(resultado.next()){
					Medico usr=new Medico();
					usr.setId(resultado.getInt(1));
					usr.setNome(resultado.getString(4));
					retorno = usr;
	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
     }
     public Medico login(String login, String senha) throws MeuProjetoException{
			
			Medico retorno = null;
			try {
				Connection con = ConectaMysql.obtemConexao();
				String queryBuscarUsuario="SELECT * FROM usuario WHERE login= ? and senha = ?" ;
				PreparedStatement ppstm = con.prepareStatement(queryBuscarUsuario);
				ppstm.setString(1,login);
				ppstm.setString(2,senha);
				
				ResultSet resultado = ppstm.executeQuery();
				while(resultado.next()){
						if (resultado.getInt(6)!=0){
							Medico usr=new Medico();
							usr.setId(resultado.getInt(1));
							usr.setLogin(resultado.getString(2));
							usr.setEmail(resultado.getString(3));
							usr.setNome(resultado.getString(4));
							usr.setSenha(resultado.getString(5));
							usr.setCRMV(resultado.getInt(6));
							retorno=usr;
						}
					
				}
				con.close();
			}catch(Exception e){
				throw new MeuProjetoException("erro no servidor");
				}
					
				return retorno;
			}
			

}
