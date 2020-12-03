package computationalRepresentation;

import java.util.Scanner;

public class IntegerInput {
	Scanner input = new Scanner(System.in);
	private int number;
	
	void setNumber() {
		number = input.nextInt();
	}
	
	int getNumber() {		
		return number;
	}
}
