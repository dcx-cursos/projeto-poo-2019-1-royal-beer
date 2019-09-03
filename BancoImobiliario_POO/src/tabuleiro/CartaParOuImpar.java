package tabuleiro;

import exceptions.SaldoInsuficienteException;
import principal.Jogador;

public class CartaParOuImpar extends CartaSorteOuRevesGenerica implements Efeito {
	 
	private int [] aux;

	
	@Override
	public void aplicaEfeito(Jogador jog) throws SaldoInsuficienteException {
		this.aux = jog.getUltimosDadosJogados();
		if((aux[0]+ aux[1])%2 == 0) {
			jog.creditar(100);
		}
		jog.debitar(100);
		}
	
		

	@Override
	public String getMensagem() {
		if((aux[0]+ aux[1])%2 == 0) {
			return "Sorte se tirou o número par da soma dos dados e revés caso contrário. Você tirou " + aux[0]+","+aux[1]+" Receba 100";
		}
		return "Sorte se tirou o número par da soma dos dados e revés caso contrário. Você tirou " + aux[0]+","+aux[1]+" Pague 100";

		}
	
	

}
