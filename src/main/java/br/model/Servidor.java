package br.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.ObjID;










//--------------------------
import br.model.ProtocoloComunicacao;
//-------------------------


public class Servidor {
		
	ProtocoloComunicacao objP01=new ProtocoloComunicacao();
	private int porta;
	
	private ServerSocket servidor;
	private Socket cliente;
	private InputStream input;
	private OutputStream output;
	private BufferedReader in;
	private PrintStream    out;
	
	
	private String dadosCifradoReceber="";     //so para mostrar - nao e de responsabilidade do servidor 
	private String dadosDecifradoReceber="";   //so para mostrar - nao e de responsabilidade do servidor 
	private String idEmbarcadoReceber="";         
	private String tipoServicoReceber="";     
	private String dadosProcessadoReceber="";
	

	private String dadosCifradoEnviar="";     //so para mostrar - nao e de responsabilidade do servidor 
	private String dadosDecifradoEnviar="";   //so para mostrar - nao e de responsabilidade do servidor 
	private String idEmbarcadoEnviar="";         
	private String tipoServicoEnviar="";     
	private String dadosProcessadoEnviar="";
	
	

	public void abrirConexao(int porta) throws IOException{
		
		System.out.println("Iniciando Servidor.");
		setServidor(new ServerSocket(porta));
		System.out.println("Aguardando conexão!");
		setCliente(servidor.accept());
		System.out.println("Conexão estabelecida.");	
		
		setInput(cliente.getInputStream());
		setOutput(cliente.getOutputStream());
		setIn(new BufferedReader(new InputStreamReader(input)));
		setOut(new PrintStream(output));
		
	}
	

	public void fecharConexao() throws IOException{
		System.out.println("Encerrada conexão.");
		
		getIn().close();
		getOut().close();
		getCliente().close();
		getServidor().close();

	}
	
	
	public void enviarDados(String id, String tipo, String dados){
		
		objP01.comunicacaoDadosEnviar(id, tipo, dados);
		
		setIdEmbarcadoEnviar(id);         
		setTipoServicoEnviar(tipo);     
		setDadosProcessadoEnviar(dados);
		setDadosCifradoEnviar(objP01.getDadosCifradoEnviar());      //so para mostrar - nao e de responsabilidade do servidor 
		setDadosDecifradoEnviar(objP01.getDadosDecifradoEnviar());  //so para mostrar - nao e de responsabilidade do servidor
		
		out.println(getDadosCifradoEnviar());
		
		//this.dadosCifradoEnviar=  
		//dadosDecifradoEnviar="";   
		
		//idEmbarcadoEnviar=id;         
		//tipoServicoEnviar=tipo;     
		//dadosProcessadoEnviar=dados;
	}
	
	
	public void receberDados() throws IOException{
		String dadosReceber = in.readLine();
		objP01.comunicacaoDadosReceber(dadosReceber);  //descriptografar e separar dados para processar
		
		setIdEmbarcadoReceber(objP01.getIdEmbarcadoReceber());   //recebe do protocolo e guarda os dados no servidor
		setTipoServicoReceber(objP01.getTipoServicoReceber());
		setDadosProcessadoReceber(objP01.getDadosProcessadoReceber());
		setDadosCifradoReceber(objP01.getDadosCifradoReceber());       //so para mostrar - nao e de responsabilidade do servidor 
		setDadosDecifradoReceber(objP01.getDadosDecifradoReceber());   //so para mostrar - nao e de responsabilidade do servidor 
		
		
		//this.idEmbarcadoReceber=objP01.getIdEmbarcadoReceber();         
		//this.tipoServicoReceber=objP01.getTipoServicoReceber();     
		//this.dadosProcessadoReceber=objP01.getDadosProcessadoReceber();
	}
	

	
	
	public void mostrarDadosProcessadoReceber(){
		 //System.out.println("\n*************************************************");
		 System.out.println("\n-------------------------------------------------"); 
		 System.out.println("Dados Recebido");
		 System.out.println("Cifrado        : "+getDadosCifradoReceber());
		 System.out.println("Decifrado      : "+getDadosDecifradoReceber());
		 System.out.println("ID Embarcado   : "+getIdEmbarcadoReceber());
		 System.out.println("Tipo Servico   : "+getTipoServicoReceber());
		 System.out.println("Dados Processar: "+getDadosProcessadoReceber());
		 System.out.println("\n-------------------------------------------------");
		 //System.out.println("*************************************************\n");
	}
	
	
	public void mostrarDadosProcessadoEnviar(){
		 //System.out.println("\n*************************************************");
		 System.out.println("\n-------------------------------------------------");
		 System.out.println("Dados Enviar");
		 System.out.println("Cifrado        : "+getDadosCifradoEnviar());
		 System.out.println("Decifrado      : "+getDadosDecifradoEnviar());
		 System.out.println("ID Embarcado   : "+getIdEmbarcadoEnviar());
		 System.out.println("Tipo Servico   : "+getTipoServicoEnviar());
		 System.out.println("Dados Processar: "+getDadosProcessadoEnviar());
		 //System.out.println("*************************************************\n");
		 System.out.println("-------------------------------------------------\n");
	}
	
	
	
	
	
	
	public boolean tipoServicoReceber(String tipo){
		if(tipo.equals(getTipoServicoReceber())){  
			return true;
		}
		else{
			return false;
		}
	} 
	
	
	
	
	
