package mru.tsc.controller;
import mru.tsc.exceptions.*;
import mru.tsc.model.Toy;

/**
 * A subclass from Toy. Animal Toy.
 * 
 * @author Sam Tang, Austin Bec
 */
public class Animal extends Toy {
	
	// enum for either Small, Medium or Large
	public enum Size { Small, Medium, Large; }
	private String material;
	private Size size;
	
	/**
	 * Constructor for Animal that calls the superclass Toy constructor as well.
	 *
	 * @param String SN - serial number
	 * @param String name - name of the toy
	 * @param String brand - brand name of the toy
	 * @param double price - price of the toy
	 * @param int availableCount - the number of toys available
	 * @param int ageAppropriate - the minimum age that is appropriate for playing
	 * @param String material - material of the toy
	 * @param String size - size of the toy, either S, M, L
	 */
	public Animal(String SN, String name, String brand, double price,
			int availableCount, int ageAppropriate,
			String material, String size) {
		
		// call the superclass's constructor
		super(SN, name, brand, price, availableCount, ageAppropriate);
		this.material = material;
		
		// define enum Size depending on the String parameter
		if (size.equals("Small") || size.equals("S")) {
			this.size = Size.Small;
		} else if (size.equals("Medium") || size.equals("M")) {
			this.size = Size.Medium;
		} else if (size.equals("Large") || size.equals("L")) {
			this.size = Size.Large;
		}
	}
	
	/**
	 * Get the material of the animal.
	 * 
	 * @param none
	 * @return String The material of the animal
	 */
	public String getMaterial() {
		return material;
	}
	
	/**
	 * Set the material of the animal.
	 * 
	 * @param none
	 * @param String material The material of the animal
	 */
	public void setMaterial(String material) {
		this.material = material;
	}
	
	/**
	 * Get the size of the animal, either Small, Medium, Large.
	 * 
	 * @param none
	 * @return Size the size of the animal
	 */
	public Size getSize() {
		return size;
	}
	
	/**
	 * Set the size of the animal, either Small, Medium, Large.
	 * 
	 * @param Size The size of the animal
	 * @return none
	 */
	public void setSize(Size size) {
		this.size = size;
	}
	
	@Override
	
	/**
	 * Return the String to a human-readable format.
	 * 
	 * @param none
	 * @return String The entire string of the animal
	 */
	public String toString() {
		return "Category: Animal, Serial Number: " + this.SN +
				", Name: " + this.name +
				", Brand: " + this.brand +
				", Price: " + this.price +
				", Available Count: " + this.availableCount +
				", Age Appropriate: " + this.ageAppropriate +
				", Material: " + this.material +
				", Size: " + this.size;
	}
	
	
}
