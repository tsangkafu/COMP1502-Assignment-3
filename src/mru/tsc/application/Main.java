package mru.tsc.application;
	
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javafx.application.Application;

import javafx.stage.Stage;
import mru.tsc.controller.ShopController;
import mru.tsc.model.Toy;
import mru.tsc.view.myGUI;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	// create a logger that can be accessed by any class
	public static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	@Override
	public void start(Stage primaryStage) {
		myGUI gui = new myGUI(primaryStage);
	}
	
	public static void main(String[] args) {
		// call the log method to register log
		log();
		LOGGER.info("Logger registered.");
		
		// read file
		ShopController.readFile();
		LOGGER.info("Successfully read toys.txt and create object for each toy.");

		// launch JavaFX
		LOGGER.info("Start the JavaFX application.");
		launch(args);
		
	}
	/**
	 * Create a log file Logging.log within doc folder, reset log level and add Simple Formatter.
	 * @author Sam Tang, Austin Bec
	 */
	public static void log() {
		try {
			//Manually reset logManager
			LogManager.getLogManager().reset();
			
			// specify the location of the log
			FileHandler fh = new FileHandler("./doc/Logging.log", false);

			// create a new simple formatter so that Logging.log will be formatted simply
			SimpleFormatter sf = new SimpleFormatter();
			// put the simple formatter into the file handler
			fh.setFormatter(sf);
			
			// add the handler
			LOGGER.addHandler(fh);
			
			// set the level to ALL so that every log will show
			LOGGER.setLevel(Level.ALL);
			
		} catch (SecurityException | IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
