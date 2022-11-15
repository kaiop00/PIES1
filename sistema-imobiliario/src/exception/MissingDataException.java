package exception;

public class MissingDataException extends Exception {
	private static final long serialVersionUID = 8343906907828432016L;
	
	public MissingDataException(String message) {
		super(message);
	}

}
