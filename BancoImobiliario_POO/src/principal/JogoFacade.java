package principal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exceptions.CorIndisponivelException;
import tabuleiro.Tabuleiro;

public class JogoFacade  {

	private Tabuleiro tabuleiro = new Tabuleiro();
	
	
	private ArrayList<Jogador> jogadores = new ArrayList<>();

	private ArrayList<String>  coresDisponiveis = carregaCores();

	
	public void cadastraJogador(String nome , String cor) throws CorIndisponivelException{
		if(this.jogadorComCor(cor) == -1) {
			if(this.verificaCorNaLista(cor) == -1){
				Jogador jog = new Jogador(nome,cor);
				this.removeCorDaLista(cor);
				jogadores.add(jog);
			}else throw new CorIndisponivelException("A cor escolhida não está dentre as opções");
		}else throw new CorIndisponivelException("Cor ja escolhida");
		
	
}
	
	
	
	private int jogadorComCor(String cor) {
		for(int k = 0; k<this.jogadores.size();k++) {
			if(this.jogadores.get(k).getCor().toUpperCase().equals(cor.toUpperCase())){
				return k;
			}
		}
		return -1;
	}
	
	private int verificaCorNaLista(String item) {
		int cont = 0;
		for(int k =0;k<coresDisponiveis.size();k++) {
			if(item.equals(this.coresDisponiveis.get(k))) return k;
			cont ++;
		}
		return -1;
	}		

	
	private void removeCorDaLista(String cor) {
		for(int k = 0 ; k<this.coresDisponiveis.size();k++) {
			if(this.coresDisponiveis.get(k).equals(cor.toUpperCase())) {
				this.coresDisponiveis.remove(k);
			}
		}
		
		}
	
		
	public String getStringDeCores() {
		String temp = "";
		for(String a : this.coresDisponiveis) {
			temp += "["+ a +"]";
		}
		return temp;
	}
	
	public ArrayList getCores() {
		return this.coresDisponiveis;
	}
	
	public ArrayList<Jogador> getJogadores(){
		return this.jogadores;
	}
	
	public ArrayList<String> carregaCores() {
		ArrayList<String> temp = new ArrayList<>();
		temp.add("PRETO");
		temp.add("BRANCO");
		temp.add("VERMELHO");
		temp.add("VERDE");
		temp.add("AZUL");
		temp.add("AMARELO");
		temp.add("LARANJA");
		temp.add("ROSA");
		
		return temp;
	}
	
	
	
}