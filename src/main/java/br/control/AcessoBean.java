package br.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.model.Acesso;
import br.model.Usuario;
import br.persistencia.AcessoDAO;
import br.persistencia.UsuarioDAO;



@ManagedBean(name = "acessoBean")
@SessionScoped
public class AcessoBean implements Serializable{
	private Acesso objA;
	private Acesso objA1;
	private Usuario objU;
	
	private AcessoDAO objADAO;
	private UsuarioDAO objUDAO;
	
	private List<Acesso>  objAL;
	private List<Acesso>  objAL1;	
	private List<Usuario>  objUL;
		
	private String dataHoraEntrada;
	private String dataHoraSaida;
	private String status;         //boolean
	private String cpf;        
	
	public AcessoBean(){
		objA= new Acesso();
		objA1= new Acesso();
		objU= new Usuario();
		objADAO = new AcessoDAO();
		objUDAO = new UsuarioDAO();
		objAL = new ArrayList<Acesso>();
		objAL1 = new ArrayList<Acesso>();
		objUL = new ArrayList<Usuario>();
		
		//this.listarAcesso();
	}
	
public String botaoPesquisarAcesso(){
		int contU=0;
		int contA=0;
		
		objUL=objUDAO.researchAll();    //lista de usuarios
		objAL1=objADAO.researchAll();   
				
		for(Usuario u: objUL){
			if((u.getCpf().equals(this.cpf))){

				break;
			}
			contU++;
		}
		for(Acesso a: objAL1){
			if(contA==contU){
				objA1.setDataHoraEntrada(a.getDataHoraEntrada());
				objA1.setDataHoraSaida(a.getDataHoraSaida());
				objA1.setStatus(a.getStatus());
				
				objAL.add(objA1);
				
				this.cpf="";
				return "acessosCRUD.xhtml?faces-redirect=true";
			}
				contA++;
		}
		this.cpf="";
		return "erro.xhtml?faces-redirect=true";
}
	
//Metodos Gest e Sets	
public List<Acesso> getObjAL() {
	return objAL;
}

public void setObjAL(List<Acesso> objAL) {
	this.objAL = objAL;
}


public String getDataHoraEntrada() {
	return dataHoraEntrada;
}

public void setDataHoraEntrada(String dataHoraEntrada) {
	this.dataHoraEntrada = dataHoraEntrada;
}

public String getDataHoraSaida() {
	return dataHoraSaida;
}

public void setDataHoraSaida(String dataHoraSaida) {
	this.dataHoraSaida = dataHoraSaida;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}	
	
	
	
	
	
	
	
	
	
}











