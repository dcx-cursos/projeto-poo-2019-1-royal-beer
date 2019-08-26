package exceptions;

public class EntradaInvalidaException extends Exception {
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg ;
	public EntradaInvalidaException (String msg) {
		super(msg);
		this.msg = msg;
		
		
	}
	
	public String toString() {
		return "ERRO: "+ msg;
	}
	
	

}
