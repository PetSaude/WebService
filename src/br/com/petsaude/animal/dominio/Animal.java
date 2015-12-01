package br.com.petsaude.animal.dominio;

public class Animal {

	
    private int id;
    private int idUsuario;
    public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	private String nome;
    private String raca;
    private String dataNasc;
    private int peso;
    private String prontuario;
    

	public String getProntuario() {
		return prontuario;
	}


	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}


	public Animal(){
    	
    }

    
    public Animal(int id, String nome, String genero, String raca, String dataNasc, int peso, String sexo,
			String cor) {
		super();
		this.id = id;
		//this.usuario = usuario;
		this.nome = nome;
		this.raca = raca;
		this.dataNasc = dataNasc;
		this.peso = peso;
		
	}


	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

