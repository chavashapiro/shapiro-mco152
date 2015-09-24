package shapiro.quadratic;

public class QuadraticEquation {
	private double a;
	private double b;
	private double c;

	public QuadraticEquation(double a, double b, double c) throws InvalidDataException {
		// "a" or "b" can't be 0 because then either the denominator or
		// inside the square root will be 0 so throw exception if one of them is
		// 0
		if (a == 0 || b == 0) {
			throw new InvalidDataException();
		}
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getPositiveX() {
		double x = (-b + (Math.sqrt((b * b) - (4 * a * c)))) / (2 * a);
		return x;
	}

	public double getNegativeX() {
		double x = (-b - (Math.sqrt((b * b) - (4 * a * c)))) / (2 * a);
		return x;
	}
}
