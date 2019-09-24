package tabuleiro;

import java.util.ArrayList;

import exceptions.ErroAoGerarCasaException;
import principal.Jogador;

public class TerrenoFactory  {
	
	private ArrayList <TerrenoAmarelo> terrenosAmarelos = new ArrayList<>();
	
	private ArrayList <TerrenoAzul> terrenosAzuis = new ArrayList<>();
	
	private ArrayList <TerrenoCiano> terrenosCiano = new ArrayList<>();
	
	private ArrayList <TerrenoLaranja> terrenosLaranja = new ArrayList<>();
	
	private ArrayList <TerrenoRosa> terrenosRosa = new ArrayList<>();
	
	private ArrayList <TerrenoRoxo> terrenosRoxos = new ArrayList<>();
	
	private ArrayList <TerrenoVerde> terrenosVerdes = new ArrayList<>();
	
	private ArrayList <TerrenoVermelho> terrenosVermelhos = new ArrayList<>();
	
	
	
	
	public CasaTabuleiro criaTerreno(String nome,String cor, double preco, double valorAluguelSemCasa, double valorAluguelCom1Casa,
			double valorAluguelCom2Casas, double valorAluguelCom3Casas, double valorAluguelCom4Casas,
			double valorAluguelComHotel, double valorHipoteca, double valorImovelCasa) throws ErroAoGerarCasaException {
		
		if(cor.toUpperCase().equals("AMARELO")) {

			return this.criaTerrenoAmarelo(nome, preco, valorAluguelSemCasa, valorAluguelCom1Casa, valorAluguelCom2Casas,
					valorAluguelCom3Casas, valorAluguelCom4Casas, valorAluguelComHotel, valorHipoteca, valorImovelCasa);
			

		}else if(cor.toUpperCase().equals("AZUL")) {

			return this.criaTerrenoAzul(nome, preco, valorAluguelSemCasa, valorAluguelCom1Casa, valorAluguelCom2Casas,
					valorAluguelCom3Casas, valorAluguelCom4Casas, valorAluguelComHotel, valorHipoteca, valorImovelCasa);
		
		}else if(cor.toUpperCase().equals("CIANO")) {

			return this.criaTerrenoCiano(nome, preco, valorAluguelSemCasa, valorAluguelCom1Casa, valorAluguelCom2Casas,
					valorAluguelCom3Casas, valorAluguelCom4Casas, valorAluguelComHotel, valorHipoteca, valorImovelCasa);
			
		}else if(cor.toUpperCase().equals("LARANJA")) {

			return this.criaTerrenoLaranja(nome, preco, valorAluguelSemCasa, valorAluguelCom1Casa, valorAluguelCom2Casas,
					valorAluguelCom3Casas, valorAluguelCom4Casas, valorAluguelComHotel, valorHipoteca, valorImovelCasa);
			
		}else if(cor.toUpperCase().equals("ROSA")) {

			return this.criaTerrenoRosa(nome, preco, valorAluguelSemCasa, valorAluguelCom1Casa, valorAluguelCom2Casas,
					valorAluguelCom3Casas, valorAluguelCom4Casas, valorAluguelComHotel, valorHipoteca, valorImovelCasa);
		
		}else if(cor.toUpperCase().equals("ROXO")) {

			return this.criaTerrenoRoxo(nome, preco, valorAluguelSemCasa, valorAluguelCom1Casa, valorAluguelCom2Casas,
					valorAluguelCom3Casas, valorAluguelCom4Casas, valorAluguelComHotel, valorHipoteca, valorImovelCasa);
			
		}else if(cor.toUpperCase().equals("VERDE")){

			return this.criaTerrenoVerde(nome, preco, valorAluguelSemCasa, valorAluguelCom1Casa, valorAluguelCom2Casas,
					valorAluguelCom3Casas, valorAluguelCom4Casas, valorAluguelComHotel, valorHipoteca, valorImovelCasa);
			
		}else if(cor.toUpperCase().equals("VERMELHO")) {

			return this.criaTerrenoVermelho(nome, preco, valorAluguelSemCasa, valorAluguelCom1Casa, valorAluguelCom2Casas,
					valorAluguelCom3Casas, valorAluguelCom4Casas, valorAluguelComHotel, valorHipoteca, valorImovelCasa);
		}


		throw new ErroAoGerarCasaException("A cor da carta não é valida");

		
	}
	
