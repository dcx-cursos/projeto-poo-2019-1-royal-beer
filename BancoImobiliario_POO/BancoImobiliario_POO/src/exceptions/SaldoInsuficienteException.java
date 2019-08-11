package exceptions;

public class SaldoInsuficienteException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	private String msg;
	
	public SaldoInsuficienteException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String toString() {
		return msg;
	}

	
}
