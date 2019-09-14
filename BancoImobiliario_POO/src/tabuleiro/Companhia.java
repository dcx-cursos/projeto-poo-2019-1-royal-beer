package tabuleiro;

import exceptions.ErroAoCalcularAluguelException;
import exceptions.SaldoInsuficienteException;
import principal.Jogador;

public class Companhia implements CasaTabuleiro,Titulo{
	
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
	
	public void cobraAluguel(Jogador jog , int [] dados) throws SaldoInsuficienteException {
		jog.debitar((dados[0]+dados[1])*this.multiplicador);
		this.dono.creditar((dados[0]+dados[1])*this.multiplicador);
	}
	
	public String getTipo() {
		return "COMPANHIA";
	}
	
	public void comprar(Jogador jog) throws SaldoInsuficienteException {
		jog.debitar(this.preco);
		this.dono = jog;
	}
	
	public double getAluguel() throws ErroAoCalcularAluguelException{
		return this.getAluguel();
	}
	@Override
	public double getPreco() {
		return this.preco;
	}
	public int getMultiplicador() {
		return this.multiplicador;
	}
	
	public double getHipoteca() {
		return this.hipoteca;
	}

	
	
	
	

}
