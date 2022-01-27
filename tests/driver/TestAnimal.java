package driver;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mru.tsc.controller.Animal;
import mru.tsc.controller.Animal.Size;

class TestAnimal {

private Animal animal;
	
	@BeforeEach
	void init() {
		animal = new Animal("2013456789", "Giraffe", "Matel", 10.00, 2, 2, "Cotton", "S");
	}

	@Test
	void testNewAnimal() {
		Animal animal2 = new Animal("3049568940", "Rino", "Matel", 15.00, 3,3, "Cotton", "M");
		assertNotSame(animal, animal2);
	}

	@Test
	void testMaterial() {
		animal.setMaterial("Metal");
		assertEquals(animal.getMaterial(), "Metal");
	}
	
	@Test
	void testSize() {
		animal.setSize(Size.Large);
		assertSame(animal.getSize(), Size.Large);
	}
	
	@Test
	void testAnimalChange() {
		Animal animal2 = new Animal("2013456789", "Giraffe", "Matel", 10.00, 2, 2, "Cotton", "S");
		animal2.setSN("3012456789");
		animal2.setName("Dog");
		animal2.setBrand("Animal CO");
		animal2.setPrice(5.00);
		animal2.setAvailableCount(5);
		animal2.setAgeAppropriate(4);
		assertNotSame(animal, animal2);
	}
	
	@Test
	void testToString() {
		String value = animal.toString();
		assertTrue(value.contains(""), "");
	}

}
