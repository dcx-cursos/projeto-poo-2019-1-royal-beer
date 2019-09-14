package tabuleiro;

import exceptions.SaldoInsuficienteException;
import principal.Jogador;

public class DiaDoCasamento extends CartaSorteOuRevesGenerica implements Efeito {
	
	private String mensagem;
	private int valorACobrar = 50;
	
	public DiaDoCasamento(String mensagem) {
		this.mensagem = mensagem;
	}

	
	@Override
	public void aplicaEfeito(Jogador jog) throws SaldoInsuficienteException {
		
	}
	
	public String getMensagem() {
		return this.mensagem;
	}
	
	public int getValorACobrar() {
		return this.valorACobrar;
	}
	
	public String getTipo() {
		return "DIADOCASAMENTO";
	}
	
	

}
