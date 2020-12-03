package computationalRepresentation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BFSTest {

	@Test
	void verifyingPositionTest() {
		//insert the graph
		GraphRepresentationByLinkedList graph = new GraphRepresentationByLinkedList();
		graph.populating();
		
		BFS bfs = new BFS(graph);
		
		//choose the source
		bfs.bfs(1);
		
		bfs.showArrays();
	}

}
