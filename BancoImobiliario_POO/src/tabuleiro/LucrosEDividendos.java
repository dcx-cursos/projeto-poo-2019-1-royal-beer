package tabuleiro;

import principal.Jogador;

public class LucrosEDividendos implements CasaTabuleiro {
	
	/*
	 * Classe para objetos do tipo LucrosEDividendos e seus respectivos metodos
	 */
	
	
	public String getNome() {
		return "Lucros e dividendos";
	}

	/*
	 * Metodo que da ao jogador $200 caso pare nesta casa
	 */
	public void ativaLucrosEDividendos(Jogador jog) {
		jog.creditar(200);
	}
	public String getTipo() {
		return "LUCROSEDIVIDENDOS";
	}
}
