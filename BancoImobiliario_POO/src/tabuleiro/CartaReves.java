package tabuleiro;

import exceptions.SaldoInsuficienteException;
import principal.Jogador;

public class CartaReves extends CartaSorteOuRevesGenerica implements Efeito {

	private String mensagem;
	private int valorAPagar;
	
	/*
	 * metodo q
	 */
	public CartaReves(String mensagem , int valorAPagar) {
		this.mensagem = mensagem;
		this.valorAPagar = valorAPagar;
	}
	
	
	@Override
	public void aplicaEfeito(Jogador jog) throws SaldoInsuficienteException {
		jog.debitar(this.valorAPagar);
		
	}
	
	public String getMensagem() {
		return this.mensagem;
	}
	

}
