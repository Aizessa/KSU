public interface MyArray<T extends Comparable<T>> {
	// Return the element at position i
	T get(int i);

	// Set the element at position i
	void set(int i, T e);

	// Return the index of smallest element in the array ( index of first
	// occurrence returned )
	int min();

	// Return the index of largest element in the array ( index of first
	// occurrence returned )
	int max();

	// Return the number of elements largest or equal e1 and smallest or equal
	// e2
	int nbBetween(T e1, T e2);
}