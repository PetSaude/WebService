package br.com.petsaude.usuario.controle;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

import br.com.petsaude.usuario.dominio.Usuario;
import br.com.petsaude.usuario.persistencia.UsuarioDAO;
import br.com.petsaude.util.MeuProjetoException;


public class UsuarioControle {
	private UsuarioDAO dao=UsuarioDAO.getInstance();
	private static final UsuarioControle instance = new UsuarioControle();

    private UsuarioControle() {
        super();
    }

    public static UsuarioControle getInstance(){
        return instance;
    }
    public void inserirUsuario(Usuario usuario)throws Exception{
    	StringBuilder message = new StringBuilder(); 
    	
    	try {
    		usuario.setEmail(usuario.getEmail().toLowerCase());
   		 if((!validarLogin(usuario.getLogin())) || (dao.existeUsuario(usuario))){
   	            message.append("O login já está cadastrado ou tem menos de 4 caracteres.");
   		 }
   	        else if(!validarEmail(usuario.getEmail()) || (dao.existeEmail(usuario))){
   	            message.append("O email digitado não é válido ou já está cadastrado.");
   	            }
   		 if(message.length() > 0){
	                throw new MeuProjetoException(message.toString());
	                }
   	     else{
   	        	dao.inserirUsuario(usuario);
   	        }

		} catch (Exception e) {
			throw new MeuProjetoException(e);
		}
	}
			
	public void atualizarUsuario(Usuario usuario) throws Exception{
		try{
			dao.atualizarUsuario(usuario);
			
		}
		catch(Exception e){
			throw new MeuProjetoException(e);
		}
	}
	
	public void excluirUsuario(Usuario usuario) throws Exception{
		try{
			dao.excluirUsuario(usuario);
			
		}catch(Exception e){		
			throw new MeuProjetoException(e);
		}
		
	}
	
	public Usuario login(String login, String senha) throws Exception{
		Usuario retorno = null;
		try{
			if(dao.login(login,senha)!=null){
				retorno = dao.login(login,senha);
			}
		}catch(Exception e){
			throw new MeuProjetoException(e);
		}
			 
		return retorno;
	}

	public ArrayList<Usuario> buscarTodosUsuarios() throws Exception{
		ArrayList<Usuario> retorno = null;
		try{
			if(dao.buscarTodosUsuarios()!=null){
				retorno = dao.buscarTodosUsuarios();
			}
		}catch(Exception e){
			throw new MeuProjetoException(e);
		}
			 
		return retorno;
	}
	
	public Usuario BuscarUsuarioPorID(int id) throws Exception{
		Usuario retorno=null;
		try{
			if(dao.BuscarUsuarioPorID(id)!=null){
				retorno=dao.BuscarUsuarioPorID(id);
			}
			
		}catch(Exception e){
			throw new MeuProjetoException(e);
		}
		return retorno;
		
	}
	
	 public boolean validarEmail(String email) {
	        boolean validadeEmail = false;
	        if (email != null && email.length() > 0) {
	            String expression = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	            Matcher matcher = pattern.matcher(email);
	            if (matcher.matches()) {
	                validadeEmail = true;
	            }
	        }
	        return validadeEmail;
	    }

	    public boolean validarLogin(String usuario) {
	        boolean LoginValido = false;
	        if ((usuario.length() < 25) && (usuario.length() >= 4)) {LoginValido = true;}
	        return LoginValido;
	    }
    
    
    
    
    
    
    
}
