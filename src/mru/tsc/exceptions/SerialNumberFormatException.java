package mru.tsc.exceptions;
/**
 * If the input serial number is not 10-digit long.
 * 
 * @author Sam Tang, Austin Bec
 */
public class SerialNumberFormatException extends Exception {
	/**
	 * Pass the message into its superclass constructor.
	 * Use getMessage() method later to show the error message.
	 */
	public SerialNumberFormatException() {
		super("Serial Number Should Be 10-Digit Long.");
	}
}
