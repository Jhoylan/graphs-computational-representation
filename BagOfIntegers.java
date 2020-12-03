package computationalRepresentation;

public class BagOfIntegers {
	private static final int PREDETERMINED_CAPACITY = 10;
	private int count;
	private int[] bag;
	
	public BagOfIntegers() {
		this.count = 0;
		this.bag = new int[PREDETERMINED_CAPACITY];
		
	}
	
	public BagOfIntegers(int initialCapacity) {
		if(initialCapacity > 0) {
			this.count = 0;
			this.bag = new int[initialCapacity];
			}else {
			throw new IllegalArgumentException("The specified initial capacity of the bag is invalid: " + initialCapacity + 
					", it must be greater than 0!");
		}
	}
	
	public void populating() {
		for(int i = 0; i < this.bag.length; i++) {
			IntegerInput numberObj = new IntegerInput();
			
			System.out.println("Insert the node and the adjacent(s) node(s)!");
			
			numberObj.setNumber();
			int number = numberObj.getNumber();
			
			this.add(number);
		}
		
	}
	
	public void add(int number) {
		if(number == 0) System.out.println("Insert a value different than 0!");
		else if(this.bag.length == this.size()) {
				System.err.println("The bag is full!");
			}else {
				for(int i = 0; i < bag.length; i++) {
					if(bag[i] == 0) {
						this.bag[i] = number;
						break;
					}
				}
			this.count++;
			}
	}
		
		
	
	
	public void addIntireBag(int[] array) {
		this.bag = array;
		this.count = 0;
		for(int i = 0; i < this.bag.length; i++) {
			if(this.bag[i] != 0) {
				this.count++;
			}
		}
	}
	
	public void copyIntireBag(BagOfIntegers otherBag) {
		this.bag = otherBag.bag;
		this.count = otherBag.count;
	}
	
	public boolean isEmpty() {
		boolean flag = true;
		
		for(int i = 0; i < this.bag.length; i++) {
			if(this.bag[i] != 0) flag = false;
		}
		
		return flag;
	}
	
	public int size() {
		return this.count;
	}
	
	public int[] getBag() {
		return this.bag;
	}
	
	@Override
	public boolean equals(Object other) {
		if(this == other) return true; 
		
		if(!(other instanceof BagOfIntegers)) return false;
		
		BagOfIntegers otherBag = (BagOfIntegers) other;
		
		boolean flag = true;
		
		for(int i = 0; i < this.bag.length; i++) {
			if(this.bag[i] != otherBag.bag[i]) {
				flag = false;
			}
		}
		
		return flag;
	}
	
}
