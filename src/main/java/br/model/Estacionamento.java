package br.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Estacionamento {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private String endereco;
	
	@OneToMany
	@JoinColumn(name = "estacionamento_id")// acrescentei o joincolumn para ele não criar a terceira tabela
	private Collection<Cartao> objCartao =new ArrayList<Cartao>();

	@OneToMany
	@JoinColumn(name = "estacionamento_id")// acrescentei o joincolumn para ele não criar a terceira tabela
	private Collection<Vagas> objVagas =new ArrayList<Vagas>();
	
	 

	//Metodos
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Collection<Vagas> getObjVagas() {
		return objVagas;
	}
		
	public void setObjVagas(Vagas vagas) {
		this.objVagas.add(vagas);
	}

	
	public Collection<Cartao> getObjCartao() {
		return objCartao;
	}

	public void setObjCartao(Cartao objCartao) {
		this.objCartao.add(objCartao);
	}


	/*
	public void setObjCartao(Collection<Cartao> objCartao) {
		this.objCartao = objCartao;
	}
	
	public void setObjVagas(Collection<Vagas> vagas) {
		this.objVagas = vagas;
	}
*/
	
	
}
