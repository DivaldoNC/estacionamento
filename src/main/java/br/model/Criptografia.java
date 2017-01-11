package br.model;

public class Criptografia {
	
	private int chave=8;
		
	public String encriptarMensagem(String encripta){
		
	      int i, n = encripta.length();
	      String saux = "";

	      for (i=0; i<n; i++) {
	        saux = saux + (char)(encripta.charAt(i) + this.chave);
	      }

	      return(saux);
	}
	
	public String desencriptaMensagem(String desencripta){
		
	      int i, n = desencripta.length();
	      String saux = "";

	      for (i=0; i<n; i++) {
	        saux = saux + (char)(desencripta.charAt(i) - this.chave);
	      }
	      return(saux);
	}

}
