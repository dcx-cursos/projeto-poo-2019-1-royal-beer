package exceptions;

public class ValorNegativoException extends Exception {

	private String msg;
	
	public ValorNegativoException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String toString() {
		return msg;
		
	}
	
}
