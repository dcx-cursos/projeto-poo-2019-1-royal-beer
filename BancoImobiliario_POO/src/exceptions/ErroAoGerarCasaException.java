package exceptions;

public class ErroAoGerarCasaException extends Exception {

	private static final long serialVersionUID = 1L;

	private String msg;
	
	public ErroAoGerarCasaException(String msg) {
		
		super(msg);
		this.msg = msg;
		
	}
	


}
