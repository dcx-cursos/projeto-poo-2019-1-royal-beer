package principal;


import java.util.Scanner;

import exceptions.ComandoIndisponivelException;
import exceptions.CorIndisponivelException;
import exceptions.ErroAoCalcularAluguelException;
import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;
import tabuleiro.Companhia;
import tabuleiro.Terreno;
import tabuleiro.Titulo;



public class Main {
	
	public static void main(String args[])  {

		JogoFacade facade = new JogoFacade();
		
		Scanner sc = new Scanner(System.in);
		
		int numJogadores = 0;
		
		String corNovoJogador = null;
		
		//Inicio do laço para seleção de quantidade de jogadores
		while(true) {
		System.out.println("Digite o numero de jogadores");
		try {
			numJogadores= Integer.parseInt(sc.nextLine());
			if(facade.verificaNumeroDeJogadores(numJogadores)) {
				break;
			}else {
				System.out.println("Entrada inválida");
				continue;
			}
			
		}catch(NullPointerException|NumberFormatException e) {
			System.out.println("Entrada inválida");
			continue;
		}
		}//Fim do laço da seleção da quantidade de jogadores
		
		
		//inicio do laço de cadastro de jogadores
		for(int k =0;k<numJogadores;k++) {
			System.out.println("Digite o nome do jogador "+(k+1)+": ");
			String nomeNovoJogador = sc.nextLine();

			//Inicio do laço para seleção de cor
			while(true) {
				System.out.println("Digite a cor do jogador "+(k+1)+ " dentre as opções abaixo");
				System.out.println(facade.getStringDeCores());
				corNovoJogador = sc.nextLine();
				if(facade.verificaCorNaLista(corNovoJogador) != -1) {
					break;
				}else {
					System.out.println("Cor inválida");	
				}	
			}
			//Fim do laço para seleção de cor
			try {
				facade.cadastraJogador(nomeNovoJogador, corNovoJogador);
			}catch(CorIndisponivelException e) {
				k--;
				System.out.println(e.toString());
			}
			}
		//Fim do laço de cadastro de jogadores
		
		
		//Começo do Jogo
		
		System.out.println("O Banco Imobiliario vai começar. Aproveite!!");
		
		//Inicio do laço do jogo
		while(facade.verificaSeJogoEstaAtivo()) {
				System.out.println(facade.iniciaJogada());
				String comando ;
				comando = sc.nextLine();
				if(comando.toUpperCase().startsWith("SAIR")) {
					System.out.println("Deseja mesmo sair?[SIM][NAO]");
					String temp = sc.nextLine();
					if(temp.toUpperCase().startsWith("S")) {
						
					}else if(temp.toUpperCase().startsWith("N")) {
						facade.decrementaPonteiro();
						continue;
					}
				}
				String jogadaStr = null;
				try {
				jogadaStr = facade.geraJogada(comando);
				}catch(ErroAoCalcularAluguelException| ValorNegativoException| SaldoInsuficienteException| ComandoIndisponivelException e) {
					System.out.println(e.toString());
					continue;
				}
				System.out.println(jogadaStr);
				
				if(facade.getCasaAtual().getTipo().contentEquals("SORTEOUREVES")) {
					System.out.println("Entri");
					continue;
				}
				
				if(comando.toUpperCase().startsWith("CONST")) {
				while (true) {
					int temp;
					System.out.println("Digite o numero da propriedade(0 para sair)");
					try {
						temp = Integer.parseInt(sc.nextLine());
					}catch(Exception e) {
						System.out.println("Entrada inválida");
						continue;
					}
					if(temp == 0) break;
					if(temp > 0 && temp <= facade.GetConstrucoes().size()+1) {
						try {
						facade.GetConstrucoes().get(temp-1).comprarCasa();
						System.out.println(facade.GetConstrucoes().size());
						}catch( SaldoInsuficienteException  e ) {
							System.out.println(e.toString());
						}catch( IndexOutOfBoundsException e) {
							System.out.println("Entrada invalida");
						}
					}
					System.out.println(facade.getStringDeConstrucao());
					
				}
				facade.decrementaPonteiro();
				continue;
				}
				
				if(facade.isCompanhiaCasaAtual()) {
					Titulo temp = (Titulo) facade.getCasaAtual();
					if(!temp.hasDono()) {
						comando = sc.nextLine();
						if(comando.toUpperCase().toUpperCase().startsWith("SI")) {
							try {
							temp.comprar(facade.getJogadorDaVez(),(Titulo)facade.getCasaTabuleiro(facade.getJogadorDaVez().getPosicao()));
							}catch(SaldoInsuficienteException e) {
							System.out.println(e.toString());
							}
							System.out.println("Compra realizada com sucesso");
						}else if(comando.toUpperCase().toUpperCase().startsWith("N")) {
							continue;
						}
					}
				}else if(facade.isTerrenoCasaAtual()) {
					Titulo temp = (Titulo) facade.getCasaAtual();
					if(!temp.hasDono()) {
						comando = sc.nextLine();
						if(comando.toUpperCase().startsWith("S")) {
							try {
								temp.comprar(facade.getJogadorDaVez(),(Titulo)facade.getCasaTabuleiro(facade.getJogadorDaVez().getPosicao()));
							}catch(SaldoInsuficienteException e) {
							System.out.println(e.toString());
							}
							System.out.println("Compra rearalizada com sucesso");
						}else if(comando.toUpperCase().startsWith("N")) {
							continue;
						}
						
					}
				}
		}//fim do laco do jogo
		
		
		sc.close();
	}//fim main

}	

