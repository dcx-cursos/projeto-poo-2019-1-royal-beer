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
import tabuleiro.Dado;
import tabuleiro.Efeito;
import tabuleiro.Prisao;
import tabuleiro.SorteOuReves;
import tabuleiro.Tabuleiro;
import tabuleiro.Terreno;

public class JogoFacade  {
	/*
	 * Classe que tem como função gerenciar o jogo
	 */
	private Tabuleiro tabuleiro = new Tabuleiro();
	
	private ArrayList<Jogador> jogadores = new ArrayList<>();

	private ArrayList<String>  coresDisponiveis = carregaCores();
	
	private ArrayList<String> comandosDisponiveis = carregaComandos();
	
	private Jogador jogadorDaVez = null ;
	
	private Dado dados = new Dado();
	
	int [] resultadoDados;
	
	private int contador;
	
	
	private int ponteiro = -1;

	/*
	 * Metodo que cadastra o jogadores
	 * @param nome Uma String com o nome do jogador
	 * @param cor Uma String com a cor do jogador
	 * @throws CorIndisponivelException caso a cor ecolhida nao esteja dentre as opcoes
	 */
	public void cadastraJogador(String nome , String cor) throws CorIndisponivelException{
		if(this.jogadorComCor(cor) == -1) {
			if(this.verificaCorNaLista(cor) != -1){
				Jogador jog = new Jogador(nome,cor);
				this.removeCorDaLista(cor);
				jogadores.add(jog);
			}else throw new CorIndisponivelException("A cor escolhida não está dentre as opções");
		}else throw new CorIndisponivelException("Cor ja escolhida");
	}
	
	/*
	 * Verifica se determinada cor ja foi escolhida dentre os jogadores
	 * @param cor Uma String da cor a ser conferida
	 * @return retorna um inteiro, -1 caso a cor não tenha sido encontrada ou o indice em que a cor se encontra
	 * caso a mesma seja encontrada
	 */
	public int jogadorComCor(String cor) {
		for(int k = 0; k<this.jogadores.size();k++) {
			if(this.jogadores.get(k).getCor().toUpperCase().equals(cor.toUpperCase())){
				return k;
			}
		}
		return -1;
	}
	/*
	 * Verifica se a cor é valida
	 * @param item Uma string com a cor a ser procurada
	 * @return retorna um inteiro , -1 caso a cor não tenha sido encontrada ou o indice em que a cor se encontra caso
	 * a mesma seja encontrada
	 */
	public int verificaCorNaLista(String item) {
		for(int k =0;k<coresDisponiveis.size();k++) {
			if(item.toUpperCase().equals(this.coresDisponiveis.get(k))) return k;
			
		}
		return -1;
	}		
	/*
	 * Remove certa cor da lista
	 * @param cor uma String que guarda a cor a ser retirada da lista
	 */
	private void removeCorDaLista(String cor) {
		for(int k = 0 ; k<this.coresDisponiveis.size();k++) {
			if(this.coresDisponiveis.get(k).equals(cor.toUpperCase())) {
				this.coresDisponiveis.remove(k);
			}
		}
		
		}
	
