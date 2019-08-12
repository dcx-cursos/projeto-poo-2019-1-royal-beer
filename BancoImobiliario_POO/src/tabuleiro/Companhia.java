package tabuleiro;

import principal.Jogador;

public class Companhia implements CasaTabuleiro{
	
	private String nome;
	private double preco;
	private double hipoteca;
	private int multiplicador;
	private Jogador dono = null;
	
	public Companhia(String nome,double preco,double hipoteca,int multiplicador) {
		
		
		this.nome = nome;
		this.preco = preco;
		this.hipoteca = hipoteca;
		this.multiplicador = multiplicador;
		
	}
	public String getNome() {
		return this.nome;
	}

	public boolean hasDono() {
		if(this.dono == null) {
			return false;
		}
		return true;
	}
	
	
	
	
	

}
