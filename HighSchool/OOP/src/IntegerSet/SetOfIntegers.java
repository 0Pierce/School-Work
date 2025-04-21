package IntegerSet;

import java.util.Arrays;

public class SetOfIntegers {

	// Makes the Array a field
	private boolean[] numArray = new boolean[101];

	// Constructor

	public SetOfIntegers(boolean[] numArray) {

		this.numArray = numArray;

	}

	// No argue Constructor
	public SetOfIntegers() {

	}

	public void insertElement(int k) {

		numArray[k] = true;

	}

	public void deleteElement(int m) {

		numArray[m] = false;
	}

	public String toSetString() {
		
		String temp = "{";
		boolean empty = true;

		for (int i = 0; i < numArray.length; i++)
			if(numArray[i]) {
				empty = false;
				temp += i + " ";
				
				
			}
				if(empty)
					temp += "---}";
				else
					temp+="}";
				
				return temp;
				
			
			

	}

	public boolean[] getNumArray() {
		return numArray;
	}

	public void setNumArray(boolean[] numArray) {
		this.numArray = numArray;
	}

	public boolean isEqualTo(SetOfIntegers input) {

		for (int i = 0; i < numArray.length; i++)
			if (input.getNumArray()[i] == numArray[i]) {
				return true;
			}

		return false;

	}
	
	
	public SetOfIntegers intersection (SetOfIntegers otherset) {
		
		SetOfIntegers c = new SetOfIntegers();
		
		for(int j = 0; j < numArray.length; j++) {
			
			if(this.getNumArray()[j] == true && otherset.getNumArray()[j] == true) {
				c.getNumArray()[j] = true;
			}
		}
		
		return c;
	}
	
	
	public String toString() {
		
		
		return "Integer set" + Arrays.toString(numArray);
		
	}
	
	

}
