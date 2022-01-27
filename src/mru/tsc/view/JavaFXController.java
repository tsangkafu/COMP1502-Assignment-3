package mru.tsc.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import mru.tsc.application.Main;
import mru.tsc.controller.Animal;
import mru.tsc.controller.BoardGame;
import mru.tsc.controller.Figure;
import mru.tsc.controller.Puzzle;
import mru.tsc.exceptions.EmptyInputException;
import mru.tsc.exceptions.MinBiggerThanMaxException;
import mru.tsc.exceptions.NegativeNumberException;
import mru.tsc.exceptions.NoResultFoundException;
import mru.tsc.exceptions.NotEnoughAvailableCountException;
import mru.tsc.exceptions.SerialNumberFormatException;
import mru.tsc.exceptions.UniqueSerialNumberException;
import mru.tsc.model.Toy;
/**
 * This class is the controller for the JavaFX GUI
 * 
 * @author Sam Tang, Austin Bec
 */
public class JavaFXController {
	
	// generic variables
	// to check if there is any error is caught
	boolean errorIsCaught;
	
	// Home Tab
	@FXML
	private RadioButton SNBtn;
	@FXML
	private RadioButton nameBtn;
	@FXML
	private RadioButton typeBtn;
	@FXML
	private ChoiceBox homeType;
	@FXML
	private ListView<String> inventory;
	@FXML
	private Button searchBtn;
	@FXML
	private Button resetBtn;
	@FXML
	private Button clearBtn;
	@FXML
	private Button purchaseBtn;
	@FXML
	private TextField SNTxt;
	@FXML
	private TextField nameTxt;
	
	// Add Toy Tab
	@FXML
	private ChoiceBox category;
	@FXML
	private TextField ATSNTxt;
	@FXML
	private TextField ATName;
	@FXML
	private TextField ATBrand;
	@FXML
	private TextField ATPrice;
	@FXML
	private TextField ATAvaCount;
	@FXML
	private TextField ATAgeAppr;
	@FXML
	private ChoiceBox classification;
	@FXML
	private TextField materialTxt;
	@FXML
	private ChoiceBox size;
	@FXML
	private ChoiceBox type;
	@FXML
	private TextField minPlayerTxt;
	@FXML
	private TextField maxPlayerTxt;
	@FXML
	private TextField designersTxt;
	@FXML
	private Button saveBtn;
	
	// Remove Toy Tab
	@FXML
	private ListView<String> RTInventory;
	@FXML
	private TextField RTSNTxt;
	@FXML
	private Button RTSearchBtn;
	@FXML
	private Button RTRemoveBtn;
	
	// Gift Option Tab
	@FXML
	private ChoiceBox GOType;
	@FXML
	private CheckBox ageCB;
	@FXML
	private CheckBox typeCB;
	@FXML
	private CheckBox priceRangeCB;
	@FXML
	private TextField GOAgeTxt;
	@FXML
	private TextField minPriceTxt;
	@FXML
	private TextField maxPriceTxt;
	@FXML
	private Button GOSearch;
	@FXML
	private Button GOPurchase;
	@FXML
	private ListView<String> GOInventory;

	/**
	 * Create an ObservableList<String> and put them into ChoiceBox.
	 * 
	 * @param none
	 * @return none
	 */
	@FXML
	private void initialize() {
		// a ObservableList<String> to store different type of toys for user to select in ChoiceBox
		ObservableList<String> options = FXCollections.observableArrayList("Figure", "Animal", "Puzzle", "Board Game");
		ObservableList<String> figureType = FXCollections.observableArrayList("Action", "Doll", "Historic");
		ObservableList<String> animalSize = FXCollections.observableArrayList("Small", "Medium", "Large");
		ObservableList<String> puzzleType = FXCollections.observableArrayList("Mechanical", "Cryptic", "Logic", "Trivia", "Riddle");
		
		// set the default value for the ChoiceBox
		homeType.setValue("Figure");
		category.setValue("Figure");
		GOType.setValue("Figure");
		classification.setValue("Action");
		size.setValue("Small");
		type.setValue("Mechanical");
		
		// import the ObservableList<String> options into ChoiceBox
		homeType.setItems(options);
		category.setItems(options);
		GOType.setItems(options);
		classification.setItems(figureType);
		size.setItems(animalSize);
		type.setItems(puzzleType);
		
		// initially, only the TextField of serial number is enabled
		nameTxt.setDisable(true);
		homeType.setDisable(true);
		
		// initially, only TextField classification of Figure (the default ChoiceBox option) is enabled
		materialTxt.setDisable(true);
		size.setDisable(true);
		type.setDisable(true);
		minPlayerTxt.setDisable(true);
		maxPlayerTxt.setDisable(true);
		designersTxt.setDisable(true);
		
		// initially, no Text Field is selected if the Check Box in Gift Option Tab is unchecked
		GOType.setDisable(true);
		GOAgeTxt.setDisable(true);
		minPriceTxt.setDisable(true);
		maxPriceTxt.setDisable(true);
	}
	
