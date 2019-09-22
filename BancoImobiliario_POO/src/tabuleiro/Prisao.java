package tabuleiro;

import java.util.ArrayList;

import exceptions.SaldoInsuficienteException;
import principal.Jogador;

public class Prisao implements CasaTabuleiro ,Efeito{

	private ArrayList<Jogador> presos;
	
	private static Prisao instance = null;
	
	private Prisao() {
		this.presos = new ArrayList <>();
		
	}
	
	public static Prisao getInstance() {
		if(instance == null) {
			instance = new Prisao();
		}
		return instance;
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

	@Override
	public void aplicaEfeito(Jogador jog) throws SaldoInsuficienteException {
		jog.setPosicao(9);
		
	}

	@Override
	public String getMensagem() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
