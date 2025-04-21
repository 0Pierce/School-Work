import RectangleEnhanced.Point;

/*
 * Create a field array
 * 
 * 
 * 
 * Create input output and add/sub methods
 * 		-For input use a for loop to put the entered number into different indexes
 * 
 * 
 * 
 * 
 * Create all other remaining methods
 * 		Returns true if the relationship is true
 * 
 * 
 */

public class HugeInteger {

	// Field

	private int[] Array;

	// constructor
	public HugeInteger(int i) {

		this.Array = new int[i];

	}

	public HugeInteger(int[] numArray) {

		this.Array = numArray;
	}

	public void HugeIntegerInput() {
		this.Array = Array;

	}

	// I swapped it from is not equal to to isEqual to
	public boolean isEqualTo(HugeInteger UserNum) {

		// Is the length the same?
		if (Array.length == UserNum.Array.length) {

			// Go through the entire Array
			for (int i = 0; i < Array.length; i++) {

				// If Two digits are equal keep checking
				// If not break the loop and returns false
				if (Array[i] == UserNum.Array[i]) {
					continue;

				} else {
					return false;
				}
			}

			return true;

			// If not dont bother checking digits just exit
		} else {
			return false;
		}

	}

	public boolean isGreaterThan(HugeInteger UserNum) {

		if (Array.length > UserNum.Array.length) {
			return true;
		} else if (Array.length < UserNum.Array.length) {
			return false;
		}

		// If none of the ifs above are satisfied it means the Arrays are the same
		// length

		// If the first number is bigger then the other first number the Array with the
		// bigger
		// first number wins
		if (Array[0] > UserNum.Array[0]) {
			return true;

		}

		if (Array[0] == UserNum.Array[0]) {

			for (int i = 0; i < Array.length; i++) {

				if (Array[i] > UserNum.Array[i]) {
					return true;

				} else if (Array[i] == UserNum.Array[i]) {

					return false;
				}

			}

			

		}
		
		return false;

	}

	public boolean isLessThan(HugeInteger UserNum) {

		// Same as above
		if (Array.length < UserNum.Array.length) {
			return true;
		} else if (Array.length > UserNum.Array.length) {
			return false;
		}

		if (Array[1] < UserNum.Array[1]) {
			return true;

		} else
			return false;

	}

	public boolean isGreaterThanOrEqualTo(HugeInteger UserNum) {

		// Checks if the Length is greater
		if (Array.length > UserNum.Array.length || Array.length == UserNum.Array.length) {

			for (int i = 0; i < Array.length; i++) {

				// If Two digits are equal keep checking
				// If not break the loop and returns false
				if (Array[i] == UserNum.Array[i]) {

					// I the same size - Mean it went through the entire array
					

				} else {
					break;
				}

			}

		} else if (Array.length < UserNum.Array.length) {
			return false;
		}
		
		
		
			
			if(Array[1] > UserNum.Array[1]) {
				return true;
			}else if(Array[1] < UserNum.Array[1]) {
				return false;
			}
			
		

		// If the code made it this far, we are certain they are the same length
		

		// If it passes all checks this means the first Array is Either Greater or they
		// are the same
		return true;

	}

	public boolean isLessThanOrEqualTo(HugeInteger UserNum) {

		if (Array.length < UserNum.Array.length || Array.length == UserNum.Array.length) {

			for (int i = 0; i < Array.length; i++) {

				// If Two digits are equal keep checking
				// If not break the loop and returns false
				if (Array[i] == UserNum.Array[i]) {

					if (i == Array.length) {
						return true;
					}
					continue;

				} else {
					break;
				}

			}

		} else if (Array.length > UserNum.Array.length) {
			return false;
		}

		// If the code made it this far, we are certain they are the same length
		for (int i = 0; i > Array.length; i++) {
			if (Array[i] == UserNum.Array[i]) {
				continue;
			} else {
				return false;
			}

		}

		// If it passes all checks this means the first Array is Either Smaller or they
		// are the same
		return true;

	}

	public boolean isZero(HugeInteger UserNum) {

		// Probably could just check first number but i decided to add two checks
		// anyways

		// Checks if length is 0
		if (Array.length == 0) {
			return true;
		} else {

			// Checks if First number is zero
			if (Array[0] == 0) {
				return true;
			} else {
				return false;
			}

		}

	}

	// Addition
	public HugeInteger add(HugeInteger AddNum) {

		HugeInteger result = new HugeInteger(AddNum.Array.length);

		for (int i = Array.length - 1; i >= 0; i--) {

			result.Array[i] = result.Array[i] + Array[i] + AddNum.Array[i];

			if (result.Array[i] >= 10) {

				result.Array[i] = result.Array[i] % 10;

				if (i == 0)
					System.out.println("Stack error");
				else
					// ?
					result.Array[i - 1] = 1;
			}

		}

		return result;

	}

	// Prob wrong
	public HugeInteger sub(HugeInteger SubNum) {

		HugeInteger result = new HugeInteger(SubNum.Array.length);

		for (int i = Array.length - 1; i >= 0; i--) {

			result.Array[i] = result.Array[i] - Array[i] - SubNum.Array[i];

			if (result.Array[i] >= 10) {

				result.Array[i] = result.Array[i] % 10;

				if (i == 0)
					System.out.println("Stack error");
				else
					result.Array[i - 1] = 1;
			}

		}

		return result;

	}

}
