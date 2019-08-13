package principal;

import java.util.ArrayList;

import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;
import tabuleiro.Dado;
import tabuleiro.Titulo;

public class Jogador {
	
	private boolean onGame = true;//variavel que guarda se o jogador está com saldo positivo;
	private String nome;
	private String cor;
	private int posicao;
	private Double dinheiro = 1500.0;
	private ArrayList<String> titulos;
	private Dado dado;
	
	public Jogador(String nome , String cor ) {
		
		dado = new Dado();
		this.nome = nome;
		this.cor = cor;
		this.posicao = 0;
		this.titulos = new ArrayList<String>();//mudar para o tipo titulos quando fizer a classe
		
	}
	
	public void addTitulo(String titulo) {
		titulos.add(titulo);
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
	
	public int []  andarCasas() {
		int [] dadosLancados = dado.JogarDoisDados();
		this.posicao +=  dadosLancados[0]+ dadosLancados[1];
		if(this.posicao >= 40) {
			this.posicao = this.posicao -40;
			this.dinheiro += 200;
		}
		return dadosLancados;
	
	}
	
	public void andarCasas(int casasAAndar) {
		this.posicao += casasAAndar;
		if (this.posicao >= 40) {
			this.posicao = this.posicao -40 ;
			this.dinheiro += 200;
		}
	}
	public double getDinheiro() {
		return this.dinheiro;
		
	}
	public ArrayList<String> getTitulos() {
		return this.titulos;
	}
	
	public boolean isOnGame() {
		return this.onGame;
	}
	
	public void debitar(double valor) throws ValorNegativoException, SaldoInsuficienteException  {
		if (valor >= 0 ) {
			if(this.dinheiro >= valor) {
				this.dinheiro -= valor;
			}else {
				throw new SaldoInsuficienteException("O seu saldo é insuficiente para realizar a açao");
			}
		}else {
			throw new ValorNegativoException("O valor inserido não pode ser negativo");
		}
		if (this.dinheiro <= 0) {
			this.onGame = false;
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
		
		String guardaTitulos = "";
		for (String k : titulos) {
			guardaTitulos += k +"\n" ; 
		}
		
		return ("O status de "+ this.nome.toUpperCase() +" ("+this.cor+") é o seguinte :\n"
		+ "Situado na posição: "+ this.posicao+ "\nPossui: $"+ this.dinheiro
		+ "\nTitulo(s) :" + guardaTitulos );
	}

}
}
