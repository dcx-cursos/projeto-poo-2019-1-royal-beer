package tabuleiro;

import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;
import principal.Jogador;

public class ImpostoDeRenda  implements CasaTabuleiro{
	
	/*
	 * Classe para objetos do tipo imposto de renda com seus respectivos metodos
	 */

	
	public String getNome() {
		return "Imposto de Renda";
	}
	/*
	 * Metodo que debita $200 do jogador caso pare nesta casa
	 * @param jog Jogador - Jogador que sera debitado o valor
	 * @return void 
	 */
	public void ativaImpostoDeRenda(Jogador jog) throws ValorNegativoException, SaldoInsuficienteException {
		jog.debitar(200);
	}
	
	
}
