import java.util.Scanner;

public class RecursivePalindrome {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a word without caps or spaces or punctiation");
		String word = input.nextLine();
		
		if(isPalindrome(word)) {
			System.out.println(word + " Is a palindrome");
		}
		else {
			System.out.println(word + " Is not a palindrome");
		}
		
	}
	
	
	public static boolean isPalindrome(String Word) {
		
		if(Word.length() == 0 || Word.length() == 1) {
			return true;
		}
		
		
		//Like an array. Word.length = last index
		if(Word.charAt(0) == Word.charAt(Word.length()-1)) {
			
			return isPalindrome(Word.substring(1, Word.length()-1));
			
		}
		
		return false;
		
		
		
		
		
		
		
		
	}

}
