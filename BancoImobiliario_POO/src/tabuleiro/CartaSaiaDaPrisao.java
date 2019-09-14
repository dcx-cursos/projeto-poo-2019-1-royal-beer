package tabuleiro;

import exceptions.SaldoInsuficienteException;
import principal.Jogador;

public class CartaSaiaDaPrisao extends CartaSorteOuRevesGenerica implements Efeito {

	private String mensagem;
	
	@Override
	public void aplicaEfeito(Jogador jog) throws SaldoInsuficienteException {
		jog.receiveCartaPrisao();
		
	}
	
	public String getMensagem() {
		return this.mensagem;
	}
	

}
