package principal;

import java.util.ArrayList;

import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;

public class Jogador {
	
	private boolean onGame = true;//variavel que guarda se o jogador está com saldo positivo;
	private String nome;
	private String cor;
	private int posicao;
	private Double dinheiro = 1.500;
	private ArrayList<Object> titulos;
	
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
	public int getPosicao() {
		return this.posicao;
	}
	public void andarCasas(int casasAAndar) {
		this.posicao += casasAAndar;
		if (posicao == 41) this.posicao = 0;
	}
	public double getDinheiro() {
		return this.dinheiro;
	}
	public ArrayList<Object> getTitulos() {
		return this.titulos;
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
public  void getStatus() {
  System.out.print("Nome: " + this.getNome());
  System.out.print("\nCor: " + this.getCor());
  System.out.print("\nDinheiro: "+ this.getDinheiro());
  System.out.print("\nPosição: " + this.getPosicao());
  if (this.getTitulos().size() == 0) {
	  System.out.print("\nTitulos: você ainda não possui Titulos\n");
}
  else {
	  System.out.print("\nTitulos: " + this.getTitulos()+ "\n");
	    
  }

}
}
