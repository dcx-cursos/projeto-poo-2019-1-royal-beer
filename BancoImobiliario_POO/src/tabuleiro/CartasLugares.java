package tabuleiro;

import exceptions.ErroAoCalcularAluguelException;
import exceptions.LimiteDeConstrucoesException;
import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;
import principal.Jogador;

public class CartasLugares implements CasaTabuleiro, Titulo{
	/*
	 * Classe objeto do tipo CartasLugares, onde estão contidos seus 
	 * atributos e metodos
	 * 
	 * @author Matheus Morais
	 * @version 1.0
	 * @since Release 1 da aplicação
	 */
	
	
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
	
	/*
	 * Metodo contrutor
	 * @param nome String- nome da casa do tabuleiro a ser cadastrada
	 * @param cor String- cor da casa do tabuleiro a ser cadastrada
	 * @param preco Double- preco da casa do tabuleiro a ser cadastrada
	 * @param valorAluguelSemCasa Double- valor do aluguel sem nenhuma casa
	 * @param valorAluguelCom1Casa Double - valor do aluguel com 1 casa
	 * @param valorAluguelCom2Casas Double - valor do aluguel com 2 casas
	 * @param valorAluguelCom3Casas Double - valor do aluguel com 3 casas
	 * @param valorAluguelCom4Casas Double - valor do aluguel com 4 casas
	 * @param valorAluguelComHotel Double - valor do aluguel com Hotel
	 * @param valorHipoteca Double - valor da hipoteca
	 * @param valorImovelCasa Double - valor para comprar uma casa

	 */
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
		this.setPosicao(0);
		
		
	}
	
	
	/*
	 * Metodo que faz a venda de casas
	 * @param jogador Jogador - jogador que deseja comprar a casa
	 * @return void
	 */
	public void venderCasa(Jogador jogador) throws ValorNegativoException, SaldoInsuficienteException, LimiteDeConstrucoesException {
		if(this.quantidaDeCasas <= 4) {
		jogador.debitar(this.valorImovelCasa);
		this.quantidaDeCasas += 1;
		}else {
			throw new LimiteDeConstrucoesException("O numero máximo de construções foi atingido em" + this.nome);
		}
	}

	/*
	 * Metodo que realiza a compra da carta
	 * @param jogador Jogador - jogador que vai comprar a carta
	 */
	public void comprar(Jogador jogador) throws ValorNegativoException, SaldoInsuficienteException{
		if (this.dono == null) {
			this.dono = jogador;
			jogador.debitar(preco);
		
			
			
		}
	}
	
	/*
	 * Metodo que retorna o valor do aluguel de acordo com a quantidade de casas
	 * @return Double - valor do aluguel
	 */
	public double getAluguel() throws  ErroAoCalcularAluguelException {
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
	
	/*
	 * Metodo que cobra do jogador o alugel
	 * @param jogador Jogador - jogador a pagar o aluguel
	 * @return void
	 */
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
	
	public String getTipo() {
		return "Carta terreno de cor :"+this.cor;
	}


	public int getPosicao() {
		return posicao;
	}


	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
	

	
}

