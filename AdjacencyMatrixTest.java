package computationalRepresentation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdjacencyMatrixTest {

	@Test
	void setElementTest() {
		AdjacencyMatrix matrix = new AdjacencyMatrix();
		matrix.populating();
		matrix.print();
		
		matrix.setAnMatrixElement(5, 0, 1);
		matrix.print();		
	}
	
	@Test
	void populatingTest() {
		AdjacencyMatrix matrix = new AdjacencyMatrix();
		matrix.populating();
		matrix.print();
	}
	
	@Test
	void cloneTest() {
		AdjacencyMatrix matrix1 = new AdjacencyMatrix();
		matrix1.populating();
			
		AdjacencyMatrix matrix2 = new AdjacencyMatrix();
		matrix2.clone(matrix1);
		
		assertEquals(matrix1.adjacencyMatrix, matrix2.adjacencyMatrix);		
	}
	
	@Test
	void equalsTest() {
		AdjacencyMatrix matrix1 = new AdjacencyMatrix();
		matrix1.populating();
			
		AdjacencyMatrix matrix2 = new AdjacencyMatrix();
		matrix2.clone(matrix1);
		
		boolean verification = matrix1.equals(matrix2);
		
		assertEquals(true, verification);
	}
	
	void setIntireMatrix() {
		AdjacencyMatrix matrix1 = new AdjacencyMatrix();
		matrix1.populating();
		
		int[][] matrix2 = matrix1.adjacencyMatrix;
		
		AdjacencyMatrix matrix3 = new AdjacencyMatrix();
		matrix3.setInteryMatrix(matrix2);
		
		boolean verification = matrix1.equals(matrix3);
		
		assertEquals(true, verification);
	}
	

}
