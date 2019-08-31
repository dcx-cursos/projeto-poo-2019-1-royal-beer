package principal;
	
import java.util.NoSuchElementException;

public class Fila {

	private String [] vetor; //Vetor que guarda os elementos da fila
	private int numeroDeElementos; //Variavel que guarda o max de elementos da fila
	private int primeiro; // Variavel que guarda o primeiro elemento da lista
	private int ultimo; //Index do ultimo espaço vazio
	
	public Fila() { //Construtor
		this.vetor=  new String [3];
		this.numeroDeElementos=0;
		this.primeiro=0;
		this.ultimo=0;
	}
	
	public boolean vazio() { //Verifica se está vazio
		return this.numeroDeElementos==0;
	}
	
	public int tamanho() { // retorna a quantidade de elementos
		return this.numeroDeElementos;
	}
	
	public void enfileirar(String item) { //add item
		
		this.vetor[this.ultimo++]= item; // add o item
		
		if(this.ultimo==this.vetor.length) this.ultimo=0; //se der overflow o ultimo, começa do inicio
		
		if(numeroDeElementos<3) this.numeroDeElementos++;// add 1 na quantidade pelo item q entrou
	}
	
	public String desenfileirar() { //Retira um elemento
		if(vazio()) throw new NoSuchElementException ("Fila vazia");
		
		String item=this.vetor[this.primeiro]; //Copia
		
		this.vetor[this.primeiro]= null; 	//apaga o conteudo
		this.numeroDeElementos--;		//diminui a qntd de elementos
		this.primeiro ++; //readapta o index do primeiro
		
		if(this.primeiro==this.vetor.length) this.primeiro =0;//refazendo o ciclo
		
		return item;
	}
	
	public String [] getAll() {
		return vetor;
	}
}