package mru.tsc.controller;

import mru.tsc.model.Toy;

/**
 * A subclass from Toy. Puzzle Toy.
 * 
 * @author Sam Tang, Austin Bec
 */
public class Puzzle extends Toy {
	
	// enum for either Mechanical, Cryptic, Logic, Trivia or Riddle
	public enum PuzzleType { Mechanical, Cryptic, Logic, Trivia, Riddle; }
	private PuzzleType puzzleType;
	
	/**
	 * Constructor for Puzzle that calls the superclass Toy constructor as well.
	 *
	 * @param String SN - serial number
	 * @param String name - name of the toy
	 * @param String brand - brand name of the toy
	 * @param double price - price of the toy
	 * @param int availableCount - the number of toys available
	 * @param int ageAppropriate - the minimum age that is appropriate for playing
	 * @param PuzzleType puzzleType - the type of the puzzle, either M, C, L, T, R
	 */
	public Puzzle(String SN, String name, String brand, double price,
			int availableCount, int ageAppropriate,
			String puzzleType) {
		
		// call the superclass's constructor
		super(SN, name, brand, price, availableCount, ageAppropriate);
		
		// define enum PuzzleType depending on the String parameter
		if (puzzleType.equals("Mechanical") || puzzleType.equals("M")) {
			this.puzzleType = PuzzleType.Mechanical;
		} else if (puzzleType.equals("Cryptic") || puzzleType.equals("C")) {
			this.puzzleType = PuzzleType.Cryptic;
		} else if (puzzleType.equals("Logic") || puzzleType.equals("L")){
			this.puzzleType = PuzzleType.Logic;
		} else if (puzzleType.equals("Trivia") || puzzleType.equals("T")) {
			this.puzzleType = PuzzleType.Trivia;
		} else if (puzzleType.equals("Riddle") || puzzleType.equals("R")) {
			this.puzzleType = PuzzleType.Riddle;
		}
	}
	
	/**
	 * Get the type of the puzzle, either Mechanical, Cryptic, Logic, Trivia or Riddle.
	 * 
	 * @param none
	 * @return PuzzleType The type of the puzzle
	 */
	public PuzzleType getPuzzleType() {
		return puzzleType;
	}
	
	/**
	 * Set the type of the puzzle, either Mechanical, Cryptic, Logic, Trivia or Riddle.
	 * @param PuzzleType puzzleType The type of the puzzle
	 * @return none
	 */
	public void setPuzzleType(PuzzleType puzzleType) {
		this.puzzleType = puzzleType;
	}
	
	@Override
	/**
	 * Return the String to a human-readable format.
	 * 
	 * @param none
	 * @return String The full String for the puzzle
	 */
	public String toString() {
		return "Category: Puzzle, Serial Number: " + this.SN +
				", Name: " + this.name +
				", Brand: " + this.brand +
				", Price: " + this.price +
				", Available Count: " + this.availableCount +
				", Age Appropriate: " + this.ageAppropriate +
				", Puzzle Type: " + this.puzzleType;
	}
}
