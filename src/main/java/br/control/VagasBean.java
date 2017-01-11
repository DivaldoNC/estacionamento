package br.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;




import br.model.Vagas;
import br.persistencia.VagasDAO;

@ManagedBean(name = "vagasBean")
@SessionScoped
public class VagasBean implements Serializable{

	private String idVaga;
	private String status;
	private String quantTotalVagas;
	
	public String getQuantTotalVagas() {
		return quantTotalVagas;
	}

	public void setQuantTotalVagas(String quantTotalVagas) {
		this.quantTotalVagas = quantTotalVagas;
	}
	private VagasDAO objVDAO;
	private Vagas    objV;

	public VagasBean(){
		quantTotalVagas="";
		objV = new Vagas();
		objVDAO = new VagasDAO();
		objVL = new ArrayList<Vagas>();
		listarVagas();
	}
	
	public void quantidadeVagas(){
		int total, cont;
		total=0;
		cont=0;
		
		objVL=objVDAO.researchAll();
		for(Vagas v: objVL){
			if(v.getStatus()==true){
				cont++;
			}
			total++;
		}
		total=total-cont;
		quantTotalVagas=Integer.toString(total);
	}
	
	
	public void listarVagas(){
		quantidadeVagas();
		objVL=objVDAO.researchAll();
		
		/*
		for(Vagas v: objVL){
			this.idVaga=v.getIdVaga();
			if(v.getStatus()==true){
				this.status="Ocupada";
			}else{this.status="Desocupada";}
		}
		*/
		
	}
	public String botaoAtualQuanVagasAdmin(){
		listarVagas();
		//objVL=objVDAO.researchAll();
		return "estacionamentoAdminCRUD?faces-redirect=true"; 
	} 

	public String botaoAtualQuanVagasUser(){
		listarVagas();
		//objVL=objVDAO.researchAll();
		return "estacionamentoUserCRUD?faces-redirect=true"; 
	} 
	
	
	
	
	//---------------------------------------
	//gets e sets
	public List<Vagas> getObjVL() {
		return objVL;
	}

	public void setObjVL(List<Vagas> objVL) {
		this.objVL = objVL;
	}
	public Vagas getObjV() {
		return objV;
	}

	public void setObjV(Vagas objV) {
		this.objV = objV;
	}
	private List<Vagas> objVL;
	
	
	public String getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(String idVaga) {
		this.idVaga = idVaga;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	
}
