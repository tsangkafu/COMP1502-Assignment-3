package mru.tsc.exceptions;

/**
 * If the input is empty this exception is thrown.
 * 
 * @author Sam Tang, Austin Bec
 */
public class EmptyInputException extends Exception {
	
	/**
	 * Pass the message into its superclass constructor.
	 * Use getMessage() method later to show the error message.
	 */
	public EmptyInputException() {
		super("The Input Cannot Be Empty.");
	}

}
