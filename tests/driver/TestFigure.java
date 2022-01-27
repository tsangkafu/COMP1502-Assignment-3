package driver;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mru.tsc.controller.Figure;
import mru.tsc.controller.Figure.Classification;

class TestFigure {

private Figure figure;
	
	@BeforeEach
	void init() {
		figure = new Figure("0123456789", "Joe", "Matel", 25.00, 5, 2, "A");
	}
	
	@Test
	void testNewFigure() {
		Figure figure2 = new Figure("1123456789", "Jane", "Matel", 25.00, 5, 2, "A");
		assertNotSame(figure, figure2);
	}
	
	@Test
	void testClassification() {
		figure.setClassification(Classification.Doll);
		assertEquals(figure.getClassification(), Classification.Doll);
	}
	
	@Test
	void testFigureChange() {
		Figure figure2 = new Figure("0123456789", "Joe", "Matel", 25.00, 5, 2, "A");
		figure2.setSN("1023456789");
		figure2.setName("Jane");
		figure2.setBrand("Hasbro");
		figure2.setPrice(20.00);
		figure2.setAvailableCount(2);
		figure2.setAgeAppropriate(3);
		assertNotSame(figure, figure2);
	}
	
	@Test
	void testToString() {
		String value = figure.toString();
		assertTrue(value.contains(""), "");
	}

}
