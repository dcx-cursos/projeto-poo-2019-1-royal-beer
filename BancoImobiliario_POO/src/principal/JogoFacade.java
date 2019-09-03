package principal;

import java.util.ArrayList;
import java.util.Random;

import exceptions.ComandoIndisponivelException;
import exceptions.CorIndisponivelException;
import exceptions.ErroAoCalcularAluguelException;
import exceptions.SaldoInsuficienteException;
import exceptions.ValorNegativoException;
import tabuleiro.CasaTabuleiro;
import tabuleiro.Companhia;
import tabuleiro.Efeito;
import tabuleiro.Prisao;
import tabuleiro.SorteOuReves;
import tabuleiro.Tabuleiro;
import tabuleiro.Terreno;

public class JogoFacade  {

	private Tabuleiro tabuleiro = new Tabuleiro();
	
	private ArrayList<Jogador> jogadores = new ArrayList<>();

	private ArrayList<String>  coresDisponiveis = carregaCores();
	
	private ArrayList<String> comandosDisponiveis = carregaComandos();
	
	private Jogador jogadorDaVez = null ;
	
	int [] resultadoDados;
	
	
	private int ponteiro = -1;

	
	public void cadastraJogador(String nome , String cor) throws CorIndisponivelException{
		if(this.jogadorComCor(cor) == -1) {
			if(this.verificaCorNaLista(cor) != -1){
				Jogador jog = new Jogador(nome,cor);
				this.removeCorDaLista(cor);
				jogadores.add(jog);
			}else throw new CorIndisponivelException("A cor escolhida não está dentre as opções");
		}else throw new CorIndisponivelException("Cor ja escolhida");
	}
	
	public int jogadorComCor(String cor) {
		for(int k = 0; k<this.jogadores.size();k++) {
			if(this.jogadores.get(k).getCor().toUpperCase().equals(cor.toUpperCase())){
				return k;
			}
		}
		return -1;
	}
	
	public int verificaCorNaLista(String item) {
		for(int k =0;k<coresDisponiveis.size();k++) {
			if(item.toUpperCase().equals(this.coresDisponiveis.get(k))) return k;
			
		}
		return -1;
	}		

	private void removeCorDaLista(String cor) {
		for(int k = 0 ; k<this.coresDisponiveis.size();k++) {
			if(this.coresDisponiveis.get(k).equals(cor.toUpperCase())) {
				this.coresDisponiveis.remove(k);
			}
		}
		
		}
	
		
	public String getStringDeCores() {
		String temp = "";
		for(String a : this.coresDisponiveis) {
			temp += "["+ a +"]";
		}
		return temp;
	}
	
	public ArrayList<String> getCores() {
		return this.coresDisponiveis;
	}
	
	public ArrayList<Jogador> getJogadores(){
		return this.jogadores;
	}
	
	public ArrayList<String> carregaCores() {
		ArrayList<String> temp = new ArrayList<>();
		temp.add("PRETO");
		temp.add("BRANCO");
		temp.add("VERMELHO");
		temp.add("VERDE");
		temp.add("AZUL");
		temp.add("AMARELO");
		temp.add("LARANJA");
		temp.add("ROSA");
		
		return temp;
	}
	
	public boolean verificaNumeroDeJogadores(int numeroDeJogadores) {
		if(numeroDeJogadores >= 2 && numeroDeJogadores <=8) {
			return true;
		}
		return false;
	}
	
	public Jogador getProxJogador() {
		this.ponteiro+= 1;
		if(this.ponteiro == this.jogadores.size()) {
			this.ponteiro = 0;
		}
		if(this.jogadores.get(this.ponteiro).isOnGame()) {
		this.jogadorDaVez = this.jogadores.get(this.ponteiro);
		}else {
			this.jogadores.remove(this.ponteiro);
			this.getProxJogador();
		}
			return this.jogadorDaVez;
		
		
	}
	
