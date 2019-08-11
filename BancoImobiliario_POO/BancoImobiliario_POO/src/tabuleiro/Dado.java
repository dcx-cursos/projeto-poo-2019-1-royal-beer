package tabuleiro;

import java.util.Random;
public class Dado {
		// Nesta classe em que realizamos o sorteio ataraves da biblioteca Java,util.Random
	//dos dados que serão jogados no momento em que o Jogador selecionar a opoção Jogar.
	public int[] JogarDoisDados() {
		Random r = new Random();
		
		int Dados [] = {r.nextInt(5)+1 , r.nextInt(5)+1};
		return Dados;
		
	}

}
