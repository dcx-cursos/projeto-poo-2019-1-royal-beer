package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;
import principal.Jogador;
import tabuleiro.ImpostoDeRenda;

class TestImpostoDeRenda {


	
	Jogador jog;
	ImpostoDeRenda a;
	
	@BeforeEach
	public void setUp() {
		jog = new Jogador("Samuel","preto");
		a = new ImpostoDeRenda();
	}
	
	@Test
	//Testa se o valor a debitado do jogador apos a ativaçao do imposto de renda está correto
	public void testAtivaImpostoDeRenda() throws ValorNegativoException, SaldoInsuficienteException {
		a.ativaImpostoDeRenda(jog);
		assertEquals(1300, jog.getDinheiro());
	}
	
	@Test
	//Testa se quando o saldo não é suficiente é lançada a exceção SaldoInsuficienteException
	public void testAtivaImpostoDeRendaComSaldoFaltando() {
		Assertions.assertThrows(SaldoInsuficienteException.class, ()->{
			jog.debitar(1500);
			a.ativaImpostoDeRenda(jog);
		});
		
	}
	
	

}
