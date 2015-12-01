package br.com.petsaude.medico.service;


import br.com.petsaude.medico.dominio.Medico;
import br.com.petsaude.medico.persistencia.MedicoDAO;
import br.com.petsaude.util.MeuProjetoException;


public class MedicoService {
	private static  final MedicoDAO medicoDAO = MedicoDAO.getInstance();
	 public Medico getMedico(int id) throws MeuProjetoException{
    	 Medico retorno=null;
    	 try {
    		 retorno = medicoDAO.getMedico(id);
		} catch (Exception e) {
			throw new MeuProjetoException("erro no servidor");
		}
		return retorno;
     }
     public Medico login(String login, String senha) throws MeuProjetoException{
			
			Medico retorno = null;
			try {
				retorno =medicoDAO.login(login, senha);
			}catch(Exception e){
				throw  new MeuProjetoException("erro ao conectar com o servidor");
				}
					
				return retorno;
			}
			

}
