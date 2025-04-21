package PartA;

public class ComplexTest {
	
	
	public static void main(String[] args) {
		
		Complex c1 = new Complex(3,2);
		Complex c2 = new Complex(4,-3);
		
		//Calls the custom made methods
		System.out.println(c1.addition(c2));
		System.out.println(c1.addition(c2).display());
		System.out.println(c1.subtraction(c2).display());
		
		Complex c3 = new Complex();
		
		System.out.println(c3.display());
		
	}

}
