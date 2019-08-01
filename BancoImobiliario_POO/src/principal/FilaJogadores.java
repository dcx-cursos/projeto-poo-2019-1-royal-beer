package principal;

import java.util.ArrayList;
import java.util.List;

public class FilaJogadores {
	

		
		//Essa classe fila foi desenvolvida especificamente para lidar com a fila de jogadores do banco imobiliario	
		
	
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
		
		public Jogador proxJogador() {
			this.ponteiro+= 1;
			if(this.ponteiro == this.fila.size()) {
				this.ponteiro = 0;
			}
			return this.fila.get(this.ponteiro) ;

		}
}