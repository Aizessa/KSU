
public class FibPb {

	public static int nbFibLeq(long n) {

		int count, f1, f2, fn;
		count = 1;
		f1 = 1;
		f2 = 1;
		fn = 0;

		if (n > 0) {

			for (int i = 0; i <= n; i++)
				if (fn <= n) {
					fn = f1 + f2;
					f1 = f2;
					f2 = fn;
					count++;

				}
			return count;

		}
		return 0;

	}
}
