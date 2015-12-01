package br.com.petsaude.animal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.petsaude.animal.dominio.Animal;
import br.com.petsaude.usuario.dominio.Usuario;
import br.com.petsaude.util.ConectaMysql;
import br.com.petsaude.util.MeuProjetoException;

public class AnimalDAO {
	private static final AnimalDAO instance = new AnimalDAO();

    private AnimalDAO() {
        super();
    }

    public static AnimalDAO getInstance(){
        return instance;
    }
    public void atualizaProntuario(String prontuario,int id) throws MeuProjetoException{
    	Connection con;
		try {
			con = ConectaMysql.obtemConexao();
			String queryAtualizar = "UPDATE animal SET prontuario = ? WHERE id = ?";
			PreparedStatement ppstm = con.prepareStatement(queryAtualizar);
			ppstm.setString(1,prontuario);
			ppstm.setInt(2,id);
			ppstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new MeuProjetoException("erro no servidor");
		}
		
		
	}
    
    public boolean existeAnimal(Animal animal,Usuario usuario) throws MeuProjetoException{
    	boolean condicao=false;
		try {
			Connection con = ConectaMysql.obtemConexao();
			String queryBuscarUsuario="SELECT * FROM animal WHERE nome= ? and id_animal_usuario= ?";
			PreparedStatement ppstm = con.prepareStatement(queryBuscarUsuario);
			ppstm.setString(1, animal.getNome());
			ppstm.setInt(2,usuario.getId());
			ResultSet resultado = ppstm.executeQuery();
			while(resultado.next()){
				condicao=true;
			}
			con.close();
		}catch(Exception e){
			throw new MeuProjetoException("Erro ao conectar com o servidor");
		}
		return condicao;
    
    }
	public void inserirAnimal(Animal animal,Usuario usuario) throws MeuProjetoException{
		try{
			Connection con = ConectaMysql.obtemConexao();
			String queryInserir = "INSERT INTO animal VALUES(null,?,?,?,?,?,?)";
			PreparedStatement ppstm = con.prepareStatement(queryInserir);
			ppstm.setString(1, animal.getNome());
			ppstm.setString(2, animal.getRaca());
			ppstm.setString(3, animal.getDataNasc());
			ppstm.setInt(4, animal.getPeso());
			ppstm.setInt(5, usuario.getId());
			ppstm.setString(6, animal.getProntuario());
			
			
			ppstm.executeUpdate();
			
			con.close();
			}catch (Exception e){
				throw new MeuProjetoException("Erro ao conectar com o servidor");
			
			}
	}
			
	public void atualizarAnimal(Animal animal) throws MeuProjetoException{
		try{
			Connection con = ConectaMysql.obtemConexao();
			String queryAtualizar = "UPDATE animal SET nome = ?, raca = ?, dataNasc = ?,peso = ? , prontuario = ? WHERE id = ?";
			PreparedStatement ppstm = con.prepareStatement(queryAtualizar);
			
			ppstm.setString(1, animal.getNome());
			ppstm.setString(2, animal.getRaca());
			ppstm.setString(3, animal.getDataNasc());
			ppstm.setInt(4, animal.getPeso());
			ppstm.setString(5, animal.getProntuario());
			ppstm.setInt(6, animal.getId());
			ppstm.executeUpdate();
			
			con.close();
			}catch (Exception e){
				throw new MeuProjetoException("Erro ao conectar com o servidor");
		
			}
	}
	
	public void excluirAnimal(Animal animal) throws MeuProjetoException{
		try{
			Connection con = ConectaMysql.obtemConexao();
			String queryDeletar = "DELETE FROM animal WHERE id = ?";
			PreparedStatement ppstm = con.prepareStatement(queryDeletar);
			
			ppstm.setInt(1, animal.getId());
			
			ppstm.executeUpdate();
			
			con.close();
			}catch (Exception e){
				throw new MeuProjetoException("Erro ao conectar com o servidor");
			}	
	}
	
	public ArrayList<Animal> buscarTodosAnimais(Usuario usuario) throws MeuProjetoException{
		ArrayList<Animal> lista = new ArrayList<Animal>();
		
		try{
			Connection con = ConectaMysql.obtemConexao();
			String queryBuscaTodos = "SELECT * FROM animal where id_animal_usuario = ?";
			PreparedStatement ppstm = con.prepareStatement(queryBuscaTodos);
			ppstm.setInt(1, usuario.getId());
			ResultSet resultado = ppstm.executeQuery();
			
			while(resultado.next()){
				if(resultado.getInt(6)==usuario.getId()){
					Animal anim = new Animal();
					anim.setId(resultado.getInt(1));
					anim.setNome(resultado.getString(2));
					anim.setRaca(resultado.getString(3));
					anim.setDataNasc(resultado.getString(4));
					anim.setPeso(resultado.getInt(5));
					anim.setIdUsuario(resultado.getInt(6));
					anim.setProntuario(resultado.getString(7));
					lista.add(anim);
				}
					
			}
			con.close();
			
		} catch (Exception e){
			throw new MeuProjetoException("Erro ao conectar com o servidor");			
		}
		
		return lista;
	}
	
	public Animal buscarAnimalPorID(int id) throws MeuProjetoException{
		
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
				anim.setIdUsuario(resultado.getInt(6));
				anim.setProntuario(resultado.getString(7));
			}else{
				return anim;
			}
			con.close();
			
		}catch (Exception e){
			throw new MeuProjetoException("Erro ao conectar com o servidor");			
			}
		
		return anim;	
	}
	
}
