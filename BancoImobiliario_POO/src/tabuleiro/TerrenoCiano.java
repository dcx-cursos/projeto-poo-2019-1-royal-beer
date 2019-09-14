package tabuleiro;

public class TerrenoCiano extends Terreno implements CasaTabuleiro {

	public TerrenoCiano(String nome, double preco, double valorAluguelSemCasa, double valorAluguelCom1Casa,
			double valorAluguelCom2Casas, double valorAluguelCom3Casas, double valorAluguelCom4Casas,
			double valorAluguelComHotel, double valorHipoteca, double valorImovelCasa) {
		
		super(nome,preco, valorAluguelSemCasa, valorAluguelCom1Casa, valorAluguelCom2Casas, valorAluguelCom3Casas,
				valorAluguelCom4Casas, valorAluguelComHotel, valorHipoteca, valorImovelCasa);
		
	}
	
	public String getCor() {
		return "Ciano";
	}

}
