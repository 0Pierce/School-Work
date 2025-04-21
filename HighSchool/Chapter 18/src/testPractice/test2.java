package testPractice;

public class test2 {
	
	
public static void main(String[] args) {
		
		

	}



	private static int mVolume(int n, int v) {
		
		if (n == -1) {
			return 1;
			
		}else {
			return mVolume(n /v) *n--;
		}
		
		
		
		
		
	}

}
