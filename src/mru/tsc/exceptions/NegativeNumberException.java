package mru.tsc.exceptions;

/**
 * Throw an exception when there is an negative user input.
 * @author Sam Tang, Austin Bec
 */
public class NegativeNumberException extends Exception {
	
	/**
	 * Pass the message into its superclass constructor.
	 * Use getMessage() method later to show the error message.
	 */
	public NegativeNumberException() {
		super("Input Should Be Greater Than 0.");
	}
}
