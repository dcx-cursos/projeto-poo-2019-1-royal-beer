package exceptions;

public class LimiteDeConstrucoesException extends Exception{
	
	String msg;
	
	public LimiteDeConstrucoesException(String msg) {
		this.msg = msg;
	}
	public String toString() {
		return msg;
	}

}
