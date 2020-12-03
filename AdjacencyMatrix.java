package computationalRepresentation;

import java.util.ArrayList;

public class AdjacencyMatrix {
	int[][] adjacencyMatrix;
	int nodes;
	
	AdjacencyMatrix(){
		this.adjacencyMatrix = new int[1][1];
	}
	
	public void populating() {
		IntegerInput nodes = new IntegerInput();
		System.out.println("Insert the number of nodes");
		nodes.setNumber();
		
		this.nodes = nodes.getNumber();
		
		
		while(this.nodes < 0 || this.nodes % 1 != 0) {
			System.out.println("Please, insert a valuable number");
			nodes.setNumber();
			this.nodes = nodes.getNumber();
		}
		
		adjacencyMatrix = new int[this.nodes][this.nodes];
		
		System.out.println("Insert the number of connections between the nodes(the value must be greater than 0)");
		
		for(int i = 0; i < nodes.getNumber(); i++) {
			for(int j = 0; j < nodes.getNumber(); j++) {
				IntegerInput numberOfConnections = new IntegerInput();
				System.out.println("Insert the number of connections between the node " + (i + 1) + " and " + (j + 1));
				numberOfConnections.setNumber();
				
				while(numberOfConnections.getNumber() < 0 || numberOfConnections.getNumber() % 1 != 0) {
					System.out.println("Please, insert a valuable number");
					numberOfConnections.setNumber();
				}
				
				adjacencyMatrix[i][j] = numberOfConnections.getNumber();
			}
		}
	}
	
	public void print() {
		for(int i = 0; i < this.nodes; i ++) {
			for(int j = 0; j < this.nodes; j++) {
				System.out.print(adjacencyMatrix[i][j]);
			}
			
			System.out.println();
		}
		
		
	}
	
	public void setAnMatrixElement(int element, int i, int j) {
		
		if(element < 0 || element % 1 != 0 || i < 0 || i % 1 != 0 || j < 0 || j % 1 != 0) {
			System.out.println("Please, insert a valuable number");			
		}else {
			this.adjacencyMatrix[i][j] = element;
		}
	}
	
	public void setInteryMatrix(int[][] matrix) {
		this.nodes = matrix[0].length;
		this.adjacencyMatrix = matrix;		
	}
	
	public void clone(AdjacencyMatrix matrix) {
		this.adjacencyMatrix = matrix.adjacencyMatrix;
		this.nodes = matrix.nodes;
	}
	
	@Override
	public boolean equals(Object otherMatrix) {
		if(this == otherMatrix) return true;
		
		if(!(otherMatrix instanceof AdjacencyMatrix)) return false;
		
		boolean flag = true;
		
		AdjacencyMatrix otherAdjacencyMatrix = (AdjacencyMatrix) otherMatrix;
		
		if(this.adjacencyMatrix[0].length != otherAdjacencyMatrix.adjacencyMatrix[0].length) return false;
		
		for(int i = 0; i < this.nodes; i++) {
			for(int j = 0; j < this.nodes; j++) {
				if(this.adjacencyMatrix[i][j] != otherAdjacencyMatrix.adjacencyMatrix[i][j]) flag = false;
			}
		}
		
		return flag;
	}
	
	
}
