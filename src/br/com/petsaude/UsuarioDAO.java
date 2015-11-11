package br.com.petsaude;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO {

	
	public boolean inserirUsuario(Usuario usuario){
		try{
			Connection con = ConectaMysql.obtemConexao();
			String queryInserir = "INSERT INTO usuario VALUES(null,?,?,?,?)";
			PreparedStatement ppstm = con.prepareStatement(queryInserir);
			
			ppstm.setString(1, usuario.getLogin());
			ppstm.setString(2, usuario.getEmail());
			ppstm.setString(3, usuario.getNome());
			ppstm.setString(4, usuario.getSenha());
			
			ppstm.executeUpdate();
			
			con.close();
			}catch (Exception e){
				e.printStackTrace();
				return false;
			}
		return true;
	}
			
	public boolean atualizarUsuario(Usuario usuario){
		try{
			Connection con = ConectaMysql.obtemConexao();
			String queryAtualizar = "UPDATE usuario SET login = ?, email = ?, nome = ?, senha = ? WHERE id = ?";
			PreparedStatement ppstm = con.prepareStatement(queryAtualizar);
			
			ppstm.setString(1, usuario.getLogin());
			ppstm.setString(2, usuario.getEmail());
			ppstm.setString(3, usuario.getNome());
			ppstm.setString(4, usuario.getSenha());
			ppstm.setInt(5, usuario.getId());
			
			ppstm.executeUpdate();
			
			con.close();
			}catch (Exception e){
				e.printStackTrace();
				return false;
			}
		return true;
	}
	
	public boolean excluirUsuario(Usuario usuario){
		try{
			Connection con = ConectaMysql.obtemConexao();
			String queryDeletar = "DELETE FROM usuario WHERE id = ?";
			PreparedStatement ppstm = con.prepareStatement(queryDeletar);
			
			ppstm.setInt(1, usuario.getId());
			
			ppstm.executeUpdate();
			
			con.close();
			}catch (Exception e){
				e.printStackTrace();
				return false;
			}
		return true;	
	}
	
	public ArrayList<Usuario> buscarTodosUsuarios(){
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		try{
			Connection con = ConectaMysql.obtemConexao();
			String queryBuscaTodos = "SELECT * FROM usuario";
			PreparedStatement ppstm = con.prepareStatement(queryBuscaTodos);
			
			ResultSet resultado = ppstm.executeQuery();
			
			while(resultado.next()){
				Usuario usr = new Usuario();
				usr.setId(resultado.getInt(1));
				usr.setLogin(resultado.getString(2));
				usr.setEmail(resultado.getString(3));
				usr.setNome(resultado.getString(4));
				usr.setSenha(resultado.getString(5));
				
				lista.add(usr);
			}
			con.close();
			
		} catch (Exception e){
				e.printStackTrace();			
		}
		
		return lista;
	}
	
	public Usuario BuscarUsuarioPorID(int id){
		
		Usuario usr = null;
		
		try{
			Connection con = ConectaMysql.obtemConexao();
			String queryBuscaID = "SELECT * FROM usuario WHERE id = ?";
			PreparedStatement ppstm = con.prepareStatement(queryBuscaID);
			
			ppstm.setInt(1, id);
			
			ResultSet resultado = ppstm.executeQuery();
			
			if(resultado.next()){
				usr = new Usuario();
				usr.setId(resultado.getInt(1));
				usr.setLogin(resultado.getString(2));
				usr.setEmail(resultado.getString(3));
				usr.setNome(resultado.getString(4));
				usr.setSenha(resultado.getString(5));
			}else{
				return usr;
			}
			con.close();
			
		}catch (Exception e){
				e.printStackTrace();			
			}
		
		return usr;	
	}
	
	public boolean excluirUsuario(int id){
		
		return excluirUsuario(new Usuario(id,"","","",""));
	}
}
