package testes;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;
import principal.Jogador;
import tabuleiro.ImpostoDeRenda;

public class testeImpostoDeRenda {
	
	private ImpostoDeRenda carta;
	private Jogador jog;
	
	@BeforeEach
	public void setUp() {
	carta = new ImpostoDeRenda();
	jog = new Jogador("Mat","preto");
	}
	
	@Test
	public void testEfeito() throws ValorNegativoException, SaldoInsuficienteException {
		carta.ativaImpostoDeRenda(jog);
	}

}
