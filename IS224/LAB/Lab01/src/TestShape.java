
public class TestShape {

	public static void main(String[] args) {

		Shape rec = new Shape("Rectangle", 10, 20);
		Shape sq = new Shape("Square", 4, 4);

		System.out.println(rec);
		System.out.println(sq);

		System.out.println("Avg is = " + (rec.calculateArea() + sq.calculateArea()) 
				/ Shape.objectNumber);

		Shape.printObjectNumber();
		for (int i = 0; i < Shape.objectNumber; i++) {
			System.out.print("*");

		}
	}

}
