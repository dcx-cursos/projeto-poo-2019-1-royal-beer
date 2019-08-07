package principal;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.CorInexistenteException;
import exceptions.CorJaEscolhidaException;
import exceptions.EntradaInvalidaException;
import tabuleiro.Tabuleiro;



public class Main {
	public static void main(String args[])   {
		
		boolean continueGame = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Banco Imobiliario\n");
		
		Menu menu = new Menu();
		
		int numJogadores;
		
		// Receber o numero de jogadores e verificar se atende aos parametros;
		while(true) {
			System.out.print("Digite o numero de jogadores [2-8]");
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
			System.out.printf("Digite o nome do Jogador %d",cont+1);
			String nomeJogador = sc.nextLine();
			
			System.out.printf("Escolha a cor do peão do jogador %d entre as opções seguintes:\n" + 
					"\n" + 
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
			
				
				jogador = jogadores.proxJogador(); //Variavel que guarda o jogador da vez
			}
			else if (comando.toUpperCase().startsWith("ST")) {
				
				jogador.getStatus();
				
			}
			
			
		}
	
		
		
			
		

		
		
		
			
		}//fim main
		
		
	
		
	}//fim class