	private TerrenoAmarelo criaTerrenoAmarelo(String nome, double preco, double valorAluguelSemCasa, double valorAluguelCom1Casa,
			double valorAluguelCom2Casas, double valorAluguelCom3Casas, double valorAluguelCom4Casas,
			double valorAluguelComHotel, double valorHipoteca, double valorImovelCasa) {
		

		TerrenoAmarelo temp = new TerrenoAmarelo(nome,preco, valorAluguelSemCasa, valorAluguelCom1Casa, valorAluguelCom2Casas, valorAluguelCom3Casas,
				valorAluguelCom4Casas, valorAluguelComHotel, valorHipoteca, valorImovelCasa);
		
		this.terrenosAmarelos.add(temp);
		
		return temp;
		
		
	}
	
	private TerrenoAzul criaTerrenoAzul(String nome, double preco, double valorAluguelSemCasa, double valorAluguelCom1Casa,
			double valorAluguelCom2Casas, double valorAluguelCom3Casas, double valorAluguelCom4Casas,
			double valorAluguelComHotel, double valorHipoteca, double valorImovelCasa) {
		
		TerrenoAzul temp = new TerrenoAzul(nome,preco, valorAluguelSemCasa, valorAluguelCom1Casa, valorAluguelCom2Casas, valorAluguelCom3Casas,
				valorAluguelCom4Casas, valorAluguelComHotel, valorHipoteca, valorImovelCasa);
		
		this.terrenosAzuis.add(temp);
		
		return temp;
	}
	
	private TerrenoCiano criaTerrenoCiano(String nome, double preco, double valorAluguelSemCasa, double valorAluguelCom1Casa,
			double valorAluguelCom2Casas, double valorAluguelCom3Casas, double valorAluguelCom4Casas,
			double valorAluguelComHotel, double valorHipoteca, double valorImovelCasa) {
		
		TerrenoCiano temp = new TerrenoCiano(nome,preco, valorAluguelSemCasa, valorAluguelCom1Casa, valorAluguelCom2Casas, valorAluguelCom3Casas,
				valorAluguelCom4Casas, valorAluguelComHotel, valorHipoteca, valorImovelCasa);
		
		this.terrenosCiano.add(temp);
		
		return temp;
	}
	
	private TerrenoLaranja criaTerrenoLaranja(String nome, double preco, double valorAluguelSemCasa, double valorAluguelCom1Casa,
			double valorAluguelCom2Casas, double valorAluguelCom3Casas, double valorAluguelCom4Casas,
			double valorAluguelComHotel, double valorHipoteca, double valorImovelCasa) {
		
		TerrenoLaranja temp = new TerrenoLaranja(nome,preco, valorAluguelSemCasa, valorAluguelCom1Casa, valorAluguelCom2Casas, valorAluguelCom3Casas,
				valorAluguelCom4Casas, valorAluguelComHotel, valorHipoteca, valorImovelCasa);
		
		this.terrenosLaranja.add(temp);
		
		return temp;
	}
	
	private TerrenoRosa criaTerrenoRosa(String nome, double preco, double valorAluguelSemCasa, double valorAluguelCom1Casa,
			double valorAluguelCom2Casas, double valorAluguelCom3Casas, double valorAluguelCom4Casas,
			double valorAluguelComHotel, double valorHipoteca, double valorImovelCasa) {
		
		TerrenoRosa temp = new TerrenoRosa(nome,preco, valorAluguelSemCasa, valorAluguelCom1Casa, valorAluguelCom2Casas, valorAluguelCom3Casas,
				valorAluguelCom4Casas, valorAluguelComHotel, valorHipoteca, valorImovelCasa);
		
		this.terrenosRosa.add(temp);
		
		return temp;
		
	}
	