	public String getDadosDecifradoReceber() {
		return dadosDecifradoReceber;
	}


	public void setDadosDecifradoReceber(String dadosDecifradoReceber) {
		this.dadosDecifradoReceber = dadosDecifradoReceber;
	}


	public String getDadosCifradoEnviar() {
		return dadosCifradoEnviar;
	}


	public void setDadosCifradoEnviar(String dadosCifradoEnviar) {
		this.dadosCifradoEnviar = dadosCifradoEnviar;
	}


	public String getDadosDecifradoEnviar() {
		return dadosDecifradoEnviar;
	}


	public void setDadosDecifradoEnviar(String dadosDecifradoEnviar) {
		this.dadosDecifradoEnviar = dadosDecifradoEnviar;
	}
	
	
	public String getDadosCifradoReceber() {
		return dadosCifradoReceber;
	}


	public void setDadosCifradoReceber(String dadosCifradoReceber) {
		this.dadosCifradoReceber = dadosCifradoReceber;
	}
	
	
	
	public String getIdEmbarcadoReceber() {
		return idEmbarcadoReceber;
	}


	public void setIdEmbarcadoReceber(String idEmbarcadoReceber) {
		this.idEmbarcadoReceber = idEmbarcadoReceber;
	}
	
	public String getTipoServicoReceber() {
		return tipoServicoReceber;
	}


	public void setTipoServicoReceber(String tipoServicoReceber) {
		this.tipoServicoReceber = tipoServicoReceber;
	}
		
	
	public String getDadosProcessadoReceber() {
		return dadosProcessadoReceber;
	}


	public void setDadosProcessadoReceber(String dadosProcessadoReceber) {
		this.dadosProcessadoReceber = dadosProcessadoReceber;
	}
	
	public String getIdEmbarcadoEnviar() {
		return idEmbarcadoEnviar;
	}


	public void setIdEmbarcadoEnviar(String idEmbarcadoEnviar) {
		this.idEmbarcadoEnviar = idEmbarcadoEnviar;
	}


	public String getTipoServicoEnviar() {
		return tipoServicoEnviar;
	}


	public void setTipoServicoEnviar(String tipoServicoEnviar) {
		this.tipoServicoEnviar = tipoServicoEnviar;
	}


	public String getDadosProcessadoEnviar() {
		return dadosProcessadoEnviar;
	}


	public void setDadosProcessadoEnviar(String dadosProcessadoEnviar) {
		this.dadosProcessadoEnviar = dadosProcessadoEnviar;
	}
	
	//------------------------------------------------------------------
	public int getPorta() {
		return porta;
	}
	public void setPorta(int porta) {
		this.porta = porta;
	}
	public ServerSocket getServidor() {
		return servidor;
	}
	public void setServidor(ServerSocket servidor) {
		this.servidor = servidor;
	}
	public Socket getCliente() {
		return cliente;
	}
	public void setCliente(Socket cliente) {
		this.cliente = cliente;
	}
	public InputStream getInput() {
		return input;
	}
	public void setInput(InputStream input) {
		this.input = input;
	}
	public OutputStream getOutput() {
		return output;
	}
	public void setOutput(OutputStream output) {
		this.output = output;
	}
	public BufferedReader getIn() {
		return in;
	}
	public void setIn(BufferedReader in) {
		this.in = in;
	}
	public PrintStream getOut() {
		return out;
	}
	public void setOut(PrintStream out) {
		this.out = out;
	}
	
	
	
	
	
	
	
	//Conexao---------------------------------------------------------------------
	
			//System.out.println("Iniciando Servidor.");
			//ServerSocket servidor = new ServerSocket(10002);
			//System.out.println("Aguardando conexão!");
			//Socket cliente = servidor.accept();
			//System.out.println("Conexão estabelecida.");
			     
			//InputStream input =cliente.getInputStream(); 
			//OutputStream output =cliente.getOutputStream(); 
			//BufferedReader in  =new BufferedReader(new InputStreamReader(input));
			//PrintStream    out =new PrintStream(output);
			
	
	//System.out.println("Encerrada conexão.");
    //in.close();
    //out.close();
    //cliente.close();
    //servidor.close();
	
	
			//----------------------------------------------------------------------------
}
