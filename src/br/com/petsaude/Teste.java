package br.com.petsaude;

import java.util.ArrayList;

import br.com.petsaude.animal.dominio.Animal;
import br.com.petsaude.animal.service.AnimalService;
import br.com.petsaude.usuario.controle.UsuarioControle;
import br.com.petsaude.usuario.dominio.Session;
import br.com.petsaude.usuario.dominio.Usuario;
import br.com.petsaude.usuario.persistencia.UsuarioDAO;
import br.com.petsaude.usuario.service.UsuarioService;
import br.com.petsaude.util.MeuProjetoException;


public class Teste {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AnimalService service = new AnimalService();
		UsuarioService usuario=new UsuarioService();
		usuario.login("Alex","12345");
		Animal animal= new Animal();
		animal.setNome("Nino");
		animal.setRaca("vira-lata");
		animal.setDataNasc("22222");
		animal.setPeso(15);
		animal.setSexo("M");
		animal.setCor("Branco");
		animal.setId(10);
		
		try {
				service.atualizarAnimal(animal);
				System.out.println("atualizado");
			
			}
	
		catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
	

	}

}
