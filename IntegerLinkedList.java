package computationalRepresentation;

import java.util.LinkedList;

public class IntegerLinkedList {
	LinkedList<Integer> linkedList = new LinkedList<Integer>();
	int size;
	int mode;
	
	IntegerLinkedList(int mode) {
		//0 for user input 
		this.mode = mode;
		if(mode == 0) {
			IntegerInput nodes = new IntegerInput();
			System.out.println("Insert the number of adjacent nodes!");
			nodes.setNumber();
			this.size = nodes.getNumber();
		}else {
			size = 0;
		}
		
	}
	
	void populating() {
		if(mode == 0) {
			for(int i = 0; i < this.size + 1; i++) {
				IntegerInput numberObj = new IntegerInput();
				
				System.out.println("Insert the node and the adjacent(s) node(s)!");
				
				numberObj.setNumber();
				int number = numberObj.getNumber();
				
				linkedList.add(number);
			}
		}
		
	}
	
	
	LinkedList<Integer> getLinkedList(){
		return linkedList;
	}
	
	void setLinkedListElement(int number) {
		linkedList.addLast(number);
		this.size++;
	}
	
	void copyIntireList(IntegerLinkedList list) {
		this.linkedList = list.linkedList;
	}
	
	void setIntireList(LinkedList<Integer> list) {
		this.linkedList = list;
	}
	
	void deleteIndexedElement(int index) {
		linkedList.remove(index);
	}
	
	void deleteFirstOccurece(int element) {
		linkedList.removeFirstOccurrence(element);
	}
	
	
	@Override
	public boolean equals(Object list) {
		if(this == list) {   	
			return true;
		}
		
		if(!(list instanceof IntegerLinkedList)) {
			return false;
		}
		
		IntegerLinkedList other = (IntegerLinkedList) list;
		
		boolean linkedListEquals = (this.linkedList == null && other.linkedList == null) 
				|| (this.linkedList != null && this.linkedList.equals(other.linkedList));
		
		return linkedListEquals;
	}
}
