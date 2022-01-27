package mru.tsc.controller;

import mru.tsc.model.Toy;

/**
 * A subclass from Toy. Figure Toy.
 * 
 * @author Sam Tang, Austin Bec
 */
public class Figure extends Toy{
	
	// enum for either Action, Doll or Historic
	public enum Classification { Action, Doll, Historic; }
	private Classification classification;
	
	/**
	 * Constructor for Figure that calls the superclass Toy constructor as well.
	 * @param int SN - serial number
	 * @param String name - name of the toy
	 * @param String brand - brand name of the toy
	 * @param double price - price of the toy
	 * @param int availableCount - the number of toys available
	 * @param int ageAppropriate - the minimum age that is appropriate for playing
	 * @param String classification - classification of the toy, either A, D, H
	 */
	public Figure(String SN, String name, String brand, double price,
			int availableCount, int ageAppropriate,
			String classification) {
		
		// call the superclass's constructor
		super(SN, name, brand, price, availableCount, ageAppropriate);
		
		// define enum Classification depending on the String parameter
		if (classification.equals("Action") || classification.equals("A") ) {
			this.classification = Classification.Action;
		} else if (classification.equals("Doll") || classification.equals("D")) {
			this.classification = Classification.Doll;
		} else if (classification.equals("Historic") || classification.equals("H")) {
			this.classification = Classification.Historic;
		}
		
	}
	
	/**
	 * Get the classification of the toy, either Action, Doll or Historic.
	 * 
	 * @param none
	 * @return Classification The classification of the toy
	 */
	public Classification getClassification() {
		return classification;
	}
	
	/**
	 * Set the classification of the toy, either Action, Doll or Historic.
	 * 
	 * @param Classification classification The classification of the toy
	 * @return none
	 */
	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	@Override
	/**
	 * Return the String to a human-readable format.
	 * 
	 * @param none
	 * @return String The full String for the figure
	 */
	public String toString() {
		return "Category: Figure, Serial Number: " + this.SN +
				", Name: " + this.name +
				", Brand: " + this.brand +
				", Price: " + this.price +
				", Available Count: " + this.availableCount +
				", Age Appropriate: " + this.ageAppropriate +
				", Classification: " + this.classification;
	}
	
}
