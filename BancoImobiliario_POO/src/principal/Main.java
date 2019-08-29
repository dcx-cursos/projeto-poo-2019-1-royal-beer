package principal;


import java.util.Scanner;

import exceptions.CorIndisponivelException;



public class Main {
	public static void main(String args[]) {

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
		while(facade.getJogadores().size() >= 1) {
			Jogador jogadorDaVez = facade.getProxJogador();
			System.out.println("A jogada de "+ jogadorDaVez.getNome()+" ("+jogadorDaVez.getCor()+") "
					+"começou");
			System.out.println("Comandos disponiveis : "+ facade.getStringDeComandos()
			+"\nEntre com um comando");
			String comandoSelecionado = sc.nextLine();
		}
		
		
		
	}//fim main

}	
