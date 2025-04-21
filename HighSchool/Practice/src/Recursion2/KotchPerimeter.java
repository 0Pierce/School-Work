package Recursion2;

public class KotchPerimeter {
	
	public static void main(String[] args) {
		
		
		
		
		System.out.println(perimeter(9,3));
		
	}
	
	
	public static int perimeter(double len, int n) {
		
		if(n == 0) {
			return  (int) (len * 3);
		}else {
			return  (int) ((double) 4/3 * perimeter(len, n-1));
		}
		
		
		
	}

}
