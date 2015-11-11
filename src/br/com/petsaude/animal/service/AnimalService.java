package br.com.petsaude.animal.service;

import java.util.ArrayList;

import br.com.petsaude.animal.controle.AnimalControle;
import br.com.petsaude.animal.dominio.Animal;
import br.com.petsaude.usuario.dominio.Session;
import br.com.petsaude.usuario.dominio.Usuario;
import br.com.petsaude.util.MeuProjetoException;

public class AnimalService {
	AnimalControle controle= AnimalControle.getInstance();
	public void inserirAnimal(Animal animal) throws MeuProjetoException{
		try{
			controle.inserirAnimal(animal);
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
	
	public ArrayList<Animal> buscarTodosAnimais() throws MeuProjetoException{
		ArrayList<Animal> retorno=null;
		try {
			if(Session.getUsuarioLogado()!=null){
				retorno= controle.buscarTodosAnimais(Session.getUsuarioLogado());
			}
			
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
	
}
