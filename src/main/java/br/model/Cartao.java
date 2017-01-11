package br.model;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cartao {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String idCartao;
	private boolean status;
	
	
	@OneToMany
	@JoinColumn(name = "cartao_id")// acrescentei o joincolumn para ele não criar a terceira tabela
	private Collection<Acesso> objAcesso =new ArrayList<Acesso>();
	
	
	//pag 32 livro k19 - Figura 2.14
	@OneToOne(mappedBy="cartao")   //Bidirecional - "mappedBY" define o mesmo relacionamento na outra entidade
	private Usuario usuario;
	

	//Metodos
	public Usuario getObjUsuario() {
		return usuario;
	}

	public void setObjUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public String getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(String idCartao) {
		this.idCartao = idCartao;
	}
	
	
	public Collection<Acesso> getObjAcesso() {
		return objAcesso;
	}


	public void setObjAcesso(Acesso objAcesso) {
		this.objAcesso.add(objAcesso);
	}
	/*
	public void setObjAcesso(Collection<Acesso> objAcesso) {
		this.objAcesso = objAcesso;
	}
	*/

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	




	
	
}
