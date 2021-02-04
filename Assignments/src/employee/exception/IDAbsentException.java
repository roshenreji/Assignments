package employee.exception;

public class IDAbsentException extends Exception{

	public IDAbsentException() {
		super("Entered ID is not present in the list");
	}
	
	public IDAbsentException(String message) {
		super(message);
	}
	
	
}
