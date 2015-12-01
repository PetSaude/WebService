package br.com.petsaude.usuario.service;

import java.util.ArrayList;

import br.com.petsaude.usuario.controle.UsuarioControle;
import br.com.petsaude.usuario.dominio.Usuario;
import br.com.petsaude.util.MeuProjetoException;

public class UsuarioService{
	
	private UsuarioControle controle =UsuarioControle.getInstance();
	
	
	public void inserirUsuario(Usuario usuario)throws Exception{
			controle.inserirUsuario(usuario);
		
		
	}
	public Usuario login(String login,String senha) throws Exception{
		return controle.login(login, senha);
		
		
	}
	public void excluirUsuario(Usuario usuario) throws Exception{
			controle.excluirUsuario(usuario);
		
	}	
	public void atualizarUsuario(Usuario usuario) throws Exception{
			controle.atualizarUsuario(usuario);
		
		
		
	}
	public boolean existeEmail(Usuario usuario) throws Exception{
		boolean retorno=false;
		if(controle.existeEmail(usuario)){
			retorno=true;
		}
		return retorno;
	}
	public boolean existeUsuario(Usuario usuario) throws MeuProjetoException{
		boolean retorno =false;
		try {
			if(controle.existeUsuario(usuario)){
				retorno=true;
			}
		} catch (Exception e) {
			throw new MeuProjetoException(e);
		}
		return retorno;
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
	public void alterarSenha(String senha,Usuario usuario) throws MeuProjetoException{
			controle.alterarSenha(senha,usuario);
		
	}
	public void alterarEmail(String email,Usuario usuario) throws MeuProjetoException{
		controle.alterarEmail(email,usuario);
	}
}
