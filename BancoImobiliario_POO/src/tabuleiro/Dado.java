package tabuleiro;

import java.util.List;
import java.util.Random;
public class Dado {
		
	public int[] JogarDoisDados() {
		Random r = new Random();
		
		int Dados [] = {r.nextInt(5)+1 , r.nextInt(5)+1};
		return Dados;
		
	}

}
