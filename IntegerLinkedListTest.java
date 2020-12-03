package computationalRepresentation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class IntegerLinkedListTest {

	@Test
	void populatingTest() {
		IntegerLinkedList linkedList = new IntegerLinkedList(0);
		linkedList.populating();
		
		
		IntegerLinkedList test = new IntegerLinkedList(1);
		test.setLinkedListElement(5);
		test.setLinkedListElement(5);
		test.setLinkedListElement(5);
		
		
		boolean verification = linkedList.equals(test);
		
		assertEquals(true, verification);
		
	}
	
	@Test
	void copyIntireListTest() {
		IntegerLinkedList test = new IntegerLinkedList(1);
		test.setLinkedListElement(5);
		test.setLinkedListElement(5);
		test.setLinkedListElement(5);
		
		IntegerLinkedList linkedList = new IntegerLinkedList(1);
		linkedList.copyIntireList(test);
		
		boolean verification = test.equals(linkedList);
		
		assertEquals(true, verification);
		
	}
	
	@Test
	void deletingFirstOccurencyTest() {
		IntegerLinkedList linkedList = new IntegerLinkedList(1);
		linkedList.setLinkedListElement(5);
		linkedList.setLinkedListElement(3);
		linkedList.setLinkedListElement(3);
		linkedList.setLinkedListElement(1);
		linkedList.deleteFirstOccurece(3);
		
		IntegerLinkedList test = new IntegerLinkedList(1);
		test.setLinkedListElement(5);
		test.setLinkedListElement(3);
		test.setLinkedListElement(1);
		
		boolean verification = test.equals(linkedList);
		
		assertEquals(true, verification);
	}
	
	@Test
	void deletingIndexedElementTest() {
		IntegerLinkedList linkedList = new IntegerLinkedList(1);
		linkedList.setLinkedListElement(5);
		linkedList.setLinkedListElement(3);
		linkedList.setLinkedListElement(3);
		linkedList.setLinkedListElement(1);
		linkedList.deleteIndexedElement(0);
		
		IntegerLinkedList test = new IntegerLinkedList(1);
		test.setLinkedListElement(3);
		test.setLinkedListElement(3);
		test.setLinkedListElement(1);
		
		boolean verification = test.equals(linkedList);
		
		assertEquals(true, verification);
	}
	

}
