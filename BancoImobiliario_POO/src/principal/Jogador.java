package principal;

import java.util.ArrayList;

import exceptions.ErroAoCalcularAluguelException;
import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;
import tabuleiro.Companhia;
import tabuleiro.Terreno;
import tabuleiro.Titulo;
/*
 * Classe que cria objeto jogador e suas ações
 */
public class Jogador {
	

	private boolean onGame = true;
	private String nome;
	private String cor;
	private int posicao;
	private Double dinheiro = 1500.0;
	private ArrayList<Titulo> titulos;
	private Fila dadosJogados;
	private boolean cartaPrisao = false;
	
/*
 * Contrutor Jogador recebe o nome e a cor do jogador e inicia as variaveis que acima não foram
 * iniciadas com os parametros passados
 */
	public Jogador(String nome , String cor ) {
		
		
		this.nome = nome;
		this.cor = cor;
		this.posicao = 0;
		this.titulos = new ArrayList<Titulo>();//mudar para o tipo titulos quando fizer a classe
		dadosJogados = new Fila();
	}
	
	/*
	 * metodo que realiza a compra de um titulo
	 * @param titulo Um objeto do tipo titulo que sera comprado
	 */
	public void comprar(Titulo titulo) throws ValorNegativoException, SaldoInsuficienteException {
		this.debitar(titulo.getPreco());
		this.titulos.add(titulo);
	}
	
	/*
	 * Retorna o nome
	 * @return uma String com o nome do jogador
	 */
	public String getNome() {
		return this.nome;
	}
	/*
	 * Retorna a cor do jogador
	 * @return uma String com a cor do jogador
	 */
	public String getCor() {
		return this.cor;
	}
	/*
	 * Retorna a posicao
	 * @return um inteiro com a posição do jogador
	 */
	public int getPosicao() {
		return this.posicao;
	}
	
	/*
	 * Anda as casas 
	 * @param casasAAdar o total de casas a andar
	 * @param dados um array com os dados que foram lançados para que possam ser colocados no historico
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
	/*
	 * Retorna o historico de dados
	 * @return um array com o historico de dados
	 */
	public String[] getHistDados() {
		return this.dadosJogados.getAll();
	}
	/*
	 * Apaga o hist de dados
	 */
	public void apagaDadosJogados() {
		this.dadosJogados = new Fila();
	}
	/*
	 * Retorna o dinheito
	 * @return um Double com o dinheito que o jogador possui
	 */
	public double getDinheiro() {
		return this.dinheiro;
		
	}
	/*
	 * Retorna os titulos do jogador
	 * @reuturn Um ArrayList com os Tituls do jogador
	 */
	public ArrayList<Titulo> getTitulos() {
		return this.titulos;
	}
	/*
	 * Metodo que guarda o status do jogador
	 * @return um boolean com o status do jogador
	 */
	public boolean isOnGame() {
		return this.onGame;
	}
	/*
	 *Metodo que retira dinheiro do jogador
	 *@param valor O valor que deve ser debitado
	 *@throws SaldoInsuficienteException no caso de o saldo não ser suficiente para debitar o valor desejado 
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
	/*9
	 * adiciona dinheiro ao jogador
	 */
	public void creditar(double valor) {
		if (valor > 0) {
			this.dinheiro += valor;
		}
	}
	/*
	 * retorna o status do jogador com todas as informacoes referentes ao mesmo
	 * @return uma String com o status do jogador
	 */
	public String getStatus() throws ErroAoCalcularAluguelException  {
	if (this.titulos.size() == 0 ) {
	return ("O status de "+ this.nome.toUpperCase() +"("+this.cor+") é o seguinte :\n"
			+ "Situado na posição: "+ this.posicao + "\nPossui: $"+ this.dinheiro
			+"\nTitulos : Nenhum");
	}else {
		
		String guardaTitulos = "";
		for (Titulo k : titulos) {
			if(k.getTipo().equals("TERRENO")) {
				Terreno temp = (Terreno) k ;
				guardaTitulos += "["+temp.getNome()+ "] - propriedade "+temp.getCor()+", aluguel : "+temp.getAluguel();
			}else if(k.getTipo().equals("COMPANHIA")) {
				Companhia temp = (Companhia) k;
				guardaTitulos += "["+temp.getNome()+"]"+" - multiplicador : "+ temp.getMultiplicador() ;
			}
		}
		
		return ("O status de "+ this.nome.toUpperCase() +" ("+this.cor+") é o seguinte :\n"
		+ "Situado na posição: "+ this.posicao+ "\nPossui: $"+ this.dinheiro
		+ "\nTitulo(s) :\n" + guardaTitulos );
	}

}
	/*
	 * Define a posicao do jogador
	 */
	public void setPosicao(int newPosicao) {
		this.posicao = newPosicao;
	}
	/*
	 * Muda o status do jogador para fora do jogo
	 */
	public void outGame() {
		this.onGame  = false;
		
	}
	/*
	 * Recebe a carta PasseLivreDaPrisao
	 */
	public void receiveCartaPrisao() {
		this.cartaPrisao = true;
	}

	/*
	 * Verifica se o jogador tem a carta de passe livre da prisao
	 */
	public boolean hasCartaPrisao() {
		return cartaPrisao;
	}
	/*
	 * Recupera os dados que foram lançados na ultima jogada
	 * @return um array de inteiros com o s dados jogados na ultima jogada
	 */
	public int []  getUltimosDadosJogados() {
		String[] aux = this.dadosJogados.getUltimoDadoJogado().split("");
		int [] temp = { Integer.parseInt(aux[0]), Integer.parseInt(aux[1])};
		return temp;
	}


	
	
	
	
	
}
