package QuadrilateralHierarchy;

public class QuadrilateralTest {
	
	public static void main(String[] args) {
		
		Quadrilateral q1 = new Quadrilateral(new Point(1.1, 1.2), new Point(6.6, 2.8), new Point(6.2, 9.9), new Point(2.2, 7.4));
		
		System.out.printf("Coords are: \n%s \n", q1.toString());
		
		Trapezoid t1 = new Trapezoid(new Point(0.0, 0.0), new Point(10.0, 0.0), new Point(8.0, 5.0), new Point(2.0, 5.0));

		System.out.printf("Coords for the Trapezoid are: \n%s \n", t1);
		System.out.printf("Height is %.2f \n", t1.getHeight());
		System.out.printf("Height is %.2f \n", t1.getBaseandArea());

		Rectangle r1 = new Rectangle(new Point(0.5, 0.0), new Point(10.0, 0.3), new Point(8.0, 5.0), new Point(2.0, 5.0));

		
		System.out.printf("Coords for the rectangle are: \n%s \n", r1);
		System.out.printf("Width is %.2f \n", r1.getWidth());
		System.out.printf("Height is %.2f \n", r1.getHeight());
		System.out.printf("Area is %.2f \n", r1.getArea());
		
	
		Square s1 = new Square(new Point(0.5, 0.0), new Point(10.0, 0.3), new Point(8.0, 5.0), new Point(2.0, 5.0));

		System.out.printf("Coords for the square are: \n%s \n", s1);
		System.out.printf("Area is %.2f \n", s1.getArea());
	
		
		Parallelogram p1 = new Parallelogram(new Point(0.5, 0.0), new Point(10.0, 0.3), new Point(8.0, 5.0), new Point(2.0, 5.0));


		System.out.printf("Coords for the square are: \n%s \n", p1);
		System.out.printf("Height is %.2f \n", p1.getHeight());
		System.out.printf("Width is %.2f \n", p1.getWidth());
		System.out.printf("Area is %.2f \n", p1.getArea());
		
	}

}
