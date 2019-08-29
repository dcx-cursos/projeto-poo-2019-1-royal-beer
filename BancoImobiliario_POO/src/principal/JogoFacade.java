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
	
	private ArrayList<String> comandosDisponiveis = carregaComandos();
	
	private int ponteiro = 0;

	
	public void cadastraJogador(String nome , String cor) throws CorIndisponivelException{
		if(this.jogadorComCor(cor) == -1) {
			if(this.verificaCorNaLista(cor) != -1){
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
	
	public int verificaCorNaLista(String item) {
		for(int k =0;k<coresDisponiveis.size();k++) {
			if(item.toUpperCase().equals(this.coresDisponiveis.get(k))) return k;
			
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
	
	private ArrayList<String> carregaCores() {
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
	
	public boolean verificaNumeroDeJogadores(int numeroDeJogadores) {
		if(numeroDeJogadores >= 2 && numeroDeJogadores <=8) {
			return true;
		}
		return false;
	}
	
	public Jogador getProxJogador() {
		this.ponteiro+= 1;
		if(this.ponteiro == this.jogadores.size()) {
			this.ponteiro = 0;
		}
			return this.jogadores.get(this.ponteiro);
		
		
	}
	
	private ArrayList<String> carregaComandos(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("Jogar");
		temp.add("Sair");
		return temp;
	}
	
	public String getStringDeComandos() {
		String temp = "";
		for(String a : this.comandosDisponiveis) {
			temp += "["+ a +"]";
		}
		return temp;
		
	}
	
	
	
	
}