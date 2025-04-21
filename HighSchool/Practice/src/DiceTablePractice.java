import java.util.Random;

public class DiceTablePractice {
	
	
	public static void main(String[] arg) {
		
		int[] results = new int[36002];
		
		int amount = 36000;
		
		Random rand1 = new Random(6);
		
		for(int i = 0; i < amount; i++) {
			System.out.println(rand1.nextInt(7) + "  ");
			
			
			
			
		}
		
		
	}

}
