package testes;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.ErroAoCalcularAluguelException;
import exceptions.LimiteDeConstrucoesException;
import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;
import principal.Jogador;
import tabuleiro.CartasLugares;




class CartasLugaresTest {
	
	CartasLugares cartas;
	Jogador jog;
	Jogador jog2;
	
	/*
	 * Antes de uniciar cada teste é uniciada uma nova carta com os seguintes parametros:
	 * nome: Leblon
	 * cor: Rosa
	 * preco = 100 , 
	 * aluguel sem casa = 6
	 * aluguel 1 casas = 30
	 * aluguel 2 casas = 90
	 * aluguel com 3 casas = 270
	 * aluguel com 4 casas = 400
	 * aluguel com hotel = 500
	 * preco de venda 50
	 * hipoteca = 50
	 * 
	 * E um jogador(jog) com os seguintes parametros
	 * 
	 * nome = jose
	 * cor = preto
	 * dinheiro = 1500
	 * 
	 * E um jogador(jog2) om os seguintes parametros:
	 * 
	 * nome: maria
	 * cor = azul
	 * dinheiro = 1500
	 * 
	 */
	
	
	

	
	@BeforeEach
	public void setUp() {
		cartas = new CartasLugares("Leblon","rosa",100,6,30,90,270,400,500,50,50);
		jog = new Jogador("Jose"," preto");
		jog2 = new Jogador("maria" ,"azul");
		}
	
	
	@Test
	// Testa o valor do aluguel sem casas
	 	public void testValorAluguelSemCasa() throws ErroAoCalcularAluguelException {
			assertEquals(6,cartas.getAluguel());
	}
	
	
	@Test
	//Testa o valor do aluguel apos a compra de uma(1) casa
	public void testValorAluguelCom1Casas() throws ErroAoCalcularAluguelException, ValorNegativoException, SaldoInsuficienteException, LimiteDeConstrucoesException {
		cartas.venderCasa(jog);
		assertEquals(30,cartas.getAluguel());
	}
	
	
	@Test
	//Testa o valor so aluguel apos a compra de duas(2) casas
	public void testValorAluguelCom2Casas() throws ValorNegativoException, SaldoInsuficienteException, ErroAoCalcularAluguelException, LimiteDeConstrucoesException {
		cartas.venderCasa(jog);
		cartas.venderCasa(jog);
		assertEquals(90,cartas.getAluguel());

	}
	
	
	//Testa valor do aluguel apos a compra de tres(3) casas
	@Test
	public void testValorAluguelCom3Casas() throws ValorNegativoException, SaldoInsuficienteException, ErroAoCalcularAluguelException, LimiteDeConstrucoesException {
		cartas.venderCasa(jog);
		cartas.venderCasa(jog);
		cartas.venderCasa(jog);
		assertEquals(270,cartas.getAluguel());
	}
	
	
	//Testa o valor do aluguel apos a compra de quatro(4) casas
	@Test
	public void testValorAluguelCom4Casas() throws ValorNegativoException, SaldoInsuficienteException, ErroAoCalcularAluguelException, LimiteDeConstrucoesException {
		cartas.venderCasa(jog);
		cartas.venderCasa(jog);
		cartas.venderCasa(jog);
		cartas.venderCasa(jog);
		assertEquals(400,cartas.getAluguel());
	}
	
	
	@Test
	//Testa o valor do alugue apos adiquirir um hotel
	public void testValorAluguelComHotel() throws ValorNegativoException, SaldoInsuficienteException, ErroAoCalcularAluguelException, LimiteDeConstrucoesException {
		cartas.venderCasa(jog);
		cartas.venderCasa(jog);
		cartas.venderCasa(jog);
		cartas.venderCasa(jog);
		cartas.venderCasa(jog);
		assertEquals(500,cartas.getAluguel());

	}
	
	
	@Test
	//Testa o erro que deve ser lançado ao tentar fazer mais construções que o limite
	public void testErroVendaDeCasas() {
			Assertions.assertThrows(LimiteDeConstrucoesException.class,() -> {
			cartas.venderCasa(jog);
			cartas.venderCasa(jog);
			cartas.venderCasa(jog);
			cartas.venderCasa(jog);
			cartas.venderCasa(jog);
			cartas.venderCasa(jog);

		});
	}
	
