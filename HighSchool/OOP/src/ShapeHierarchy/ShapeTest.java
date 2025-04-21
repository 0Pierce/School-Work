package ShapeHierarchy;

import java.util.ArrayList;

public class ShapeTest {
	
	public static void main(String[] args) {
		
		//Array list
		ArrayList<shape> shapeList = new ArrayList<shape>();
		
		
		
		shapeList.add(new Circle(1));
		shapeList.add(new Circle(2));
		
		shapeList.add(new Sphere(1));
		shapeList.add(new Sphere(2));
		
		
		//: Means comes from
		for(shape currentShape : shapeList) {
			
			//Displays Radius
			System.out.println(currentShape);
			
			//Displays area
			System.out.printf("The Area is: %.2f units units squared\n", currentShape.calcArea());
			
			//If you happen to be a 3d shape then do this code
			if(currentShape instanceof ThreeDShape) {
				
				//Down casting - Forces it to turn into a 3d shape? (Temp variable)
				ThreeDShape ThreeDimShape = (ThreeDShape)currentShape;
				
				//Casts the sphere class?
				System.out.printf("The volume is: %.2f units cubed ", ((Sphere) currentShape).calcVolume());
				
			}
			
			
			
		}
		
		
	}

}
