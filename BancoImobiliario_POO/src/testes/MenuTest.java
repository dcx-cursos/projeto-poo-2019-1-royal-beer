package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.CorInexistenteException;
import exceptions.CorJaEscolhidaException;
import principal.Menu;

class MenuTest {

	Menu menu;
	
	@BeforeEach
	public void setUp() {
		menu = new Menu();
	}
	
	@Test
	//Testa o tamanho da lista após o cadastro do jogador
	public void testCadastraJogador() throws CorInexistenteException, CorJaEscolhidaException {
		menu.cadastraJogador("Matheus", "preto");
		assertEquals(1,menu.getListaJogadores().size());
	}
	
	@Test
	//Testa o lançamento da exceção CorInexistenteException
	public void testCorException() throws CorInexistenteException, CorJaEscolhidaException {
		Assertions.assertThrows(CorInexistenteException.class,() -> {
			menu.cadastraJogador("Matheus","ciano");
		});
	}
	
	@Test
	//Testa o lançamento da exceção CorJaEscolhidaException
	public void testCorJaEscolhidaException() {
		Assertions.assertThrows(CorJaEscolhidaException.class,() -> {
			menu.cadastraJogador("Matheus","preto");
			menu.cadastraJogador("Matheus","preto");
		});
		
	
	
	}
	
	

	


	

}
