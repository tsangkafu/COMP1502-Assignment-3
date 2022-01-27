package mru.tsc.view;

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mru.tsc.application.Main;
import mru.tsc.controller.*;
import mru.tsc.model.Toy;

public class myGUI {
	public myGUI(Stage primaryStage){
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("Main.fxml"));
			
			Scene scene = new Scene(parent, 1000, 550);

			primaryStage.setTitle("Toy Store Company");
			
			primaryStage.setScene(scene);
			
			primaryStage.show();
			
			// handle when user close the window
			primaryStage.setOnCloseRequest(e -> {
				int result = JOptionPane.showConfirmDialog (null, "Do You Want To Save Before You Exit?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					ShopController.saveFile();
					Main.LOGGER.info("User has saved changes before exit.");
				} else {
					Main.LOGGER.info("User has not saved changes before exit.");
				}
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
