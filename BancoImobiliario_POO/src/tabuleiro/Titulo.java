package tabuleiro;

import exceptions.ErroAoCalcularAluguelException;

public interface Titulo {
	
	public double getAluguel() throws ErroAoCalcularAluguelException;
	public String getNome();
	public double getPreco();
	public String getCor();
	
}
