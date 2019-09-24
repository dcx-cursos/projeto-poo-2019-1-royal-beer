package tabuleiro;

import exceptions.SaldoInsuficienteException;
import principal.Jogador;

public class VaParaPrisao implements CasaTabuleiro ,Efeito{
	
	
	public String getNome() {
		return "Vá Para Prisão";
	}
	/*
	 * Metodo que retorna se a casa tem dono
	 */
	public boolean hasDono() {
		return false;
	}
	
	public String getTipo() {
		return "VAPARAPRISAO";
	}
	@Override
	public void aplicaEfeito(Jogador jog) throws SaldoInsuficienteException {
		jog.setPosicao(10);
		
	}
	@Override
	public String getMensagem() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
