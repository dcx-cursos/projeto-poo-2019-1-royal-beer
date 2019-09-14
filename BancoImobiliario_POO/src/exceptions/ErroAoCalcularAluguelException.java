package exceptions;

public class ErroAoCalcularAluguelException extends Exception{	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public ErroAoCalcularAluguelException(String msg) {
		
		
		super(msg);
		this.msg = msg;
	}
	
	public String toString() {
		return msg;
	}
}