	@Test
	//Testa se o valor do aluguel do imóvel sem casa foi descontado do jogador corretamente
	public void testCobrancaAluguelSemCasa() throws ErroAoCalcularAluguelException, ValorNegativoException, SaldoInsuficienteException {
		cartas.comprar(jog);
		cartas.cobraAluguel(jog2);
		
		assertEquals(1494,jog2.getDinheiro());
	}
	
	@Test
	//Testa se o valor do aluguel do imóvel com 1 casa foi descontado do jogador corretamente
	public void testCobrancaAluguelCom1Casa() throws ValorNegativoException, SaldoInsuficienteException, ErroAoCalcularAluguelException, LimiteDeConstrucoesException {
		cartas.comprar(jog);
		cartas.venderCasa(jog);

		cartas.cobraAluguel(jog2);
		
		assertEquals(1470,jog2.getDinheiro());
	}
	
	
	@Test
	//Testa se o valor do Aluguel do imóvel com 2 casas foi descontado corretamente
	public void testCobrancaAluguelCom2Casas() throws ErroAoCalcularAluguelException, ValorNegativoException, SaldoInsuficienteException, LimiteDeConstrucoesException {
		cartas.comprar(jog);
		cartas.venderCasa(jog);
		cartas.venderCasa(jog);
		
		cartas.cobraAluguel(jog2);
		
		assertEquals(1410,jog2.getDinheiro());
	}
	
	@Test
	//Testa se o valor do aluguel do imóvel com 3 casas foi descontado corretamente
	public void testCobrancaAluguelCom3Casas() throws ValorNegativoException, SaldoInsuficienteException, LimiteDeConstrucoesException, ErroAoCalcularAluguelException {
		cartas.comprar(jog);
		cartas.venderCasa(jog);
		cartas.venderCasa(jog);
		cartas.venderCasa(jog);
		
		cartas.cobraAluguel(jog2);
		
		assertEquals(1230,jog2.getDinheiro());
	}
	
	@Test
	// Testa se o valor do aluguel do imóvel com 4 casas foi descontado corretamente
	public void testCobrancaAluguelCom4Casas() throws ValorNegativoException, SaldoInsuficienteException, LimiteDeConstrucoesException, ErroAoCalcularAluguelException {
		cartas.comprar(jog);
		cartas.venderCasa(jog);
		cartas.venderCasa(jog);
		cartas.venderCasa(jog);
		cartas.venderCasa(jog);

		
		cartas.cobraAluguel(jog2);
		
		assertEquals(1100,jog2.getDinheiro());
	}
	
	@Test
	//Testa se o valor do aluguel do imóvel com Hotel foi descontado corretamente
	public void testCobrancaAluguelComHotel() throws ValorNegativoException, SaldoInsuficienteException, LimiteDeConstrucoesException, ErroAoCalcularAluguelException {
		cartas.comprar(jog);
		cartas.venderCasa(jog);
		cartas.venderCasa(jog);
		cartas.venderCasa(jog);
		cartas.venderCasa(jog);
		cartas.venderCasa(jog);
	
		cartas.cobraAluguel(jog2);

		assertEquals(1000,jog2.getDinheiro());
}
	@Test
	//Testa o método que verfica se o terreno tem dono
	public void testHasDono() {
		
		assertFalse(cartas.hasDono());
	}
	
	@Test
	//Testa o método que verifica se o terreno tem dono
	public void testHasDono2() throws ValorNegativoException, SaldoInsuficienteException {
		cartas.comprar(jog);
		
		assertTrue(cartas.hasDono());
	}
	
	
	
	
		
		
		
	
	
	

	
	

}
