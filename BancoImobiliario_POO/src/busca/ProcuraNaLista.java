package busca;

import java.util.List;

import principal.Jogador;

public class ProcuraNaLista {
	
	/*
	 *Objeto para fazer busca na lista e auxiliar o cadastro de jogadores do banco
	 *imobiliario
	 * @author Matheus Morais
	 * @version 1.0
	 * @since Release 1 da aplicação
	 */
	
	
	/*
	 * Metodo para busca de uma String dentro de um array
	 * @param lista []  - array com strings
	 * @param b  String - string a ser procurada em lista
	 * @return int -1 caso não encontre a String ou indice da String caso ache
	 */
	public int busca( String [] lista ,String b) {
		
		for(int k = 0;k<lista.length;k++) {
			if(lista[k].toUpperCase().equals(b.toUpperCase())) {
				return k;
			}
		}
			
		return -1;
		
	}
	/*
	 * Método que busca se a cor escolhida está disponivel
	 * @param lista List- lista de jogadores 
	 * @param a String - cor a ser checada se algum jogador possui
	 * @return -1 caso esteja disponivel ou o indice do objeto caso encontre
	 */

	public int buscaCorJogador(List<Jogador> lista ,String a) {
		for(int k = 0;k<lista.size();k++) {
			if(lista.get(k).getCor().toUpperCase().equals(a.toUpperCase())) {
				return k;
			}
		}
		return -1;

	}
	
	public void removeStringDaLista() {
		
	}

	
	

}
