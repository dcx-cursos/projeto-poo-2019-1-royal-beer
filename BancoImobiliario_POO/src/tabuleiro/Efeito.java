package tabuleiro;

import exceptions.SaldoInsuficienteException;
import principal.Jogador;

public interface Efeito {
	
	public void aplicaEfeito(Jogador jog) throws SaldoInsuficienteException;
	
	public String getMensagem();

}
