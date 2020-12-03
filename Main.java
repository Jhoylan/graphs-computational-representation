package computationalRepresentation;

public class Main {

	public static void main(String[] args) {
		System.out.println("Graph represented by linked lists");
		GraphRepresentationByLinkedList array1 = new GraphRepresentationByLinkedList();
		array1.populating();		
		
		System.out.println("Graph represented by bags");
		GraphRepresentationByBags array2 = new GraphRepresentationByBags(0);
		array2.populating();
		
		System.out.println("Graph represented by adjacency matrix");
		AdjacencyMatrix matrix = new AdjacencyMatrix();
		matrix.populating();
		
		System.out.println("The graph computational representation by linked list is: ");
		array1.show();
		
		System.out.println("The graph computational representation by bags is: ");
		array2.show();

		System.out.println("The graph computational representation by adjacency matrix is: ");
		matrix.print();
	}

}
