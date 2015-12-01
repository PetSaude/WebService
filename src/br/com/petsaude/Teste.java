package br.com.petsaude;

import java.util.ArrayList;

import sun.print.resources.serviceui;
import br.com.petsaude.animal.dominio.Animal;
import br.com.petsaude.animal.service.AnimalService;
import br.com.petsaude.clinica.dominio.Clinica;
import br.com.petsaude.clinica.service.ClinicaService;
import br.com.petsaude.medico.dominio.Medico;
import br.com.petsaude.medico.service.MedicoService;
import br.com.petsaude.usuario.dominio.Usuario;
import br.com.petsaude.usuario.service.UsuarioService;
import br.com.petsaude.vaga.dominio.Vaga;
import br.com.petsaude.vaga.service.VagaService;



public class Teste {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		UsuarioService usuario=new UsuarioService();
		Usuario userUsuario= new Usuario();
		AnimalService animalService=new AnimalService();
		Animal animal=new Animal();
		animal.setNome("mel");
		animal.setRaca("vira-vira");
		animal.setDataNasc("30-10-1991");
		animal.setPeso(40);
		animal.setProntuario("prontuario");
		animal.setId(13);
		//userUsuario.setEmail("indodddliveira@gmail.com");
		//userUsuario.setSenha("ikkkkju");
		userUsuario.setLogin("sdira");
		//userUsuario.setNome("Dira Oliveira");
		userUsuario.setId(3);
		ClinicaService clinicaService = new ClinicaService();
		ArrayList<Clinica> clin=clinicaService.retrieveClinicas();
		
	
		try {	
			 Usuario  usr= new Usuario();
			 usr.setId(1);
			UsuarioService us = new UsuarioService();
			Usuario user = us.login("Alex","bispo");
			System.out.println(user.getNome());
			System.out.println(user.getId());
			
				//animalService.atualizarAnimal(animal);
			
			//animalService.inserirAnimal(animal, userUsuario);
			
			}
	
		catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
	

	}

}
