package br.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.model.Acesso;
import br.model.Cartao;
import br.model.Estacionamento;
import br.model.Usuario;
import br.model.Vagas;
import br.persistencia.AcessoDAO;
import br.persistencia.CartaoDAO;
import br.persistencia.EstacionamentoDAO;
import br.persistencia.UsuarioDAO;
import br.persistencia.VagasDAO;


@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable{
	
	private String login;
	private String senha;
	
	private String nome;
	private String cpf;
	private String matricula;
	private String telefone;
	private String endereco;
	private String modeloVeiculo;
	private String placaVeiculo;
	private String corVeiculo;
	private String tipoUsuario;      //boolean
	private String status;           //boolean
	
	private String dataNascimento;   //Calendar
	private String idCartao;         //Cartao
	
	private AcessoDAO  objADAO;
	private CartaoDAO  objCDAO;
	private UsuarioDAO objUDAO;
	private VagasDAO   objVDAO;
	private EstacionamentoDAO objEDAO;
	
	private Acesso  objA;
	private Cartao  objC;
	private Usuario objU;
	private Vagas   objV;
	private Estacionamento objE;
	
	private List<Acesso>  objAL;
	private List<Cartao>  objCL;
	private List<Usuario> objUL;
	private List<Vagas>   objVL;
	private List<Estacionamento> objEL; 
	
	
	
	private List<Usuario> objUL1;
	


	//-----------------------------------------
	//Construtor
	public UsuarioBean(){
		//limparCampos();
		
		objA=new Acesso();
		objADAO=new AcessoDAO();

		objC=new Cartao();
		objCDAO=new CartaoDAO();
	
		objU=new Usuario();
		objUDAO=new UsuarioDAO();
		
		objV=new Vagas();
		objVDAO=new VagasDAO();
		
		objE=new Estacionamento();
		objEDAO=new EstacionamentoDAO();
		
		objC.setObjAcesso(objA);
		objU.setObjCartao(objC);
		objE.setObjCartao(objC);
		objE.setObjVagas(objV);
		
		this.objAL =new ArrayList<Acesso>();
		this.objCL =new ArrayList<Cartao>();
		this.objUL =new ArrayList<Usuario>();
		this.objVL =new ArrayList<Vagas>();
		this.objEL =new ArrayList<Estacionamento>();
	
		this.objUL1 =new ArrayList<Usuario>();	
		this.listarTodosUsuarios();
	}
	
	public void listarTodosUsuarios() {

		objUL=objUDAO.researchAll();    //lista de usuarios
		
		//return "cadastroCRUD.xhtml?faces-redirect=true";
	}
	
	
	public String botaoLogar() {
		System.out.println(this.login);
		System.out.println(this.senha);
		
		objUL1=objUDAO.researchAll();    //lista de usuarios
		
		for(Usuario u: objUL1){		
			if((u.getLogin().equals(this.login))&&(u.getSenha().equals(this.senha))){			
				if(u.getTipoUsuario()==true){
					this.login="";
					this.senha="";
					System.out.println(u.getLogin());
					System.out.println(u.getSenha());
					return "admin.xhtml?faces-redirect=true";					
				}				
				return "user.xhtml?faces-redirect=true";
			}
		}		
		return "erro.xhtml?faces-redirect=true";
	}
	
	
	public void limparCampos() {
		this.login="";
		this.senha="";
		
		this.nome="";
		this.cpf="";
		this.matricula="";
		this.telefone="";
		this.endereco="";
		this.modeloVeiculo="";
		this.placaVeiculo="";
		this.corVeiculo="";
		this.tipoUsuario="";      //boolean
		this.status="";           //boolean
		
		this.dataNascimento="";   //Calendar
		this.idCartao="";
	}
	
	
	public String botaolimparCamposLogar(){
		
		this.login="";
		this.senha="";
		
		return "login.xhtml?faces-redirect=true";
	}
	
	
	public String botaoPesquisarUsuario(){
		
		objUL1=objUDAO.researchAll();    //lista de usuarios
			
		for(Usuario u: objUL){
			System.out.println(u.getCpf());
			System.out.println(this.cpf);
			
			if((u.getCpf().equals(this.cpf))){
				//this.login="";
				//this.senha="";
				
				this.nome=u.getNome();
				this.cpf=u.getCpf();
				this.matricula=u.getMatricula();
				this.telefone=u.getTelefone();
				this.endereco=u.getEndereco();
				this.modeloVeiculo=u.getModeloVeiculo();
				this.placaVeiculo=u.getPlacaVeiculo();
				this.corVeiculo=u.getCorVeiculo();
				
				if(u.getTipoUsuario()==true){  //boolean
					this.tipoUsuario="admin";
				}else{this.tipoUsuario="user";}

				if(u.getStatus()==true){         //boolean
					this.status="Ativado";
				}else{this.status="Desativado";}


				this.dataNascimento=u.getDataNascimento();   //Calendar
				//this.idCartao=u.getIdCartao();				
							
				
				//this.idCartao=objC.getIdCartao();
				
				return "cadastroCRUD.xhtml?faces-redirect=true";
			}
		}
			this.cpf="";
			return "cadastroCRUD.xhtml?faces-redirect=true";
	}
	
	
	
	
	
	
	public String botaoPesquisa(){
		objUL1=objUDAO.researchAll();    //lista de usuarios
		
		for(Usuario u: objUL){
			//System.out.println(u.getCpf());
			//System.out.println(this.cpf);
			
			if((u.getCpf().equals(this.cpf))){
				//this.login="";
				//this.senha="";
				
				this.nome=u.getNome();
				this.cpf=u.getCpf();
				this.matricula=u.getMatricula();
				this.telefone=u.getTelefone();
				this.endereco=u.getEndereco();
				this.modeloVeiculo=u.getModeloVeiculo();
				this.placaVeiculo=u.getPlacaVeiculo();
				this.corVeiculo=u.getCorVeiculo();
				
				if(u.getTipoUsuario()==true){  //boolean
					this.tipoUsuario="admin";
				}else{this.tipoUsuario="user";}

				if(u.getStatus()==true){         //boolean
					this.status="Ativado";
				}else{this.status="Desativado";}


				this.dataNascimento=u.getDataNascimento();   //Calendar
				//this.idCartao=u.getIdCartao();				
							
				
				//this.idCartao=objC.getIdCartao();
				return "cadastroCRUD.xhtml?faces-redirect=true";
			}
		}
			this.cpf="";
			return "cadastroCRUD.xhtml?faces-redirect=true";
		
	}
	
	
	
	public String botaoNovo(){
		this.limparCampos();
		
		return "cadastroCRUD.xhtml?faces-redirect=true";
	}
	
	public String botaoExcluir(){
		
		this.limparCampos();
		
		/*
		objUL1=objUDAO.researchAll();    //lista de usuarios
		

		for(Usuario u: objUL1){
			if((this.cpf).equals(u.getCpf())){
				objUDAO.delete(objU);
			}
			
		}
		*/
		return "cadastroCRUD.xhtml?faces-redirect=true";
}
	
	
	public String botaoSalvar(){
		
		objU.setLogin(this.login);
		objU.setSenha(this.senha);
		objU.setNome(this.nome);
		objU.setCpf(this.cpf);
		objU.setMatricula(this.matricula);
		objU.setTelefone(this.telefone);
		objU.setEndereco(this.endereco);
		objU.setModeloVeiculo(this.modeloVeiculo);
		objU.setPlacaVeiculo(this.placaVeiculo);
		objU.setCorVeiculo(this.corVeiculo);
		
		if((this.tipoUsuario).equals("true")){
			objU.setTipoUsuario(true);
		}else{objU.setTipoUsuario(false);}
	
		if((this.status).equals("true")){
			objU.setStatus(true);
		}else{objU.setStatus(false);}
			
		objU.setDataNascimento(this.dataNascimento);
		
		objADAO.create(objA);
		objCDAO.create(objC);
		objUDAO.create(objU);
		//objVDAO.create(objV);
		//objEDAO.create(objE);
		
		
		objUL=objUDAO.researchAll();
		
		return "cadastroCRUD.xhtml?faces-redirect=true";
	}
	
	
	
	//-----------------------------------------
	//Gets e Sets
	public List<Usuario> getObjUL() {
		return objUL;
	}

	public void setObjUL(List<Usuario> objUL) {
		this.objUL = objUL;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getModeloVeiculo() {
		return modeloVeiculo;
	}
	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	public String getCorVeiculo() {
		return corVeiculo;
	}
	public void setCorVeiculo(String corVeiculo) {
		this.corVeiculo = corVeiculo;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}	
	
	public String getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(String idCartao) {
		this.idCartao = idCartao;
	}
}

