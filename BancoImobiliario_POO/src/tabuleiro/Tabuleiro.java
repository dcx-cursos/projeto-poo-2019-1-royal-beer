package tabuleiro;

import java.util.List;

public class Tabuleiro {
	
	private CasaTabuleiro [] a = new CasaTabuleiro[40];
	
	
	public Tabuleiro() {
		
		CartaSorteOuReves cartaSorteOuReves = new CartaSorteOuReves();
		
		a[0] = new PontoDePartida();
		a[1] = new CartasLugares("Leblon","rosa",100,6,30,90,270,400,500,50,50);
		a[2] = cartaSorteOuReves;
		a[3] = new CartasLugares("Av. Presidente Vargas","rosa",60,2,10,30,90,160,250,30,50);
		a[4] = new CartasLugares("Av. Nossa Senhora de Copacabana","rosa",60,2,10,30,90,160,250,30,50);
		a[5] = new Companhia("Companhia Ferroviaria",200,100,50);
		a[6] = new CartasLugares("Av. Brigadeiro Faria Lima","azul",240,20,100,300,750,925,1100,120,150);
		a[7] = new Companhia("Companhia de Viação",200,100,50);
		a[8] = new CartasLugares("Av. Rebouças","azul",220,18,90,250,700,875,1050,110,150);
		a[9] = new CartasLugares("Av. 9 de Julho","azul",220,18,90,250,700,875,1050,110,150);
		a[10] = new Prisao();//Lembrar de alterar
		a[11] = new CartasLugares("Av. Europa","roxo",200,16,80,220,600,800,1000,100,100);
		a[12] = cartaSorteOuReves;
		a[13] = new CartasLugares("Rua Augusta","roxo",180,14,70,200,550,750,950,90,100);
		a[14] = new CartasLugares("Av Pacaembu","roxo",180,14,70,200,550,750,950,90,100);
		a[15] = new Companhia("Companhia de Táxi",150,75,40);
		a[16] = cartaSorteOuReves;
		a[17] = new CartasLugares("Interlagos","laranja",350,35,175,500,1100,1300,1500,175,200);
		a[18] = new LucrosEDividendos();
		a[19] = new CartasLugares("Morumbi","laranja",400,50,200,600,1400,1700,2000,200,200);
		a[20] = new ParadaLivre();
		a[21] = new CartasLugares("Flamengo","vermelho",120,8,40,100,300,450,600,60,50);
		a[22] = cartaSorteOuReves;
		a[23] = new CartasLugares("Botafogo","vermelho",100,6,30,90,270,400,500,50,50);
		a[24] = new ImpostoDeRenda();
		a[25] = new Companhia("Companhia de Navegação",150,75,40);
		a[26] = new CartasLugares("Av. Brasil","amarelo",160,12,60,180,500,700,900,80,100);
		a[27] = cartaSorteOuReves;
		a[28] = new CartasLugares("Av. Paulista","amarelo",140,10,50,150,450,625,750,70,100);
		a[29] = new CartasLugares("Jardim Europa","amarelo",140,12,60,180,500,700,900,80,100);
		a[30] = new VaParaPrisao();
		a[31] = new CartasLugares("Copacabana","verde",260,22,110,330,800,975,1150,130,150);
		a[32] = new Companhia("Companhia de Aviação",150,75,40);
		a[34] = new CartasLugares("Av. Atlântica","verde",300,26,130,390,900,1100,1275,150,200);
		a[35] = new Companhia("Companhia de Táxi Aéreo",200,100,50);
		a[36] = new CartasLugares("Ipanema","verde",300,26,130,390,900,1100,1275,150,200);
		a[37] = cartaSorteOuReves;
		a[38] = new CartasLugares("Jardim Paulista","jazz",280,24,120,360,850,1025,1200,140,150);
		a[39] = new CartasLugares("Brooklin","jazz",260,22,110,330,800,975,1150,130,150);
		
	}
	
	public CasaTabuleiro [] getTabuleiro() {
		return a;
	}
	
	
	
	

}

