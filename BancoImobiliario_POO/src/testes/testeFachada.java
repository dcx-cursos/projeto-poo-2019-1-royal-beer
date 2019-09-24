package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import exceptions.ComandoIndisponivelException;
import exceptions.CorIndisponivelException;
import exceptions.SaldoInsuficienteException;
import principal.Jogador;
import principal.JogoFacade;
import tabuleiro.Dado;
import tabuleiro.Terreno;

class testeFachada {

public JogoFacade jogo ;
	
	
	@Mock
	Dado dado = null;
	
	
	
	@BeforeEach
	public void setUp() {
		jogo = new JogoFacade();
		
	}

	//testa o metodo de cadastro
	@Test
	void testCadastraJogador() throws CorIndisponivelException {
		jogo.cadastraJogador("Matheus", "Preto");
		assertEquals(1,jogo.getJogadores().size());
	}
	
	/*
	 *testa o lançamento da exceção caso o jogador escolha uma cor que não está
	 *disponivel
	 */
	@Test
	void testCorIncdisponivelException() {
		Assertions.assertThrows(CorIndisponivelException.class, () ->{
			jogo.cadastraJogador("Matheus", "Macarrao");
		});
		Assertions.assertThrows(CorIndisponivelException.class, () ->{
			jogo.cadastraJogador("Matheus", "Preto");
			jogo.cadastraJogador("Jose","Preto");
		});
	}
	/*
	 * testa o lançamento da exceção caso o comando escolhido não esteja 
	 * dentro das opçoẽs
	 */
	@Test
	void testComandoIndisponivelException() {
		Assertions.assertThrows(ComandoIndisponivelException.class,() ->{
			jogo.geraJogada("Bobao");
		});
	}
	@Test
	void testRemoveCorDaLista() throws CorIndisponivelException {
		jogo.cadastraJogador("Will","Azul");
		jogo.cadastraJogador("Matheus", "Preto");
		jogo.cadastraJogador("Wesley","rosa");
		assertEquals(5,jogo.getCores().size());
	}
	
	@Test
	void testJogadorComCor() throws CorIndisponivelException {
		jogo.cadastraJogador("Will","Azul");
		jogo.cadastraJogador("Matheus", "Preto");
		jogo.cadastraJogador("Wesley","rosa");
		assertEquals(-1,jogo.jogadorComCor("Laranja"));
	}
	
	@Test
	void testVerificaCorNaLista() {
		assertTrue(-1 != jogo.verificaCorNaLista("verde"));
		assertTrue(-1 == jogo.verificaCorNaLista("magenta"));
	}
	
	@Test
	void testVerificaNumeroDeJogadores() {
		assertTrue(jogo.verificaNumeroDeJogadores(2));
		assertFalse(jogo.verificaNumeroDeJogadores(9));
	}
	
	@Test
	void testGetProxJogador() throws CorIndisponivelException {
		jogo.cadastraJogador("Will","Azul");
		jogo.cadastraJogador("Matheus", "Preto");
		jogo.cadastraJogador("Wesley","rosa");
		
		assertEquals("Will",jogo.getProxJogador().getNome());
		assertEquals("Matheus",jogo.getProxJogador().getNome());
		assertEquals("Wesley",jogo.getProxJogador().getNome());
		assertEquals("Will",jogo.getProxJogador().getNome());
		
	}
	
	@Test
	void testCarregaCores() {
		assertEquals(8,jogo.carregaCores().size());
		
	}
	
	@Test
	void testVerificaJogoEstaAtivo() throws CorIndisponivelException {
		jogo.cadastraJogador("Will","Azul");
		assertFalse(jogo.verificaSeJogoEstaAtivo());
		jogo.cadastraJogador("Matheus", "Preto");
		assertTrue(jogo.verificaSeJogoEstaAtivo());
	}
	
	@Test
	void testGetCasaTabuleiro() {
		assertEquals("PONTODEPARTIDA",jogo.getCasaTabuleiro(0).getTipo());
	}
	
	@Test
	void testGetResultadoDados() {
		int [] temp = jogo.getResultadoDado();
		assertTrue(	temp[0] > 0 && temp[0]<7 && temp[1]>0 && temp[1]<7);
	}
	
	@Test 
	void testHasDono() throws CorIndisponivelException, SaldoInsuficienteException {
		Jogador jog = new Jogador("Preto","Azul");
		Terreno temp = (Terreno)jogo.getCasaTabuleiro(1);
		temp.comprar(jog,null);
		assertTrue(temp.hasDono());
	}
	

	
	
	

}
