package exceptions;

public class CorInexistenteException extends Exception{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String msg;
		
		public CorInexistenteException(String msg) {
			super(msg);
			this.msg = msg;
		}
		public String toString() {
			return this.msg;
		}
}
