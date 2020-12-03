package computationalRepresentation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BagOfIntegersTest {

	@Test
	void addingTest() {
		BagOfIntegers bag1 = new BagOfIntegers(3);
		bag1.add(5);
		bag1.add(5);
		bag1.add(5);
		
		int[] bagArray = {5, 5,  5};
		BagOfIntegers bag2 = new BagOfIntegers(3);
		bag2.addIntireBag(bagArray);
		
		boolean verification = bag1.equals(bag2);
		
		assertEquals(true, verification);
		
	}
	
	@Test
	void copyingTest() {
		BagOfIntegers bag1 = new BagOfIntegers(3);
		bag1.add(5);
		bag1.add(5);
		bag1.add(5);
		
		BagOfIntegers bag2 = new BagOfIntegers(3);
		bag2.copyIntireBag(bag1);
		
		boolean verification = bag1.equals(bag2);
		
		assertEquals(true, verification);
		
		int bag1Size = bag1.size();
		int bag2Size = bag2.size();
		
		assertEquals(bag1Size, bag2Size);
	}
	
	@Test
	void emptinessTest() {
		BagOfIntegers bag1 = new BagOfIntegers(3);
		bag1.add(5);
		boolean bag1IsEmpty = bag1.isEmpty();
		
		assertEquals(false, bag1IsEmpty);
		
		BagOfIntegers bag2 = new BagOfIntegers(3);
		boolean bag2IsEmpty = bag2.isEmpty();
		
		assertEquals(true, bag2IsEmpty);
		
	}
	
	@Test 
	void sizeTest(){
		BagOfIntegers bag1 = new BagOfIntegers(3);
		bag1.add(5);
		bag1.add(5);
		bag1.add(5);
		
		int size = bag1.size();
		
		assertEquals(3, size);
	}
	
	@Test
	void populatingTest() {
		BagOfIntegers bag1 = new BagOfIntegers(3);
		bag1.populating();
		
		BagOfIntegers bag2 = new BagOfIntegers(3);
		bag2.add(5);
		bag2.add(5);
		bag2.add(5);
		
		boolean verification = bag1.equals(bag2);
		
		assertEquals(true, verification);
	}
	

}
