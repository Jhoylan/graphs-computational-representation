package computationalRepresentation;

import java.util.ArrayList;
import java.util.List;

public class DFS {
	private GraphRepresentationByLinkedList graph;
	private List<Integer> pi;
	private List<Integer> discoveryTime;
	private List<Integer> finalizationTime;
	private List<String> color;
	private int time;
	private List<Integer> ascendingDiscoveryTime;
	private List<Integer> topologicalSort;
	private List<Integer> id;
	private int count;
	
	public DFS(GraphRepresentationByLinkedList graph) {
		this.graph = new GraphRepresentationByLinkedList(1);
		this.graph = graph;
		
		this.time = 1;
		this.count = 1;
		
		this.id = new ArrayList<>();
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
			this.id.add(0);
		}	
		
	}
	
	public void dfsGraph(String mode) {
		if(mode.equals("normal")) {
			for(int i = 0; i < this.graph.getTotalNodes(); i++) {
				if (this.color.get(i) == "white") {
					dfsVisit(this.graph.arrayOfLinkedLists.get(i), i);
					this.count++;
				} 
			}	
		}else if(mode.equals("topological")) {
			List<Integer> sources = this.sourcesList();
			
			for(int i = 0; i < sources.size(); i++) {
				int node = sources.get(i);
				
				for(int j = 0; j < this.graph.getTotalNodes(); j++) {
					if(this.graph.arrayOfLinkedLists.get(j).linkedList.get(0) == node) {
						dfsVisit(this.graph.arrayOfLinkedLists.get(j), j);
						break;
					}
				}
								
			}	
		}		
		
	}
	
	public void dfsVisit(IntegerLinkedList list, int node) {
		this.color.set(node, "gray");
		this.id.set(node, count);
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
		return this.color;
	}
	
	public List<Integer> sourcesList(){
		List<Integer> sources = new ArrayList<>();
		int node = 0;
		
		for(int i = 0; i < this.graph.getTotalNodes(); i++) {
			boolean isSource = true;
			node = this.graph.arrayOfLinkedLists.get(i).linkedList.get(0);
			
			for(int j = 0; j < this.graph.getTotalNodes(); j++) {
				if(this.graph.arrayOfLinkedLists.get(j).linkedList.lastIndexOf(node) > 0) {
					isSource = false;
					break;
				}
			}
		
			if(isSource) {
				sources.add(node);
			}
		}
		
		return sources;
	}
	
	public List<List<List<Integer>>> getTopologicalEdges() {
		List<List<List<Integer>>> topologicalEdges = new ArrayList<>();
		List<List<Integer>> edges = new ArrayList<>();
		List<Integer> topologicalSort = this.getTopologicalSort();
		
		for(int i = 0; i < this.topologicalSort.size(); i++){
			edges = this.getEdges(topologicalSort.get(i));
			
			if(edges.size() > 0) {
				topologicalEdges.add(edges);
			}			
		}
		
		return topologicalEdges;
	}
	
	public List<List<Integer>> getEdges(int node){
		List<List<Integer>> edges = new ArrayList<>();
		
		for(int i = 0; i < this.graph.getTotalNodes(); i++) {
			List<Integer> linkedList = this.graph.arrayOfLinkedLists.get(i).linkedList;
			
			if(linkedList.get(0) == node && linkedList.size() > 1) {
				for(int j = 1; j < linkedList.size(); j++) {
					List<Integer> edge = new ArrayList<>();
					edge.add(linkedList.get(0));
					edge.add(linkedList.get(j));
					
					edges.add(edge);
				}
				
				break;
			}
		}
		
		return edges;
	}
	
	public boolean isConnected(int node1, int node2) {
		
		if(this.id.get(this.position(node1)) == this.id.get(this.position(node2))) {
			return true;
		}
		
		return false;
	}
	
	public int getId(int node) {
		return this.id.get(this.position(node));
	}
	
	public int getNumberOfConnectedComponents() {
		return this.count;
	}
	
	public List<Integer> getConnectedComponentsOfId(int id){
		List<Integer> connectedComponents = new ArrayList<>();
		
		for(int i = 0; i < this.graph.getTotalNodes(); i++) {
			if(this.id.get(i) == id) {
				connectedComponents.add(this.graph.arrayOfLinkedLists.get(i).linkedList.get(0));
			}
		}
		
		return connectedComponents;
	}
	
	public List<List<Integer>>getTheListsOfConnectedComponents() {
		List<List<Integer>> ListsOfConnectedComponents = new ArrayList<>();
		
		for(int i = 1; i < count; i++) {
			List<Integer> connectedComponents = new ArrayList<>();
			
			for(int j = 0; j < this.graph.getTotalNodes(); j++) {
				int firstElement = this.graph.arrayOfLinkedLists.get(j).linkedList.get(0);
				
				if(this.id.get(this.position(firstElement)) == i) {
					connectedComponents.add(firstElement);
				}
			}
			
			ListsOfConnectedComponents.add(connectedComponents);
		}
		
		return ListsOfConnectedComponents;
	}
}

