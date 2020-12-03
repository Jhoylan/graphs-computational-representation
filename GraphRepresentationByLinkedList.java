package computationalRepresentation;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphRepresentationByLinkedList {
	int i = 0;
	int totalNodes;
	
	IntegerLinkedList[] arrayOfLinkedLists = new IntegerLinkedList[this.insertNodes()];
	
	int insertNodes() {
		IntegerInput nodes = new IntegerInput();
		System.out.println("Insert the number of the graph's nodes!");
		nodes.setNumber();
		this.totalNodes = nodes.getNumber();
		return this.totalNodes;
	
	}
	
	void populating() {
		
		for(int i = 0; i < arrayOfLinkedLists.length; i++) {
			System.out.print("Node " + (i + 1) + ", ");
			arrayOfLinkedLists[i] = new IntegerLinkedList(0);
			arrayOfLinkedLists[i].populating();
		}
	}
	
	void setArrayOfLinkedList(IntegerLinkedList list) {
		arrayOfLinkedLists[this.i] = new IntegerLinkedList(1);
		arrayOfLinkedLists[this.i].copyIntireList(list);
		
		this.i++;	
	}
	
	ArrayList<LinkedList<Integer>> getArrayOfLinkedList() {
		ArrayList<LinkedList<Integer>> array = new ArrayList<LinkedList<Integer>>();
		
		for(int i = 0; i < arrayOfLinkedLists.length; i++) {
			IntegerLinkedList linkedListObj = new IntegerLinkedList(1);
			linkedListObj.copyIntireList(arrayOfLinkedLists[i]);
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
		
		for(int i = 0; i < arrayOfLinkedLists.length; i++) {			
			thisArrayElements.copyIntireList(this.arrayOfLinkedLists[i]);			
			otherArrayElements.copyIntireList(otherArray.arrayOfLinkedLists[i]);
			
			if(!(thisArrayElements.equals(otherArrayElements))) {
				flag = false;
			}
		}
		
		return flag;
		
	}
	
}