		/*
		 * Obtem uma String com todas as cores juntas
		 * @return Uma String com as cores
		 */
	public String getStringDeCores() {
		String temp = "";
		for(String a : this.coresDisponiveis) {
			temp += "["+ a +"]";
		}
		return temp;
	}
	/*
	 * Obtem uma lista com as cores disponiveis
	 * @return um ArrayList com as cores disponiveis
	 */
	public ArrayList<String> getCores() {
		return this.coresDisponiveis;
	}
	/*
	 * Obtem a lista de jogadores
	 * @return um ArrayList com todos os jogadores
	 */
	public ArrayList<Jogador> getJogadores(){
		return this.jogadores;
	}
	/*
	 * Adiciona as cores na lista de cores
	 */
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
	/*
	 * Verifica de o numero de jogadores é suficiente para manter o jogo ativo
	 * @return retorna true caso o numero de jogadores seja maior que 1 e menor que 8
	 */
	public boolean verificaNumeroDeJogadores(int numeroDeJogadores) {
		if(numeroDeJogadores >= 2 && numeroDeJogadores <=8) {
			return true;
		}
		return false;
	}
	/*
	 * Obtem o proximo jogador 
	 * @return uma Objeto do tipo Jogador
	 */
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
	/*
	 * Carrega os comandos 
	 */
	private ArrayList<String> carregaComandos(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("JOGAR");
		temp.add("SAIR");
		return temp;
	}
	/*
	 * Obtem uma String com os comandos
	 */
	public String getStringDeComandos() {
		
		String temp = "";
		for(String a : this.comandosDisponiveis) {
			temp += "["+ a +"]";
		}
		return temp;
		
	}
	/*
	 * Verifica se um comando é valido
	 * @return retorna um inteiro , -1 caso o comando não tenha sido encontrada ou o indice em que o comando se encontra caso
	 * a mesma seja encontrada
	 */
	public boolean validaComando(String comando) {
	
		for(int k =0;k<this.comandosDisponiveis.size();k++){
			if(comando.toUpperCase().startsWith(this.comandosDisponiveis.get(k).substring(0,3))){
			return true;
		}
	}
		return false;
	}
	/*
	 * Metodo que verifica se o jogo está ativo
	 * @return true caso o jogo esteja artico,false caso contrario
	 */
	public boolean verificaSeJogoEstaAtivo() {
		if(this.jogadores.size() > 1) return true;
		return false;
	}
	/*
	 * retorna uma casa do tabuleiro de acordo com o parametro passado
	 * @param casa Um inteiro que indica o indice do tabuleiro que se deseja
	 */
	public CasaTabuleiro getCasaTabuleiro(int casa) {
		return tabuleiro.getCartasLugares(casa);
	}
	/*
	 * Lanca dois dados
	 * @return retorna um array de inteiros com o valor dos dois dados
	 */
	public int [] getResultadoDado() {
		return dados.jogarDados();
	}


	
	/*
	 * Metodo que inicia a jogada de acordo com o estado do jogador
	 */
	public String iniciaJogada() {
		
			this.getProxJogador();
		
		
		System.out.println( "A jogada de " + this.jogadorDaVez.getNome() + "("+ this.jogadorDaVez.getCor()+") começou");
		
		this.resultadoDados = this.getResultadoDado();
		
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
	
	
	/*
	 * Metodo que recebe os comandos
	 * @param comando Uma string com o comando 
	 * @return uma String de acordo com o comando inserido
	 */
	public String geraJogada(String comando) throws ErroAoCalcularAluguelException, ValorNegativoException, SaldoInsuficienteException, ComandoIndisponivelException {
		
		
		

		if(comando.toUpperCase().startsWith("JOG")||comando.toUpperCase().equals("JOGAR")) {
			
			this.jogadorDaVez.andarCasas(this.resultadoDados[0]+this.resultadoDados[1],this.resultadoDados);
			
			if(tabuleiro.getCasaTabuleiro(jogadorDaVez.getPosicao()).getTipo().equals("TERRENO")) {
				Terreno aux = (Terreno) tabuleiro.getCasaTabuleiro(jogadorDaVez.getPosicao());
				if(!aux.hasDono()) {
					return "O jogador "+ jogadorDaVez.getNome()+" ("+jogadorDaVez.getCor()+") "
							+"tirou "+ resultadoDados[0]+","+ resultadoDados[1]+ " e avançou para " 
							+  this.jogadorDaVez.getPosicao()+" - "
							+ tabuleiro.getCasaTabuleiro(this.jogadorDaVez.getPosicao()).getNome()
							+ "\nO titulo da propriedade "+aux.getNome()+ " está disponivel por $"+aux.getPreco()
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
			//parte que cuida da ida para a prisao em caso de repetição dos dados 3 vezes
			if(this.resultadoDados[0] == this.resultadoDados[1]) {
				this.geraJogada("jogar");
				this.ponteiro --;
				this.contador ++;
				if(contador >= 3) {
					this.jogadorDaVez.setPosicao(9);
					this.ponteiro = 0;
				}
			}
			
			
			
			
			
		}else if(comando.toUpperCase().startsWith("ST")) {
			this.ponteiro -- ;

			return this.getJogadorDaVez().getStatus()+"\n(Aperte ENTER para proseguir com o jogo";
		
			
		}else if(comando.toUpperCase().startsWith("SAI")) {
			this.jogadorDaVez.outGame();
			this.jogadores.remove(this.jogadorDaVez);
			if(!this.verificaSeJogoEstaAtivo()) {
				return "Jogo encerrado\nOs demais jogadores faliram\nO jogador"+this.jogadorDaVez.getNome()+" venceu";
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
	/*
	 * Obtem a casa atual do jogador
	 * @retutn Um Objeto do tipo CasaTabuleiro
	 */
	public CasaTabuleiro getCasaAtual() {
		
		return tabuleiro.getCartasLugares(this.jogadorDaVez.getPosicao());
	}
	/*
	 * Verifica se a casa atual é um terreno
	 * @return retorna true caso positivo e negativo caso contraio
	 */
	public boolean isTerrenoCasaAtual() {
		if(this.getCasaAtual().getTipo().equals("TERRENO")) {
			return true;
		}
		return false;
	}
	/*
	 * Verifica se a casa atual é uma companhia
	 * @return retorna true caso positivo e negativo caso contraio
	 */
	public boolean isCompanhiaCasaAtual() {
		if(this.getCasaAtual().getTipo().equals("COMPANHIA")) {
			return true;
		}
		return false;
	}
	/*
	 * Obtem o jogador da vez
	 * @return retorma um Objeto do tipo Jogador com o jogador da vez
	 * 
	 */
	public Jogador getJogadorDaVez() {
		return this.jogadorDaVez;
	}
	

}
			
		
		
		
		
		

	
	
	
	
	
