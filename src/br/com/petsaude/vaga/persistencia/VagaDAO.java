package br.com.petsaude.vaga.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.petsaude.animal.dominio.Animal;
import br.com.petsaude.clinica.dominio.Clinica;
import br.com.petsaude.clinica.persistencia.ClinicaDAO;
import br.com.petsaude.medico.dominio.Medico;
import br.com.petsaude.medico.persistencia.MedicoDAO;
import br.com.petsaude.usuario.dominio.Usuario;
import br.com.petsaude.util.ConectaMysql;
import br.com.petsaude.util.MeuProjetoException;
import br.com.petsaude.vaga.dominio.Vaga;

public class VagaDAO {
	private static final VagaDAO instance = new VagaDAO();
	  
    private VagaDAO() {
        super();
    }

    public static VagaDAO getInstance(){
        return instance;
    }
    public ArrayList<Vaga> retrieveVagasClinica(Clinica clinica) throws MeuProjetoException{
  	  
	      ArrayList<Integer> clinicaIds = new ArrayList<Integer>();
	      ArrayList<Vaga> vagas=null;
			try{
				Connection con = ConectaMysql.obtemConexao();
				String queryBuscaTodos = "SELECT * FROM vaga where id_clinica = ?";
				PreparedStatement ppstm = con.prepareStatement(queryBuscaTodos);
				ppstm.setInt(1,clinica.getId());
				
				ResultSet resultado = ppstm.executeQuery();
				
				while(resultado.next()){
					clinicaIds.add(resultado.getInt(1));
					
				}
				vagas=new ArrayList<Vaga>();
				if(!clinicaIds.isEmpty()){
					for(int i:clinicaIds){
						if(this.getVaga(i).getStatus().equals("DISPONIVEL")){
							vagas.add(this.getVaga(i));
							
						}
						
					}
				}
				
				con.close();
			} catch (Exception e){
					e.printStackTrace();
					throw new MeuProjetoException("Erro ao conectar com o servidor");			
			}
			return vagas;
			
			
		}
    public ArrayList<Vaga> retrieveVagasUsuario(Usuario usuario) throws MeuProjetoException{
    	ArrayList<Integer> vagaIds = new ArrayList<Integer>();
    	ArrayList<Vaga> vagas = new ArrayList<Vaga>();
    	try {
    		Connection con = ConectaMysql.obtemConexao();
    		  String queryBuscaTodos = "SELECT * FROM vaga where id_usuario=?";
    		  PreparedStatement ppstm = con.prepareStatement(queryBuscaTodos);
    		  ppstm.setInt(1, usuario.getId());
    
      		  ResultSet resultado = ppstm.executeQuery();

      		while(resultado.next()){
				vagaIds.add(resultado.getInt(1));
				
			}
			
			if(!vagaIds.isEmpty()){
				for(int i:vagaIds){
					vagas.add(this.getVaga(i));
				}
			}
			
			con.close();
			return vagas;
		} catch (Exception e){
				throw new MeuProjetoException("Erro ao conectar com o servidor");			
		}
		
    }
    public ArrayList<Vaga> retrieveVagasMedico(Medico usuario) throws MeuProjetoException{
    	ArrayList<Integer> vagaIds = new ArrayList<Integer>();
    	ArrayList<Vaga> vagas = new ArrayList<Vaga>();
    	try {
    		Connection con = ConectaMysql.obtemConexao();
    		  String queryBuscaTodos = "SELECT * FROM vaga where id_medico=?";
    		  PreparedStatement ppstm = con.prepareStatement(queryBuscaTodos);
    		  ppstm.setInt(1, usuario.getId());
    
      		  ResultSet resultado = ppstm.executeQuery();

      		while(resultado.next()){
				vagaIds.add(resultado.getInt(1));
				
			}
			
			if(!vagaIds.isEmpty()){
				for(int i:vagaIds){
					vagas.add(this.getVaga(i));
				}
			}
			
			con.close();
			return vagas;
		} catch (Exception e){
				throw new MeuProjetoException("Erro ao conectar com o servidor");			
		}
		
    }
    public Vaga getVaga(int id) throws MeuProjetoException{
  	  Vaga vaga=null;
  	  try {
  		  Connection con = ConectaMysql.obtemConexao();
  		  String queryBuscaTodos = "SELECT * FROM vaga where id = ?";
  		  PreparedStatement ppstm = con.prepareStatement(queryBuscaTodos);
  		  ppstm.setInt(1, id);
  		  ResultSet resultado = ppstm.executeQuery();
			
			if(resultado.next()){
			    Medico medico = MedicoDAO.getInstance().getMedico(resultado.getInt(5));
				vaga = new Vaga();
				vaga.setId(resultado.getInt(1));
				vaga.setIdClinica(resultado.getInt(2));
				vaga.setIdUsuario(resultado.getInt(3));
				vaga.setIdAnimal(resultado.getInt(4));
				vaga.setMedico(medico);
				vaga.setData(resultado.getString(6));
				vaga.setStatus(resultado.getString(7));
			}
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
  	  return vaga;
  	  
    }public void updateVaga(Usuario usuario,Animal animal,Vaga vaga) throws MeuProjetoException{
    	try{
			Connection con = ConectaMysql.obtemConexao();
			String queryAtualizar = "UPDATE vaga SET id_usuario=?,id_animal=?,status='CONFIRMADO' WHERE id= ?";
			PreparedStatement ppstm = con.prepareStatement(queryAtualizar);
			
			ppstm.setInt(1, usuario.getId());
			ppstm.setInt(2, animal.getId());
			ppstm.setInt(3, vaga.getId());
			ppstm.executeUpdate();
			con.close();
			}catch (Exception e){
				throw new MeuProjetoException("Erro ao conectar com o servidor");
				
				
			}

    	
    }
}
