package tabuleiro;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import exceptions.ErroAoGerarCasaException;

public class Tabuleiro  {
	
	private CasaTabuleiro [] tabuleiro = new CasaTabuleiro[40];
	
	private TerrenoFactory factory = new TerrenoFactory();
	
	
	public Tabuleiro() {
		
		try {
			this.geraTabuleiro();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		
	}
	
	public CasaTabuleiro getCasaTabuleiro(int posicao) {
		return tabuleiro[posicao];
	}
	
	public CasaTabuleiro [] getTabuleiro() {
		return this.tabuleiro;
	}
	
	private void geraTabuleiro() throws FileNotFoundException,IOException{
		
		FileReader fileReader = new FileReader("CasasTabuleiro.txt");
		BufferedReader  bufferedReader = new BufferedReader(fileReader);
		
		
		for(int k = 0;k<this.tabuleiro.length;k++) {
			
			String [] casa = bufferedReader.readLine().split(",");
			
			
			if(casa[1].toUpperCase().equals("PONTODEPARTIDA")){
				PontoDePartida temp = new PontoDePartida();
				tabuleiro[Integer.parseInt(casa[0])] = temp;
				
				
	
			}else if(casa[1].toUpperCase().equals("COMPANHIA")) {
				Companhia temp = new Companhia(casa[2],Integer.parseInt(casa[3]),Integer.parseInt(casa[4]),Integer.parseInt(casa[5]));
				tabuleiro[Integer.parseInt(casa[0])] = temp;
				

				
			}else if(casa[1].toUpperCase().equals("SORTEOUREVES")) {
				SorteOuReves temp = new SorteOuReves();
				tabuleiro[Integer.parseInt(casa[0])] = temp;

				
				
				
			}else if(casa[1].toUpperCase().equals("PRISAO")) {
				Prisao temp = new Prisao();
				tabuleiro[Integer.parseInt(casa[0])] = temp;
				

				
			

			}else if(casa[1].toUpperCase().equals("VAPARAPRISAO")){
				VaParaPrisao temp = new VaParaPrisao();
				tabuleiro[Integer.parseInt(casa[0])] = temp;
				

				
				
		
			
			}else if(casa[1].toUpperCase().equals("IMPOSTODERENDA")) {
				ImpostoDeRenda temp = new ImpostoDeRenda();
				tabuleiro[Integer.parseInt(casa[0])] = temp;
				

				
			}else if(casa[1].toUpperCase().equals("LUCROSEDIVIDENDOS")) {
				LucrosEDividendos temp = new LucrosEDividendos();
				tabuleiro[Integer.parseInt(casa[0])] = temp;
				

				
	
				
			}else if(casa[1].toUpperCase().equals("PARADALIVRE")) {
				ParadaLivre temp = new ParadaLivre();
				tabuleiro[Integer.parseInt(casa[0])] = temp;
				

				
			}else {
				CasaTabuleiro temp;
				try {
				temp = factory.criaTerreno(casa[1], casa[2], Double.parseDouble(casa[3]), Double.parseDouble(casa[4]),
						Double.parseDouble(casa[5]), Double.parseDouble(casa[6]), Double.parseDouble(casa[7]),
						Double.parseDouble(casa[8]), Double.parseDouble(casa[9]), Double.parseDouble(casa[10]), 
						Double.parseDouble(casa[11]));
				
						tabuleiro[Integer.parseInt(casa[0])] = temp;
				}catch(ErroAoGerarCasaException e) {
					System.out.println(e.toString());
				}

				
			
				
			}
		
		}
		
		
		fileReader.close();
		bufferedReader.close();
	
	
	}
	
	public CasaTabuleiro getCartasLugares(int posicao) {
			return tabuleiro[posicao];
			
		}
	
	public Prisao getPrisao() {
		return (Prisao) this.getCasaTabuleiro(10);
	}
		
		
	}
	
	
	
	
	
	


