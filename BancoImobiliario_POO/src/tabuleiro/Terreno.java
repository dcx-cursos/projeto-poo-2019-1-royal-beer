package tabuleiro;

import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;
import principal.Jogador;

public interface Terreno {
	
	public void venderCasa(Jogador jogador) throws ValorNegativoException, SaldoInsuficienteException;
	

}
