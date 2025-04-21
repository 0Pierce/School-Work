import java.util.Scanner;

public class ShapeTest {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Would you like 2D shapes or 3D Shapes? (Use Caps)");
		String shape = input.nextLine();
		
		Rectangle r1 = new Rectangle();
		
		if(shape == "2D") {
			
			System.out.println("What shape would you like?");
			String TwoD = input.nextLine();
			
			
			
			
			
			if(TwoD == "Rectangle") {
				
				
				
				//Organism organism = (Animal)currentOrganism;
				
				System.out.println();
				
				
			}else if(TwoD == "Triangle") {
				
				
			}
			
			
			
		}else if(shape == "3D") {
			
		}else {
			System.out.println("Invalid input");
		}
		
		
		
	}

}
