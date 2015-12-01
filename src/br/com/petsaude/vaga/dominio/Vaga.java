package br.com.petsaude.vaga.dominio;

import java.util.Date;

import br.com.petsaude.medico.dominio.Medico;

public class Vaga {
	 private int id;
	 private String data;
	 private String status;
	 private Medico medico;
	 private int idAnimal;
	 private int idUsuario;
	 public int getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public int getIdClinica() {
		return idClinica;
	}
	public void setIdClinica(int idClinica) {
		this.idClinica = idClinica;
	}
	private int idClinica;
		
}
