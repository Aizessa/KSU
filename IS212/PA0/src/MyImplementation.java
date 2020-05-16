
public class MyImplementation<T extends Comparable<T>> implements MyArray<T> {
	private T[] arr;

	public MyImplementation(int size) {
		arr = (T[]) new Comparable[size];
	}

	public T get(int i) {
		return arr[i];

	}

	// Set the element at position i
	public void set(int i, T e) {
		arr[i] = e;
	}

	// Return the index of smallest element in the array ( index of first
	// occurrence returned )
	public int min() {
		T min;
		min = arr[0];

		int index = 0;
		for (int i = 1; i < arr.length; i++) {

			if (min.compareTo(arr[i]) > 0) {
				min = arr[i];
				index = i;
			}
		}
		return index;

	}

	// Return the index of largest element in the array ( index of first
	// occurrence returned )
	public int max() {
		T max;
		max = arr[0];
		int index = 0;
		for (int i = 1; i < arr.length; i++) {
			if (max.compareTo(arr[i]) < 0) {
				max = arr[i];
				index = i;
			}
		}
		return index;
	}

	// Return the number of elements largest or equal e1 and smallest or equal
	// e2
	public int nbBetween(T e1, T e2) {
		int nb;
		nb = 0;
		for (int i = 0; i < arr.length; i++) {
			if (e1.compareTo(arr[i]) <= 0 && e2.compareTo(arr[i]) >= 0) {
				nb++;
			}

		}
		return nb;
	}

}
