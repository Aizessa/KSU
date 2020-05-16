
public class MyArrayFactory {
	
	public static <T extends Comparable <T>> MyArray<T> getMyArray(int n) {
		return new MyImplementation <T>(n); 
	}

}
