package computationalRepresentation;

import java.util.ArrayList;

public class DFS {
	GraphRepresentationByLinkedList graph = new GraphRepresentationByLinkedList();
	ArrayList<Integer> pi;
	ArrayList<Integer> discoveryTime;
	ArrayList<Integer> finalizationTime;
	ArrayList<String> color;
	int time = 1;
	
	public DFS() {
		this.graph.populating();
		this.graph.show();
	}
	
	public void dfsGraph() {
		this.initialization();
		
		for(int i = 0; i < graph.totalNodes; i++) {
			if (this.color.get(i) == "white") {
				dfsVisit(this.graph.arrayOfLinkedLists[i], i);
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
				this.dfsVisit(this.graph.arrayOfLinkedLists[adjVertexPosition], adjVertexPosition);
			}
		}
		
		this.color.set(node, "black");
		this.finalizationTime.set(node, this.time);
		this.time++;
	}
		
	private void initialization(){
		this.discoveryTime = new ArrayList<Integer>(graph.totalNodes);
		this.finalizationTime = new ArrayList<Integer>(graph.totalNodes);
		this.color = new ArrayList<String>(graph.totalNodes);
		this.pi = new ArrayList<Integer>(graph.totalNodes);
		
		for(int i = 0; i < graph.totalNodes; i++) {
			this.discoveryTime.add(i, 0);
			this.finalizationTime.add(i, 0);
			this.color.add(i, "white");
			this.pi.add(i, 0);
		}
		
	}
	
	public void show() {
		int minorTime = 1;
		int count = 0;
		int[] ascendingDiscoveryTime = new int[this.graph.totalNodes];
		
		for(int i = 0; i < this.graph.totalNodes; i++) {
			if(this.discoveryTime.get(i) == minorTime) {
				ascendingDiscoveryTime[count] = this.graph.arrayOfLinkedLists[i].linkedList.get(0);
				minorTime++;
				i = 0;
			}
		}
		
		System.out.println("The nodes discovery time in ascending order is: ");
		
		for(int i : ascendingDiscoveryTime) {
			System.out.print(i);
		}
		
		System.out.println();
		
		ArrayList<Integer> decreasingFinalizationTime = this.finalizationTime;
		
		for(int i = 1; i < decreasingFinalizationTime.size(); i++) {
			int max = decreasingFinalizationTime.get(0);
			
			if(decreasingFinalizationTime.get(i) > max) {
				max = decreasingFinalizationTime.get(i);
				int temp = decreasingFinalizationTime.get(i);
				decreasingFinalizationTime.add(i, decreasingFinalizationTime.get(i -1));
				decreasingFinalizationTime.add(i - 1, temp);
			}
		}
		
		System.out.println("The topological sort using decreasing is:");
		System.out.print(decreasingFinalizationTime);
		
	}
	
	public int position(int vertex) {
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
		System.out.println("The discovery time array is: " + this.discoveryTime);
		System.out.println("The finalization time array is: " + this.finalizationTime);
		System.out.println("The color array is: " + this.color);
		System.out.println("The pi array is: " + this.pi);
	}

}

