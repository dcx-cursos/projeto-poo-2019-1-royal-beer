package exceptions;

public class CorInexistenteException extends Exception{

		private String msg;
		
		public CorInexistenteException(String msg) {
			super(msg);
			this.msg = msg;
		}
		
		public String toString() {
			return this.msg;
		}
}
