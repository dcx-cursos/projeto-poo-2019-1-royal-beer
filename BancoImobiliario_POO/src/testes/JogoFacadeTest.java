package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.CorIndisponivelException;
import principal.JogoFacade;

class JogoFacadeTest {
	
	public JogoFacade jogo ;
	
	@BeforeEach
	public void setUp() {
		jogo = new JogoFacade();
		
	}

	
	@Test
	void testCadastraJogador() throws CorIndisponivelException {
		jogo.cadastraJogador("Matheus", "Preto");
		assertEquals(1,jogo.getJogadores().size());
	}
	
	@Test
	void testAtualizacaoListaDeCores() throws CorIndisponivelException {
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

}
