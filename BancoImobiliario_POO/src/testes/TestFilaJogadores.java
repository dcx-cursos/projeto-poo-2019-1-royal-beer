package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import principal.FilaJogadores;
import principal.Jogador;

class TestFilaJogadores {

	FilaJogadores fila;
	ArrayList<Jogador> jogadores = new ArrayList<>();
	Jogador jog;
	Jogador jog2;
	
	@BeforeEach
	public void setUp() {
		jog = new Jogador("Samuel","preto");
		jog2 = new Jogador("Leo","vermelho");
		jogadores.add(jog);
		jogadores.add(jog2);
		fila = new FilaJogadores(jogadores);
	}
	
	@Test
	//Testa se a fila está pegando corretamente o proximo jogador
	public void  testProxJogador() {
		assertEquals("Samuel",fila.proxJogador().getNome());
	}
	
	@Test
	//Testa se a fila está pegando  corretamente o prox jogadot apos 1 jogada
	public void testProxJogadorApos1Jogada() {
		fila.proxJogador();
		assertEquals("Leo",fila.proxJogador().getNome());
	}
	
	

}
