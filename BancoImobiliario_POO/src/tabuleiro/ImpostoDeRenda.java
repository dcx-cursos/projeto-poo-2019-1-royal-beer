package tabuleiro;

import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;
import principal.Jogador;

public class ImpostoDeRenda  implements CasaTabuleiro{

	
	public String getNome() {
		return "Imposto de Renda";
	}

	public void ativaImpostoDeRenda(Jogador jog) throws ValorNegativoException, SaldoInsuficienteException {
		jog.debitar(200);
	}
	
	
}
