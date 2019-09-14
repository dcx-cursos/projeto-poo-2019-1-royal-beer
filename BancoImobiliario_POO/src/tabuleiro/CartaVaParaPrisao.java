package tabuleiro;

import exceptions.SaldoInsuficienteException;
import principal.Jogador;

public class CartaVaParaPrisao extends CartaSorteOuRevesGenerica implements Efeito {

	
	
	@Override
	public void aplicaEfeito(Jogador jog) throws SaldoInsuficienteException {
		jog.setPosicao(9);
		
	}
	
	public String getMensagem() {
		return "Vá para a prisão";
	}
	
	

}
