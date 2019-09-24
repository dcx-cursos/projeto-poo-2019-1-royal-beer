package testes;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.SaldoInsuficienteException;
import principal.Jogador;
import tabuleiro.CartaReves;
import tabuleiro.CartaSorte;
import tabuleiro.VaParaPrisao;

class testeSorteOuReves {

	public CartaReves cartaPaga;
	CartaSorte cartaRecebe;
	Jogador jog;

	@BeforeEach()
	public void setUp() {
		cartaPaga = new CartaReves("Pague 100",100);
		cartaRecebe = new CartaSorte("Receba 100",100);
		jog = new Jogador("Mat","preto");
	}
	@Test
	public void testEfeitoPaga() throws SaldoInsuficienteException{
		cartaPaga.aplicaEfeito(jog);
		assertEquals(1400.0, jog.getDinheiro(),0);
	}
	@Test
	public void testEfeitoRecebe() throws SaldoInsuficienteException {
		cartaRecebe.aplicaEfeito(jog);
		System.out.println(jog.getDinheiro());
		assertEquals(1600.0,jog.getDinheiro(),0);
	}
	@Test
	public void testCartaVaParaPrisao() throws SaldoInsuficienteException {
		VaParaPrisao temp = new VaParaPrisao();
			temp.aplicaEfeito(jog);
			assertEquals(10,jog.getPosicao());
	}


}
