package shapiro.physics;

public class Projectile {
	private double angle;
	private double velocity;
	private double time;
	private double radians;

	public Projectile(double angle, double velocity, double time) {
		this.angle = angle;
		this.velocity = velocity;
		this.time = time;
		this.radians = Math.toRadians(angle);
	}

	public double getX() {
		double x = (Math.sin(radians)) * velocity * time;
		return x;
	}

	public double getY() {
		double y = (Math.cos(radians)) * velocity * time - (.5 * 9.8 * time * time);
		return y;
	}
	
	public void setTime(double newTime) {
		this.time = newTime;
	}
}
