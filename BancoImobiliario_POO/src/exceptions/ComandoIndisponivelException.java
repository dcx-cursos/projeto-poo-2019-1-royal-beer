package exceptions;

public class ComandoIndisponivelException extends Exception{

	private String msg;
	
	public ComandoIndisponivelException (String msg) {
		this.msg = msg;
	}
	
	public String toString() {
		return this.msg;
	}
}
