package principal;

import java.util.ArrayList;

import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;
import tabuleiro.Titulo;

public class Jogador {
	
	private boolean onGame = true;//variavel que guarda se o jogador está com saldo positivo;
	private String nome;
	private String cor;
	private int posicao;
	private Double dinheiro = 1.500;
	private ArrayList<Titulo> titulos;
	
	public Jogador(String nome , String cor ) {
		
		this.nome = nome;
		this.cor = cor;
		this.posicao = 0;
		this.titulos = new ArrayList<Titulo>();//mudar para o tipo titulos quando fizer a classe
		
	}
	
	public String getNome() {
		return this.nome;
	}
	public String getCor() {
		return this.cor;
	}
	public int getPosicao() {
		return this.posicao;
	}
	
	public void andarCasas(int [] dadosLancados) {
		
		this.posicao +=  dadosLancados[0]+ dadosLancados[1];
		if(this.posicao >= 40) this.posicao = 40 - this.posicao;
	}
	
	public void andarCasas(int casasAAndar) {
		this.posicao += casasAAndar;
		if (this.posicao >= 40) this.posicao = 40 - this.posicao ;
	}
	public double getDinheiro() {
		return this.dinheiro;
	}
	public ArrayList<Titulo> getTitulos() {
		return this.titulos;
	}
	
	public boolean isOnGame() {
		return this.onGame;
	}
	
	public void debitar(double valor) throws ValorNegativoException  {
		if (this.dinheiro <0) {
			throw new ValorNegativoException("O valor inserido é negativo");
		}else {
			this.dinheiro -= valor;
			if(this.dinheiro < 0) {
				this.onGame = false;
			}
			
		}
		
	}
	
	public void creditar(double valor) {
		if (valor > 0) {
			this.dinheiro += valor;
		}
	}
public String getStatus() {
	if (this.titulos.size() == 0 ) {
	return ("O status de "+ this.nome.toUpperCase() +"("+this.cor+") é o seguinte :\n"
			+ "Situado na posição: "+ this.posicao+ "\nPossui: $"+ this.dinheiro
			+"\nTitulos : Nenhum");
	}else {
		
		String guardaTitulos = null;
		for (Titulo k : titulos) {
			guardaTitulos += k +"\n" ; 
		}
		
		return ("O status de "+ this.nome.toUpperCase() +" ("+this.cor+") é o seguinte :\n"
		+ "Situado na posição: "+ this.posicao+ "\nPossui: $"+ this.dinheiro
		+ "\nTitulo(s) :" + guardaTitulos );
	}

}
}
