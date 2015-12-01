package br.com.petsaude.usuario.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.petsaude.usuario.dominio.Usuario;
import br.com.petsaude.util.ConectaMysql;
import br.com.petsaude.util.MeuProjetoException;

public class UsuarioDAO {
	private static final UsuarioDAO instance = new UsuarioDAO();

    private UsuarioDAO() {
        super();
    }

    public static UsuarioDAO getInstance(){
        return instance;
    }

	
	public void inserirUsuario(Usuario usuario) throws MeuProjetoException{
		try{
			Connection con = ConectaMysql.obtemConexao();
			String queryInserir = "INSERT INTO usuario VALUES(null,?,?,?,?,?)";
			PreparedStatement ppstm = con.prepareStatement(queryInserir);
			
			ppstm.setString(1, usuario.getLogin());
			ppstm.setString(2, usuario.getEmail());
			ppstm.setString(3, usuario.getNome());
			ppstm.setString(4, usuario.getSenha());
			ppstm.setInt(5,0);
			
			
			ppstm.executeUpdate();
			
			con.close();
			}catch (Exception e){
				e.printStackTrace();
			
			}
	}
	public void alterarSenha(String senha,Usuario usuario) throws MeuProjetoException{
		try{
			Connection con = ConectaMysql.obtemConexao();
			String queryAtualizar = "UPDATE usuario SET senha = ? WHERE id = ?";
			PreparedStatement ppstm = con.prepareStatement(queryAtualizar);
			ppstm.setString(1,senha);
			ppstm.setInt(2,usuario.getId());
			ppstm.execute();
		}catch(Exception e){
			throw new MeuProjetoException("impossivel alterar senha");
		}
	}
	public void alterarEmail(String email,Usuario usuario) throws MeuProjetoException{
		try{
			Connection con = ConectaMysql.obtemConexao();
			String queryAtualizar = "UPDATE usuario SET email = ? WHERE id = ?";
			PreparedStatement ppstm = con.prepareStatement(queryAtualizar);
			ppstm.setString(1,email);
			ppstm.setInt(2,usuario.getId());
			ppstm.execute();
		}catch(Exception e){
			throw new MeuProjetoException("impossivel alterar email");
		}
		
}
	public void atualizarUsuario(Usuario usuario) throws MeuProjetoException{
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
				throw new MeuProjetoException("Erro ao conectar com o servidor");
				
				
			}

	}
	
	public void excluirUsuario(Usuario usuario) throws MeuProjetoException{
		
		try{
			
			Connection con = ConectaMysql.obtemConexao();
			String queryDeletar = "DELETE FROM usuario WHERE id = ?";
			PreparedStatement ppstm = con.prepareStatement(queryDeletar);
			ppstm.setInt(1, usuario.getId());
			ppstm.executeUpdate();
			con.close();
			}catch (Exception e){
				throw new MeuProjetoException("Erro ao conectar com o servidor");
				
			}	
	}
	public boolean existeUsuario(Usuario usuario) throws MeuProjetoException{
		boolean condicao=false;
		try {
			Connection con = ConectaMysql.obtemConexao();
			String queryBuscarUsuario="SELECT login FROM usuario WHERE login= ?" ;
			PreparedStatement ppstm = con.prepareStatement(queryBuscarUsuario);
			ppstm.setString(1, usuario.getLogin());
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
	public boolean existeEmail(Usuario usuario) throws MeuProjetoException{
		boolean condicao=false;
		try {
			Connection con = ConectaMysql.obtemConexao();
			String queryBuscarUsuario="SELECT email FROM usuario WHERE email= ?" ;
			PreparedStatement ppstm = con.prepareStatement(queryBuscarUsuario);
			ppstm.setString(1, usuario.getEmail());
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
	
	public Usuario login(String login, String senha) throws MeuProjetoException{
			
			Usuario retorno = null;
			try {
				Connection con = ConectaMysql.obtemConexao();
				String queryBuscarUsuario="SELECT * FROM usuario WHERE login= ? and senha = ?" ;
				PreparedStatement ppstm = con.prepareStatement(queryBuscarUsuario);
				ppstm.setString(1,login);
				ppstm.setString(2,senha);
				
				ResultSet resultado = ppstm.executeQuery();
				while(resultado.next()){
						if (resultado.getInt(6)==0){
							Usuario usr=new Usuario();
							usr.setId(resultado.getInt(1));
							usr.setLogin(resultado.getString(2));
							usr.setEmail(resultado.getString(3));
							usr.setNome(resultado.getString(4));
							usr.setSenha(resultado.getString(5));
							retorno=usr;
						}
						else{
							return retorno;
						}
						
					
				}
				con.close();
			}catch(Exception e){
				e.printStackTrace();
				}
					
				return retorno;
			}
			
			

	public ArrayList<Usuario> buscarTodosUsuarios() throws MeuProjetoException{
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
				throw new MeuProjetoException("Erro ao conectar com o servidor");			
		}
		
		return lista;
	}
	
	public Usuario BuscarUsuarioPorID(int id) throws MeuProjetoException{
		
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
			throw new MeuProjetoException("Erro ao conectar com o servidor");			
			}
		
		return usr;	
	}
	
}
