package tabuleiro;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class SorteOuReves implements CasaTabuleiro{
	
	private FilaDeCartas baralho  = new FilaDeCartas();


	public SorteOuReves() {
		
		this.geraBaralho();
	}
	public void geraBaralho()  {
		
		
		ArrayList<Efeito> temp = new ArrayList<>();
		
		temp.add(new DiaDoCasamento());
		temp.add(new CartaSaiaDaPrisao());
		temp.add(new CartaVaParaPrisao());
		temp.add(new CartaVaParaOInicio());
		temp.add(new CartaParOuImpar());
		
		FileReader fileReader = null;
		try {
		fileReader = new FileReader("cartasSorteOuReves.txt");
		}catch(FileNotFoundException e) {
			System.out.println(e.toString());
		}
		BufferedReader  bufferedReader = new BufferedReader(fileReader);
		String [] temp1 = null;
		for(int k = 0 ; k<26;k++) {
			try {
			 temp1 = bufferedReader.readLine().split(",");
			}catch(IOException e) {
				k--;
				System.out.println(e.toString());
				continue;
			}catch(NullPointerException e) {
				break;
			}
		
			if(temp1[0].equals("Sorte")) {
				temp.add(new CartaSorte(temp1[1],Integer.parseInt(temp1[2])));
			}else if(temp1.equals("Reves")) {
				temp.add(new CartaReves(temp1[1],Integer.parseInt(temp1[2])));
			}
			
		
		
		
			Random random= new Random();
			int num;
			while(temp.size()>0) {
			num = random.nextInt(temp.size());
			baralho.enfileirar(temp.get(num));
			temp.remove(num);
			}
		}
		
		}


	
	
	public String getNome() {
		return "Sorte ou Reves";
		
		
	}
	public String getTipo() {
		return "SORTEOUREVES";
	}
	
	public Efeito getProxCarta() {
		return this.baralho.getCarta();
	}

	
	

}
