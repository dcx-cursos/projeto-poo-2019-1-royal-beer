package principal;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.EntradaInvalidaException;



public class Main {
	public static void main(String args[])  {
		
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
			}catch(EntradaInvalidaException e ) {
				System.out.println(e.toString());
				continue;
			}
			cont++;
			
			if(numJogadores == cont) break;
		}
		

		FilaB jogadores = new FilaB(menu.getListaJogadores());
		System.out.println("O Banco Imobiliario ja vai começar.Aproveite!!");
		Jogador jogador = jogadores.proxJogador();// variavel que guarda o jogador da vez
		System.out.printf("A jogada de %s (%s) começou\n",jogador.getNome(), jogador.getCor());
		System.out.println("Comandos disponiveis: [Jogar] [Sair]");
		System.out.println("Entre com um comando");
	
		
		
			
		

		
		
		
			
		}//fim main
		
		
	
		
	}//fim class


