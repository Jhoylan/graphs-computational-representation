package computationalRepresentation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class DFSTest {

	@Test
	void dfsTest() {
		//creating lists
		IntegerLinkedList list1 = new IntegerLinkedList(1);
		list1.addLinkedListElement(1);
		list1.addLinkedListElement(2);
		list1.addLinkedListElement(3);

		IntegerLinkedList list2 = new IntegerLinkedList(1);
		list2.addLinkedListElement(2);
		list2.addLinkedListElement(1);
		list2.addLinkedListElement(4);
		list2.addLinkedListElement(5);
		
		IntegerLinkedList list3 = new IntegerLinkedList(1);
		list3.addLinkedListElement(3);
		list3.addLinkedListElement(1);
		list3.addLinkedListElement(4);
		
		IntegerLinkedList list4 = new IntegerLinkedList(1);
		list4.addLinkedListElement(4);
		list4.addLinkedListElement(2);
		list4.addLinkedListElement(3);
		
		IntegerLinkedList list5 = new IntegerLinkedList(1);
		list5.addLinkedListElement(5);
		list5.addLinkedListElement(2);
		
		//creating a graph
		GraphRepresentationByLinkedList graph = new GraphRepresentationByLinkedList(1);
		graph.addLinkedList(list1);
		graph.addLinkedList(list2);
		graph.addLinkedList(list3);
		graph.addLinkedList(list4);
		graph.addLinkedList(list5);
		
		DFS graphDfs = new DFS(graph);
		graphDfs.dfsGraph();
		
		List<Integer> ascendingDiscoveryTime = graphDfs.getAscendingDiscoveryTime();		
		List<Integer> topologicalSort = graphDfs.getTopologicalSort();
		List<String> color = graphDfs.getColor();
		
		List<Integer> aDTExpected = new ArrayList<>();
		aDTExpected.add(1);
		aDTExpected.add(2);
		aDTExpected.add(4);
		aDTExpected.add(3);
		aDTExpected.add(5);
		
		List<Integer> tSExpected = new ArrayList<>();
		tSExpected.add(1);
		tSExpected.add(2);
		tSExpected.add(5);
		tSExpected.add(4);
		tSExpected.add(3);
		
		List<String> colorExpected = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			colorExpected.add("black");
		}
		
		Assertions.assertEquals(aDTExpected, ascendingDiscoveryTime);
		Assertions.assertEquals(tSExpected, topologicalSort);
		Assertions.assertEquals(colorExpected, color);
	}

}
