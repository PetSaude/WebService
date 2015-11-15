package br.com.petsaude.animal.dominio;

public class Animal {

	
    private int id;
    private int usuario;
    private String nome;
    private String raca;
    private String dataNasc;
    private int peso;
    private String sexo;
    private String cor;

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
		this.sexo = sexo;
		this.cor = cor;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
}

