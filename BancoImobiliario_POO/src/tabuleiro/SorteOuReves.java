package tabuleiro;

import java.util.ArrayList;
import java.util.Random;

public class SorteOuReves implements CasaTabuleiro{
	
	private FilaDeCartas baralho  = new FilaDeCartas();


	public SorteOuReves() {
		
		this.geraBaralho();
	}
	public void geraBaralho() {
		
		
		ArrayList<Efeito> temp = new ArrayList<>();
		
		temp.add(new CartaReves("Sua empresa foi multada por poluir demais.Pague 200",200));
		temp.add(new DiaDoCasamento("O dia do seu casamento chegou, receba os presentes.\nSerá debitado $50 de cada jogador"));
		temp.add(new CartaReves("Reformou a casa.Pague 50",50));
		temp.add(new CartaSorte("Seu livro será publicado por uma grande editora. Receba 50",50));
		temp.add(new CartaSaiaDaPrisao());
		temp.add(new CartaVaParaPrisao());
		temp.add(new CartaVaParaOInicio());
		temp.add(new CartaSorte("Suas ações na bolsa de valores estão em alta. Receba 100",100));
		temp.add(new CartaReves("Você vai começar um curso de MBA e ganhou um bom desconto para pagamento a vista. Pague 20",20));
		temp.add(new CartaReves("Ferias com a família. Pague 20",20));
		temp.add(new CartaSorte("Recebeu o prêmio de profissional do ano e ganhou um carro. Receba 10",10));
		temp.add(new CartaJogueOsDadosNovamente());
		temp.add(new CartaReves("Sua empresa vai patrocinar uma expedição na antartida. Pague 50",50));
		temp.add(new CartaSorte("Vendeu parte da empresa para um investidor. Receba 75",75));
		temp.add(new CartaSorte("Apostou num cavalo azarão e ganhou. Receba 100",100));
		temp.add(new CartaReves("A falta de chuva prejudicou a colheita. Pague 45",45));
		temp.add(new CartaSorte("Recebei uma herança inesperada. Receba 75",75));
		temp.add(new CartaReves("Seu filho decidiu fazer intercambio. Pague 20",20));
		temp.add(new CartaSorte("Sua casa será desapropriada para a construção de um metro e ganhará uma gorda indenização. Receba 60",60));
		temp.add(new CartaSorte("Venceu licitação para grande obra. Receba 150",150));
		temp.add(new CartaSorte("Seu iate afundou,mas você tinha seguro!. Receba 25",25));
		temp.add(new CartaReves("Seus funcionarios entraram em greve. Pague 30",30));
		temp.add(new CartaReves("Comprou obra de arte falsificada. Pague 22",22));
		temp.add(new CartaParOuImpar());
		temp.add(new CartaReves("Seu jatinho precisa de manutenção. Pague 9",9));
		temp.add(new CartaReves("Renovou a frota de carros da sua empresa. Pague 100",100));
		temp.add(new CartaSorte("Ganhou sozinho na loteria. Receba 80",80));
		temp.add(new CartaReves("Atualizou os computadores da empresa. Pague 30",30));
		temp.add(new CartaReves("Um navio afundou com as sua mercadorias(não tinha seguro). Pague 40",40));
		temp.add(new CartaReves("A produção de leite das suas fazendas ficou abaixo da expectativa. Pague 60",60));
		temp.add(new CartaSorte("Tirou primeiro lugar no torneio de golfe. Receba 100",100));
		
		
			Random random= new Random();
			int num;
			while(temp.size()>0) {
			num = random.nextInt(temp.size());
			baralho.enfileirar(temp.get(num));
			temp.remove(num);
			}
			
		
		}


	
	
	public String getNome() {
		return "Sorte ou Reves";
		
		
	}
	public String getTipo() {
		return "SORTEOUREVES";
	}
	
	public Efeito getProxCarta() {
		return this.baralho.getCarta();
	}

	
	

}
