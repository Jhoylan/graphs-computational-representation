package computationalRepresentation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DFSTest {

	@Test
	void dfsTest() {
		DFS graphDfs = new DFS();
		graphDfs.dfsGraph();
		graphDfs.showArrays();
	}

}
