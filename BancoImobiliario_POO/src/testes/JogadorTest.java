package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;
import principal.Jogador;
import tabuleiro.CartasLugares;

class JogadorTest {
	
	Jogador jog;
	

	
	

	@BeforeEach
	public void setUp() {
		jog = new Jogador("Samuel","preto");
	}
	
	@Test
	//Testa andar 1 casa
	public void testAnda1Casa() {
		jog.andarCasas(1);
			
		assertEquals(1,jog.getPosicao());
		
		}
	

	
		@Test
		//Testa andar as casas usando um dado(mock)
		public void testAndarCasas() {
			int [] a = {2,4};//Simula o lançamento de dados com o valor 2 e 4
			jog.andarCasas(a[0]+ a[1]);
			assertEquals(6,jog.getPosicao());
		}
	
		@Test
		//testa andar 45 casas (Tem como objetivo verificar quando ocorre a volta no tabuleiro)
		public void testAndar45Casas() {
			jog.andarCasas(45);
			
			assertEquals(5,jog.getPosicao());
		}
		
		@Test
		//Testa se o nome do titulo foi adicionado na lista de nome dos titulos adiquiridos
		public void testAddNomeTitulo() throws ValorNegativoException, SaldoInsuficienteException {
			CartasLugares a = new CartasLugares("Leblon","rosa",100,6,30,90,270,400,500,50,50);
			jog.comprar(a);
			
			assertEquals(1,jog.getTitulos().size());
		}
		
		@Test
		//Testa se o jogador ganha $200 ao passar pelo ponto de partida
		public void testGanhaDinheiroNoPontoDePartida() {
			jog.andarCasas(41);
			
			assertEquals(1700,jog.getDinheiro());
		}
		
		@Test
		//Testa se quando o jogador gasta todo seu dinheiro ele sai do jogo 
		public void testFalencia() throws ValorNegativoException, SaldoInsuficienteException {
			jog.debitar(1500);
			
			assertFalse(jog.isOnGame());
			
		}
		
		@Test
		//Testa o método creditar
		public void testCreditar() {
			jog.creditar(500);
			
			assertEquals(2000,jog.getDinheiro());
		}
		
		

		
		
		
		


}
