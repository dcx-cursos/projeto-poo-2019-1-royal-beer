package principal;
	
import java.util.NoSuchElementException;
/*
 * Essa classe cria historico dos dados jogados
 * @author Matheus Morais
 */
public class Fila {

	private String [] vetor; 
	private int numeroDeElementos; 
	private int primeiro; 
	private int ultimo; 
	
	/*
	 * Construtor Fila inicia cada variavel de instancia e atribui valor maximo ao vetor de 3
	 * e as demais variaveis sao iniciadas com o valor 0
	 */
	public Fila() { 
		this.vetor=  new String [3];
		this.numeroDeElementos=0;
		this.primeiro=0;
		this.ultimo=0;
	}
	/*
	 * Metodo verifica se a fila está vazia
	 */
	public boolean vazio() {
		return this.numeroDeElementos==0;
	}
	/*
	 * Metodo verifica e retorna o tamanho da lista
	 * @return um inteiro com o tamanho da lista
	 */
	public int tamanho() {
		return this.numeroDeElementos;
	}
	/*
	 * Adiciona um elemento no final da fila
	 * @param uma string com o item a ser enfileirado
	 */
	public void enfileirar(String item) { //add item
		this.vetor[this.ultimo] = item;
		ultimo ++;
		if(ultimo == 3) {
			ultimo = 0;
		}
		
	}
	/*
	 * retira o primeiro elemento da fila
	 * @return uma string com o elemento a ser retornado
	 */
	public String desenfileirar() { //Retira um elemento
		if(vazio()) throw new NoSuchElementException ("Fila vazia");
		
		String item=this.vetor[this.primeiro]; 
		
		this.vetor[this.primeiro]= null; 
		this.numeroDeElementos--;		
		this.primeiro ++; 
		
		if(this.primeiro==this.vetor.length) this.primeiro =0;
		
		return item;
	}
	/*returna o vetor que guarda o historico de dados
	 * @return retorna um array de String
	 * 
	 */
	public String [] getAll() {
		return vetor;
	}
	/*
	 * retorna o ultimo os ultimos dois dados jogados
	 * @return retorna um array com os dois ultimos dados jogados
	 */
	public String getUltimoDadoJogado() {
		return this.vetor[ultimo];
	}
	

	
	
	
	
}