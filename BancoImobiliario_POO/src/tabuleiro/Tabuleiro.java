package tabuleiro;

import java.util.List;

public class Tabuleiro {
	
	private CasaTabuleiro [] a = new CasaTabuleiro[40];
	
	
	public Tabuleiro() {
		a[0] = new PontoDePartida();
		a[1] = new CartasLugares("Leblon","roxo",100,6,30,90,270,400,500,50,50);
		a[3] = new CartaSorteOuReves();
		a[4] = new CartasLugares("Av. Presidente Vargas","roxo",60,2,10,30,90,160,250,30,50);
		a[5] = new CartasLugares("Av. Nossa Senhora de Copacabana","roxo",60,2,10,30,90,160,250,30,50);
		//a[6] = new 
	}
	
	public CasaTabuleiro [] getTabuleiro() {
		return a;
	}
	
	
	
	

}

