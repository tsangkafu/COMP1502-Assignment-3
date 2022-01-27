package mru.tsc.model;

import java.util.ArrayList;

/**
 * The superclass that is abstract and cannot be instanialized.
 * 
 * It stores common variables of its subclass including
 * serial number, name, brand name, price,
 * available count and minimum appropriate age.
 * 
 * @author Sam Tang, Austin Bec
 */
public abstract class Toy {
	
	// 10-digit serial number, using String can preserve the leading zero
	protected String SN;
	
	// name of the toy
	protected String name;
	
	// brand name of the toy
	protected String brand;
	
	// price of the toy
	protected double price;
	
	// the number of toys available
	protected int availableCount;
	
	// the minimum age that is appropriate for playing
	protected int ageAppropriate;
	
	// an ArrayList to store different types of toys
	public static ArrayList<Toy> toys;
	
	/**
	 * Constructor to create an Toy object used only by subclass.
	 * @param String SN - serial number
	 * @param String name - name of the toy
	 * @param String brand - brand name of the toy
	 * @param double price - price of the toy
	 * @param int availableCount - the number of toys available
	 * @param int ageAppropriate - the minimum age that is appropriate for playing
	 */
	public Toy(String SN, String name, String brand, double price,
			int availableCount, int ageAppropriate) {
		this.SN = SN;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.availableCount = availableCount;
		this.ageAppropriate = ageAppropriate;
	}
	
	/**
	 * Get the serial number of the toy.
	 * 
	 * @param none
	 * @return String - the serial number
	 */
	public String getSN() {
		return SN;
	}
	
	/**
	 * Set the serial number of the toy.
	 * 
	 * @param int SN - set the serial number
	 * @return none
	 */
	public void setSN(String SN) {
		this.SN = SN;
	}
	
	/**
	 * Get the name of the toy.
	 * 
	 * @param none
	 * @return String - the name of the toy
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the toy.
	 * 
	 * @param String name - set the name
	 * @return none
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get the brand name of the toy.
	 * 
	 * @param none
	 * @return String - the brand name of the toy
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * Set the brand name of the toy.
	 * 
	 * @param String brand - set the brand name
	 * @return none
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Get the price of the toy.
	 * 
	 * @param none
	 * @return double - the price of the toy
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Set the price of the toy.
	 * 
	 * @param double price - set the price
	 * @return none
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Get the number of available toys.
	 * 
	 * @param none
	 * @return int - the number of toys available
	 */
	public int getAvailableCount() {
		return availableCount;
	}
	
	/**
	 * Set the number of toys available.
	 * 
	 * @param int availableCount - the number of toys available
	 * @return none
	 */
	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}
	
	/**
	 * Get the minimum appropriate age for playing the toy.
	 * 
	 * @param none
	 * @return int - the minimum age appropriate for play the toy
	 */
	public int getAgeAppropriate() {
		return ageAppropriate;
	}
	
	/**
	 * Set the minimum appropriate age for playing the toy.
	 * 
	 * @param int ageAppropriate - the minimum appropriate age for playing the toy
	 * @return none
	 */
	public void setAgeAppropriate(int ageAppropriate) {
		this.ageAppropriate = ageAppropriate;
	}
	
}
