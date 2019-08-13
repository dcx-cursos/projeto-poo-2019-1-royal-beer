package tabuleiro;

import exceptions.ErroAoCalcularAluguelException;
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
	
	/*
	 *Metodo deve retornar a cor do terreno
	 */
	public String getCor();
	
}
