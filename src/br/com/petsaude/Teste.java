package br.com.petsaude;

import sun.print.resources.serviceui;
import br.com.petsaude.animal.dominio.Animal;
import br.com.petsaude.animal.service.AnimalService;
import br.com.petsaude.usuario.dominio.Usuario;
import br.com.petsaude.usuario.service.UsuarioService;



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
		animal.setSexo("M");
		animal.setCor("azul");
		animal.setGenero("labrador");
		
		userUsuario.setEmail("indiravoliveira@gmail.com");
		userUsuario.setSenha("indijuju");
		userUsuario.setLogin("didira");
		userUsuario.setNome("Indira Oliveira");
		userUsuario.setId(4);
	
		try {
					if(animalService.existeAnimal(animal, userUsuario)){
						System.out.println("true");
					}
			//animalService.inserirAnimal(animal, userUsuario);
			
			}
	
		catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
	

	}

}
