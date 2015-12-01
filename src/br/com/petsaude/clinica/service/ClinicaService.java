package br.com.petsaude.clinica.service;

import java.util.ArrayList;

import br.com.petsaude.clinica.dominio.Clinica;
import br.com.petsaude.clinica.persistencia.ClinicaDAO;
import br.com.petsaude.util.MeuProjetoException;

public class ClinicaService {
		private static final ClinicaDAO clinicaDAO= ClinicaDAO.getInstance();
		
		 public ArrayList<Clinica> retrieveClinicas() throws MeuProjetoException{
			 try {
				return clinicaDAO.retrieveClinicas();
			} catch (Exception e) {
				throw new MeuProjetoException(e);
			}
		 }
		 public Clinica getClinica(int id) throws MeuProjetoException{
			 Clinica clinica = null;
			 try {
				clinica = clinicaDAO.getClinica(id);
			} catch (Exception e) {
				throw new MeuProjetoException(e);
			}
			 return clinica;
		 }
}
