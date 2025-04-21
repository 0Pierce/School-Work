
public class Power {
	static int count = 0;
	
	public static void main(String[] args) {
		
		System.out.println("Main");
		
		int count,base = 5,exp = 3;
		int answer = power(base, exp);
		
		
		System.out.println(answer);
		
	}
	
	public static int power(int base, int exp) {
		
		
		if(exp != 0) {
			return (base * power(base,exp -1));
		}
		else {
			return 1;
		}
		
		
		
		
		
	}
	

}
