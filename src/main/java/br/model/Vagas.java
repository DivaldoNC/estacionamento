package br.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vagas {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String idVaga;
	private boolean status;
	
	
	public String getIdVaga() {
		return idVaga;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	
	public void setIdVaga(String idVaga) {
		this.idVaga = idVaga;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	//Metodos

	
	
}