	private ArrayList<String> carregaComandos(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("JOGAR");
		temp.add("SAIR");
		return temp;
	}
	
	public String getStringDeComandos() {
		
		String temp = "";
		for(String a : this.comandosDisponiveis) {
			temp += "["+ a +"]";
		}
		return temp;
		
	}
	
	public boolean validaComando(String comando) {
	
		for(int k =0;k<this.comandosDisponiveis.size();k++){
			if(comando.toUpperCase().startsWith(this.comandosDisponiveis.get(k).substring(0,3))){
			return true;
		}
	}
		return false;
	}
	
	public boolean verificaSeJogoEstaAtivo() {
		if(this.jogadores.size() > 1) return true;
		return false;
	}
	
	public CasaTabuleiro getCasaTabuleiro(int casa) {
		return tabuleiro.getCartasLugares(casa);
	}
	
	public int [] getResultadoDado() {
		int [] numeros=new int [2];
		Random random= new Random();
		numeros[0]= random.nextInt(6)+1;
		numeros[1]= random.nextInt(6)+1;
		
		this.resultadoDados = numeros;
		return numeros;
	}


	
	
	public String iniciaJogada() {
		
			this.getProxJogador();
		
		
		System.out.println( "A jogada de " + this.jogadorDaVez.getNome() + "("+ this.jogadorDaVez.getCor()+") começou");
		
		resultadoDados = this.getResultadoDado();
		
		Prisao prisao = tabuleiro.getPrisao();
		if(prisao.verificaPrisioneiro(this.jogadorDaVez)) {
			if(this.resultadoDados[0]==this.resultadoDados[1]) {
				this.jogadorDaVez.apagaDadosJogados();
				prisao.libertaPrisioneito(this.jogadorDaVez);
				this.jogadorDaVez.andarCasas(this.resultadoDados[0]+this.resultadoDados[1],this.resultadoDados);
			return("O Jogador" + this.jogadorDaVez.getNome() + "tirou"
					+ this.resultadoDados[0]+","+this.resultadoDados[1]+"e saiu da prisao. Na proxima rodada "
					+ "o jogador podera mover-se normalmente");
				
		}else {
			return("O jogador " + this.jogadorDaVez.getNome()
			+ " tirou os dados ["+this.resultadoDados[0]+","+this.resultadoDados[1]+"], e não saiu da prisão. "
			+"[pagar][status][sair]");
	
		}
	
	}
		return "[jogar][status][sair]" ;
		
		
	}
	
	
	
