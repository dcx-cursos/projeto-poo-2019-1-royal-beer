package principal;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.CorInexistenteException;
import exceptions.CorJaEscolhidaException;
import exceptions.EntradaInvalidaException;
import exceptions.ErroAoCalcularAluguelException;
import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;
import tabuleiro.CartaSorteOuReves;
import tabuleiro.CartasLugares;
import tabuleiro.CasaTabuleiro;
import tabuleiro.Companhia;
import tabuleiro.Dado;
import tabuleiro.ImpostoDeRenda;
import tabuleiro.LucrosEDividendos;
import tabuleiro.ParadaLivre;
import tabuleiro.Prisao;
import tabuleiro.Tabuleiro;
import tabuleiro.VaParaPrisao;



public class Main {
	public static void main(String args[])   {

		boolean continueGame = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Banco Imobiliario\n");
		
		Menu menu = new Menu();
		Dado dado = new Dado();
		
		int numJogadores;
		
		// Receber o numero de jogadores e verificar se atende aos parametros;
		while(true) {
			System.out.print("Digite o numero de jogadores [2-8] - ");
		try {
			numJogadores = Integer.parseInt(sc.nextLine());
			if(numJogadores>= 2 && numJogadores<=8) {
				break;
			}
			else {
				System.out.println("Entrada inválida");
				continue;
			}
			
		}catch (NumberFormatException e ) {
			System.out.println("Entrada inválida");
		}
		
		}
		int cont = 0;
		while(true) {
			System.out.printf("Digite o nome do Jogador %d - ",cont+1);
			String nomeJogador = sc.nextLine();
			while(true) {
			System.out.printf("\nEscolha a cor do peão do jogador %d entre as opções seguintes:\n" + 
					"[preto][branco][vermelho][verde][azul][amarelo][laranja][rosa]\n",cont+1);
			
			String corEscolhida = sc.nextLine();

			try {
				menu.cadastraJogador(nomeJogador, corEscolhida);
			}catch(CorInexistenteException e ) {
				System.out.println(e.toString());
				cont --;
				continue;
			}catch(CorJaEscolhidaException e) {
				System.out.println(e.toString());
				cont--;
				continue;
			}finally {
				cont++;
			}
			break;
			}
			
			if(numJogadores == cont) break;
		}
		

		FilaJogadores jogadores = new FilaJogadores(menu.getListaJogadores());
		
		System.out.println("O Banco Imobiliario ja vai começar.Aproveite!!");
		Tabuleiro tabuleiro = new Tabuleiro();
		
		
		Jogador jogador = jogadores.proxJogador();//Variavel que guarda o jogador da vez
		
		
		
		
		//Inicia a partida com um laço que sai ao terminar o jogo ou quando todos jogadores escolhem sair
		while(true) {
			
			
			
			System.out.printf("A jogada de %s (%s) começou\n",jogador.getNome(), jogador.getCor());
			System.out.println("Comandos disponiveis: [Jogar] [Sair] [Status]");
			System.out.println("Entre com um comando");
			
			String comando = sc.nextLine();
			
			if(comando.toUpperCase().startsWith("SA")) {
				
					while(true) {
						System.out.println("Você realmente quer sair?");
						String opcao = sc.nextLine();
						if(opcao.toUpperCase().startsWith("S")) {
							continueGame = false;
							break;
						}else if (opcao.toUpperCase().startsWith("N")) {
							break;
						}else {
							System.out.println("Comando inválido");
							continue;
							}
				}
					if (continueGame == false) {
						System.out.println("Jogo Encerrado");
						break;
					}
				
			}else if (comando.toUpperCase().startsWith("JO")) {

				int dadosJogados [] = dado.JogarDoisDados(); 
				jogador.andarCasas(dadosJogados);
				CasaTabuleiro cartaAtual = null;
				try {
					cartaAtual = tabuleiro.getCasaTabuleiro(jogador.getPosicao());
				}catch(EntradaInvalidaException e) {
					e.toString();
				}
			 
				System.out.println("O jogador "+ jogador.getNome() + "("+ jogador.getCor()+") "
						+"tirou " + dadosJogados[0] + "," + dadosJogados[1] + " e o peão avançou para " 
						+jogador.getPosicao()+ " -" + cartaAtual.getNome()+"\n");
						
						int posicaoJogador = jogador.getPosicao();
				
						 if(posicaoJogador == 10) { 
							 Prisao cartaEmUso = (Prisao) cartaAtual;
						 }else if(posicaoJogador == 2||posicaoJogador == 12||posicaoJogador ==16
								 ||posicaoJogador ==22||posicaoJogador == 27||posicaoJogador == 37) {
							 	
							 CartaSorteOuReves cartaEmUso = (CartaSorteOuReves) cartaAtual;
				
							 
							 System.out.println("Parada livre");
							 
						 }else if (posicaoJogador == 5|| posicaoJogador == 7 || posicaoJogador == 15
								 || posicaoJogador == 25 ||posicaoJogador == 32|| posicaoJogador == 35) {
							 
							 Companhia cartaEmUso = (Companhia) cartaAtual;
							 
							 System.out.println("Parada livre");
							 
						 }else if (jogador.getPosicao() == 18) {
							 
							 LucrosEDividendos cartaEmUso = (LucrosEDividendos) cartaAtual;
							 cartaEmUso.ativaLucrosEDividendos(jogador);
							 
						 }else if(jogador.getPosicao()== 20) {
							 
							 ParadaLivre cartaEmUso = (ParadaLivre) cartaAtual;
							 System.out.println("Parada livre");
						 }
						 else if(jogador.getPosicao() == 24) {
							 
							 ImpostoDeRenda cartaEmUso = (ImpostoDeRenda) cartaAtual;
							 try {
							 cartaEmUso.ativaImpostoDeRenda(jogador);
							 }catch(ValorNegativoException e) {
								 e.toString();
							 }catch(SaldoInsuficienteException e){
								 e.toString();
							 }
							 
							 
						 }else if(jogador.getPosicao() == 30) {
							 
							 VaParaPrisao cartaEmUso = (VaParaPrisao) cartaAtual;
							 System.out.println("Parada livre");
						
						 }else if(jogador.getPosicao() == 0){
							 System.out.println("Parada Livre");
						 }else {
							CartasLugares cartaEmUso = (CartasLugares) cartaAtual;
							if(cartaEmUso.hasDono()) {
								try {
								System.out.println("Essa propriedade é de "+cartaEmUso.getDono().getNome()
										+"o valor do aluguel a ser debitado é de "+cartaEmUso.getAluguel());
								try {
								cartaEmUso.cobraAluguel(jogador);
								}catch(SaldoInsuficienteException e) {
									System.out.println(e.toString());
								}
										
								}catch(ErroAoCalcularAluguelException |ValorNegativoException e) {
									e.toString();
								}
								}else {
									System.out.println("O titulo da propriedade "+cartaEmUso.getNome() +" está disponivel por"
											+ " por $ " + cartaEmUso.getPreco());
									if(jogador.getDinheiro() > cartaEmUso.getPreco()) {
										System.out.println(jogador.getNome()+",você possui "+jogador.getDinheiro()
										+"\nDeseja comprar "+cartaEmUso.getNome()+" ? [S/N] ");
										String opcao = sc.nextLine();
										if(opcao.toUpperCase().startsWith("S")) {
											try {
											cartaEmUso.comprar(jogador);
											}catch(ValorNegativoException|  SaldoInsuficienteException e){
												System.out.println(e.toString());
											}
										}
									}else {
										System.out.println("Você não possui dinheiro para comprar a propriedade");
									}
							}
						 }
						
				jogador = jogadores.proxJogador();
			
				
				
			}else if (comando.toUpperCase().startsWith("ST")) {
				
				System.out.println(jogador.getStatus());
				
				
				
			}
		}
			
			
	
			
		
			
		

		
		
		
			
		}//fim main
		
		
	
		
	}//fim class


