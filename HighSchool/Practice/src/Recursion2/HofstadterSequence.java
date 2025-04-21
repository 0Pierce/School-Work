package Recursion2;

public class HofstadterSequence {
	
	
	public static void main(String[] args) {
		
		int n = 2000;
		
		System.out.println(qSequence(n));
		
		
		
	}
	
	
	private static int qSequence(int n) {
		
		if(n == 1 || n == 2) { //Base case
			return 1;
		}else {
					//Recursive call
			return qSequence(n - qSequence(n-1)) + qSequence(n-qSequence(n-2));
			
			
		}
			
		
		
	}

}
