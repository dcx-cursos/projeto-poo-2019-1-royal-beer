package tabuleiro;

public class ParadaLivre implements CasaTabuleiro{
	
	
	public String getNome() {
		return "Parada Livre";
	}

	public boolean hasDono() {
		return false;
	}
	public String getTipo() {
		return "PARADALIVRE";
	}
}
