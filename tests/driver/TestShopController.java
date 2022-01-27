package driver;


import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import mru.tsc.controller.ShopController;
import mru.tsc.model.Toy;

class TestShopController {

	@BeforeClass
	
	@Test
	void testReadFile() {
		ShopController.readFile();
		assertNotNull(Toy.toys);
	}
	
	@Test
	void testSave() {
		ShopController.saveFile();
	}

	@Test
	void testClear() throws IOException {
		ShopController.clearFile();
	}
}
