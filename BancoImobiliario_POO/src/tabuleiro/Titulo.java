package tabuleiro;

import exceptions.ErroAoCalcularAluguelException;
import exceptions.SaldoInsuficienteException;
import principal.Jogador;
 /*
  * Interface para agrupar objetos do tipo Terreno
  */
public interface Titulo {
	/*
	 * Metodo deve calcular e retornar o valor do aluguel do terreno
	 * @return Double - valor do aluguel
	 */
	public double getAluguel() throws ErroAoCalcularAluguelException;
	
	/*
	 * Metodo debe retornar o nome do terreno
	 */
	public String getNome();
	
	/*
	 * Metodo deve retornar o preco do terreno
	 */
	
	public double getPreco();
	
	public String getTipo();
	
	public void comprar(Jogador jog,Titulo tit) throws  SaldoInsuficienteException;
	
public boolean hasDono();

}
