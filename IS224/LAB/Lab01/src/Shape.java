
public class Shape {
	private String name;
	private int height;
	private int width;
	public static int objectNumber = 0;

	public Shape(String name, int height, int width) {
		this.name = name;
		this.height = height;
		this.width = width;
		objectNumber++;

	}

	public double calculateArea() {
		return height * width;
	}

	public static void printObjectNumber() {
      System.out.println("Number of objects is : " + objectNumber);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public String toString() {
		return "Shape Name is " + name +" , Area = " + calculateArea() ;
	}

}
