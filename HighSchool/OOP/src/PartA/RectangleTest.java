package PartA;

public class RectangleTest {

	public static void main(String[] args) {
		
		System.out.println("RECTANGLE 1 TEST");
		Rectangle r1 = new Rectangle(10.0 , 5.0);
		System.out.println(r1.getPerimeter());
		System.out.println(r1.getArea());
		r1.setLength(15.0);
		System.out.println(r1.getLength());
		
		System.out.println("RECTANGLE 2 TEST");
		Rectangle r2 = new Rectangle();
		System.out.println(r2.getPerimeter());
		System.out.println(r2.getArea());
		
		System.out.println("RECTANGLE 3 TEST");
		Rectangle r3 = new Rectangle(-5.0, 80);
		System.out.println(r2.getPerimeter());
		System.out.println(r2.getArea());
		
	}

}
