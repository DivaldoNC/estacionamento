package br.principal;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.List;

import br.model.Acesso;
import br.model.Cartao;
import br.model.Estacionamento;
import br.model.Servidor;
import br.model.Usuario;
import br.model.Vagas;
import br.persistencia.AcessoDAO;
import br.persistencia.CartaoDAO;
import br.persistencia.EstacionamentoDAO;
import br.persistencia.UsuarioDAO;
import br.persistencia.VagasDAO;

public class Principal {
	
	private  static int quantidadeVagasExterna=0;
	private  static int quantidadeVagasInterna=0;
	private static String vagasInterna=""; 
	
	
	public static void main(String[] args)throws IOException{
		//Quantidade de Vagas Externa
		quantidadeVagasExterna=5;
		quantidadeVagasInterna=5;
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss:S");

	
		//Acesso
		Acesso objA1 =new Acesso(); objA1.setStatus(false); 
		Acesso objA2 =new Acesso(); objA2.setStatus(false); 
		Acesso objA3 =new Acesso(); objA3.setStatus(false); 
		Acesso objA4 =new Acesso(); objA4.setStatus(false); 
		Acesso objA5 =new Acesso(); objA5.setStatus(false); 
		Acesso objA6 =new Acesso(); objA6.setStatus(false); 
		Acesso objA7 =new Acesso(); objA7.setStatus(false); 
		Acesso objA8 =new Acesso(); objA8.setStatus(false); 
		Acesso objA9 =new Acesso(); objA9.setStatus(false); 
					
		//Usuario
		Usuario objU1 = new Usuario(); objU1.setNome("Adrielly");  objU1.setMatricula("200800000000"); objU1.setTelefone("22221111"); objU1.setCpf("11111111111");
		Usuario objU2 = new Usuario(); objU2.setNome("Bruno");     objU2.setMatricula("200811111111"); objU2.setTelefone("22222222"); objU2.setCpf("22222222222");
		Usuario objU3 = new Usuario(); objU3.setNome("Camila");    objU3.setMatricula("200822222222"); objU3.setTelefone("22223333"); objU3.setCpf("33333333333");
		Usuario objU4 = new Usuario(); objU4.setNome("Divaldo");   objU4.setMatricula("200833333333"); objU4.setTelefone("22224444"); objU4.setCpf("44444444444");
		Usuario objU5 = new Usuario(); objU5.setNome("Eduardo");   objU5.setMatricula("200844444444"); objU5.setTelefone("22225555"); objU5.setCpf("55555555555");
		Usuario objU6 = new Usuario(); objU6.setNome("Fabio");     objU6.setMatricula("200855555555"); objU6.setTelefone("22226666"); objU6.setCpf("66666666666");
		Usuario objU7 = new Usuario(); objU7.setNome("Gabrielly"); objU7.setMatricula("200866666666"); objU7.setTelefone("22227777"); objU7.setCpf("77777777777");
		Usuario objU8 = new Usuario(); objU8.setNome("Humberto");  objU8.setMatricula("200877777777"); objU8.setTelefone("22228888"); objU8.setCpf("88888888888");
		Usuario objU9 = new Usuario(); objU9.setNome("Isabelly");  objU9.setMatricula("200888888888"); objU9.setTelefone("22229999"); objU9.setCpf("99999999999");
	
		objU1.setEndereco("Balneario");     objU1.setModeloVeiculo("Corolla");     objU1.setPlacaVeiculo("AAA1111"); objU1.setCorVeiculo("PRETO");  
		objU2.setEndereco("Urias");         objU2.setModeloVeiculo("Honda");       objU2.setPlacaVeiculo("AAA2222"); objU2.setCorVeiculo("PRETO");  
		objU3.setEndereco("Campinas");      objU3.setModeloVeiculo("Hyundai");     objU3.setPlacaVeiculo("AAA3333"); objU3.setCorVeiculo("PRETO");  
		objU4.setEndereco("Universitario"); objU4.setModeloVeiculo("Fiat");        objU4.setPlacaVeiculo("AAA4444"); objU4.setCorVeiculo("PRETO");  
		objU5.setEndereco("Perim");         objU5.setModeloVeiculo("Ford");        objU5.setPlacaVeiculo("AAA5555"); objU5.setCorVeiculo("PRETO");  
		objU6.setEndereco("Coimbra");       objU6.setModeloVeiculo("Palio");       objU6.setPlacaVeiculo("AAA6666"); objU6.setCorVeiculo("PRETO"); 
		objU7.setEndereco("Industrial");    objU7.setModeloVeiculo("Mistsubishi"); objU7.setPlacaVeiculo("AAA7777"); objU7.setCorVeiculo("PRETO");  
		objU8.setEndereco("Atheneu");       objU8.setModeloVeiculo("Chevrolet");   objU8.setPlacaVeiculo("AAA8888"); objU8.setCorVeiculo("PRETO");  
		objU9.setEndereco("Trindade");      objU9.setModeloVeiculo("Volkswagen");  objU9.setPlacaVeiculo("AAA9999"); objU9.setCorVeiculo("PRETO");  
		
		objU1.setTipoUsuario(false); objU1.setStatus(false); objU1.setDataNascimento("1985/11/20"); //informa uma data
		objU2.setTipoUsuario(false); objU2.setStatus(false); objU2.setDataNascimento("1985/11/20"); //informa uma data
		objU3.setTipoUsuario(false); objU3.setStatus(false); objU3.setDataNascimento("1985/11/20"); //informa uma data
		objU4.setTipoUsuario(true); objU4.setStatus(false); objU4.setDataNascimento("1985/11/20"); //informa uma data
		objU5.setTipoUsuario(false); objU5.setStatus(false); objU5.setDataNascimento("1985/11/20"); //informa uma data
		objU6.setTipoUsuario(false); objU6.setStatus(false); objU6.setDataNascimento("1985/11/20"); //informa uma data
		objU7.setTipoUsuario(false); objU7.setStatus(false); objU7.setDataNascimento("1985/11/20"); //informa uma data
		objU8.setTipoUsuario(false); objU8.setStatus(false); objU8.setDataNascimento("1985/11/20"); //informa uma data
		objU9.setTipoUsuario(false); objU9.setStatus(false); objU9.setDataNascimento("1985/11/20"); //informa uma data

		objU1.setLogin("ARB"); objU1.setSenha("123");
		objU2.setLogin("AAA"); objU2.setSenha("123");
		objU3.setLogin("AAA"); objU3.setSenha("123");
		objU4.setLogin("DNC"); objU4.setSenha("123");
		objU5.setLogin("AAA"); objU5.setSenha("123");
		objU6.setLogin("AAA"); objU6.setSenha("123");
		objU7.setLogin("AAA"); objU7.setSenha("123");
		objU8.setLogin("AAA"); objU8.setSenha("123");
		objU9.setLogin("AAA"); objU9.setSenha("123");
			
		//Carta
		Cartao objC1 =new Cartao(); objC1.setIdCartao("0E 4E 11 1E"); objC1.setStatus(true);  		
		Cartao objC2 =new Cartao(); objC2.setIdCartao("AE B9 0F 1");  objC2.setStatus(true);  
		Cartao objC3 =new Cartao(); objC3.setIdCartao("0E 5D 0C 1E"); objC3.setStatus(false); 
		Cartao objC4 =new Cartao(); objC4.setIdCartao("79 61 49 B5"); objC4.setStatus(true);  
		Cartao objC5 =new Cartao(); objC5.setIdCartao("9C D7 03 5A"); objC5.setStatus(true);  
		Cartao objC6 =new Cartao(); objC6.setIdCartao("AE 75 44 F5"); objC6.setStatus(true);  
		Cartao objC7 =new Cartao(); objC7.setIdCartao("9C 36 E3 16"); objC7.setStatus(true);  
		Cartao objC8 =new Cartao(); objC8.setIdCartao("52 2C 20 27"); objC8.setStatus(true);  
		Cartao objC9 =new Cartao(); objC9.setIdCartao("73 A7 C4 A9"); objC9.setStatus(true); 
		
		//Vagas
		Vagas objV1 =new Vagas(); objV1.setIdVaga("A1"); objV1.setStatus(false);
		Vagas objV2 =new Vagas(); objV2.setIdVaga("A2"); objV2.setStatus(false);    
		Vagas objV3 =new Vagas(); objV3.setIdVaga("A3"); objV3.setStatus(false);
		Vagas objV4 =new Vagas(); objV4.setIdVaga("B1"); objV4.setStatus(false);
		Vagas objV5 =new Vagas(); objV5.setIdVaga("B2"); objV5.setStatus(false);
		
		//Estacionamento
		Estacionamento objE1 =new Estacionamento(); objE1.setNome("ESTACIONAMENTO ENFASE"); objE1.setEndereco("BALNEARIO");		
		
				
		//----------------------------------------------------------------------------------------------------------------------------------------
		//Cartao ->Acesso
		objC1.setObjAcesso(objA1);
		objC2.setObjAcesso(objA2);
		objC3.setObjAcesso(objA3);  
		objC4.setObjAcesso(objA4);  
		objC5.setObjAcesso(objA5);  
		objC6.setObjAcesso(objA6);
		objC7.setObjAcesso(objA7); 
		objC8.setObjAcesso(objA8); 
		objC9.setObjAcesso(objA9); 
		
		//Cartao <-> Usuario   - Não vai utilizar porque os dados e colocado na tabela "Usuario <-> Cartao" 
		//objC1.setObjUsuario(objU1);     
		
		//Usuario <-> Cartao 
		objU1.setObjCartao(objC1);
		objU2.setObjCartao(objC2);
		objU3.setObjCartao(objC3); 
		objU4.setObjCartao(objC4); 
		objU5.setObjCartao(objC5); 
		objU6.setObjCartao(objC6); 
		objU7.setObjCartao(objC7); 
		objU8.setObjCartao(objC8); 
		objU9.setObjCartao(objC9); 
		
		//Estacionamento -> Vagas
		objE1.setObjVagas(objV1);
		objE1.setObjVagas(objV2);
		objE1.setObjVagas(objV3); 
		objE1.setObjVagas(objV4); 
		objE1.setObjVagas(objV5); 
		
		//Estacionamento -> Cartao
		objE1.setObjCartao(objC1);
		objE1.setObjCartao(objC2);
		objE1.setObjCartao(objC3);
		objE1.setObjCartao(objC4);
		objE1.setObjCartao(objC5);
		objE1.setObjCartao(objC6);
		objE1.setObjCartao(objC7);
		objE1.setObjCartao(objC8);
		objE1.setObjCartao(objC9);
		
		System.out.println("\n\n\n\n\n\n******************************************************************************************");
		AcessoDAO objAD = new AcessoDAO();
		CartaoDAO objCD = new CartaoDAO();
		UsuarioDAO objUD = new UsuarioDAO();

		VagasDAO objVD = new VagasDAO();
		EstacionamentoDAO objED = new EstacionamentoDAO();
		
		
		System.out.println("\n\n\n\n\n\n******************************************************************************************");
		//Criar Tabelas Com dados
		objAD.create(objA1);
		objAD.create(objA2);
		objAD.create(objA3);
		objAD.create(objA4);
		objAD.create(objA5);
		objAD.create(objA6);
		objAD.create(objA7);
		objAD.create(objA8);
		objAD.create(objA9);
		
		objCD.create(objC1);
		objCD.create(objC2);
		objCD.create(objC3);
		objCD.create(objC4);
		objCD.create(objC5);
		objCD.create(objC6);
		objCD.create(objC7);
		objCD.create(objC8);
		objCD.create(objC9);

		objUD.create(objU1);
		objUD.create(objU2);
		objUD.create(objU3);
		objUD.create(objU4);
		objUD.create(objU5);
		objUD.create(objU6);
		objUD.create(objU7);
		objUD.create(objU8);
		objUD.create(objU9);
		
		objVD.create(objV1);
		objVD.create(objV2);
		objVD.create(objV3);
		objVD.create(objV4);
		objVD.create(objV5);
				
		objED.create(objE1);
		System.out.println("\n\n\n\n\n\n******************************************************************************************");
		
System.out.println("\n\n\n\n\n\n******************************************************************************************");
		
		List<Acesso> objAL = new ArrayList<Acesso>();
		List<Cartao> objCL = new ArrayList<Cartao>();
		List<Vagas> objVL = new ArrayList<Vagas>();
		
		objAL=objAD.researchAll();
		objCL=objCD.researchAll();
		objVL=objVD.researchAll();
		
		
		System.out.println("\n\n\n\n\n\n******************************************************************************************");
		//-----------------------------------------------------------------------------------------------------
		//conexao
		Servidor objS01 =new Servidor();
		objS01.abrirConexao(10002);
		
		
		while(true){
			
			objS01.receberDados();
			System.out.println("\n******************************************************************************************");
			System.out.println("Mensagem recebida do cliente [" + objS01.getCliente().getInetAddress().getHostName()+ "]: "+ objS01.getDadosCifradoReceber());
			System.out.println("******************************************************************************************\n");
						
			objS01.mostrarDadosProcessadoReceber();
			
			//----------------------------------------------
			//Verifica se o servidor foi conectado e envia resposta de cliente conectado 
			if(true==objS01.tipoServicoReceber("S00")){  
				if("CLIENTE - CONECTADO.".equals(objS01.getDadosProcessadoReceber())){
					objS01.enviarDados("A01", "C00", "SERVIDOR - CONECTADO");
					objS01.mostrarDadosProcessadoEnviar();
				}else{System.out.println("Falha...  Mensagem nao existe.");}
			}
			
			
			//----------------------------------------------
			//enviar quantidade de vagas 
			else if(true==objS01.tipoServicoReceber("S01")){                                                        //verifica servico - vagas que deve ter o estacionamento      
				objS01.enviarDados("A01", "C01", Integer.toString(quantidadeVagasExterna));
				objS01.mostrarDadosProcessadoEnviar();
			}
			
			//----------------------------------------------
			//Mapa de Vagas Interna
			
			else if(true==objS01.tipoServicoReceber("S02")){
				
				if(objS01.getDadosProcessadoReceber().length()==quantidadeVagasInterna){  //verifica o tamanho da string de vagas enviada com a quantidade de vagas tem - 11 -> 2 = cada 1 representa 1 vaga
					
					//System.out.println("\n*************************************************");
					System.out.println("\n-------------------------------------------------");
					System.out.println("Mapa Vagas: "+objS01.getDadosProcessadoReceber());
					System.out.println("Vagas: Ocupada");
					
					vagasInterna=objS01.getDadosProcessadoReceber();                                 //atualiza total das vagas internas
					
					//manager.getTransaction().begin();			
					int cont=0;
					for(Vagas objEB : objVL) {
						if("1".equals(objS01.getDadosProcessadoReceber().substring(cont, cont+1))){
							objEB.setStatus(false);
							System.out.println(objEB.getIdVaga()+": NAO");
						}
						else if("0".equals(objS01.getDadosProcessadoReceber().substring(cont, cont+1))){
							objEB.setStatus(true);
							System.out.println(objEB.getIdVaga()+": SIM");
						}
						else{System.out.println("Falha...  Mensagem nao existe.");}
						
						cont++;
					}
					
					objVD.update(objV1);
					objVD.update(objV2);
					objVD.update(objV3);
					objVD.update(objV4);
					objVD.update(objV5);
					
					//objAD.update(objVL);
					//manager.getTransaction().commit();
					
					//System.out.println("*************************************************\n");
					System.out.println("-------------------------------------------------\n");
				}
			}
			
			//----------------------------------------------
			//Codigo restante adcionar
			
			else if(true==objS01.tipoServicoReceber("S03")){                                      //verificar cartao
				
				//manager.getTransaction().begin();	
				
				int contC=0;
				for(Cartao objCB : objCL) { //verifica todos cartoes
					
					if(objCB.getIdCartao().equals(objS01.getDadosProcessadoReceber())){ //Cadastrado: SIM
						//System.out.println("Cadastrado: "+objCB.getIdCartao()+" : SIM");
						
						if(objCB.getStatus()==true){ //PERMISSAO: SIM
							//System.out.println("Permissao: "+objCB.getStatus()+" : SIM");
							
							int contA=0;
							for(Acesso objAB : objAL){
								if(contA==contC){                 // verifica acesso do mesmo cartao - nao deve ser desta maneira
									
									if(objAB.getStatus()==false){ //ACESSAR: ENTRAR
										//System.out.println("Acesso: "+objAB.getStatus()+" : ENTRAR");
										
										if((quantidadeVagasExterna>0) &&(quantidadeVagasExterna<6)){
											objS01.enviarDados("A01", "C04", "PERMISSAO: SIM. - ACESSO: ENTRAR.");
											objS01.mostrarDadosProcessadoEnviar();
											
											while(true){                                                      //Espera Resposta se entro - Acesso: Sim ou Acesso: Nao
								    			objS01.receberDados();
												System.out.println("\n******************************************************************************************");
												System.out.println("Mensagem recebida do cliente [" + objS01.getCliente().getInetAddress().getHostName()+ "]: "+ objS01.getDadosCifradoReceber());
												System.out.println("******************************************************************************************\n");
															
												objS01.mostrarDadosProcessadoReceber();

												if(true==objS01.tipoServicoReceber("S05")){
													
													if("ACESSO: SIM.".equals(objS01.getDadosProcessadoReceber())){
														objAB.setStatus(true);                                              //Mudar Acesso para - "true" vai sai
														objAB.setDataHoraEntrada(sdf.format(Calendar.getInstance().getTime())); 
														
														quantidadeVagasExterna=quantidadeVagasExterna-1;                    //Diminuir a quantidade de vagas
														break;
													}else{System.out.println("Falha...  Mensagem nao existe.");break;}
												}
												else if(true==objS01.tipoServicoReceber("S04")){
													
													if("ACESSO: NAO.".equals(objS01.getDadosProcessadoReceber())){          //Nao entro - Nao alterar nada
														break;
													}else{System.out.println("Falha...  Mensagem nao existe.");break;}
												}
												else{System.out.println("Falha...  Mensagem nao existe.");break;}
											}//while acesso Entrar - Sim ou Nao
										}
										else{
							    			objS01.enviarDados("A01", "C04", "PERMISSAO: SIM. - ACESSO: LOTADO.");
											objS01.mostrarDadosProcessadoEnviar();
							    		}
							    		break;
										
									}//ACESSAR: ENTRAR
									else{
										//System.out.println("Acesso: "+objAB.getStatus()+" : SAIR");
						    			
										objS01.enviarDados("A01", "C04", "PERMISSAO: SIM. - ACESSO: SAIR.");
										objS01.mostrarDadosProcessadoEnviar();
										
										while(true){                                                          //Espera Resposta se entro - Acesso: Sim ou Acesso: Nao
							    			objS01.receberDados();
											System.out.println("\n******************************************************************************************");
											System.out.println("Mensagem recebida do cliente [" + objS01.getCliente().getInetAddress().getHostName()+ "]: "+ objS01.getDadosCifradoReceber());
											System.out.println("******************************************************************************************\n");
														
											objS01.mostrarDadosProcessadoReceber();
											
											if(true==objS01.tipoServicoReceber("S05")){
												
												if("ACESSO: SIM.".equals(objS01.getDadosProcessadoReceber())){
													objAB.setStatus(false);                                              //Mudar Acesso para - "true" vai sai
													objAB.setDataHoraSaida(sdf.format(Calendar.getInstance().getTime()));                                     //Mudar Acesso para - "true" vai sai
													quantidadeVagasExterna=quantidadeVagasExterna+1;                   //Diminuir a quantidade de vagas
													break;
												}else{System.out.println("Falha...  Mensagem nao existe.");break;}
											}
											else if(true==objS01.tipoServicoReceber("S04")){
												
												if("ACESSO: NAO.".equals(objS01.getDadosProcessadoReceber())){        //Nao entro - Nao alterar nada
													break;
												}else{System.out.println("Falha...  Mensagem nao existe.");break;}
											}
											else{System.out.println("Falha...  Mensagem nao existe.");break;}

										}//while acesso Sair - Sim ou Nao
							    		break;
									}//ACESSAR: SAIR
								}//verifica todos acesso do mesmo cartao
								contA++;
							}//verifica todos acesso
							
							objAD.update(objA1);
							objAD.update(objA2);
							objAD.update(objA3);
							objAD.update(objA4);
							objAD.update(objA5);
							objAD.update(objA6);
							objAD.update(objA7);
							objAD.update(objA8);
							objAD.update(objA9);
							
						}//PERMISSAO: SIM
						
						else if(objCB.getStatus()==false){ //PERMISSAO: NAO
							System.out.println("Permissao: "+objCB.getStatus()+" : NAO");
							objS01.enviarDados("A01", "C03", "PERMISSAO: NAO.");
							objS01.mostrarDadosProcessadoEnviar();
							System.out.println("\n******************************************************************************************");
						}//PERMISSAO: NAO
						
						break;
					}//Cadastrado: SIM
					
					else if(contC==8){
						System.out.println("Cadastrado: "+objCB.getIdCartao()+" : NAO"); //Cadastrado: NAO 
						objS01.enviarDados("A01", "C02", "PERMISSAO: ALERTA.");
						objS01.mostrarDadosProcessadoEnviar();
						System.out.println("\n******************************************************************************************");
				    	break;
					}//Cadastrado: NAO 
					contC++;	
				}//verifica todos cartoes
				
				//manager.getTransaction().commit();
			}
			
			
		
			
			
			
			
			
			//-----------------------------------
			if("FIM".equals(objS01.getDadosProcessadoReceber())){
				System.out.println("Teste - FIM");
				break;
			}
			
		}
		
		objS01.fecharConexao();

		System.out.println("\n\n\n\n\nFIM\n******************************************************************************************");
		
	
	}
}

