package tabuleiro;

import java.util.Random;

public class Dado {
	
	public int [] jogarDados() {
		int [] numeros=new int [2];
		Random random= new Random();
		numeros[0]= random.nextInt(6)+1;
		numeros[1]= random.nextInt(6)+1;
		return numeros;
	}

}
