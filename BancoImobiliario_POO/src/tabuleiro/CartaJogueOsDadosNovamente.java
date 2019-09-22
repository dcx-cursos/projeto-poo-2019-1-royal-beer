package tabuleiro;
import java.util.Random;

import exceptions.SaldoInsuficienteException;
import principal.Jogador;

public class CartaJogueOsDadosNovamente extends CartaSorteOuRevesGenerica implements Efeito {
	
	private int [] dadosJogados;

	private int [] jogaDados() {
		int [] numeros=new int [2];
		Random random= new Random();
		numeros[0]= random.nextInt(6)+1;
		numeros[1]= random.nextInt(6)+1;
		this.dadosJogados = numeros;
		return numeros;
	}
	
	@Override
	public void aplicaEfeito(Jogador jog) throws SaldoInsuficienteException {
		this.jogaDados();
		jog.andarCasas(dadosJogados[0]+dadosJogados[1], dadosJogados);
		
	}

	@Override
	public String getMensagem() {
		return "- Jogue os dados Novamente - O jogador tirou( "+dadosJogados[0]+","+dadosJogados[1] + ") e andou mais "+ (dadosJogados[0]+dadosJogados[1])
				+"casas. Na proxima jogada podera jogar normalmente";
	}

}
