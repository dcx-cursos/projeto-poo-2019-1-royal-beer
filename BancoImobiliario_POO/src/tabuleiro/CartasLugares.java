package tabuleiro;

import exceptions.ErroAoCalcularAluguelException;
import exceptions.LimiteDeConstrucoesException;
import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;
import principal.Jogador;

public class CartasLugares implements CasaTabuleiro, Titulo{
	
	
	private String nome;
	private String cor;
	private double preco;
	private double valorAluguelSemCasa;
	private double valorAlguelCom1Casa;
	private double valorAluguelCom2Casas;
	private double valorAluguelCom3Casas;
	private double valorAluguelCom4Casas;
	private double valorAluguelComHotel;
	private double valorHipoteca;
	private double valorImovelCasa;
	private int quantidaDeCasas;
	private int posicao;
	private Jogador dono = null;
	
	
	public CartasLugares(String nome,String cor,double preco, double valorAluguelSemCasa, double valorAluguelCom1Casa,
		double valorAluguelCom2Casas,double valorAluguelCom3Casas,double valorAluguelCom4Casas,double valorAluguelComHotel,
		double valorHipoteca,double valorImovelCasa) {
		
		this.nome = nome;
		this.cor = cor;
		this.preco = preco;
		this.valorAluguelSemCasa = valorAluguelSemCasa;
		this.valorAlguelCom1Casa = valorAluguelCom1Casa;
		this.valorAluguelCom2Casas = valorAluguelCom2Casas;
		this.valorAluguelCom3Casas = valorAluguelCom3Casas;
		this.valorAluguelCom4Casas = valorAluguelCom4Casas;
		this.valorAluguelComHotel = valorAluguelComHotel;
		this.valorHipoteca = valorHipoteca;
		this.quantidaDeCasas = 0;
		this.posicao = 0;
		
		
	}
	
	
	
	public void venderCasa(Jogador jogador) throws ValorNegativoException, SaldoInsuficienteException, LimiteDeConstrucoesException {
		if(this.quantidaDeCasas <= 4) {
		jogador.debitar(this.valorImovelCasa);
		this.quantidaDeCasas += 1;
		}else {
			throw new LimiteDeConstrucoesException("O numero máximo de construções foi atingido em" + this.nome);
		}
	}

	
	public void comprar(Jogador jogador) throws ValorNegativoException, SaldoInsuficienteException{
		if (this.dono == null) {
			this.dono = jogador;
			jogador.debitar(preco);
			jogador.addTitulo(this.nome);
			
			
		}
	}
	
	
	public double getAluguel() throws ErroAoCalcularAluguelException {
		if(this.quantidaDeCasas >5) {
			
			throw new ErroAoCalcularAluguelException("O numero de casas excede o limite");
		}
		
		if(this.quantidaDeCasas == 0) return this.valorAluguelSemCasa;
		else if(this.quantidaDeCasas == 1) return this.valorAlguelCom1Casa;
		else if(this.quantidaDeCasas == 2) return this.valorAluguelCom2Casas;
		else if(this.quantidaDeCasas == 3) return this.valorAluguelCom3Casas;
		else if(this.quantidaDeCasas == 4) return this.valorAluguelCom4Casas;
		else return this.valorAluguelComHotel;
	
	}
	
	public void cobraAluguel(Jogador jogador) throws ErroAoCalcularAluguelException, ValorNegativoException, SaldoInsuficienteException {

			jogador.debitar(getAluguel());
			this.dono.creditar(getAluguel());
		
			
		
	}
	
	
	
	
	public double getValorHipoteca() {
		return this.valorHipoteca;
	}
	
	public double getPreco() {
		return this.preco;
	}

	public String getNome() {
		return this.nome;
	}
	
	public int getQuantidadeDeCasas() {
		return this.quantidaDeCasas;
	}
	
	public String getCor() {
		return this.cor;
	}
	public Jogador getDono() {
		return this.dono;
	}
	
	public boolean hasDono() {
		if (this.dono == null ) {
			return false;
		}
		return true;
	}
	
	
	

	
}