	/**
	 * Allow user to search inventory by either Serial Number, Name, or Type and display the result in ListView accordingly.
	 * 
	 * @param ActionEvent e - the action event passed in
	 * @return none
	 */
	public void searchInventory(ActionEvent e) {
		Main.LOGGER.info("User tried to implement a search in Home Tab.");
		
		// clear the list before showing
		inventory.getItems().clear();
		
		// initialize the errorIsCaught boolean
		errorIsCaught = false;
		
		try {
			// when user choose serial number as search criteria
			if (SNBtn.isSelected()){
				// validate the input using validate method
				errorIsCaught = validate(SNTxt, "Serial Number", "SN");
				if (errorIsCaught) return;
				
				// search through the ArrayList<Toy> located in Toy Class
				for (Toy toy : Toy.toys) {
					// show the match result
					if (SNTxt.getText().equals(toy.getSN())) {
						inventory.getItems().add(toy.toString());
						break;
					}
				}
			}
			
			// when user choose name as search criteria
			if (nameBtn.isSelected()) {
				errorIsCaught = validate(nameTxt, "Name", "Text");
				
				if (!errorIsCaught) {
					// search toy which contains the user input
					for (Toy toy : Toy.toys) {
						if (toy.getName().toLowerCase().contains(nameTxt.getText().toLowerCase())) {
							inventory.getItems().add(toy.toString());
						}
					}
				}
				
			}
			
			// when user choose type as search criteria
			if (typeBtn.isSelected()) {
				for (Toy toy : Toy.toys) {
					// get the simple name of the class
					String toyType = toy.getClass().getSimpleName();
					
					// separate "BoardGame" to "Board Game" so that it matches with ChoiceBox
					if (toyType.equals("BoardGame")) {
						toyType = "Board Game";
					}
					// if the name of the class equals to the user-selected ChoiceBox
					if (toyType.equals(homeType.getSelectionModel().getSelectedItem().toString())) {
						inventory.getItems().add(toy.toString());
					}
				}
			}
			
			// handle when no result is found but only when no error is caught beforehand
			if (!errorIsCaught && inventory.getItems().isEmpty()) {
				throw new NoResultFoundException();
			}
		}catch (NoResultFoundException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			Main.LOGGER.info("User successfully implemented a search but no result found.");
		}
		
	}
	
	/**
	 * Allow user to purchase toy in search result and deduct the available count accordingly.
	 * 
	 * @param ActionEvent e - the action event passed in
	 * @return none
	 */
	public void purchase(ActionEvent e) {
		Main.LOGGER.info("User tried to purchase toy.");
		try {
			// get the result (String) that user selects
			String userSelection = inventory.getSelectionModel().getSelectedItem().toString();
			// get the Serial Number using index of Number +8 to get the first digit and +18 to get the last digit
			String selectedSN = userSelection.substring(userSelection.indexOf("Number") + 8,
					userSelection.indexOf("Number") + 18);
			// search through the ArrayList<Toy> toys to see if there is any serial number match
			for (Toy toy : Toy.toys) {
				if (selectedSN.equals(toy.getSN())) {
					if (toy.getAvailableCount() > 0) {
						// deduct the available count
						toy.setAvailableCount(toy.getAvailableCount() - 1);
						JOptionPane.showMessageDialog(null, "You Have Successfully Purchase " + toy.getName() + ".\n" +
								"The Avaliable Count is " + toy.getAvailableCount() + " now.");
						Main.LOGGER.info("User purchased " + toy.getName() + " (Serial Number: " + toy.getSN() + "). " +
								"Available Count: " + toy.getAvailableCount() + ".");
						// clear the list
						inventory.getItems().clear();
						// update the items purchased
						inventory.getItems().add(toy.toString());
						
					} else {
						throw new NotEnoughAvailableCountException();
					}
				}
			}
		} catch (NotEnoughAvailableCountException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			Main.LOGGER.warning("User tried to purchase toy with not enough available count.");
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Please Select A Toy.");
			Main.LOGGER.warning("User tried not to select toy before purchase.");
		}
	}
	
