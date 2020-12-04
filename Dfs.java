package computationalRepresentation;

import java.util.ArrayList;
import java.util.List;

public class DFS {
	private GraphRepresentationByLinkedList graph;
	private List<Integer> pi;
	private List<Integer> discoveryTime;
	private List<Integer> finalizationTime;
	private List<String> color;
	private int time = 1;
	private List<Integer> ascendingDiscoveryTime;
	private List<Integer> topologicalSort;
	
	public DFS(GraphRepresentationByLinkedList graph) {
		this.graph = new GraphRepresentationByLinkedList(1);
		this.graph = graph;
		
		this.topologicalSort = new ArrayList<>();
		this.ascendingDiscoveryTime = new ArrayList<>();
		this.discoveryTime = new ArrayList<Integer>(this.graph.getTotalNodes());
		this.finalizationTime = new ArrayList<Integer>(this.graph.getTotalNodes());
		this.color = new ArrayList<String>(this.graph.getTotalNodes());
		this.pi = new ArrayList<Integer>(this.graph.getTotalNodes());
		
		for(int i = 0; i < this.graph.getTotalNodes(); i++) {
			this.discoveryTime.add(0);
			this.finalizationTime.add(0);
			this.color.add("white");
			this.pi.add(0);
		}	
		
	}
	
	public void dfsGraph() {
				
		for(int i = 0; i < this.graph.getTotalNodes(); i++) {
			if (this.color.get(i) == "white") {
				dfsVisit(this.graph.arrayOfLinkedLists.get(i), i);
			} 
		}
	}
	
	public void dfsVisit(IntegerLinkedList list, int node) {
		this.color.set(node, "gray");
		this.discoveryTime.set(node, this.time);
		this.time++;
			
		for(int i = 1; i < list.linkedList.size(); i++) {
			int adjVertex = list.linkedList.get(i);
			int adjVertexPosition = this.position(adjVertex);
			
;			if(this.color.get(adjVertexPosition) == "white") {
				this.pi.set(adjVertexPosition, list.linkedList.get(0));
				this.dfsVisit(this.graph.arrayOfLinkedLists.get(adjVertexPosition), adjVertexPosition);
			}
		}
		
		this.color.set(node, "black");
		this.finalizationTime.set(node, this.time);
		this.time++;
	}
		
		
	public int position(int vertex) {
		int position = 0;
		
		for(int i = 0; i < this.graph.getTotalNodes(); i++) {
			int firstLinkedListElement = this.graph.arrayOfLinkedLists.get(i).linkedList.get(0);
			
			if(firstLinkedListElement == vertex) {
				position = i;
				break;
			}
		}
		
		return position;
	}
	
	public List<Integer> getAscendingDiscoveryTime(){
		int minTime = 1;
		
		while(ascendingDiscoveryTime.size() != this.discoveryTime.size()) {
						
			for(int i = 0; i < discoveryTime.size(); i++) {
				if(minTime == discoveryTime.get(i)) {
					ascendingDiscoveryTime.add(this.graph.arrayOfLinkedLists.get(i).linkedList.get(0));
				}
			}
			
			minTime++;
		}
		
		return this.ascendingDiscoveryTime;
	}
	
	public List<Integer> getTopologicalSort(){
		int maxTime = this.graph.getTotalNodes() * 2;
		
		while(topologicalSort.size() != this.finalizationTime.size()) {
			for(int i = 0; i < this.finalizationTime.size(); i++) {
				if(this.finalizationTime.get(i) == maxTime) {
					topologicalSort.add(this.graph.arrayOfLinkedLists.get(i).linkedList.get(0));
				}
			}
			
			maxTime--;
		}
		
		return this.topologicalSort;
	}

	public List<String> getColor() {
		return color;
	}
	
	
}

