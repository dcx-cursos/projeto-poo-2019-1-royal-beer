package exceptions;

public class LimiteDeCasasAlcancadoException extends Exception{
	
	private String msg;
	
	public LimiteDeCasasAlcancadoException(String msg) {
		
		super(msg);
		this.msg = msg;
		
	}
	
	public String toString() {
		return "O limite de construções ha foi alcançado neste imóvel";
	}

}
