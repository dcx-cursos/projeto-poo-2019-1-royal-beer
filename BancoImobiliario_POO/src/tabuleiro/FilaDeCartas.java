package tabuleiro;

public class FilaDeCartas {
	
	private Efeito [] cartas ; // vetor que representa a fila
	private int numeroDeElementos;
	private int ponteiro;
	
	public FilaDeCartas() {
		this.cartas = new Efeito[31];
		this.numeroDeElementos = 0;
		this.ponteiro = 0;
	}
	
	public void enfileirar(Efeito e) {
		this.cartas[numeroDeElementos++] = e;
	}
	
	public Efeito desenfileirar() {
		this.numeroDeElementos --;
		return cartas[this.numeroDeElementos + 1];
	}
	
	public Efeito getCarta() {
		if(this.ponteiro == this.numeroDeElementos) {
			this.ponteiro = 0;
			return this.cartas[this.ponteiro];
		}
		this.ponteiro ++;
		return this.cartas[this.ponteiro - 1];
	}
	

}
