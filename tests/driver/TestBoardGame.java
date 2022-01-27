package driver;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mru.tsc.controller.BoardGame;

class TestBoardGame {

	
	private BoardGame game;
	private ArrayList<String> designers;
	
	@BeforeEach
	void init() {
		designers = new ArrayList<>();
		game = new BoardGame("7012345689", "Clue", "Hasbro", 30.99, 8, 5, 2, 8, designers);
	}

	@Test
	void testNewBoardGame() {
		BoardGame game2 = new BoardGame("8020349560", "The Game of Life", "Hasbro", 31.00, 10, 5, 4, 99, designers);
		designers.add("A guy");
		assertNotSame(game, game2);
	}
	
	@Test
	void testDesigners() {
		String value = "Joe";
		designers.add(value);
		assertTrue(game.getDesigners().contains(value), value);
	}

	@Test
	void testGameChange() {
		
		designers.add("A guy");
		BoardGame game2 = new BoardGame("7012345689", "Clue", "Hasbro", 30.99, 8, 5, 2, 8, designers);
		game2.setSN("8012345679");
		game2.setName("Life");
		game2.setBrand("Goliath");
		game2.setPrice(35.99);
		game2.setAgeAppropriate(9);
		game2.setMinNumberOfPlayers(3);
		game2.setMaxNumberOfPlayers(10);
		game2.addDesigners("Mark");
		assertNotSame(game, game2);
	}
	
	@Test
	void testToString() {
		String value = game.toString();
		assertTrue(value.contains(""), "");
	}
}
