package br.model;

public class ProtocoloComunicacao {

	private String dadosCifradoReceber="";  
	private String dadosDecifradoReceber="";   
	private String idEmbarcadoReceber="";         
	private String tipoServicoReceber="";     
	private String dadosProcessadoReceber="";
	
	private String dadosCifradoEnviar="";  
	private String dadosDecifradoEnviar="";   
	private String idEmbarcadoEnviar="";         
	private String tipoServicoEnviar="";     
	private String dadosProcessadoEnviar="";
	
	
	Criptografia objCrip = new Criptografia();
	
	
	ProtocoloComunicacao(){
		this.dadosCifradoReceber="";  
		this.dadosDecifradoReceber="";   
		this.idEmbarcadoReceber="";         
		this.tipoServicoReceber="";     
		this.dadosProcessadoReceber="";
		
		this.dadosCifradoEnviar="";  
		this.dadosDecifradoEnviar="";   
		this.idEmbarcadoEnviar="";         
		this.tipoServicoEnviar="";     
		this.dadosProcessadoEnviar="";
	}

	void comunicacaoDadosReceber(String dadosProcessar){
		setDadosCifradoReceber(dadosProcessar);                                              //setar dados cifrado
		setDadosDecifradoReceber(criptografiaDeCifrar(dadosProcessar));                      //setar dados decifrado
		 
		//Separa os Dados
		int tamanhaDados=getDadosDecifradoReceber().length();
		
		setIdEmbarcadoReceber(this.dadosDecifradoReceber.substring(0, 3));  		         //Identificador do Arduino - A01
		setTipoServicoReceber(this.dadosDecifradoReceber.substring(4, 7));         		     //Tipo do Servico - S01
		setDadosProcessadoReceber(this.dadosDecifradoReceber.substring(8, tamanhaDados));	 //Dados procassar
	}


	
	String comunicacaoDadosEnviar(String id, String tipo, String dados){
		
		setIdEmbarcadoEnviar(id);
		setTipoServicoEnviar(tipo);
		setDadosProcessadoEnviar(dados);
		setDadosDecifradoEnviar(id+":"+tipo+":"+dados);
		setDadosCifradoEnviar(criptografiaCifrar(id+":"+tipo+":"+dados));
		
		return getDadosCifradoEnviar();
	}
	

	String criptografiaCifrar(String cifrar){
		String cifrado="";
		//decifrado=cifrar;
		cifrado=objCrip.encriptarMensagem(cifrar);
		
		setDadosDecifradoReceber(cifrado);
		return cifrado;
	}
	
	String criptografiaDeCifrar(String decifrar){
		String decifrado="";
		//cifrado=decifrar;
		
		decifrado=objCrip.desencriptaMensagem(decifrar);
		return decifrado;
	}

	public String getDadosCifradoReceber() {
		return dadosCifradoReceber;
	}

	public void setDadosCifradoReceber(String dadosCifradoReceber) {
		this.dadosCifradoReceber = dadosCifradoReceber;
	}

	public String getDadosDecifradoReceber() {
		return dadosDecifradoReceber;
	}

	public void setDadosDecifradoReceber(String dadosDecifradoReceber) {
		this.dadosDecifradoReceber = dadosDecifradoReceber;
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
	
	 
	
	
	
}
