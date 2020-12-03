package computationalRepresentation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class GraphRepresentationByLinkedListTest {

	@Test
	void testPopulating() {
		GraphRepresentationByLinkedList arrayOfLinkedLists = new GraphRepresentationByLinkedList();
		arrayOfLinkedLists.populating();
						
		//creating lists
		IntegerLinkedList list1 = new IntegerLinkedList(1);
		list1.setLinkedListElement(5);
		list1.setLinkedListElement(5);
	
		IntegerLinkedList list2 = new IntegerLinkedList(1);
		list2.setLinkedListElement(6);
		list2.setLinkedListElement(6);
		
		//creating an array of the linked lists above
		GraphRepresentationByLinkedList arrayTest = new GraphRepresentationByLinkedList();
		arrayTest.setArrayOfLinkedList(list1);
		arrayTest.setArrayOfLinkedList(list2);
		
		boolean verification =  arrayTest.equals(arrayOfLinkedLists);
		
		assertEquals(true, verification);
		
		
			
	}

}
