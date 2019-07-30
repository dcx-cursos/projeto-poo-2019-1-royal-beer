package principal;

import java.util.ArrayList;

import exceptions.EntradaInvalidaException;

public class Menu {
	
	ArrayList<Jogador> jogadores = new ArrayList<>();
	
	public void cadastraJogador(String nome , String cor) throws EntradaInvalidaException {
		
		Jogador jog = new Jogador(nome,cor);
		
		for(Jogador k : jogadores) {
			if(k.getCor().equals(cor)) {
				
				throw new exceptions.EntradaInvalidaException("Cor já escolhida");
			}
		}
		jogadores.add(jog);
	
	}public ArrayList<Jogador> getListaJogadores(){
		return this.jogadores;
		
	}
	
	
	
	
}
