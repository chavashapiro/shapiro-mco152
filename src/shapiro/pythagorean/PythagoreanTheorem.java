package shapiro.pythagorean;

public class PythagoreanTheorem {
	private double a;
	private double b;
	private double c;

	public PythagoreanTheorem() {

	}

	public void setAB(double a, double b) {
		this.a = a;
		this.b = b;
		this.c = Math.sqrt((a * a) + (b * b));
	}

	public void setAC(double a, double c) {
		this.a = a;
		this.c = c;
		this.b = Math.sqrt((c * c) - (a * a));
	}

	public void setBC(double b, double c) {
		this.b = b;
		this.c = c;
		this.a = Math.sqrt((c * c) - (b * b));
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public double getC() {
		return c;
	}
}
