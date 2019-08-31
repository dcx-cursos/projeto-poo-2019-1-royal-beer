package principal;


import java.util.Scanner;

import exceptions.ComandoIndisponivelException;
import exceptions.CorIndisponivelException;
import exceptions.ErroAoCalcularAluguelException;
import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;
import tabuleiro.Companhia;
import tabuleiro.Terreno;
import tabuleiro.TerrenoAmarelo;
import tabuleiro.TerrenoRosa;



public class Main {
	public static void main(String args[])  {

		JogoFacade facade = new JogoFacade();
		
		Scanner sc = new Scanner(System.in);
		
		int numJogadores = 0;
		
		String corNovoJogador = null;
		
		String comandoSelecionado;
		
		
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
				String comando = null;
				comando = sc.nextLine();
				String jogadaStr = null;
				try {
				jogadaStr = facade.geraJogada(comando);
				}catch(ErroAoCalcularAluguelException| ValorNegativoException| SaldoInsuficienteException| ComandoIndisponivelException e) {
					System.out.println(e.toString());
				}
				System.out.println(jogadaStr);
				if(facade.isCompanhiaCasaAtual()) {
					Companhia temp = (Companhia) facade.getCasaAtual();
					if(!temp.hasDono()) {
						comando = sc.nextLine();
						if(comando.toUpperCase().startsWith("S")) {
							try {
							temp.comprar(facade.getJogadorDaVez());
							}catch(SaldoInsuficienteException e) {
							System.out.println(e.toString());
							}
							System.out.println("Compra realizada com sucesso");
						}
					}
				}else if(facade.isTerrenoCasaAtual()) {
					Terreno temp = (Terreno) facade.getCasaAtual();
					if(!temp.hasDono()) {
						comando = sc.nextLine();
						if(comando.toUpperCase().startsWith("S")) {
							try {
								temp.comprar(facade.getJogadorDaVez());
							}catch(SaldoInsuficienteException e) {
							System.out.println(e.toString());
							}
							System.out.println("Compra realizada com sucesso");
						}
					}
				}
		}//fim do laco do jogo
		System.out.println("Jogo encerrado");
		
		
	}//fim main

}	
