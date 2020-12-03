package computationalRepresentation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntegerInputTest {

	@Test
	void testInputRead() {
		IntegerInput number = new IntegerInput();
		number.setNumber();
		int userNumber = number.getNumber();
		
		
		assertEquals(5, userNumber);
	}

}
