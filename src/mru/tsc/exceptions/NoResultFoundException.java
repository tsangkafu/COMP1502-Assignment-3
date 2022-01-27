package mru.tsc.exceptions;
/**
 * If there is no result found this exception is thrown.
 * 
 * @author Sam Tang, Austin Bec
 */
public class NoResultFoundException extends Exception{

	/**
	 * Pass the message into its superclass constructor.
	 * Use getMessage() method later to show the error message.
	 */
	public NoResultFoundException() {
			super("No Result Found.");
	}
}
