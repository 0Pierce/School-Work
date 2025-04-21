package RectangleEnhanced;

public class EnhancedRectangleTest {
	
	
	public static void main(String[] args) {
	
		Point[] point = new Point[4];
		
		
		
		//Assigning coords to test the rectangle
		point[0] = new Point(0,0);
		point[1] = new Point(0,2);
		point[2] = new Point(5,2);
		point[3] = new Point(3,0);
		
				
		EnhancedRectangle myRect = new EnhancedRectangle(point);
		
		
		if(myRect.isRect()) {
			System.out.println("Rectangle Created");
		}else {
			System.out.println("Points do not form a rectangle");
		}
		
		if(myRect.isSquare())
			System.out.println("Rectangle is a square");
		else {
			System.out.println("Rectangle is not a squsre");
		}
		
		
		
		System.out.println("Sveiki! - Lithuanian");
		System.out.printf("Length %.2f units \n", myRect.getLength());
		System.out.printf("Width %.2f units \n", myRect.getWidth());
		System.out.printf("Perimeter %.2f units \n", myRect.getPerimeter());
		System.out.printf("Area %.2f units \n", myRect.getArea());
		
		System.out.println();
		
		myRect.getPoint()[0].setY(0.5);
		
		if (myRect.isRect())
			System.out.println("Rectangle Created");
		else {
			System.out.println("Points do not form a rectangle");
		}
		
		
		
	}
	
	
	
	

}
