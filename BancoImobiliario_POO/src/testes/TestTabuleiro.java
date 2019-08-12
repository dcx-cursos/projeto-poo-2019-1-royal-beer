package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.EntradaInvalidaException;
import tabuleiro.Tabuleiro;

class TestTabuleiro {

	Tabuleiro tabuleiro;
	 
	@BeforeEach
	public void setUp() {
		tabuleiro = new Tabuleiro();
	}
	
	@Test
	//Testa se a a carta '0' é o ponto de partida
	public void testGetCasa0Tabuleiro() throws EntradaInvalidaException {
		assertEquals("Ponto de partida",tabuleiro.getCasaTabuleiro(0).getNome());
	}
	
	@Test
	//Testa se a carta '1' é o leblon
	public void testGetCasa1Tabuleiro() throws EntradaInvalidaException {
		assertEquals("Leblon",tabuleiro.getCasaTabuleiro(1).getNome());
	}
	

	
	

}
