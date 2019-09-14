package exceptions;

public class ComandoIndisponivelException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public ComandoIndisponivelException (String msg) {
		this.msg = msg;
	}
	
	public String toString() {
		return this.msg;
	}
}
