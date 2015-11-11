package br.com.petsaude;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AnimalDAO {


	public boolean inserirAnimal(Animal animal){
		try{
			Connection con = ConectaMysql.obtemConexao();
			String queryInserir = "INSERT INTO animal VALUES(null,?,?,?,?,?,?)";
			PreparedStatement ppstm = con.prepareStatement(queryInserir);
			
			ppstm.setString(1, animal.getNome());
			ppstm.setString(2, animal.getRaca());
			ppstm.setString(3, animal.getDataNasc());
			ppstm.setInt(4, animal.getPeso());
			ppstm.setString(5, animal.getSexo());
			ppstm.setString(6, animal.getCor());
			
			ppstm.executeUpdate();
			
			con.close();
			}catch (Exception e){
				e.printStackTrace();
				return false;
			}
		return true;
	}
			
	public boolean atualizarAnimal(Animal animal){
		try{
			Connection con = ConectaMysql.obtemConexao();
			String queryAtualizar = "UPDATE animal SET nome = ?, raca = ?, dataNasc = ?, peso = ?, sexo = ?, cor = ? WHERE id = ?";
			PreparedStatement ppstm = con.prepareStatement(queryAtualizar);
			
			ppstm.setString(1, animal.getNome());
			ppstm.setString(2, animal.getRaca());
			ppstm.setString(3, animal.getDataNasc());
			ppstm.setInt(4, animal.getPeso());
			ppstm.setString(5, animal.getSexo());
			ppstm.setString(6, animal.getCor());
			ppstm.setInt(7, animal.getId());
			
			ppstm.executeUpdate();
			
			con.close();
			}catch (Exception e){
				e.printStackTrace();
				return false;
			}
		return true;
	}
	
	public boolean excluirAnimal(Animal animal){
		try{
			Connection con = ConectaMysql.obtemConexao();
			String queryDeletar = "DELETE FROM animal WHERE id = ?";
			PreparedStatement ppstm = con.prepareStatement(queryDeletar);
			
			ppstm.setInt(1, animal.getId());
			
			ppstm.executeUpdate();
			
			con.close();
			}catch (Exception e){
				e.printStackTrace();
				return false;
			}
		return true;	
	}
	
	public ArrayList<Animal> buscarTodosAnimais(){
		ArrayList<Animal> lista = new ArrayList<Animal>();
		
		try{
			Connection con = ConectaMysql.obtemConexao();
			String queryBuscaTodos = "SELECT * FROM animal";
			PreparedStatement ppstm = con.prepareStatement(queryBuscaTodos);
			
			ResultSet resultado = ppstm.executeQuery();
			
			while(resultado.next()){
				Animal anim = new Animal();
				anim.setId(resultado.getInt(1));
				anim.setNome(resultado.getString(2));
				anim.setRaca(resultado.getString(3));
				anim.setDataNasc(resultado.getString(4));
				anim.setPeso(resultado.getInt(5));
				anim.setSexo(resultado.getString(6));
				anim.setCor(resultado.getString(7));
				
				lista.add(anim);
			}
			con.close();
			
		} catch (Exception e){
				e.printStackTrace();			
		}
		
		return lista;
	}
	
	public Animal BuscarAnimalPorID(int id){
		
		Animal anim = null;
		
		try{
			Connection con = ConectaMysql.obtemConexao();
			String queryBuscaID = "SELECT * FROM animal WHERE id = ?";
			PreparedStatement ppstm = con.prepareStatement(queryBuscaID);
			
			ppstm.setInt(1, id);
			
			ResultSet resultado = ppstm.executeQuery();
			
			if(resultado.next()){
				anim = new Animal();
				anim.setId(resultado.getInt(1));
				anim.setNome(resultado.getString(2));
				anim.setRaca(resultado.getString(3));
				anim.setDataNasc(resultado.getString(4));
				anim.setPeso(resultado.getInt(5));
				anim.setSexo(resultado.getString(6));
				anim.setCor(resultado.getString(7));
			}else{
				return anim;
			}
			con.close();
			
		}catch (Exception e){
				e.printStackTrace();			
			}
		
		return anim;	
	}
	
	public boolean excluirAnimal(int id){
		
		return excluirAnimal(new Animal(id,"","","","",0,"",""));
	}
	
}
