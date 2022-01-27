package mru.tsc.controller;
import java.util.ArrayList;

import mru.tsc.model.Toy;

/**
 * A subclass from Toy. Board Game Toy.
 * 
 * @author Sam Tang, Austin Bec
 */
public class BoardGame extends Toy {
	
	// maximum number of players
	private int maxNumberOfPlayers;
	
	// minimum number of players
	private int minNumberOfPlayers;
	
	// String ArrayList for designer(s)
	private ArrayList<String> designers = new ArrayList<>();
	
	/**
	 * Constructor for Board Game that calls the superclass Toy constructor as well.
	 * 
	 * @param String SN - serial number
	 * @param String name - name of the toy
	 * @param String brand - brand name of the toy
	 * @param double price - price of the toy
	 * @param int availableCount - the number of toys available
	 * @param int ageAppropriate - the minimum age that is appropriate for playing
	 * @param int maxNumberOfPlayers - the maximum number of players
	 * @param int minNumberOfPlayers - the minimum number of players
	 * @param ArrayList<String> designers - the ArrayList that store the designers of the board game
	 */
	public BoardGame(String SN, String name, String brand, double price,
			int availableCount, int ageAppropriate,
			int minNumberOfPlayers, int maxNumberOfPlayers,
			ArrayList<String> designers) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		
		// create an new ArrayList to store designers
		this.designers = designers;
		this.minNumberOfPlayers = minNumberOfPlayers;
		this.maxNumberOfPlayers = maxNumberOfPlayers;
	}
	
	/**
	 * Get the maximum number of players.
	 * 
	 * @param none
	 * @return int The maximum number of players
	 */
	public int getMaxNumberOfPlayers() {
		return maxNumberOfPlayers;
	}
	
	/**
	 * Set the maximum number of players.
	 * 
	 * @param int maxNumberOfPlayers The maximum number of players
	 * @return none
	 */
	public void setMaxNumberOfPlayers(int maxNumberOfPlayers) {
		this.maxNumberOfPlayers = maxNumberOfPlayers;
	}
	
	/**
	 * Get the minimum number of players.
	 * 
	 * @param none
	 * @return int The minimum number of players
	 */
	public int getMinNumberOfPlayers() {
		return minNumberOfPlayers;
	}
	
	/**
	 * Set the minimum number of players.
	 * 
	 * @param int minNumberOfPlayers The minimum number of players
	 * @return none
	 */
	public void setMinNumberOfPlayers(int minNumberOfPlayers) {
		this.minNumberOfPlayers = minNumberOfPlayers;
	}

	/**
	 * Get the ArrayList of designers of the board game.
	 * 
	 * @param none
	 * @return ArrayList<String> The ArrayList of designers of the board game
	 */
	public ArrayList<String> getDesigners() {
		return designers;
	}
	
	/**
	 * Add the designer to the ArrayList<String> designers.
	 * 
	 * @param String designer One of the designers of the board game.
	 * @return none
	 */
	public void addDesigners(String designer) {
		this.designers.add(designer);
	}
	
	@Override
	/**
	 * Return the String to a human-readable format.
	 * 
	 * @param none
	 * @return String The full BoardGame String
	 */
	public String toString() {
		return "Category: Board Game, Serial Number: " + this.SN +
				", Name: " + this.name +
				", Brand: " + this.brand +
				", Price: " + this.price +
				", Available Count: " + this.availableCount +
				", Age Appropriate: " + this.ageAppropriate +
				", Minimum Players: " + this.minNumberOfPlayers +
				", Maximum Players: " + this.maxNumberOfPlayers +
				", Designers: " + this.designers;
	}
}
