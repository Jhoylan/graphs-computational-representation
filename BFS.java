package computationalRepresentation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	GraphRepresentationByLinkedList graph;
	List<String> color;
	List<Integer> distance;
	List<Integer> pi; 
	Queue<Integer> queue;
	
	
	public BFS(GraphRepresentationByLinkedList graph) {
		queue = new LinkedList<>();
		color = new ArrayList<>();
		distance = new ArrayList<>();
		pi = new ArrayList<>();
		this.graph = graph;
		
		for(int i = 0; i < this.graph.totalNodes; i++) {
			color.add("white");
			distance.add(0);
			pi.add(0);
		}
	}
	
	void bfs(int source) {
		int sourcePosition = this.verifyingPosition(source);		
		
		color.set(sourcePosition, "gray");
				
		int linkedListSize = this.graph.arrayOfLinkedLists[sourcePosition].linkedList.size();
		
		for(int i = 1; i < linkedListSize; i++) {
			int adjacentVertex = this.graph.arrayOfLinkedLists[sourcePosition].linkedList.get(i);
			int adjacentVertexPosition = this.verifyingPosition(adjacentVertex);
			pi.set(adjacentVertexPosition, source);
			queue.offer(adjacentVertex);
		}
		
		color.set(sourcePosition, "black");
		
		while(queue.size() != 0) {
			int vertex = queue.element();
			int vertexPosition = this.verifyingPosition(vertex);
			distance.set(vertexPosition, distance.get(this.verifyingPosition(pi.get(vertexPosition))) + 1);
			queue.poll();
			
			for(int i = 1; i < this.graph.arrayOfLinkedLists[vertexPosition].linkedList.size(); i++) {
				int adjacentVertex = this.graph.arrayOfLinkedLists[vertexPosition].linkedList.get(i);
				int adjVertexPosition = this.verifyingPosition(adjacentVertex);
				
				if(color.get(adjVertexPosition) == "white") {
					color.set(adjVertexPosition, "gray");
					distance.set(adjVertexPosition, distance.get(vertexPosition) + 1);
					pi.set(adjVertexPosition, vertex);
					
					linkedListSize = this.graph.arrayOfLinkedLists[adjVertexPosition].linkedList.size();
					
					for(int j = 1; j < linkedListSize; j++) {
						queue.offer(this.graph.arrayOfLinkedLists[adjVertexPosition].linkedList.get(j));
					}
					
					color.set(adjVertexPosition, "black");
				}
			}
			
			color.set(vertexPosition, "black");
		}
	}
	
	public int verifyingPosition(int vertex) {
		int position = 0;
		
		for(int i = 0; i < this.graph.totalNodes; i++) {
			int firstLinkedListElement = this.graph.arrayOfLinkedLists[i].linkedList.get(0);
			
			if(firstLinkedListElement == vertex) {
				position = i;
				break;
			}
		}
		
		return position;
	}
	
	public void showArrays() {
		System.out.println("The vertexes distances are: " + distance);
		System.out.println("The vertexes predecessors are: " + pi);
		System.out.println("The vertexes colors are: " + color);

	}
}
