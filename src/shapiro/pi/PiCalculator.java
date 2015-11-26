package shapiro.pi;

public class PiCalculator {

	private double pi;
	private boolean positive;
	private long iterations;

	public PiCalculator(long iteration) {

		positive = true; // if u plus, if 1 minus
		iterations = iteration;
		calculatePi();
	}

	private void calculatePi() {
		for (double denom = 1; denom < iterations * 2; denom = denom + 2) {
			if (positive) {
				pi += 4 / denom;

			} else {
				pi -= 4 / denom;

			}
			positive = !positive;

		}
	}

	public double getPi() {
		return pi;
	}
}
