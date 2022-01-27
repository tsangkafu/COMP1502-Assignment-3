package driver;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mru.tsc.controller.Puzzle;
import mru.tsc.controller.Puzzle.PuzzleType;

class TestPuzzle {

	private Puzzle puzzle;

	@BeforeEach
	public void init() {
		puzzle = new Puzzle("4012356789", "City", "Hasbro", 25.00, 3, 8, "M");
	}

	@Test
	void testNewPuzzle() {
		Puzzle puzzle2 = new Puzzle ("5012346789", "House", "Hasbro", 25.00, 8, 2, "L");
		assertNotSame(puzzle, puzzle2);
	}
	
	@Test
	void testType() {
		puzzle.setPuzzleType(PuzzleType.Logic);
		assertSame(puzzle.getPuzzleType(), PuzzleType.Logic);
	}

	@Test
	void testPuzzleChange() {
		Puzzle puzzle2 = new Puzzle("4012356789", "City", "Hasbro", 25.00, 3, 8, "M");
		puzzle2.setSN("5012346789");
		puzzle2.setName("Lego City");
		puzzle2.setBrand("Goliath");
		puzzle2.setPrice(36.99);
		puzzle2.setAvailableCount(4);
		puzzle2.setAgeAppropriate(9);
		assertNotSame(puzzle, puzzle2);
	}
	
	@Test
	void testToString() {
		String value = puzzle.toString();
		assertTrue(value.contains(""), "");
	}

}