	public String geraJogada(String comando) throws ErroAoCalcularAluguelException, ValorNegativoException, SaldoInsuficienteException, ComandoIndisponivelException {
		
		this.jogadorDaVez.andarCasas(this.resultadoDados[0]+this.resultadoDados[1],this.resultadoDados);
		
		

		if(comando.toUpperCase().startsWith("JOG")||comando.equals("jogar")) {
			
			if(tabuleiro.getCasaTabuleiro(jogadorDaVez.getPosicao()).getTipo().equals("TERRENO")) {
				Terreno aux = (Terreno) tabuleiro.getCasaTabuleiro(jogadorDaVez.getPosicao());
				if(!aux.hasDono()) {
					return "O jogador "+ jogadorDaVez.getNome()+" ("+jogadorDaVez.getCor()+") "
							+"tirou "+ resultadoDados[0]+","+ resultadoDados[1]+ " e avançou para " 
							+  this.jogadorDaVez.getPosicao()+" - "
							+ tabuleiro.getCasaTabuleiro(this.jogadorDaVez.getPosicao()).getNome()
							+ "\nO titulo da propriedade "+aux.getNome()+ " está disponivel"
							+ "\n"+this.jogadorDaVez.getNome()+", você possui " + this.jogadorDaVez.getDinheiro()+"$" 
							+ "\nDeseja comprar? ([SIM][NAO])";
					
				}
				aux.cobraAluguel(this.jogadorDaVez);
				return "O jogador "+ jogadorDaVez.getNome()+" ("+jogadorDaVez.getCor()+") "
						+"tirou "+ resultadoDados[0]+","+ resultadoDados[1]+ " e avançou para " 
						+  this.jogadorDaVez.getPosicao()+" - "
						+ tabuleiro.getCasaTabuleiro(this.jogadorDaVez.getPosicao()).getNome()
						+ "A propriedade pertence a " + aux.getDono().getNome()+ " o valor do aluguel que será debitado "
						+ "é de :"+ aux.getAluguel();
	
					
			}else if(tabuleiro.getCasaTabuleiro(jogadorDaVez.getPosicao()).getTipo().equals("PRISAO")) {
				Prisao aux = (Prisao) tabuleiro.getCasaTabuleiro(jogadorDaVez.getPosicao());
				return (aux.getMsg());
				
			}else if(tabuleiro.getCasaTabuleiro(jogadorDaVez.getPosicao()).getTipo().equals("COMPANHIA")) {
				Companhia aux = (Companhia)  tabuleiro.getCasaTabuleiro(jogadorDaVez.getPosicao());
				
				if(!aux.hasDono()) {
					return "O jogador "+ jogadorDaVez.getNome()+" ("+jogadorDaVez.getCor()+") "
							+"tirou "+ resultadoDados[0]+","+ resultadoDados[1]+ " e avançou para " 
							+  this.jogadorDaVez.getPosicao()+" - "
							+ tabuleiro.getCasaTabuleiro(this.jogadorDaVez.getPosicao()).getNome()
							+ "\nO titulo da "+aux.getNome()+ "está disponivel"
							+ "\n"+this.jogadorDaVez.getNome()+", você possui " + this.jogadorDaVez.getDinheiro()
							+ "\nDeseja comprar? ([SIM][NAO])";
				}else {
					
					aux.cobraAluguel(this.jogadorDaVez,this.resultadoDados);
					return "O jogador "+ jogadorDaVez.getNome()+" ("+jogadorDaVez.getCor()+") "
					+"tirou "+ resultadoDados[0]+","+ resultadoDados[1]+ " e avançou para " 
					+  this.jogadorDaVez.getPosicao()+" - "
					+ tabuleiro.getCasaTabuleiro(this.jogadorDaVez.getPosicao()).getNome()
					+ "\nO titulo da "+aux.getNome()+ "está disponivel"
					+ "\n"+this.jogadorDaVez.getNome()+", você possui" + this.jogadorDaVez.getDinheiro();
					
				}
				
					
				
			}else if(tabuleiro.getCasaTabuleiro(jogadorDaVez.getPosicao()).getTipo().equals("IMPOSTODERENDA")) {
				this.jogadorDaVez.debitar(200);
				return "O jogador "+ jogadorDaVez.getNome()+" ("+jogadorDaVez.getCor()+") "
						+"tirou "+ resultadoDados[0]+","+ resultadoDados[1]+ " e avançou para " 
						+  this.jogadorDaVez.getPosicao()+" - "
						+ tabuleiro.getCasaTabuleiro(this.jogadorDaVez.getPosicao()).getNome()
						+ "Foram debitados 200$ de imposto de renda";
				
			}else if(tabuleiro.getCasaTabuleiro(jogadorDaVez.getPosicao()).getTipo().equals("LUCROSEDIVIDENDOS")){
				this.jogadorDaVez.creditar(200);
				return "O jogador "+ jogadorDaVez.getNome()+" ("+jogadorDaVez.getCor()+") "
						+"tirou "+ resultadoDados[0]+","+ resultadoDados[1]+ " e avançou para " 
						+  this.jogadorDaVez.getPosicao()+" - "
						+ tabuleiro.getCasaTabuleiro(this.jogadorDaVez.getPosicao()).getNome()
						+ "Foram adicionados 200$ a sua conta";
				
			}else if(tabuleiro.getCasaTabuleiro(jogadorDaVez.getPosicao()).getTipo().equals("PARADALIVRE")) {
				return "O jogador "+ jogadorDaVez.getNome()+" ("+jogadorDaVez.getCor()+") "
						+"tirou "+ resultadoDados[0]+","+ resultadoDados[1]+ " e avançou para " 
						+  this.jogadorDaVez.getPosicao()+" - "
						+ tabuleiro.getCasaTabuleiro(this.jogadorDaVez.getPosicao()).getNome();
				
			}else if(tabuleiro.getCasaTabuleiro(jogadorDaVez.getPosicao()).getTipo().equals("PONTODEPARTIDA")) {
				
				return "O jogador "+ jogadorDaVez.getNome()+" ("+jogadorDaVez.getCor()+") "
						+"tirou "+ resultadoDados[0]+","+ resultadoDados[1]+ " e avançou para " 
						+  this.jogadorDaVez.getPosicao()+" - "
						+ tabuleiro.getCasaTabuleiro(this.jogadorDaVez.getPosicao()).getNome();
				
			}else if(tabuleiro.getCasaTabuleiro(jogadorDaVez.getPosicao()).getTipo().equals("VAPARAPRISAO")) {
				this.jogadorDaVez.setPosicao(10);
				return "O jogador"+ this.jogadorDaVez.getNome()+" tirou"+ resultadoDados[0]+","+ resultadoDados[1]+" e caiu na casa "
						+ "Vá para prisão' e foi colocado na Prisão."
						+"Nas proximas jogadas para sair ele poderá pagar ou tentar pegar dois dados iguais";
				
			}else if(tabuleiro.getCasaTabuleiro(jogadorDaVez.getPosicao()).getTipo().equals("SORTEOUREVES")){
				SorteOuReves aux = (SorteOuReves) tabuleiro.getCasaTabuleiro(jogadorDaVez.getPosicao());
				Efeito aux1 = aux.getProxCarta();
				aux1.aplicaEfeito(jogadorDaVez);
				return aux1.getMensagem();
			}
	
			
			
		}else if(comando.toUpperCase().startsWith("ST")) {
			this.ponteiro -- ;

			return this.getJogadorDaVez().getStatus()+"\n(Aperte ENTER para proseguir com o jogo";
		
			
		}else if(comando.toUpperCase().startsWith("SAI")) {
			this.jogadorDaVez.outGame();
			this.jogadores.remove(this.jogadorDaVez);
			if(!this.verificaSeJogoEstaAtivo()) {
				return "Jogo encerrado";
			}
			return "O jogador "+this.jogadorDaVez.getNome()+"saiu do jogo";
		}else if(comando.toUpperCase().startsWith("PAG")) {
			if(this.tabuleiro.getCasaTabuleiro(this.jogadorDaVez.getPosicao()).getTipo().equals("PRISAO")) {
				Prisao prisao = tabuleiro.getPrisao();
				this.jogadorDaVez.debitar(50);
				prisao.libertaPrisioneito(this.jogadorDaVez);
			}
		}
		this.ponteiro--;
		
		throw new ComandoIndisponivelException("O comando selecionado não está dentro das opções");
	
	

	}
	
	public CasaTabuleiro getCasaAtual() {
		
		return tabuleiro.getCartasLugares(this.jogadorDaVez.getPosicao());
	}
	
	public boolean isTerrenoCasaAtual() {
		if(this.getCasaAtual().getTipo().equals("TERRENO")) {
			return true;
		}
		return false;
	}
	
	public boolean isCompanhiaCasaAtual() {
		if(this.getCasaAtual().getTipo().equals("COMPANHIA")) {
			return true;
		}
		return false;
	}
	
	public Jogador getJogadorDaVez() {
		return this.jogadorDaVez;
	}
}
			
		
		
		
		
		
	
	
	
	
	
	