	private TerrenoRoxo criaTerrenoRoxo(String nome, double preco, double valorAluguelSemCasa, double valorAluguelCom1Casa,
			double valorAluguelCom2Casas, double valorAluguelCom3Casas, double valorAluguelCom4Casas,
			double valorAluguelComHotel, double valorHipoteca, double valorImovelCasa) {
		
		TerrenoRoxo temp = new TerrenoRoxo(nome,preco, valorAluguelSemCasa, valorAluguelCom1Casa, valorAluguelCom2Casas, valorAluguelCom3Casas,
				valorAluguelCom4Casas, valorAluguelComHotel, valorHipoteca, valorImovelCasa);
		
		this.terrenosRoxos.add(temp);
		
		return temp;
	}
	
	private TerrenoVerde criaTerrenoVerde(String nome, double preco, double valorAluguelSemCasa, double valorAluguelCom1Casa,
			double valorAluguelCom2Casas, double valorAluguelCom3Casas, double valorAluguelCom4Casas,
			double valorAluguelComHotel, double valorHipoteca, double valorImovelCasa) {
		
		TerrenoVerde temp = new TerrenoVerde(nome,preco, valorAluguelSemCasa, valorAluguelCom1Casa, valorAluguelCom2Casas, valorAluguelCom3Casas,
				valorAluguelCom4Casas, valorAluguelComHotel, valorHipoteca, valorImovelCasa);
		
		this.terrenosVerdes.add(temp);
		
		return temp;
		
	}
	
	private TerrenoVermelho criaTerrenoVermelho(String nome, double preco, double valorAluguelSemCasa, double valorAluguelCom1Casa,
			double valorAluguelCom2Casas, double valorAluguelCom3Casas, double valorAluguelCom4Casas,
			double valorAluguelComHotel, double valorHipoteca, double valorImovelCasa) {
		
		TerrenoVermelho temp = new TerrenoVermelho(nome,preco, valorAluguelSemCasa, valorAluguelCom1Casa, valorAluguelCom2Casas, valorAluguelCom3Casas,
				valorAluguelCom4Casas, valorAluguelComHotel, valorHipoteca, valorImovelCasa);
		
		this.terrenosVermelhos.add(temp);
		
		return temp;
	}
	
	public ArrayList <TerrenoAmarelo> getListaTerrenosAmarelos(){
		return this.terrenosAmarelos;
		
	}
	
	public ArrayList <TerrenoAzul> getListaTerrenosAzuis(){
		return this.terrenosAzuis;
		
	}
	
	public ArrayList <TerrenoCiano> getListaTerrenosCiano(){
		return this.terrenosCiano;
		
	}
	
	public ArrayList <TerrenoLaranja> getListaTerrenosLaranja(){
		return this.terrenosLaranja;
		
	}
	
	public ArrayList <TerrenoRosa> getListaTerrenosRosa(){
		return this.terrenosRosa;
		
	}
	
	public ArrayList <TerrenoRoxo> getListaTerrenosRoxos(){
		return this.terrenosRoxos;
		
	}
	
	public ArrayList <TerrenoVerde> getListaTerrenosVerdes(){
		return this.terrenosVerdes;
		
	}
	
	public ArrayList <TerrenoVermelho> getListaTerrenosVermelhos(){
		return this.terrenosVermelhos;
	}
/*
	public ArrayList<> verificaMonopolio(Jogador jog){
		int cont;
		cont = 0;
		for(Terreno a : this.terrenosAmarelos) {
			if(a.getDono().equals(jog)) {
				cont ++;
			}
		}
		if(cont == this.terrenosAmarelos.size()) {

		}
	}
	*/

	
}
