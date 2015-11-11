package br.com.petsaude.usuario.dominio;
import br.com.petsaude.usuario.dominio.Usuario;

public class Session {

    public static Usuario usuarioLogado;
    public static void setUsuarioLogado(Usuario usuario){
        usuarioLogado = usuario;
    }

    public static Usuario getUsuarioLogado(){
        return usuarioLogado;
    }
}
