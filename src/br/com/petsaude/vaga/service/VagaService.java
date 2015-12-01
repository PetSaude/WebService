package br.com.petsaude.vaga.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.petsaude.animal.dominio.Animal;
import br.com.petsaude.clinica.dominio.Clinica;
import br.com.petsaude.medico.dominio.Medico;
import br.com.petsaude.usuario.dominio.Usuario;
import br.com.petsaude.util.ConectaMysql;
import br.com.petsaude.util.MeuProjetoException;
import br.com.petsaude.vaga.dominio.Vaga;
import br.com.petsaude.vaga.persistencia.VagaDAO;

public class VagaService {
	private static final VagaDAO vagaDAO = VagaDAO.getInstance();
	public ArrayList<Vaga> retrieveVagasClinica(Clinica clinica) throws MeuProjetoException{
	  	  
		ArrayList<Vaga> vagas = null;
			
			try{
				vagas = vagaDAO.retrieveVagasClinica(clinica);
			} catch (Exception e){
					throw new MeuProjetoException("Erro ao conectar com o servidor");			
			}
			
			return vagas;
		}
  public Vaga getVaga(int id) throws MeuProjetoException{
	  Vaga vaga=null;
	  try {
		  vaga= vagaDAO.getVaga(id);
			
		} catch (Exception e) {
			throw new MeuProjetoException("erro no servidor");
		}
	  return vaga;
	  
  }
  public ArrayList<Vaga> retrieveVagasUsuario(Usuario usuario) throws MeuProjetoException{
 
  	ArrayList<Vaga> vagas = new ArrayList<Vaga>();
  	try {
  		  vagas = vagaDAO.retrieveVagasUsuario(usuario);
		} catch (Exception e){
				throw new MeuProjetoException("Erro ao conectar com o servidor");			
		}
  	return vagas;
		
  }
  public ArrayList<Vaga> retrieveVagasMedico(Medico usuario) throws MeuProjetoException{
  	ArrayList<Vaga> vagas = new ArrayList<Vaga>();
  	try {
  		vagas = vagaDAO.retrieveVagasMedico(usuario);
		} catch (Exception e){
				throw new MeuProjetoException("Erro ao conectar com o servidor");			
		}
  	return vagas;
  }
  public void updateVaga(Usuario usuario,Animal animal,Vaga vaga) throws MeuProjetoException{
	  try {
		   vagaDAO.updateVaga(usuario, animal, vaga);
	} catch (Exception e) {
		throw new MeuProjetoException(e);
	}
  }
}
