package principal;

import java.io.FileNotFoundException;
import java.io.IOException;

import tabuleiro.Tabuleiro;

public class Main {
	public static void main(String args[]) {
		
		Tabuleiro tabuleiro = null;
		
		try {
			tabuleiro = new Tabuleiro();
		}catch(FileNotFoundException e) {
			System.err.println("Erro ao encontrar a pasta com os arquivos do tabuleiro\n"+e.toString());
			
		}catch(IOException e ) {
			System.err.println("Erro ao ler arquivos do tabuleiro\n "+e.toString());
		}
		
		
		
		
	}//fim main

}
