package shapiro.acm;

public class Rascal {
	public static int R(int n, int m) {
		int value;
		if (n < 0 || m < 0 || m > n) {
			return 0;
		}
		if (m == 0 || m == n) {
			return 1;
		}
		value = (R((n - 1), (m - 1)) * R((n - 1), m) + 1) / R((n - 2), (m - 1));
		return value;
	}
}
