package tabuleiro;

import java.util.ArrayList;

import principal.Jogador;

public class Prisao implements CasaTabuleiro{

	private ArrayList<Jogador> presos;
	
	public Prisao() {
		this.presos = new ArrayList <>();
		
	}
	
	public void addPreso(Jogador jog) {
		presos.add(jog);
		
	}
	
	public boolean verificaPrisioneiro(Jogador jog ) {
		
		if(!presos.isEmpty()) {
			for(Jogador a : presos) {
				if(a.equals(jog)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void libertaPrisioneito(Jogador jog) {
		presos.remove(jog);
	}
	
	public String getMsg() {
		return "Prisao como visitante";
	}
	
	
	
	public String getNome(){
		return "Prisao";
	}
	
	
	public String getTipo() {
		return "PRISAO";
	}
	
	
}
