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
		test.addLinkedListElement(5);
		test.addLinkedListElement(5);
		test.addLinkedListElement(5);
		
		
		boolean verification = linkedList.equals(test);
		
		assertEquals(true, verification);
		
	}
	
	@Test
	void copyIntireListTest() {
		IntegerLinkedList test = new IntegerLinkedList(1);
		test.addLinkedListElement(5);
		test.addLinkedListElement(5);
		test.addLinkedListElement(5);
		
		IntegerLinkedList linkedList = new IntegerLinkedList(1);
		linkedList.copyIntireList(test);
		
		boolean verification = test.equals(linkedList);
		
		assertEquals(true, verification);
		
	}
	
	@Test
	void deletingFirstOccurencyTest() {
		IntegerLinkedList linkedList = new IntegerLinkedList(1);
		linkedList.addLinkedListElement(5);
		linkedList.addLinkedListElement(3);
		linkedList.addLinkedListElement(3);
		linkedList.addLinkedListElement(1);
		linkedList.deleteFirstOccurece(3);
		
		IntegerLinkedList test = new IntegerLinkedList(1);
		test.addLinkedListElement(5);
		test.addLinkedListElement(3);
		test.addLinkedListElement(1);
		
		boolean verification = test.equals(linkedList);
		
		assertEquals(true, verification);
	}
	
	@Test
	void deletingIndexedElementTest() {
		IntegerLinkedList linkedList = new IntegerLinkedList(1);
		linkedList.addLinkedListElement(5);
		linkedList.addLinkedListElement(3);
		linkedList.addLinkedListElement(3);
		linkedList.addLinkedListElement(1);
		linkedList.deleteIndexedElement(0);
		
		IntegerLinkedList test = new IntegerLinkedList(1);
		test.addLinkedListElement(3);
		test.addLinkedListElement(3);
		test.addLinkedListElement(1);
		
		boolean verification = test.equals(linkedList);
		
		assertEquals(true, verification);
	}
	

}
