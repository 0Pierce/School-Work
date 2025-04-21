package Recursion2;

public class ReverseWords {
	
	public static void main(String[] args) {
		
		String phrase = "I am running fast";
		
		System.out.println(reverseWords(phrase));
		
	}
	
	/*
	 * For the BASE CASE:
	 *  no space character found so the current phrase is just a single word,
	 *  then return phrase itself
	 *  For the recursive call:
	 *  -Return first the recursively reversed rest of the current phrase
	 *  (Not including the leading space), followed by a space character
	 *  and then the first word is in the current phrase
	 */
	
	
	private static String reverseWords(String phrase) {
		
		int position = phrase.indexOf(" "); //Determine the position of the first space within the phrase
		
		if(position == -1) {
			System.out.println("Entered if");
			return phrase;
		}else {
			
			System.out.println("Entered else");
			System.out.println(phrase);
			return reverseWords(phrase.substring(position +1)) + " " + phrase.substring(0, position);
		}
		
		
		
	}

	
	
	
}