	/**
	 * Empty the ViewList<String> inventory.
	 * 
	 * @param ActionEvent e - the action event passed in
	 * @return none
	 */
	public void clearList(ActionEvent e) {
		inventory.getItems().clear();
	}
	
	/**
	 * Reset the input Text Field or selected Choice Box
	 * 
	 * @param ActionEvent e - the action event passed in
	 * @return none
	 */
	public void reset(ActionEvent e) {
		SNTxt.setText("");
		nameTxt.setText("");
		homeType.setValue("Figure");
	}
	
	/**
	 * Allow user to search by Serial Number in the Remove Toy tab.
	 * 
	 * @param ActionEvent e - the action event passed in
	 * @return none
	 */
	public void searchForRemove(ActionEvent e) {
		Main.LOGGER.info("User tried to implement a search in Remove Toy Tab.");
		// initialize the errorIsCaught boolean
		errorIsCaught = false;
		
		// clear the list before showing
		RTInventory.getItems().clear();
		
		try {
			// validate the input using validate method
			errorIsCaught = validate(RTSNTxt, "Serial Number", "SN");
			if (errorIsCaught) return;
			
			// search through the ArrayList<Toy> located in Toy Class
			for (Toy toy : Toy.toys) {
				// show the match result
				if (RTSNTxt.getText().equals(toy.getSN())) {
					RTInventory.getItems().add(toy.toString());
					break;
				}
			}
			
			// handle when no result is found but only when no error is caught beforehand
			if (!errorIsCaught && RTInventory.getItems().isEmpty()) {
				throw new NoResultFoundException();
				
			}
		} catch (NoResultFoundException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			Main.LOGGER.info("User successfully implemented a search but no result found.");
		}
	}
	
