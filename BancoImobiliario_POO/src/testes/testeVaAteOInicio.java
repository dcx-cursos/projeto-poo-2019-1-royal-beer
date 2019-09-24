package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.SaldoInsuficienteException;
import principal.Jogador;
import tabuleiro.CartaVaParaOInicio;

class testeVaAteOInicio {

	private Jogador jog;
	private CartaVaParaOInicio carta;
	
	@BeforeEach
	public void setUp() {
		this.jog = new Jogador("Mat","Preto");
		this.carta = new CartaVaParaOInicio();
	}
	
	@Test
	void testEfeito() throws SaldoInsuficienteException {
		carta.aplicaEfeito(jog);
		assertEquals(0,jog.getPosicao());
	}

}
