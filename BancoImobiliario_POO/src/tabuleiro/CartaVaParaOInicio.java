package tabuleiro;

import exceptions.SaldoInsuficienteException;
import principal.Jogador;

public class CartaVaParaOInicio extends CartaSorteOuRevesGenerica implements Efeito{

	@Override
	public void aplicaEfeito(Jogador jog) throws SaldoInsuficienteException {
		jog.setPosicao(0);
		
	}

	@Override
	public String getMensagem() {
		return "Va para o começo";
	}

}
