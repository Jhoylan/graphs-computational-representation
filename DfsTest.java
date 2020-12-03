package computationalRepresentation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DfsTest {

	@Test
	void dfsTest() {
		Dfs graphDfs = new Dfs();
		graphDfs.dfsGraph();
		graphDfs.showArrays();
	}

}
