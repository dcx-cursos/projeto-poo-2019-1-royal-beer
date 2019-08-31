package tabuleiro;

public class VaParaPrisao implements CasaTabuleiro{
	
	
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
		return "SORTEOUREVES";
	}

	
}
