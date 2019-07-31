package principal;

import java.awt.List;
import java.util.ArrayList;

public class FilaB {
		
		//Essa classe fila foi desenvolvida especificamente para lidar com a fila de jogadores do banco imobiliario	
		
	
		private ArrayList<Jogador> fila;
		private int tamanho;
		private int ponteiro;
		
		public FilaB (ArrayList lista) {
		
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