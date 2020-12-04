package computationalRepresentation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	private GraphRepresentationByLinkedList graph;
	private List<String> color;
	private List<Integer> distance;
	private List<Integer> pi;
	private Queue<Integer> queue;

	public BFS(GraphRepresentationByLinkedList graph) {
		queue = new LinkedList<>();
		color = new ArrayList<>();
		distance = new ArrayList<>();
		pi = new ArrayList<>();
		this.graph = graph;

		for (int i = 0; i < this.graph.getTotalNodes(); i++) {
			color.add("white");
			distance.add(0);
			pi.add(0);
		}
	}

	void bfs(int source) {
		int sourcePosition = this.position(source);

		color.set(sourcePosition, "gray");

		int linkedListSize = this.graph.arrayOfLinkedLists.get(sourcePosition).linkedList.size();

		for (int i = 1; i < linkedListSize; i++) {
			int adjacentVertex = this.graph.arrayOfLinkedLists.get(sourcePosition).linkedList.get(i);
			int adjacentVertexPosition = this.position(adjacentVertex);
			pi.set(adjacentVertexPosition, source);
			queue.offer(adjacentVertex);
		}

		color.set(sourcePosition, "black");

		while (queue.size() != 0) {
			int vertex = queue.element();
			int vertexPosition = this.position(vertex);
			distance.set(vertexPosition, distance.get(this.position(pi.get(vertexPosition))) + 1);
			queue.poll();

			for (int i = 1; i < this.graph.arrayOfLinkedLists.get(vertexPosition).linkedList.size(); i++) {
				int adjacentVertex = this.graph.arrayOfLinkedLists.get(vertexPosition).linkedList.get(i);
				int adjVertexPosition = this.position(adjacentVertex);

				if (color.get(adjVertexPosition) == "white") {
					color.set(adjVertexPosition, "gray");
					distance.set(adjVertexPosition, distance.get(vertexPosition) + 1);
					pi.set(adjVertexPosition, vertex);

					linkedListSize = this.graph.arrayOfLinkedLists.get(adjVertexPosition).linkedList.size();

					for (int j = 1; j < linkedListSize; j++) {
						queue.offer(this.graph.arrayOfLinkedLists.get(adjVertexPosition).linkedList.get(j));
					}

					color.set(adjVertexPosition, "black");
				}
			}

			color.set(vertexPosition, "black");
		}
	}

	public int position(int vertex) {
		int position = 0;

		for (int i = 0; i < this.graph.getTotalNodes(); i++) {
			int firstLinkedListElement = this.graph.arrayOfLinkedLists.get(i).linkedList.get(0);

			if (firstLinkedListElement == vertex) {
				position = i;
				break;
			}
		}

		return position;
	}

	public List<String> getColor() {
		return color;
	}

	public List<Integer> getDistance() {
		return distance;
	}

	public List<Integer> getPi() {
		return pi;
	}
	
}
