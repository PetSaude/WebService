package br.com.petsaude.animal.controle;

import java.util.ArrayList;

import br.com.petsaude.animal.dominio.Animal;
import br.com.petsaude.animal.persistencia.AnimalDAO;
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
	public void inserirAnimal(Animal animal,Usuario usuario) throws MeuProjetoException{
		StringBuilder message = new StringBuilder();
		try{
			if(existeAnimal(animal,usuario)){
				message.append("você já possui um animal cadastrado com esse nome");
			}
			if(message.length() > 0){throw new MeuProjetoException(
	                message.toString());}
			else{
				dao.inserirAnimal(animal,usuario);
			}
		}catch(Exception e){
			throw new MeuProjetoException(e);
		}
	}
	public boolean existeAnimal(Animal animal,Usuario usuario) throws MeuProjetoException{
		boolean retorno = false;
		
		try {
			retorno=dao.existeAnimal(animal,usuario);
	
			
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

				retorno= dao.buscarTodosAnimais(usuario);
			
			
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
	public void atualizaProntuario(String prontuario,int id){
		try {
			dao.atualizaProntuario(prontuario, id);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
