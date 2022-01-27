package mru.tsc.exceptions;

/**
 * If the serial number is already in the ArrayList this exception is thrown.
 * 
 * @author Sam Tang, Austin Bec
 */
public class UniqueSerialNumberException extends Exception {
	
	/**
	 * Pass the message into its superclass constructor.
	 * Use getMessage() method later to show the error message.
	 */
	public UniqueSerialNumberException() {
		super("Serial Number Already Exists.");
	}
}
