package exceptions;

public class CorIndisponivelException extends Exception {

	private static final long serialVersionUID = 1L;
	private String msg;
	
	public CorIndisponivelException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String toString() {
		return msg;
	}
}
