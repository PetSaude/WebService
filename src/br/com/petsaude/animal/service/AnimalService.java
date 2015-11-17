package br.com.petsaude.animal.service;

import java.util.ArrayList;

import br.com.petsaude.animal.controle.AnimalControle;
import br.com.petsaude.animal.dominio.Animal;
import br.com.petsaude.usuario.dominio.Usuario;
import br.com.petsaude.util.MeuProjetoException;

public class AnimalService {
	AnimalControle controle= AnimalControle.getInstance();
	public void inserirAnimal(Animal animal,Usuario usuario) throws MeuProjetoException{
		try{
			controle.inserirAnimal(animal,usuario);
		}catch(Exception e){
			throw new MeuProjetoException(e);
		}
	}
			
	public void atualizarAnimal(Animal animal) throws MeuProjetoException{
		try {
			controle.atualizarAnimal(animal);
		} catch (Exception e) {
			throw new MeuProjetoException(e);
		}
	}
	
	public void excluirAnimal(Animal animal) throws MeuProjetoException{
		try {
			controle.excluirAnimal(animal);
		} catch (Exception e) {
			throw new MeuProjetoException(e);
		}
	}
	
	public ArrayList<Animal> buscarTodosAnimais(Usuario usuario) throws MeuProjetoException{
		ArrayList<Animal> retorno=null;
		try {
	
				retorno= controle.buscarTodosAnimais(usuario);
			
		} catch (Exception e) {
			throw new MeuProjetoException(e);
		}
		return retorno;
	}
	
	public Animal buscarAnimalPorID(int id) throws MeuProjetoException{
		try {
			return controle.buscarAnimalPorID(id);
		} catch (Exception e) {
			throw new MeuProjetoException(e);
		}
	}
	public boolean existeAnimal(Animal animal ,Usuario usuario) throws MeuProjetoException{
		boolean retorno = false;
		
		try {
		
			retorno=controle.existeAnimal(animal,usuario);
			
		} catch (Exception e) {
			throw new MeuProjetoException(e);
		}
		return retorno;
	}
	
}
