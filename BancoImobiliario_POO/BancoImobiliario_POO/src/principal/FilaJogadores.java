package principal;

import java.util.ArrayList;
import java.util.List;

public class FilaJogadores {
	

		
		//Essa classe fila foi desenvolvida especificamente para lidar com a fila de jogadores do banco imobiliario	
		// guardando a ordem na sequencia em que os jogadore são cadastrados no jogo.
	
		private List<Jogador> fila;
		private int tamanho;
		private int ponteiro;
		
		public void adicionaJogadorNaFila(Jogador jog) {
			fila.add(jog);
		}
		
		public FilaJogadores (ArrayList<Jogador> lista) {
		
			this.fila = lista;
			this.tamanho = fila.size();
			this.ponteiro = -1;
		}
		
		public int quantidadeJogadores() {
			return this.fila.size();
		}
		
		public Jogador proxJogador() {
			this.ponteiro+= 1;
			if(this.ponteiro == this.fila.size()) {
				this.ponteiro = 0;
			}
			if(this.fila.get(this.ponteiro).isOnGame() == true) {
				return this.fila.get(this.ponteiro);
			}
			fila.remove(this.fila.get(this.ponteiro));
			
			return this.proxJogador();
			

		}
}