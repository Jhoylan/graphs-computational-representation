package computationalRepresentation;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphRepresentationByLinkedList {
	private int totalNodes;
	private int mode;
	
	ArrayList<IntegerLinkedList> arrayOfLinkedLists = new ArrayList<>();
	
	public GraphRepresentationByLinkedList(int mode) {
		this.mode = mode;
	}
	
	void populating() {
		if(this.mode == 0) {
			System.out.println("Insert the number of nodes!");
			
			IntegerInput nodes = new IntegerInput();
			nodes.setNumber();
			
			this.totalNodes = nodes.getNumber();
			
			for(int i = 0; i < this.totalNodes; i++) {
				System.out.print("Node " + (i + 1) + ", ");
				
				arrayOfLinkedLists.add(new IntegerLinkedList(0));
				arrayOfLinkedLists.get(i).populating();
			}
		}
		
	}
	
	void setLinkedList(IntegerLinkedList list, int index) {
		arrayOfLinkedLists.set(index, list);
	}
	
	void addLinkedList(IntegerLinkedList list) {
		arrayOfLinkedLists.add(list);
		this.totalNodes++;
	}
	
	ArrayList<LinkedList<Integer>> getArrayOfLinkedList() {
		ArrayList<LinkedList<Integer>> array = new ArrayList<LinkedList<Integer>>();
		
		for(int i = 0; i < arrayOfLinkedLists.size(); i++) {
			IntegerLinkedList linkedListObj = new IntegerLinkedList(1);
			linkedListObj.copyIntireList(arrayOfLinkedLists.get(i));
			LinkedList<Integer> list = linkedListObj.getLinkedList();
			
			array.add(i, list);
		}
		
		return array;   
	}
	
	void show() {
		ArrayList<LinkedList<Integer>> array = this.getArrayOfLinkedList();
		
		System.out.print("G = [");
		
		for(int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i));
			if(i < array.size() - 1) System.out.print(", ");
		}
		
		System.out.println("]");
	}
	
	public int getTotalNodes() {
		return this.totalNodes;
	}
	
	
	@Override
	public boolean equals(Object array) {
		if(this == array) {
			return true;
		}
		
		if(!(array instanceof GraphRepresentationByLinkedList)) {
			return false;
		}
		
		boolean flag = true;
		
		IntegerLinkedList thisArrayElements = new IntegerLinkedList(1);
		IntegerLinkedList otherArrayElements = new IntegerLinkedList(1);
		
		GraphRepresentationByLinkedList otherArray = (GraphRepresentationByLinkedList) array;
		
		for(int i = 0; i < arrayOfLinkedLists.size(); i++) {			
			thisArrayElements.copyIntireList(this.arrayOfLinkedLists.get(i));			
			otherArrayElements.copyIntireList(otherArray.arrayOfLinkedLists.get(i));
			
			if(!(thisArrayElements.equals(otherArrayElements))) {
				flag = false;
			}
		}
		
		return flag;
		
	}
	
}
