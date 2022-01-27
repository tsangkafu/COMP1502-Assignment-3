package mru.tsc.exceptions;

/**
 * If the minimum number is larger than the maximum number this exception is thrown.
 * 
 * @author Sam Tang, Austin Bec
 *
 */
public class MinBiggerThanMaxException extends Exception {
	
	public MinBiggerThanMaxException() {
		super("The Number Of Minimum Players Cannot Be Bigger Than Maximum Players.");
	}
}