	/**
	 * Allow user to remove toy after search.
	 * @param ActionEvent e - the action event passed in
	 * @return none
	 */
	public void remove(ActionEvent e) {
		Main.LOGGER.info("User tried to remove a toy.");
		try {
			if (!RTInventory.getSelectionModel().getSelectedItem().isEmpty()) {
				for (Toy toy : Toy.toys) {
					// iterate through the ArrayList<Toy> toys located in Toy Class
					if (RTSNTxt.getText().equals(toy.getSN())) {
						// prompt the user to confirm the remove action
						int result = JOptionPane.showConfirmDialog (null, "Are You Sure To Remove " + toy.getName() + 
								" (Serial Number: " + toy.getSN() + ")?",
								"Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						// remove the toy if the user confirms
						if (result == JOptionPane.YES_OPTION) {
							Toy.toys.remove(toy);
							JOptionPane.showMessageDialog(null, toy.getName() + " Is Successfully Removed.");
							Main.LOGGER.info("User successfully removed a toy. Serial Number: " + toy.getSN());
							// clear the list
							RTInventory.getItems().clear();
						}
						break;
					}
				}
			}
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Please Select A Toy.");
			Main.LOGGER.warning("User tried not to select toy before purchase.");
		}

	}
	
	/**
	 * Allow user to search for suggested gift by entering at least two of the options.
	 * 
	 * @param ActionEvent e - the action event passed in
	 * @return none
	 */
	public void giftOptionSearch(ActionEvent e) {
		Main.LOGGER.info("User tried to implement a search in Gift Option Tab.");
		
		// clear the list before each search
		GOInventory.getItems().clear();

		errorIsCaught = false;
		
		// confirm at least two options (Check Box) are chosen
		int count = 0;
		if (ageCB.isSelected()) count++;
		if (typeCB.isSelected()) count++;
		if (priceRangeCB.isSelected()) count++;
		if (count < 2) {
			JOptionPane.showMessageDialog(null, "Please Choose At Least Two Option");
			Main.LOGGER.warning("User tried to search for gift but selected less than 2 options.");
			return;
		}
		
		// validate Text Field age if selected
		if (ageCB.isSelected()) {
			errorIsCaught = validate(GOAgeTxt, "Age", "Integer");
			if (errorIsCaught) return;
		}
		
		// validate Minimum Price and Maximum Price
		if (priceRangeCB.isSelected()) {
			errorIsCaught = validate(minPriceTxt, "Minimum Price", "Double");
			if (errorIsCaught) return;
			errorIsCaught = validate(maxPriceTxt, "Maximum Price", "Double");
			if (errorIsCaught) return;
			try {
				// if the minimum price is bigger than the maximum price
				if (Double.parseDouble(minPriceTxt.getText()) > 
				Double.parseDouble(maxPriceTxt.getText())) {
					throw new MinBiggerThanMaxException();
				}
			} catch (MinBiggerThanMaxException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				Main.LOGGER.warning("User tried to input a Minimum Number which is bigger than Maximum Number.");
				return;
			}
		}
		
		/*
		 * There were 4 scenario:
		 * 1. User chooses Age and Type
		 * 2. User chooses Age and Price Range
		 * 3. User chooses Type and Price Range
		 * 4. User chooses all Age, Type and Price Range
		 */
		
		// case 1
		if (ageCB.isSelected() && typeCB.isSelected() && !priceRangeCB.isSelected()) {
			// search through the ArrayList<Toy> toys located in Toy Class
			for (Toy toy : Toy.toys) {
				// make the simple name of BoardGame Class become "Board Game"
				String simpleName = toy.getClass().getSimpleName().replace("dG", "d G");
	
				if (Integer.parseInt(GOAgeTxt.getText()) >= toy.getAgeAppropriate() &&
						GOType.getSelectionModel().getSelectedItem().toString().equals(simpleName)) {
					GOInventory.getItems().add(toy.toString());
				}
			}
		}
		
		// case 2
		if (ageCB.isSelected() && priceRangeCB.isSelected() && !typeCB.isSelected()) {
			for (Toy toy : Toy.toys) {
				if (Integer.parseInt(GOAgeTxt.getText()) >= toy.getAgeAppropriate() &&
						Double.parseDouble(minPriceTxt.getText()) <= toy.getPrice() &&
						Double.parseDouble(maxPriceTxt.getText()) >= toy.getPrice()) {
					GOInventory.getItems().add(toy.toString());
				}
			}
		}
		
		// case 3
		if (typeCB.isSelected() && priceRangeCB.isSelected() && !ageCB.isSelected()) {
			for (Toy toy: Toy.toys) {
				// make the simple name of BoardGame Class become "Board Game"
				String simpleName = toy.getClass().getSimpleName().replace("dG", "d G");
				
				if (GOType.getSelectionModel().getSelectedItem().toString().equals(simpleName) &&
						Double.parseDouble(minPriceTxt.getText()) <= toy.getPrice() &&
						Double.parseDouble(maxPriceTxt.getText()) >= toy.getPrice()) {
					GOInventory.getItems().add(toy.toString());
				}
			}
		}
		
		// case 4
		if (ageCB.isSelected() && typeCB.isSelected() && priceRangeCB.isSelected()) {
			for (Toy toy: Toy.toys) {
				// make the simple name of BoardGame Class become "Board Game"
				String simpleName = toy.getClass().getSimpleName().replace("dG", "d G");
				
				if (Integer.parseInt(GOAgeTxt.getText()) >= toy.getAgeAppropriate() &&
						GOType.getSelectionModel().getSelectedItem().toString().equals(simpleName) &&
						Double.parseDouble(minPriceTxt.getText()) <= toy.getPrice() &&
						Double.parseDouble(maxPriceTxt.getText()) >= toy.getPrice()) {
					GOInventory.getItems().add(toy.toString());
				}
			}
		}
		
		// handle when no result is found but only when no error is caught beforehand
		try {
			if (!errorIsCaught && GOInventory.getItems().isEmpty()) {
				throw new NoResultFoundException();
			}
		} catch (NoResultFoundException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			Main.LOGGER.info("User successfully implemented a search but no result found.");
		}
	}
	
	/**
	 * Allow user to buy the suggested gift.
	 * 
	 * @param ActionEvent e - the action event passed in
	 * @return none
	 */
	public void giftOptionPuchase(ActionEvent e) {
		Main.LOGGER.info("User tried to purchase toy.");
		try {
			// get the result (String) that user selects
			String userSelection = GOInventory.getSelectionModel().getSelectedItem().toString();
			// get the Serial Number using index of Number +8 to get the first digit and +18 to get the last digit
			String selectedSN = userSelection.substring(userSelection.indexOf("Number") + 8,
					userSelection.indexOf("Number") + 18);
			// search through the ArrayList<Toy> toys to see if there is any serial number match
			for (Toy toy : Toy.toys) {
				if (selectedSN.equals(toy.getSN())) {
					if (toy.getAvailableCount() > 0) {
						// deduct the available count
						toy.setAvailableCount(toy.getAvailableCount() - 1);
						JOptionPane.showMessageDialog(null, "You Have Successfully Purchase " + toy.getName() + ".\n" +
								"The Avaliable Count is " + toy.getAvailableCount() + " now.");
						Main.LOGGER.info("User purchased " + toy.getName() + " (Serial Number: " + toy.getSN() + "). " +
								"Available Count: " + toy.getAvailableCount() + ".");
						// clear the list
						GOInventory.getItems().clear();
						// update the items purchased
						GOInventory.getItems().add(toy.toString());
					} else {
						throw new NotEnoughAvailableCountException();
					}
				}
			}
		} catch (NotEnoughAvailableCountException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			Main.LOGGER.warning("User tried to purchase toy with not enough available count.");
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Please Select A Toy.");
			Main.LOGGER.warning("User tried not to select toy before purchase.");
		}
	}
	
	/**
	 * Decide whether a TextField or ChoiceBox is disabled.
	 * Depends on the radio button or ChoiceBox selected.
	 * 
	 * @param ActionEvent e - the action event passed in
	 * @return none
	 */
	public void selectedAndDisable(ActionEvent e) {
		// for Home Tab
		if (SNBtn.isSelected()) {
			SNTxt.setDisable(false);
			nameTxt.setDisable(true);
			homeType.setDisable(true);
		}
		if (nameBtn.isSelected()) {
			SNTxt.setDisable(true);
			nameTxt.setDisable(false);
			homeType.setDisable(true);
		}
		if (typeBtn.isSelected()) {
			SNTxt.setDisable(true);
			nameTxt.setDisable(true);
			homeType.setDisable(false);
		}
		
		// for Add Toy Tab
		try {
			if (category.getSelectionModel().getSelectedItem().toString().equals("Figure")) {
				classification.setDisable(false);
				materialTxt.setDisable(true);
				size.setDisable(true);
				type.setDisable(true);
				minPlayerTxt.setDisable(true);
				maxPlayerTxt.setDisable(true);
				designersTxt.setDisable(true);
			}
			if (category.getSelectionModel().getSelectedItem().toString().equals("Animal")) {
				classification.setDisable(true);
				materialTxt.setDisable(false);
				size.setDisable(false);
				type.setDisable(true);
				minPlayerTxt.setDisable(true);
				maxPlayerTxt.setDisable(true);
				designersTxt.setDisable(true);
			}
			if (category.getSelectionModel().getSelectedItem().toString().equals("Puzzle")) {
				classification.setDisable(true);
				materialTxt.setDisable(true);
				size.setDisable(true);
				type.setDisable(false);
				minPlayerTxt.setDisable(true);
				maxPlayerTxt.setDisable(true);
				designersTxt.setDisable(true);
			}
			if (category.getSelectionModel().getSelectedItem().toString().equals("Board Game")) {
				classification.setDisable(true);
				materialTxt.setDisable(true);
				size.setDisable(true);
				type.setDisable(true);
				minPlayerTxt.setDisable(false);
				maxPlayerTxt.setDisable(false);
				designersTxt.setDisable(false);
			}
		// handle when the initial value of ChoiceBox category is null
		} catch (NullPointerException e1) {
			category.setValue("Figure");
		}
		
		// for Gift Option Tab
		if (ageCB.isSelected()) {
			// if the Check Box ageCB is not selected, then the Text Field GOAgeTxt will be disabled
			GOAgeTxt.disableProperty().bind(ageCB.selectedProperty().not());
		}
		if (typeCB.isSelected()) {
			// if the Check Box typeCB is not selected, then the Choice Box GOType will be disabled
			GOType.disableProperty().bind(typeCB.selectedProperty().not());
		}
		if (priceRangeCB.isSelected()) {
			// if the Check Box priceRangeCB is not selected, then both Text Field minPriceTxt and maxPriceTxt will be disabled
			minPriceTxt.disableProperty().bind(priceRangeCB.selectedProperty().not());
			maxPriceTxt.disableProperty().bind(priceRangeCB.selectedProperty().not());
		}
	}
	
	/**
	 * Add different types of toys into the ArrayList<Toy> toys located in Toys Class according to user input.
	 * 
	 * @param ActionEvent e - the action event passed in
	 * @return none
	 */
	public void addToy(ActionEvent e) {
		Main.LOGGER.info("User tried to add a toy.");
		
		// initialize errorIsCaught boolean when there is no error caught yet
		errorIsCaught = false;
		
		// validate the Serial Number
		errorIsCaught = validate(ATSNTxt, "Serial Number", "SN");
		// end the method if error is caught
		if (errorIsCaught) return;
		
		// if no error is caught then check if the serial number already exists
		if (!errorIsCaught) {
			try {
				for (Toy toy : Toy.toys) {
					if (ATSNTxt.getText().equals(toy.getSN())) {
						throw new UniqueSerialNumberException();
					}
				}
			} catch (UniqueSerialNumberException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				Main.LOGGER.warning("User tried to input nothing duplicated Serial Number.");
				return;
			}
		}
		// validate the Name
		errorIsCaught = validate(ATName, "Name", "Text");
		if (errorIsCaught) return;
		
		// validate the Brand
		errorIsCaught = validate(ATBrand, "Brand", "Text");
		if (errorIsCaught) return;
		
		// validate the Price
		errorIsCaught = validate(ATPrice, "Price", "Double");
		if (errorIsCaught) return;
		
		// validate the Available Count
		errorIsCaught = validate(ATAvaCount, "Available Count", "Integer");
		if (errorIsCaught) return;
		
		// validate the Age Appropriate
		errorIsCaught = validate(ATAgeAppr, "Age Appropriate", "Integer");
		if (errorIsCaught) return;
		
		// in case it is a figure
		if (category.getSelectionModel().getSelectedItem().equals("Figure")) {
			// construct an Figure Object
			Figure figure = new Figure(ATSNTxt.getText(), ATName.getText(),
					ATBrand.getText(), Double.parseDouble(ATPrice.getText()),
					Integer.parseInt(ATAvaCount.getText()), Integer.parseInt(ATAgeAppr.getText()),
					classification.getSelectionModel().getSelectedItem().toString());
			Toy.toys.add(figure);
		}
		
		// in case it is an animal
		if (category.getSelectionModel().getSelectedItem().equals("Animal")) {
			errorIsCaught = validate(materialTxt, "Material", "Text");
			if (errorIsCaught) return;
			
			// construct an Figure Object
			Animal animal = new Animal(ATSNTxt.getText(), ATName.getText(),
					ATBrand.getText(), Double.parseDouble(ATPrice.getText()),
					Integer.parseInt(ATAvaCount.getText()), Integer.parseInt(ATAgeAppr.getText()),
					materialTxt.getText(), size.getSelectionModel().getSelectedItem().toString());
			Toy.toys.add(animal);
		}
		
		// in case it is a puzzle
		if (category.getSelectionModel().getSelectedItem().equals("Puzzle")) {
			
			// construct an Puzzle Object
			Puzzle puzzle = new Puzzle(ATSNTxt.getText(), ATName.getText(),
					ATBrand.getText(), Double.parseDouble(ATPrice.getText()),
					Integer.parseInt(ATAvaCount.getText()), Integer.parseInt(ATAgeAppr.getText()),
					type.getSelectionModel().getSelectedItem().toString());
			Toy.toys.add(puzzle);
		}
		
		// in case it is a board game
		if (category.getSelectionModel().getSelectedItem().equals("Board Game")) {
			
			// validate the minimum number of players
			errorIsCaught = validate(minPlayerTxt, "Minimum Number Of Players", "Integer");
			if (errorIsCaught) return;
			// validate the maximum number of players
			errorIsCaught = validate(maxPlayerTxt, "Maximum Number Of Players", "Integer");
			if (errorIsCaught) return;
			// if minimum > maximum then throw MinBiggerThanMaxException
			try {
				if (Integer.parseInt(minPlayerTxt.getText()) > Integer.parseInt(maxPlayerTxt.getText())) {
					throw new MinBiggerThanMaxException();
				}
			} catch (MinBiggerThanMaxException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				Main.LOGGER.warning("User tried to input a Minimum Number which is bigger than Maximum Number.");
				return;
			}
			errorIsCaught = validate(designersTxt, "Designers", "Text");
			if (errorIsCaught) return;
			
			// break down the designers into an ArrayList<String> to fit the constructor
			ArrayList<String> designers = new ArrayList<>();
			String[] tokens = designersTxt.getText().split(",");
			for (String str : tokens) {
				designers.add(str);
			}
			
			// construct an BoardGame Object
			BoardGame boardgame = new BoardGame(ATSNTxt.getText(), ATName.getText(),
					ATBrand.getText(), Double.parseDouble(ATPrice.getText()),
					Integer.parseInt(ATAvaCount.getText()), Integer.parseInt(ATAgeAppr.getText()),
					Integer.parseInt(minPlayerTxt.getText()), Integer.parseInt(maxPlayerTxt.getText()),
					designers);
			Toy.toys.add(boardgame);
		}
		
		// print the message to prompt user that the new toy is added
		JOptionPane.showMessageDialog(null, category.getSelectionModel().getSelectedItem().toString() +
				" Is Added. Serial Number: " + ATSNTxt.getText());
		
		// logging
		Main.LOGGER.info("User added a new " + 
				category.getSelectionModel().getSelectedItem().toString() + 
				". Serial Number: " + ATSNTxt.getText());
	}
	
	/**
	 * Validate the user input in Text Field and print error message in JOptionPane accordingly.
	 * 
	 * @param textField - the Text Field that the user is on
	 * @param fieldName - the name of the Text Field
	 * @param type - can be "SN", "Text", "Integer", "Double"
	 * @return boolean - indicate if there is error caught or not
	 */
	public boolean validate(TextField textField, String fieldName, String type) {
		try {
			// validate empty input first
			if (textField.getText().isEmpty()) {
				throw new EmptyInputException();
			}
			if (type.equals("SN")) {
				// check if it is an integer, if not then a NumberFormatException is thrown
				Long.parseLong(textField.getText());
				
				// check if the SN is 10-digit long
				if (textField.getText().length() != 10) {
					throw new SerialNumberFormatException();
				}
			}
			if (type.equals("Double")) {
				// try to parse into double, if not then a NumberFormatException is thrown
				double userInput = Double.parseDouble(textField.getText());
				if (userInput <= 0) {
					throw new NegativeNumberException();
				}
			}
			if (type.equals("Integer")) {
				int userInput = Integer.parseInt(textField.getText());
				if (userInput <= 0) {
					throw new NegativeNumberException();
				}
			}
		} catch (EmptyInputException e1) {
			JOptionPane.showMessageDialog(null, fieldName + " Cannot Be Empty.");
			Main.LOGGER.warning("User tried to input nothing into " + fieldName + " Text Field.");
			// return if the error is caught
			return true;
		} catch (NumberFormatException e1) {
			if (type.equals("Double")) {
				JOptionPane.showMessageDialog(null, fieldName + " Should Be Number Only.");
			} else {
				JOptionPane.showMessageDialog(null, fieldName + " Should Be Integer Only.");
			}
			Main.LOGGER.warning("User tried to input " + fieldName + " with incorrect format.");
			// return if the error is caught
			return true;
		} catch (SerialNumberFormatException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			Main.LOGGER.warning("User tried to input Serial Number with incorrect format.");
			// return if the error is caught
			return true;
		} catch (NegativeNumberException e1) {
			JOptionPane.showMessageDialog(null, fieldName + " Should Be Greater Than 0.");
			Main.LOGGER.warning("User tried to input a negative number to " + fieldName + ".");
			return true;
		}
		// return false if no error is caught
		return false;
	}
}
