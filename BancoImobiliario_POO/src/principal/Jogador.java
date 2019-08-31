package principal;

import java.util.ArrayList;

import exceptions.ErroAoCalcularAluguelException;
import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;
import tabuleiro.Titulo;

public class Jogador {
	
	/*
	 * Classe para objetos do tipo Jogador, onde estão contidos valores(parametros)
	 * e métodos para o mesmo
	 * 
	 * @author Matheus Morais
	 * @version 1.0
	 * @since Release 1 da aplicaçao
	 */
	
	private boolean onGame = true;
	private String nome;
	private String cor;
	private int posicao;
	private Double dinheiro = 1500.0;
	private ArrayList<Titulo> titulos;
	private Fila dadosJogados;
	
	
	/*
	 * Método construtor
	 * @param nome String - Nome do jogador a ser cadastrado
	 * @param cor String - Cor do jogador a ser cadastrado
	 */
	public Jogador(String nome , String cor ) {
		
		
		this.nome = nome;
		this.cor = cor;
		this.posicao = 0;
		this.titulos = new ArrayList<Titulo>();//mudar para o tipo titulos quando fizer a classe
		dadosJogados = new Fila();
	}
	
	/*
	 * Metodo para realizar a compra de um Titulo
	 * @param titulo Titulo - titulo a ser comprado
	 * @return void
	 */
	public void comprar(Titulo titulo) throws ValorNegativoException, SaldoInsuficienteException {
		this.debitar(titulo.getPreco());
		this.titulos.add(titulo);
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
	
	
	/*
	 * Metodo que realiza a movimentação do jogador no tabuleiro
	 * @param casasAAndar int - quantidade de casas a andar
	 * @return void
	 */
	public void andarCasas(int casasAAndar,int[] dados) {
		this.posicao += casasAAndar;
		if (this.posicao >= 40) {
			this.posicao = this.posicao -40 ;
			this.dinheiro += 200;
			String aux = Integer.toString(dados[0]) +""+ Integer.toString(dados[1]);
			this.dadosJogados.enfileirar(aux);
		}
	}
	
	public void apagaDadosJogados() {
		this.dadosJogados = new Fila();
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
	/*
	 * Metoque de retira certo valor do jogador
	 * @param valor Double - valor a ser retirado(debitado)
	 * @return void
	 */
	public void debitar(double valor)throws SaldoInsuficienteException  {
		if (valor >= 0 ) {
			if(this.dinheiro >= valor) {
				this.dinheiro -= valor;
			}else {
				throw new SaldoInsuficienteException("O seu saldo é insuficiente para realizar a açao");
			}
		}
		if (this.dinheiro <= 0) {
			this.onGame = false;
		}
		
	}
	/*
	 * Metodo que adiciona certo valor a conta do jogador
	 * @param valor Double - valor a ser adicionado(creditado) na conta
	 * @return void
	 */
	public void creditar(double valor) {
		if (valor > 0) {
			this.dinheiro += valor;
		}
	}
	/*
	 * Metodo que retorna o status do jogador com as seguintes informaçẽs :
	 * O nome do jogador;
	 *A cor do peão;
	 *O nome da posição atual no tabuleiro;
	 *Quanto dinheiro o jogador possui;
	 *Uma lista dos títulos que o jogador possui com as informações relativas a cada 
	 *título (cor do grupo se for propriedade, aluguel das propriedades, valor das 
	 *companhias, etc.).
	 *@return String - Status do jogador
	 */
	
	public String getStatus() throws ErroAoCalcularAluguelException  {
	if (this.titulos.size() == 0 ) {
	return ("O status de "+ this.nome.toUpperCase() +"("+this.cor+") é o seguinte :\n"
			+ "Situado na posição: "+ this.posicao + "\nPossui: $"+ this.dinheiro
			+"\nTitulos : Nenhum");
	}else {
		
		String guardaTitulos = "";
		for (Titulo k : titulos) {
			guardaTitulos += "["+k.getNome()+"]" + " propriedade -"+k.getCor() +
					", aluguel : $ "+ k.getAluguel() + "\n" ; 
		}
		
		return ("O status de "+ this.nome.toUpperCase() +" ("+this.cor+") é o seguinte :\n"
		+ "Situado na posição: "+ this.posicao+ "\nPossui: $"+ this.dinheiro
		+ "\nTitulo(s) :\n" + guardaTitulos );
	}

}
	
	public void setPosicao(int newPosicao) {
		this.posicao = newPosicao;
	}
	
	public void outGame() {
		this.onGame  = false;
		
	}
	
	
	
	
}
