package employee.exception;

public class IDPresentException extends Exception {

	public IDPresentException(){
		super("This Id is already present");
	}
	
	public IDPresentException(String message){
		super(message);
	}
	
}
