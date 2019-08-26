package principal;

import java.util.ArrayList;
import java.util.List;

public class FilaJogadores {
	
		/*
		 * Classe que para Objetos 'FilaJogadores' que tem como função organizar os jogadores
		 * do banco imobiliario
		 * 
		 * @author Matheus Morais
		 * @version 1.0
		 * @since Release 01 da aplicação
		 */
		
		
	
		private List<Jogador> fila;
		private int tamanho;
		private int ponteiro;
		
		
		/*
		 * Metodo contrutor
		 * @param lista ArrayList - lista de jogadores
		 */
		public FilaJogadores (ArrayList<Jogador> lista) {
			
			this.fila = lista;
			this.tamanho = fila.size();
			this.ponteiro = -1;
		}
		
		/*
		 * Metodo que adiciona um jogador na fila
		 * @param jog Jogador- jogador a ser adicionado na fila
		 * @return void
		 */
		public void adicionaJogadorNaFila(Jogador jog) {
			fila.add(jog);
		}
	
		/*
		 * Metodo retorna a quantidade de jogadores
		 * @return int - qantidade de jogadores
		 */
		public int quantidadeJogadores() {
			return this.fila.size();
		}
		/*
		 * Metodo que retorna o jogador que está um indice a frente do jogador
		 * que foi chamado anteriormente, começando pelo primeiro jogador que foi
		 * adicionado. Caso o jogador tenha falido, o método vai retirar o mesmo da
		 * fila e chamar o próximo
		 * 
		 * @return Jogador
		 * 
		 */
		public Jogador proxJogador() {
			this.ponteiro+= 1;
			if(this.ponteiro == this.fila.size()) {
				this.ponteiro = 0;
			}
			if(this.fila.get(this.ponteiro).isOnGame()) {
				return this.fila.get(this.ponteiro);
			}
			fila.remove(this.fila.get(this.ponteiro));
			
			return this.proxJogador();
			

		}
}