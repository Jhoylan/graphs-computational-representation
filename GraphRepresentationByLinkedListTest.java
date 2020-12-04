package computationalRepresentation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class GraphRepresentationByLinkedListTest {

	@Test
	void testPopulating() {
		GraphRepresentationByLinkedList arrayOfLinkedLists = new GraphRepresentationByLinkedList(0);
		arrayOfLinkedLists.populating();
						
		//creating lists
		IntegerLinkedList list1 = new IntegerLinkedList(1);
		list1.addLinkedListElement(5);
		list1.addLinkedListElement(5);
	
		IntegerLinkedList list2 = new IntegerLinkedList(1);
		list2.addLinkedListElement(6);
		list2.addLinkedListElement(6);
		
		//creating an array of the linked lists above
		GraphRepresentationByLinkedList arrayTest = new GraphRepresentationByLinkedList(1);
		arrayTest.addLinkedList(list1);
		arrayTest.addLinkedList(list2);
		
		boolean verification =  arrayTest.equals(arrayOfLinkedLists);
		
		assertEquals(true, verification);			
	}
	
	@Test
	void showTest() {
		//creating lists
		IntegerLinkedList list1 = new IntegerLinkedList(1);
		list1.addLinkedListElement(5);
		list1.addLinkedListElement(5);
		
		IntegerLinkedList list2 = new IntegerLinkedList(1);
		list2.addLinkedListElement(6);
		list2.addLinkedListElement(6);
				
		//creating an array of the linked lists above
		GraphRepresentationByLinkedList arrayTest = new GraphRepresentationByLinkedList(1);
		arrayTest.addLinkedList(list1);
		arrayTest.addLinkedList(list2);
		
		arrayTest.show();
	}

}
