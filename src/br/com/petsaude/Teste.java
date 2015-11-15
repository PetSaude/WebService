package br.com.petsaude;

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
		animal.setNome("totozin");
		animal.setRaca("vira-vira");
		animal.setDataNasc("30-10-1991");
		animal.setPeso(40);
		animal.setSexo("M");
		animal.setCor("azul");

		userUsuario.setEmail("Rodolfo@gmail.com");
		userUsuario.setSenha("1234");
		userUsuario.setLogin("dolfo");
		userUsuario.setNome("Rodolfo");
		userUsuario.setId(3);
	
		try {
			usuario.login("dolfo","1234");
			animalService.inserirAnimal(animal, userUsuario);
			}
	
		catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
	

	}

}
