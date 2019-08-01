package principal;

import java.awt.List;
import java.util.ArrayList;

import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;

public class Jogador {
	
	private boolean onGame = true;//variavel que guarda se o jogador está com saldo positivo;
	private String nome;
	private String cor;
	private int posicao;
	private Double dinheiro = 1.500;
	private ArrayList titulos;
	
	public Jogador(String nome , String cor ) {
		
		this.nome = nome;
		this.cor = cor;
		this.posicao = 0;
		this.titulos = new ArrayList<Object>();//mudar para o tipo titulos quando fizer a classe
		
	}
	
	public String getNome() {
		return this.nome;
	}
	public String getCor() {
		return this.cor;
	}
	
	public void andarCasas(int casasAAndar) {
		this.posicao += casasAAndar;
		if (posicao == 41) this.posicao = 0;
	}
	public double getDinheiro() {
		return this.dinheiro;
	}
	public void debitar(double valor) throws ValorNegativoException , SaldoInsuficienteException {
		if (this.dinheiro <0) {
			throw new ValorNegativoException("O valor inserido é negativo");
		}else if(this.dinheiro<=valor ) {
			throw new SaldoInsuficienteException("O da compra é superior ao seu saldo");
		}else {
			this.dinheiro -= valor;
			
		}
		
	}
	
}
