package tabuleiro;

public class PontoDePartida implements CasaTabuleiro {
	
	
	@Override
	public String getNome() {
		return "Ponto de partida";
	}
	public boolean hasDono() {
		return false;
	}
	
	public String getTipo() {
		return "PONTODEPARTIDA";
	}
	

}
