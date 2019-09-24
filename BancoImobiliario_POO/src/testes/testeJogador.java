package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.SaldoInsuficienteException;
import principal.Jogador;
import tabuleiro.TerrenoAmarelo;

class testeJogador {

	Jogador jog;
	@BeforeEach
	public void setUp() {
		jog = new Jogador("Mat","preto");
		
	}
	
	
	
	@Test
	void testCreditaDinheito() {
		jog.creditar(100);
		assertEquals(1600,jog.getDinheiro());
	}
	
	@Test
	void testDebitaDinheito() throws SaldoInsuficienteException {
		jog.debitar(100);
		assertEquals(1400,jog.getDinheiro());
	}
	
	@Test
	void testAdicionaTerreno() {
		TerrenoAmarelo a = new TerrenoAmarelo("olav",100,121,454,121,54,65,24,15,35);
		jog.addTitulo(a);
		assertEquals(1,jog.getTitulos().size());
	}

}
