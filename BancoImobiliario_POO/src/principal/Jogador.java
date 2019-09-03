package principal;

import java.util.ArrayList;

import exceptions.ErroAoCalcularAluguelException;
import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;
import tabuleiro.Companhia;
import tabuleiro.Terreno;
import tabuleiro.Titulo;

public class Jogador {
	

	private boolean onGame = true;
	private String nome;
	private String cor;
	private int posicao;
	private Double dinheiro = 1500.0;
	private ArrayList<Titulo> titulos;
	private Fila dadosJogados;
	private boolean cartaPrisao = false;
	

	public Jogador(String nome , String cor ) {
		
		
		this.nome = nome;
		this.cor = cor;
		this.posicao = 0;
		this.titulos = new ArrayList<Titulo>();//mudar para o tipo titulos quando fizer a classe
		dadosJogados = new Fila();
	}
	
	
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
	

	public void andarCasas(int casasAAndar,int[] dados) {
		this.posicao += casasAAndar;
		if (this.posicao >= 40) {
			this.posicao = this.posicao -40 ;
			this.dinheiro += 200;
			String aux = Integer.toString(dados[0]) +""+ Integer.toString(dados[1]);
			this.dadosJogados.enfileirar(aux);
		}
	}
	
	public String[] getHistDados() {
		return this.dadosJogados.getAll();
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
	
	public void creditar(double valor) {
		if (valor > 0) {
			this.dinheiro += valor;
		}
	}
	
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
	
	public void setPosicao(int newPosicao) {
		this.posicao = newPosicao;
	}
	
	public void outGame() {
		this.onGame  = false;
		
	}
	
	public void receiveCartaPrisao() {
		this.cartaPrisao = true;
	}


	public boolean hasCartaPrisao() {
		return cartaPrisao;
	}
	
	public int []  getUltimosDadosJogados() {
		String[] aux = this.dadosJogados.getUltimoDadoJogado().split("");
		int [] temp = { Integer.parseInt(aux[0]), Integer.parseInt(aux[1])};
		return temp;
	}


	
	
	
	
	
}
