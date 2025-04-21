import NumbersRational.Rational;

public class HugeIntegerTest {
	
	
	public static void main(String[] args) {
		
		
		
		int num1array[] = {2,2,3,4,5};
		
		int num2array[] = {2,2,3,4,5};
		
		int num3array[] = {1,3,3,4,5};
		
		
		
		HugeInteger num1 = new HugeInteger(num1array);
		HugeInteger num2 = new HugeInteger(num2array);
		HugeInteger num3 = new HugeInteger(num3array);
		
		
		
		System.out.println(num1.isGreaterThanOrEqualTo(num2));
		System.out.println(num2.isGreaterThanOrEqualTo(num3));
	}

}
