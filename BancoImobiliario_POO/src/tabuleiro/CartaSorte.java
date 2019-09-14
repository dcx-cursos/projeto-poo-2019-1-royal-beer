package tabuleiro;

import exceptions.SaldoInsuficienteException;
import principal.Jogador;

public class CartaSorte extends CartaSorteOuRevesGenerica implements Efeito {
	
	private String mensagem;
	private int valorAReceber;
	
	public CartaSorte(String msg,int valorAReceber) {
		this.mensagem = msg;
		this.valorAReceber = valorAReceber;
	}

	
	public void aplicaEfeito(Jogador jog) throws SaldoInsuficienteException{
		jog.creditar(this.valorAReceber);
		
	}
	
	public String getMensagem() {
		return this.mensagem;
	}

}
