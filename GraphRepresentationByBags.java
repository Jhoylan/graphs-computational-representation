package computationalRepresentation;

import java.util.ArrayList;

public class GraphRepresentationByBags {
	private static final int PREDETERMINED_CAPACITY = 10;
	
	BagOfIntegers[] arrayOfBags;
	
	public GraphRepresentationByBags() {
		this.arrayOfBags = new BagOfIntegers[PREDETERMINED_CAPACITY];	
		
		for(int i = 0; i < PREDETERMINED_CAPACITY; i++) {
			this.arrayOfBags[i] = new BagOfIntegers();
		}
	}
	
	//pass 0 for the constructor for manual input
	public GraphRepresentationByBags(int mode) {
		int nodes = this.insertNodes();
		if(mode == 0) {
			this.arrayOfBags = new BagOfIntegers[nodes];
			
			for(int i = 0; i < nodes; i++) {
				this.arrayOfBags[i] = new BagOfIntegers();
			}
		}
		
	}

	int insertNodes() {
		IntegerInput nodes = new IntegerInput();
		System.out.println("Insert the number of the graph's nodes!");
		nodes.setNumber();
		return nodes.getNumber();
	
	}
	
	void populating() {
		for(int i = 0; i < this.arrayOfBags.length; i++) {
			System.out.println("Insert the number of adjacent nodes of node " + (i + 1));
			
			IntegerInput adjacentNodes = new IntegerInput();
			adjacentNodes.setNumber();
			
			arrayOfBags[i] = new BagOfIntegers(adjacentNodes.getNumber() + 1);
			arrayOfBags[i].populating();
		}
	}
	
	void setArrayOfBags(BagOfIntegers bag, int index) {
		this.arrayOfBags[index] = bag;
	}
	
	
	ArrayList<int[]> getArrayOfIntArray(){
		ArrayList<int[]> array = new ArrayList<int[]>();
		
		for(int i = 0; i < this.arrayOfBags.length; i++) {
			BagOfIntegers bag = new BagOfIntegers();
			bag.copyIntireBag(this.arrayOfBags[i]);
			array.add(i, bag.getBag());
		}
		
		return array;
	}
	
	boolean isEmpty() {
		boolean flag = true;
		
		for(int i = 0; i < this.arrayOfBags.length; i++) {			
			if(!this.arrayOfBags[i].isEmpty()) {	
				flag = false;
				break;
			}
		}
		
		return flag;
	}
	
	void show() {
		ArrayList<int[]> arrayOfInt = new ArrayList<int[]>();
		arrayOfInt = this.getArrayOfIntArray();	
		
		System.out.print("G = [");
		
		for(int i = 0; i < arrayOfInt.size(); i++) {
			int[] array = arrayOfInt.get(i);
			
			System.out.print("[");
			
			for(int j = 0; j < array.length; j++) {
				System.out.print(array[j]);
				if(j < array.length - 1) System.out.print(", ");
			}
			
			System.out.print("]");
			
			if(i < arrayOfInt.size() - 1)System.out.print(", ");
		}
		
		System.out.println("]");
	}
	
	@Override
	public boolean equals(Object other) {
		if(this == other) return true;
		if(!(other instanceof GraphRepresentationByBags)) return false;
		
		GraphRepresentationByBags otherArrayOfBags = (GraphRepresentationByBags) other;
		
		boolean flag = true;
		
		for(int i = 0; i < this.arrayOfBags.length; i++) {
					
			if(!(this.arrayOfBags[i].equals(otherArrayOfBags.arrayOfBags[i]))) flag = false; 
		}
		
		return flag;
	}
}

