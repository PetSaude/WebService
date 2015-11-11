package br.com.petsaude.usuario.dominio;

public class Usuario {
	
	private int id;
	private String login;
	private String email;
	private String nome;
	private String senha;
	
	public Usuario(){
		
	}

	public Usuario(int id, String login, String email, String nome, String senha) {
		super();
		this.id = id;
		this.login = login;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
		
	
	

