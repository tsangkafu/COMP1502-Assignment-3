package mru.tsc.controller;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import mru.tsc.application.Main;
import mru.tsc.exceptions.*;
import mru.tsc.model.Toy;

/**
 * Shop Controller for file handling.
 * Method includes reading and writing to a toys.txt;
 * create objects for each toy and put them into an ArrayList.
 * 
 * @author Sam Tang, Austin Bec
 */
public class ShopController {
	
	/**
	 * Read toys.txt and create object for each toy respectively.
	 * 
	 * @throws EnumException 
	 * @throws NumberFormatException 
	 */
	public static void readFile() {
		// read the toys.txt
		File read = new File("./res/toys.txt");
		try {
			// Reserve memory for ArrayList<Toy> located in Toy Class
			Toy.toys = new ArrayList<>();
			// scan the toys.txt
			Scanner reader = new Scanner(read);
			while(reader.hasNextLine()) {
				// store each toy into a String
				String toy = reader.nextLine();
				/* read the first character of the text
				 * and differentiate different types of toys
				 */
				switch(toy.charAt(0)){
					// for figures
					case '0':
					case '1':
						// split the toy by ";"
						String[] tokens = toy.split(";");
						/* Parse the String to appropriate type and create an object
						 * tokens[0] = Serial number
						 * tokens[1] = game name
						 * tokens[2] = brand name
						 * tokens[3] = price
						 * tokens[4] = available count
						 * tokens[5] = age appropriate
						 * tokens[6] = classification
						 */
						Figure figure = new Figure(tokens[0], tokens[1],
								tokens[2], Double.valueOf(tokens[3]),
								Integer.valueOf(tokens[4]), Integer.valueOf(tokens[5]),
								tokens[6]);
						
						// add figure to ArrayList<Toy> located in Toy class
						Toy.toys.add(figure);
						break;
					// for animals
					case '2':
					case '3':
						// split the toy by ";"
						String[] tokens2 = toy.split(";");
						/* Parse the String to appropriate type and create an object
						 * tokens2[0] = Serial number
						 * tokens2[1] = game name
						 * tokens2[2] = brand name
						 * tokens2[3] = price
						 * tokens2[4] = available count
						 * tokens2[5] = age appropriate
						 * tokens2[6] = material
						 * tokens2[7] = size
						 */
						Animal animal = new Animal(tokens2[0], tokens2[1],
								tokens2[2], Double.valueOf(tokens2[3]),
								Integer.valueOf(tokens2[4]), Integer.valueOf(tokens2[5]),
								tokens2[6], tokens2[7]);
						
						// add animal to ArrayList<Toy> located in Toy class
						Toy.toys.add(animal);
						break;
					// for puzzles
					case '4':
					case '5':
					case '6':
						// split the toy by ";"
						String[] tokens3 = toy.split(";");
						/* Parse the String to appropriate type and create an object
						 * tokens3[0] = Serial number
						 * tokens3[1] = game name
						 * tokens3[2] = brand name
						 * tokens3[3] = price
						 * tokens3[4] = available count
						 * tokens3[5] = age appropriate
						 * tokens3[6] = puzzle type
						 */
						Puzzle puzzle = new Puzzle(tokens3[0], tokens3[1],
								tokens3[2], Double.valueOf(tokens3[3]),
								Integer.valueOf(tokens3[4]), Integer.valueOf(tokens3[5]),
								tokens3[6]);
						
						// add puzzle to ArrayList<Toy> located in Toy class
						Toy.toys.add(puzzle);
						break;
					// for board games
					case '7':
					case '8':
					case '9':
						// split the toy by ";"
						String[] tokens4 = toy.split(";");
						/* tokens4[0] = Serial number
						 * tokens4[1] = game name
						 * tokens4[2] = brand name
						 * tokens4[3] = price
						 * tokens4[4] = available count
						 * tokens4[5] = age appropriate
						 * tokens4[6] = the range of number of players
						 * tokens4[7] = designer(s)
						 */
						
						/* String Array to store maximum and minimum players respectively 
						 * tokensOfPlayerNumber[0] = minimum players
						 * tokensOfPlayerNumber[1] = maximum players
						 */
						String[] tokensOfPlayerNumber = tokens4[6].split("-");
						
						// String Array to store designer(s), size of the Array depends
						String[] tokensOfDesigners = tokens4[7].split(",");
						// put all designers into an ArrayList
						ArrayList<String> designers = new ArrayList<>();
						for (String str : tokensOfDesigners) {
							designers.add(str);
						}
						
						// parse the String to appropriate type and create an object
						BoardGame boardgame = new BoardGame(tokens4[0], tokens4[1],
								tokens4[2], Double.valueOf(tokens4[3]),
								Integer.valueOf(tokens4[4]), Integer.valueOf(tokens4[5]),
								Integer.valueOf(tokensOfPlayerNumber[0]),
								Integer.valueOf(tokensOfPlayerNumber[1]),
								designers);
						
						// add board game to ArrayList<Toy> located in Toy class
						Toy.toys.add(boardgame);
						break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("***Warning: An error occured***");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Save file using ArrayList<Toy> toys accordingly.
	 * 
	 * @param none
	 * @return none
	 */
	public static void saveFile() {
		try {
			String join = null;
			// clean up the file
			clearFile();
			// Create a file writer and append each toy
			FileWriter writer = new FileWriter("./res/toys.txt", true);
			// a for each loop to append every toy to toys.txt
			for (Toy toy : Toy.toys) {
				String buffer = String.join(";", toy.getSN(),
						toy.getName(),
						toy.getBrand(),
						Double.toString(toy.getPrice()),
						Integer.toString(toy.getAvailableCount()),
						Integer.toString(toy.getAgeAppropriate())) + ";";
				// handle figure case
				if (toy instanceof Figure) {
					Figure figure = (Figure) toy;
					// change the first character of the enum to String
					buffer = buffer + Character.toString(figure.getClassification().name().charAt(0));
				// handle animal case
				} else if (toy instanceof Animal) {
					Animal animal = (Animal) toy;
					// get material
					buffer = buffer + animal.getMaterial() + ";";
					// change the first character of the enum to String
					buffer = buffer + Character.toString(animal.getSize().name().charAt(0));
				// handle puzzle case
				} else if (toy instanceof Puzzle) {
					Puzzle puzzle = (Puzzle) toy;
					// change the first character of the enum to String
					buffer = buffer + Character.toString(puzzle.getPuzzleType().name().charAt(0));
				// handle boardgame case
				} else if (toy instanceof BoardGame) {
					BoardGame boardgame = (BoardGame) toy;
					// add minimum and maximum numbers of player to the string
					buffer = buffer + boardgame.getMinNumberOfPlayers() +
							"-" +boardgame.getMaxNumberOfPlayers() + ";";
					// use loop to put ArrayList<String> designers to String in correct format
					for (String str : boardgame.getDesigners()) {
						// trim the unnecessary space
						buffer = buffer + str.trim() + ",";
					}
					// delete the last ","
					buffer = buffer.substring(0, buffer.length() - 1);
				}
				// add a new line
				buffer = buffer + "\n";
				// write to the file
				writer.write(buffer);
			}
			// close the writer
			writer.close();
		} catch (Exception e) {
			
		}
	}
	
	/**
	 * A method to clear the file to empty.
	 * 
	 * @throws IOException
	 * @param none
	 * @return none
	 */
	public static void clearFile() throws IOException {
		PrintWriter writer = new PrintWriter("./res/toys.txt");
		writer.print("");
		writer.close();
	}
	
}
		
