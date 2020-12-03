package computationalRepresentation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class GraphRepresentationByBagsTest {

	@Test
	void emptinessTest() {
		GraphRepresentationByBags arrayOfBags =  new GraphRepresentationByBags();
		
		boolean empty = arrayOfBags.isEmpty();  
		
		assertEquals(true, empty);
		
		BagOfIntegers bag = new BagOfIntegers();
		bag.add(5);
		bag.add(5);
		
		arrayOfBags.setArrayOfBags(bag, 0);
		
		empty = arrayOfBags.isEmpty();  
			
		assertEquals(false, empty);
	
	}
	
	@Test
	void populatingTest() {
		GraphRepresentationByBags arrayOfBags =  new GraphRepresentationByBags(0);
		arrayOfBags.populating();
		
		GraphRepresentationByBags arrayOfBags2 =  new GraphRepresentationByBags(0);
		
		BagOfIntegers bag = new BagOfIntegers();
		bag.add(5);
		bag.add(5);
		
		arrayOfBags2.setArrayOfBags(bag, 0);
		
		boolean verification = arrayOfBags.equals(arrayOfBags2);
		
		assertEquals(true, verification);
	}
	
	
}
