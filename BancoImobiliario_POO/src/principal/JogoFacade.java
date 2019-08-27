package principal;

import java.util.ArrayList;

import busca.ProcuraNaLista;
import exceptions.CorInexistenteException;
import exceptions.CorJaEscolhidaException;
import exceptions.EntradaInvalidaException;

public class Menu {
	
	/*
	 * Classe que tem como função auxiliar no cadastro dos jogadores
	 * @author Matheus Morais
	 * @version 1.0
	 * @since Release 1 da aplicação 
	 */
	
	ArrayList<Jogador> jogadores = new ArrayList<>();

	private String []  cores= {"PRETO","BRANCO","VERMELHO","VERDE","AZUL","AMARELO","LARANJA","ROSA"};
	
	/*
	 * Metodo tem como funcao cadastrar o jogador, caso a cor que o jogador selecionou
	 * ja tenha sido escolhida ou não esteja dentro das opções o metodo lançara exceções
	 * @param nome String - nome do jogador a ser cadastrado
	 * @param cor String - cor do jogador a ser cadastrado
	 * @return void 
	 */
	public void cadastraJogador(String nome , String cor) throws  CorInexistenteException, CorJaEscolhidaException {
		
		
		ProcuraNaLista searcher = new ProcuraNaLista();
		if(searcher.buscaCorJogador(jogadores,cor)== -1) {
			if(searcher.busca(cores,cor)!= -1) {
				Jogador jog = new Jogador(nome,cor);
				this.jogadores.add(jog);
				
			}else {
				throw new CorInexistenteException("A cor escolhida não está dentre as opções");
			}
		}else {
			throw new CorJaEscolhidaException("A cor escolhida ja foi selecionada por outro jogador! Escolha novamente");
		}
	
	}
	
	public ArrayList<Jogador> getListaJogadores(){
		return this.jogadores;
		
	}
	

	
	
	

	
	
}
