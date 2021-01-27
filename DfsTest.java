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
		graphDfs.dfsGraph("normal");
		
		List<Integer> ascendingDiscoveryTime = graphDfs.getAscendingDiscoveryTime();		
		List<String> color = graphDfs.getColor();
		
		List<Integer> aDTExpected = new ArrayList<>();
		aDTExpected.add(1);
		aDTExpected.add(2);
		aDTExpected.add(4);
		aDTExpected.add(3);
		aDTExpected.add(5);
		
		List<String> colorExpected = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			colorExpected.add("black");
		}
		
		Assertions.assertEquals(aDTExpected, ascendingDiscoveryTime);
		Assertions.assertEquals(colorExpected, color);
	}
	
	@Test
	void topologicalSortingTest() {
		//creating lists
		IntegerLinkedList list1 = new IntegerLinkedList(1);
		list1.addLinkedListElement(1);
		list1.addLinkedListElement(2);
		list1.addLinkedListElement(3);
		
		IntegerLinkedList list2 = new IntegerLinkedList(1);
		list2.addLinkedListElement(2);
		list2.addLinkedListElement(3);
		
		IntegerLinkedList list3 = new IntegerLinkedList(1);
		list3.addLinkedListElement(3);
		
		IntegerLinkedList list4 = new IntegerLinkedList(1);
		list4.addLinkedListElement(4);
		list4.addLinkedListElement(2);
		list4.addLinkedListElement(5);
		
		IntegerLinkedList list5 = new IntegerLinkedList(1);
		list5.addLinkedListElement(5);
		
		IntegerLinkedList list6 = new IntegerLinkedList(1);
		list6.addLinkedListElement(6);
		list6.addLinkedListElement(3);
		
		GraphRepresentationByLinkedList graph = new GraphRepresentationByLinkedList(1);
		graph.addLinkedList(list1);
		graph.addLinkedList(list2);
		graph.addLinkedList(list3);
		graph.addLinkedList(list4);
		graph.addLinkedList(list5);
		graph.addLinkedList(list6);
		
		DFS graphDfs = new DFS(graph);
		graphDfs.dfsGraph("topological");
		
		List<Integer> topologicalSort = graphDfs.getTopologicalSort();
		
		List<Integer> tSExpected = new ArrayList<>();
		tSExpected.add(6);
		tSExpected.add(4);
		tSExpected.add(5);
		tSExpected.add(1);
		tSExpected.add(2);
		tSExpected.add(3);
		
		System.out.println("The topological result is: " + topologicalSort);
		
		Assertions.assertEquals(tSExpected, topologicalSort);		
		
	}
	
	@Test 
	void edgesReturningTest(){
		//creating lists
		IntegerLinkedList list1 = new IntegerLinkedList(1);
		list1.addLinkedListElement(1);
		list1.addLinkedListElement(2);
		list1.addLinkedListElement(3);
		
		IntegerLinkedList list2 = new IntegerLinkedList(1);
		list2.addLinkedListElement(2);
		list2.addLinkedListElement(3);
		
		IntegerLinkedList list3 = new IntegerLinkedList(1);
		list3.addLinkedListElement(3);
		
		GraphRepresentationByLinkedList graph = new GraphRepresentationByLinkedList(1);
		graph.addLinkedList(list1);
		graph.addLinkedList(list2);
		graph.addLinkedList(list3);
		
		DFS graphDfs = new DFS(graph);
		
		List<Integer> edge1 =  new ArrayList<>();
		edge1.add(2);
		edge1.add(3);
		
		List<List<Integer>> edgesExpected = new ArrayList<>();
		edgesExpected.add(edge1);
		
		List<List<Integer>> edges = graphDfs.getEdges(2);
		
		Assertions.assertEquals(edgesExpected, edges);
	}
	
	@Test
	void topologicalEdgesTest() {
		//creating lists
		IntegerLinkedList list1 = new IntegerLinkedList(1);
		list1.addLinkedListElement(1);
		list1.addLinkedListElement(2);
		list1.addLinkedListElement(3);
		
		IntegerLinkedList list2 = new IntegerLinkedList(1);
		list2.addLinkedListElement(2);
		list2.addLinkedListElement(3);
		
		IntegerLinkedList list3 = new IntegerLinkedList(1);
		list3.addLinkedListElement(3);
		
		IntegerLinkedList list4 = new IntegerLinkedList(1);
		list4.addLinkedListElement(4);
		list4.addLinkedListElement(2);
		list4.addLinkedListElement(5);
		
		IntegerLinkedList list5 = new IntegerLinkedList(1);
		list5.addLinkedListElement(5);
		
		IntegerLinkedList list6 = new IntegerLinkedList(1);
		list6.addLinkedListElement(6);
		list6.addLinkedListElement(3);
		
		GraphRepresentationByLinkedList graph = new GraphRepresentationByLinkedList(1);
		graph.addLinkedList(list1);
		graph.addLinkedList(list2);
		graph.addLinkedList(list3);
		graph.addLinkedList(list4);
		graph.addLinkedList(list5);
		graph.addLinkedList(list6);
		
		DFS graphDfs = new DFS(graph);
		graphDfs.dfsGraph("topological");
		
		List<List<List<Integer>>> toplogicalEdges = graphDfs.getTopologicalEdges();
		
		System.out.println("The edges are: " + toplogicalEdges);
		
	}
	
	@Test
	void isConnectedTest() {
		//creating lists
		IntegerLinkedList list1 = new IntegerLinkedList(1);
		list1.addLinkedListElement(1);
		list1.addLinkedListElement(2);
		list1.addLinkedListElement(5);
		
		IntegerLinkedList list2 = new IntegerLinkedList(1);
		list2.addLinkedListElement(2);
		list2.addLinkedListElement(1);
		list2.addLinkedListElement(5);
		
		IntegerLinkedList list3 = new IntegerLinkedList(1);
		list3.addLinkedListElement(3);
		list3.addLinkedListElement(6);		
		
		IntegerLinkedList list4 = new IntegerLinkedList(1);
		list4.addLinkedListElement(5);
		list4.addLinkedListElement(1);
		list4.addLinkedListElement(2);
		
		IntegerLinkedList list5 = new IntegerLinkedList(1);
		list5.addLinkedListElement(6);
		list5.addLinkedListElement(3);
		
		GraphRepresentationByLinkedList graph = new GraphRepresentationByLinkedList(1);
		graph.addLinkedList(list1);
		graph.addLinkedList(list2);
		graph.addLinkedList(list3);
		graph.addLinkedList(list4);
		graph.addLinkedList(list5);
			
		DFS graphDfs = new DFS(graph);
		graphDfs.dfsGraph("normal");
		
		boolean connection1 = graphDfs.isConnected(2, 1);
		boolean connection2 = graphDfs.isConnected(1, 5);
		boolean connection3 = graphDfs.isConnected(3, 6);
		boolean connection4 = graphDfs.isConnected(6, 1);
		boolean connection5 = graphDfs.isConnected(3, 5);
				
		Assertions.assertEquals(true, connection1);
		Assertions.assertEquals(true, connection2);
		Assertions.assertEquals(true, connection3);
		Assertions.assertEquals(false, connection4);
		Assertions.assertEquals(false, connection5);
		
	}
	
	@Test
	void getIdTest() {
		//creating lists
		IntegerLinkedList list1 = new IntegerLinkedList(1);
		list1.addLinkedListElement(1);
		list1.addLinkedListElement(2);
		list1.addLinkedListElement(5);

		IntegerLinkedList list2 = new IntegerLinkedList(1);
		list2.addLinkedListElement(2);
		list2.addLinkedListElement(1);
		list2.addLinkedListElement(5);

		IntegerLinkedList list3 = new IntegerLinkedList(1);
		list3.addLinkedListElement(3);
		list3.addLinkedListElement(6);		

		IntegerLinkedList list4 = new IntegerLinkedList(1);
		list4.addLinkedListElement(5);
		list4.addLinkedListElement(1);
		list4.addLinkedListElement(2);

		IntegerLinkedList list5 = new IntegerLinkedList(1);
		list5.addLinkedListElement(6);
		list5.addLinkedListElement(3);

		GraphRepresentationByLinkedList graph = new GraphRepresentationByLinkedList(1);
		graph.addLinkedList(list1);
		graph.addLinkedList(list2);
		graph.addLinkedList(list3);
		graph.addLinkedList(list4);
		graph.addLinkedList(list5);

		DFS graphDfs = new DFS(graph);
		graphDfs.dfsGraph("normal");

		Assertions.assertEquals(1, graphDfs.getId(1));
		Assertions.assertEquals(1, graphDfs.getId(2));
		Assertions.assertEquals(1, graphDfs.getId(5));
		Assertions.assertEquals(2, graphDfs.getId(3));
		Assertions.assertEquals(2, graphDfs.getId(6));
		
	}
	
	@Test
	void getConnectedComponentsOfIdTest() {
		//creating lists
		IntegerLinkedList list1 = new IntegerLinkedList(1);
		list1.addLinkedListElement(1);
		list1.addLinkedListElement(2);
		list1.addLinkedListElement(5);

		IntegerLinkedList list2 = new IntegerLinkedList(1);
		list2.addLinkedListElement(2);
		list2.addLinkedListElement(1);
		list2.addLinkedListElement(5);

		IntegerLinkedList list3 = new IntegerLinkedList(1);
		list3.addLinkedListElement(3);
		list3.addLinkedListElement(6);		

		IntegerLinkedList list4 = new IntegerLinkedList(1);
		list4.addLinkedListElement(5);
		list4.addLinkedListElement(1);
		list4.addLinkedListElement(2);

		IntegerLinkedList list5 = new IntegerLinkedList(1);
		list5.addLinkedListElement(6);
		list5.addLinkedListElement(3);

		GraphRepresentationByLinkedList graph = new GraphRepresentationByLinkedList(1);
		graph.addLinkedList(list1);
		graph.addLinkedList(list2);
		graph.addLinkedList(list3);
		graph.addLinkedList(list4);
		graph.addLinkedList(list5);

		DFS graphDfs = new DFS(graph);
		graphDfs.dfsGraph("normal");
		
		List<Integer> connectedComponentsExp1 = new ArrayList<>();
		connectedComponentsExp1.add(1);
		connectedComponentsExp1.add(2);
		connectedComponentsExp1.add(5);
		
		List<Integer> connectedComponentsExp2 = new ArrayList<>();
		connectedComponentsExp2.add(3);
		connectedComponentsExp2.add(6);
		
		List<Integer> connectedComponents1 = graphDfs.getConnectedComponentsOfId(1);
		List<Integer> connectedComponents2 = graphDfs.getConnectedComponentsOfId(2);
		
		Assertions.assertEquals(connectedComponentsExp1, connectedComponents1);
		Assertions.assertEquals(connectedComponentsExp2, connectedComponents2);
		
	}
	
	@Test
	void getTheListsOfConnectedComponentsTest() {
		//creating lists
		IntegerLinkedList list1 = new IntegerLinkedList(1);
		list1.addLinkedListElement(1);
		list1.addLinkedListElement(2);
		list1.addLinkedListElement(5);

		IntegerLinkedList list2 = new IntegerLinkedList(1);
		list2.addLinkedListElement(2);
		list2.addLinkedListElement(1);
		list2.addLinkedListElement(5);

		IntegerLinkedList list3 = new IntegerLinkedList(1);
		list3.addLinkedListElement(3);
		list3.addLinkedListElement(6);		

		IntegerLinkedList list4 = new IntegerLinkedList(1);
		list4.addLinkedListElement(5);
		list4.addLinkedListElement(1);
		list4.addLinkedListElement(2);

		IntegerLinkedList list5 = new IntegerLinkedList(1);
		list5.addLinkedListElement(6);
		list5.addLinkedListElement(3);

		GraphRepresentationByLinkedList graph = new GraphRepresentationByLinkedList(1);
		graph.addLinkedList(list1);
		graph.addLinkedList(list2);
		graph.addLinkedList(list3);
		graph.addLinkedList(list4);
		graph.addLinkedList(list5);

		DFS graphDfs = new DFS(graph);
		graphDfs.dfsGraph("normal");
		
		List<Integer> connectedComponentsExp1 = new ArrayList<>();
		connectedComponentsExp1.add(1);
		connectedComponentsExp1.add(2);
		connectedComponentsExp1.add(5);
		
		List<Integer> connectedComponentsExp2 = new ArrayList<>();
		connectedComponentsExp2.add(3);
		connectedComponentsExp2.add(6);
		
		List<List<Integer>> allConnectedComponentsExp = new ArrayList<>();
		allConnectedComponentsExp.add(connectedComponentsExp1);
		allConnectedComponentsExp.add(connectedComponentsExp2);
		
		List<List<Integer>> allConnectedComponents = graphDfs.getTheListsOfConnectedComponents();
		
		Assertions.assertEquals(allConnectedComponentsExp, allConnectedComponents);
	}
}
