
public class Perfectnumner {
	
	public static void main(String[] args) {
		
		for (int num = 1; num <= 1000;num++) {
			
			if (perfect(num))
				System.out.printf("%d is perfect ", num);
		}
	}

	private static boolean perfect(int num) { // to accept num
		
		int total = 0;
		for (int factor = 1; factor < num; factor++)
			if (num % factor ==0)
				total +=factor;
		
		if (total == num)
			return true;
		else
			return false;
	}

}
