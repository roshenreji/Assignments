package library.exception;

public class PasswordMatchException extends Exception {

	public PasswordMatchException() {
		super("Entered Password is not present");
	}
	
	public PasswordMatchException(String message) {
		super(message);
	}
}
