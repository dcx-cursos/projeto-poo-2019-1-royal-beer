package exceptions;

public class CorJaEscolhidaException extends Exception {

	private String msg;
	
	public CorJaEscolhidaException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String toString() {
		return msg;
	}
}
