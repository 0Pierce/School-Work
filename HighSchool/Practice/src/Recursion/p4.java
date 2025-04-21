package Recursion;

public class p4 {
	
	
	public static void main(String[] args) {
		
		String word = "obo";
		
		
		if(isPalindrome(word)) {
			System.out.println("It is a palindrome");
		}
		else {
			
			System.out.println("Is not a palindrome");
		
		}
		
		
		
		
	}
	
	
	
	
	public static boolean isPalindrome(String word) {

		if (word.length() == 1 || word.length() == 0) {
			return true;
		}
		
		if(word.charAt(0) == word.charAt(word.length()-1)) {
			return isPalindrome(word.substring(1,word.length() -1));
			
			//return isPalindrome(Word.substring(1, Word.length()-1));
		}
		
		return false;
		
		
		
		
		
	}

}
