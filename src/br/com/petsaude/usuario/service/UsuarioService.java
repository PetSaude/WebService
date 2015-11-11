package br.com.petsaude.usuario.service;

import java.util.ArrayList;

import br.com.petsaude.usuario.controle.UsuarioControle;
import br.com.petsaude.usuario.dominio.Usuario;
import br.com.petsaude.util.MeuProjetoException;

public class UsuarioService{
	
	private UsuarioControle controle =UsuarioControle.getInstance();
	
	
	public void inserirUsuario(Usuario usuario)throws MeuProjetoException{
		try{
			controle.inserirUsuario(usuario);
		}catch (Exception e){
			throw new MeuProjetoException(e);
		}
		
	}
	public Usuario login(String login,String senha) throws MeuProjetoException{
		Usuario retorno = null;
		try {
			retorno= controle.login(login, senha);
		} catch (Exception e) {
			throw new MeuProjetoException(e);
		}
		return retorno;
		
	}
	public void excluirUsuario(Usuario usuario) throws MeuProjetoException{
		try{
			controle.excluirUsuario(usuario);
			
		}catch(Exception e){		
			throw new MeuProjetoException(e);
		}
	}	
	public void atualizarUsuario(Usuario usuario) throws MeuProjetoException{
		try {
			controle.atualizarUsuario(usuario);
		} catch (Exception e) {
			throw new MeuProjetoException(e);
		}
		
		
	}
	
	public ArrayList<Usuario> buscarTodosUsuarios() throws MeuProjetoException{
		ArrayList<Usuario> retorno=null;
		try {
			retorno=controle.buscarTodosUsuarios();
		} catch (Exception e) {
			throw new MeuProjetoException(e);
		}
		return retorno;
		
	}
}
