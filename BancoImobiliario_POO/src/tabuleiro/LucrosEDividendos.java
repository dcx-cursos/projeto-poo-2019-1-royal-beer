package tabuleiro;

import principal.Jogador;

public class LucrosEDividendos implements CasaTabuleiro {
	
	
	public String getNome() {
		return "Lucros e dividendos";
	}

	public void ativaLucrosEDividendos(Jogador jog) {
		jog.creditar(200);
	}
}
