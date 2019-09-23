package tabuleiro;

import exceptions.SaldoInsuficienteException;
import principal.Jogador;

public class DiaDoCasamento extends CartaSorteOuRevesGenerica implements Efeito {
	
	private String mensagem;
	private int valorACobrar = 50;
	
	public DiaDoCasamento() {
		this.mensagem = "O dia do seu casamento chegou, receba os presentes.\nSerá debitado $50 de cada jogador";
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
