package mru.tsc.exceptions;
/**
 * If the available count is not enough this exception is thrown.
 * 
 * @author Sam Tang, Austin Bec
 */
public class NotEnoughAvailableCountException extends Exception {
	/**
	 * Pass the message into its superclass constructor.
	 * Use getMessage() method later to show the error message.
	 */
	public NotEnoughAvailableCountException() {
		super("Purchase Unsuccessful. The Available Count Is Not Enough.");
	}
}
