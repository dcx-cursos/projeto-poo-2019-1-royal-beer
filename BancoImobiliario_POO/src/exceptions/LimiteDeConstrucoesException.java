package exceptions;

public class LimiteDeConstrucoesException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	
	public LimiteDeConstrucoesException(String msg) {
		this.msg = msg;
	}
	public String toString() {
		return msg;
	}

}
