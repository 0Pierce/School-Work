package A3;

public class Lab3 {
	
//Main method
	public static void main(String[] args) {
		
		//Method call
		System.out.println(getProduct(5,2));
		System.out.println(isPalindrome("olo"));
	}
	
	
	
	
	public static int getProduct(int m, int n) {
		
		//N is 1, simply return m since its 1*m
        if (n == 1) {
            return m;
        }
      
       //Proceed with recursion calculations
        if (n > 0) {
            return m + getProduct(m, n - 1);
        } else {
            return -m + getProduct(m, n + 1);
        }
    
	}
	
    public static boolean isPalindrome(String s) {
      
    	//Checks if the string has 1 or 0 characters, if so return true
        if (s.length() == 0 || s.length() == 1) {
            return true;
      
        } else {
        //Checking the front and back of the string, comparing them
        	//If correct we continue the recursion until we have checked througjout the string
            if (s.charAt(0) == s.charAt(s.length() - 1)) {
            	//At the end we return one last time
                return isPalindrome(s.substring(1, s.length() - 1));
            } else {
              //retrun false
                return false;
            }
        }
    }
	
	

}
