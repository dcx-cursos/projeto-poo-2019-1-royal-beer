package exceptions;

public class ErroAoCalcularAluguelException extends Exception{	
	
	
	private String msg;
	
	public ErroAoCalcularAluguelException(String msg) {
		
		
		super(msg);
		this.msg = msg;
	}
	
	public String toString() {
		return msg;
	}
}
