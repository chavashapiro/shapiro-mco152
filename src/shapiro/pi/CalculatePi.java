package shapiro.pi;

public class CalculatePi {

	public static void main(String args[]) {
		// calculate pi

		PiCalculator calc = new PiCalculator(100000000000L);
		System.out.println(calc.getPi());

		double pi = 0;
		double mathSign = 0; // if u plus, if 1 minus
		for (double denom = 1; denom < 1000000000; denom = denom + 2) {
			if (mathSign == 0) {
				pi += 4 / denom;
				mathSign++;
			} else {
				pi -= 4 / denom;
				mathSign--;
			}

		}
		System.out.printf("%.5f", pi);
		System.out.println("\n" + pi);

	}
}
