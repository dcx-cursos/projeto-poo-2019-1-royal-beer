package tabuleiro;

import java.util.Random;
public class Dado {
	/*
	 * Classe para objetos do tipo dado, onde estão contidos seus metodos
	 * 
	 * @author Matheus Morais
	 * @version 1.0
	 * @since Release 1 da aplicação
	 */
		
	
	
	/*
	 * Metodo que joga dois dados 
	 * @return dados int[] - Array com o valor dos dois dados 
	 * 
	 */
	public int[] JogarDoisDados() {
		Random r = new Random();
		
		int Dados [] = {r.nextInt(5)+1 , r.nextInt(5)+1};
		return Dados;
	
	}

}
