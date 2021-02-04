package library.exception;

public class IdAbsentException extends Exception {

	public IdAbsentException(){
		super();
	}
	
	public IdAbsentException(String message){
		super(message);
	}
}
