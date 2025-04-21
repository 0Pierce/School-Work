package Recursion2;

public class adding {
	
	public static void main(String[] args) {
		
		int num1 , num2;
		
		System.out.println(add(10,5));
		
		
		
		
		
		
	}
	
	
	public static int add(int num1, int num2) {
		
		
		if (num2 == 0) {
			System.out.println("Entered if");
			return num1;
		}else {
			System.out.println("Entered else");
			return add(++num1,--num2);
		}
		
	}
	
	

}
