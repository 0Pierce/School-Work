package NumbersRational;

public class Rational {

	private int numerator;
	private int denominator;

	// Constructor
	public Rational(int numerator, int denominator) {

		this.numerator = numerator;
		this.denominator = denominator;

		int temp = Math.abs(numerator);

		// Checks if the fraction can be divided
		for (int i = temp; i >= 2; i--) {

			if (numerator % i == 0 && denominator % i == 0) {

				numerator = numerator / i;
				denominator = denominator / i;

			}

		}
		this.numerator = numerator;
		this.denominator = denominator;

	}

	public String displayRational() {

		if (denominator == 0) {
			return "Not defined";
		} else if (numerator == 0)
			return "0";
		else {
			return numerator + "/" + denominator;

		}

	}

	// Substraction
	public Rational sub(Rational r2) {

		Rational r3 = new Rational(numerator * r2.denominator - r2.numerator * denominator,
				denominator * r2.denominator);

		return r3;

	}

	public Rational add(Rational r2) {

		Rational r3 = new Rational(numerator * r2.denominator + r2.numerator * denominator,
				denominator * r2.denominator);

		return r3;

	}

	public Rational mult(Rational r2) {

		Rational r3 = new Rational(numerator * r2.numerator, denominator * r2.denominator);

		return r3;

	}

	public Rational division(Rational r2) {

		Rational r3 = new Rational(numerator * r2.denominator, denominator * r2.numerator);

		return r3;
	}
	
	
	public String displayRationalDec(int digits) {
		
		return String.format("%." +digits+"f", (double)numerator/denominator);
		
		
		
		
	}
	

}
