package busca;

import java.util.List;

import principal.Jogador;

public class ProcuraNaLista {
	
	//confere se um elemento esta em uma lista retornando seu indice, caso o elemento não esteja
	//o retorna -1"
	public int busca( String [] lista ,String b) {
		
		for(int k = 0;k<lista.length;k++) {
			if(lista[k].toUpperCase().equals(b.toUpperCase())) {
				return k;
			}
		}
			
		return -1;
		
	}
	//confere em uma lista do tipo Jogador se uma certa cor ja foi selecionada, caso positivo retorna o indice
	//do jogador que selecionou a cor ,caso contrario retorna -1
	public int buscaCorJogador(List<Jogador> lista ,String a) {
		for(int k = 0;k<lista.size();k++) {
			if(lista.get(k).getCor().toUpperCase().equals(a.toUpperCase())) {
				return k;
			}
		}
		return -1;

		
	}

}
