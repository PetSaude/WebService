package br.com.petsaude.animal.controle;

import java.util.ArrayList;

import br.com.petsaude.animal.dominio.Animal;
import br.com.petsaude.animal.persistencia.AnimalDAO;
import br.com.petsaude.usuario.dominio.Session;
import br.com.petsaude.usuario.dominio.Usuario;
import br.com.petsaude.util.MeuProjetoException;

public class AnimalControle {
	private static final AnimalControle instance = new AnimalControle();

    private AnimalControle() {
        super();
    }

    public static AnimalControle getInstance(){
        return instance;
    }
	AnimalDAO dao=AnimalDAO.getInstance();
	public void inserirAnimal(Animal animal) throws MeuProjetoException{
		StringBuilder message = new StringBuilder();
		try{
			if(existeAnimal(animal,Session.getUsuarioLogado())){
				message.append("você já possui um animal cadastrado com esse nome");
			}
			if(message.length() > 0){throw new MeuProjetoException(
	                message.toString());}
			else{
				
				animal.setUsuario(Session.getUsuarioLogado().getId());
				dao.inserirAnimal(animal);
			}
		}catch(Exception e){
			throw new MeuProjetoException(e);
		}
	}
	public boolean existeAnimal(Animal animal,Usuario usuario) throws MeuProjetoException{
		boolean retorno = false;
		
		try {
			if(dao.existeAnimal(animal,usuario)){
				retorno=dao.existeAnimal(animal,usuario);
			}
			
		} catch (Exception e) {
			throw new MeuProjetoException(e);
		}
		return retorno;
	}
			
	public void atualizarAnimal(Animal animal) throws MeuProjetoException{
		try {
			dao.atualizarAnimal(animal);
		} catch (Exception e) {
			throw new MeuProjetoException(e);
		}
	}
	
	public void excluirAnimal(Animal animal) throws MeuProjetoException{
		try {
			dao.excluirAnimal(animal);
		} catch (Exception e) {
			throw new MeuProjetoException(e);
		}
	}
	
	public ArrayList<Animal> buscarTodosAnimais(Usuario usuario) throws MeuProjetoException{
		ArrayList<Animal> retorno=null;
		try {
			if(Session.getUsuarioLogado()!=null){
				retorno= dao.buscarTodosAnimais(Session.getUsuarioLogado());
			}
			
		} catch (Exception e) {
			throw new MeuProjetoException(e);
		}
		return retorno;
	}
	
	public Animal buscarAnimalPorID(int id) throws MeuProjetoException{
		try {
			return dao.buscarAnimalPorID(id);
		} catch (Exception e) {
			throw new MeuProjetoException(e);
		}
	}
}
