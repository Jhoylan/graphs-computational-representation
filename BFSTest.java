package computationalRepresentation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class BFSTest {

	@Test
	void verifyingPositionTest() {
		// creating lists
		IntegerLinkedList list1 = new IntegerLinkedList(1);
		list1.addLinkedListElement(1);
		list1.addLinkedListElement(2);
		list1.addLinkedListElement(3);

		IntegerLinkedList list2 = new IntegerLinkedList(1);
		list2.addLinkedListElement(2);
		list2.addLinkedListElement(1);
		list2.addLinkedListElement(4);

		IntegerLinkedList list3 = new IntegerLinkedList(1);
		list3.addLinkedListElement(3);
		list3.addLinkedListElement(1);
		list3.addLinkedListElement(4);

		IntegerLinkedList list4 = new IntegerLinkedList(1);
		list4.addLinkedListElement(4);
		list4.addLinkedListElement(2);
		list4.addLinkedListElement(3);

		// creating a graph
		GraphRepresentationByLinkedList graph = new GraphRepresentationByLinkedList(1);
		graph.addLinkedList(list1);
		graph.addLinkedList(list2);
		graph.addLinkedList(list3);
		graph.addLinkedList(list4);
		
		BFS bfs = new BFS(graph);
		bfs.bfs(3);
		
		List<String> color = bfs.getColor();
		List<Integer> distance = bfs.getDistance();
		List<Integer> pi = bfs.getPi();
		
		List<Integer>distanceExpected = new ArrayList<>();
		distanceExpected.add(1);
		distanceExpected.add(2);
		distanceExpected.add(0);
		distanceExpected.add(1);
		
		List<Integer> piExpected = new ArrayList<>();
		piExpected.add(3);
		piExpected.add(1);
		piExpected.add(0);
		piExpected.add(3);
		
		List<String> colorExpected = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			colorExpected.add("black");
		}
		
		assertEquals(colorExpected, color);
		assertEquals(distanceExpected, distance);
		assertEquals(piExpected, pi);
	}

}
