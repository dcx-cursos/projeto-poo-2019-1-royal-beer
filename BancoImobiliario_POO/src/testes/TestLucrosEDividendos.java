package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import principal.Jogador;
import tabuleiro.LucrosEDividendos;

class TestLucrosEDividendos {

	LucrosEDividendos a ;
	Jogador jog;
	
	@BeforeEach
	public void setUp() {
		a = new LucrosEDividendos();
		jog = new Jogador("Samuel","preto");
	}
	
	@Test
	//Testa se ao ativar a carta Lucros e dividendos o jogador recebe $200
	public void testAtivaLucrosEDividendos() {
		a.ativaLucrosEDividendos(jog);
		assertEquals(1700,jog.getDinheiro());
	}

}
