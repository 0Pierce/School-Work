package PartA;

/*
 * (Complex Class) Create a class called Complex for performing arithmetic with complex numbers. Complex numbers have the form:
realPart + imaginaryPart * i , where i  is the square root of -1

Write a program to test your class. Use floating-point variables to represent the private data of the class. 
Provide a constructor that enables an object of this class to be initialized when it is declared. 
Provide a no-argument constructor with default values in case no initializers are provided.

Provide public methods that perform the following operations: 

Add two Complex numbers: The real parts are added together and the imaginary parts are added together. 
Subtract two Complex numbers: The real part of the right operand is subtracted from the real part of the left operand,
 and the imaginary part of the right operand is subtracted from the imaginary part of the left operand. 
Print Complex numbers in the form (a, b), where a is the real part and b is the imaginary part.
 */

public class Complex {

	// fields
	private double realPart;
	private double imaginaryPart;

	// Constructors
	public Complex(double realPart, double imaginaryPart) {
		super(); // Calls the super classes constructor method first

		// Associating the fields with parameters
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}

	// default Constructor
	public Complex() {
		super();
		realPart = 0.0;
		imaginaryPart = 0.0;
	}

	// Getters and setters; a pair for each field
	public double getRealPart() {
		return realPart;
	}

	public void setRealPart(double realPart) {
		this.realPart = realPart;
	}

	public double getImaginaryPart() {
		return imaginaryPart;
	}

	public void setImaginaryPart(double imaginaryPart) {
		this.imaginaryPart = imaginaryPart;
	}

	
	
		//toString method
		@Override
		public String toString() {
		return "Complex [realPart=" + realPart + ", imaginaryPart=" + imaginaryPart + "]";
	}

	// Utility methods
	public Complex addition(Complex c2){
		
		Complex c3 = new Complex();
		
		c3.setRealPart(this.realPart + c2.realPart);
		c3.setImaginaryPart(this.imaginaryPart + c2.imaginaryPart);
		
		return c3;
	}

	public Complex subtraction(Complex c2){
		
		Complex c3 = new Complex();
		
		c3.setRealPart(this.realPart - c2.realPart);
		c3.setImaginaryPart(this.imaginaryPart - c2.imaginaryPart);
		
		return c3;
	}
	
	
	//This method returns a formatted String of the complex number
	public String display() {
		
		return String.format("( %f, %f)", realPart, imaginaryPart);
	}

}
