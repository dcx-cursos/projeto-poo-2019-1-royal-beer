package principal;

import java.util.ArrayList;

import busca.ProcuraNaLista;
import exceptions.CorInexistenteException;
import exceptions.CorJaEscolhidaException;
import exceptions.EntradaInvalidaException;

public class Menu {
	
	ArrayList<Jogador> jogadores = new ArrayList<>();
	
	private String []  cores= {"PRETO","BRANCO","VERMELHO","VERDE","AZUL","AMARELO","LARANJA","ROSA"};
	
	public void cadastraJogador(String nome , String cor) throws  CorInexistenteException, CorJaEscolhidaException {
		
		
		ProcuraNaLista searcher = new ProcuraNaLista();
		System.out.println(searcher.busca(cores, cor));
		System.out.println(searcher.buscaCorJogador(jogadores, cor));
		if(searcher.buscaCorJogador(jogadores,cor)== -1) {
			if(searcher.busca(cores,cor)!= -1) {
				Jogador jog = new Jogador(nome,cor);
				this.jogadores.add(jog);
				
			}else {
				throw new CorInexistenteException("A cor escolhida não está dentre as opções");
			}
		}else {
			throw new CorJaEscolhidaException("A cor escolhida ja foi selecionada por outro jogador?");
		}
	
	}
	
	public ArrayList<Jogador> getListaJogadores(){
		return this.jogadores;
		
	}
	

	
	
}
