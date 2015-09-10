package shapiro.physics;

public class ProjectileMain {
	public static void main(String[] args) {
		double angle = 31;
		double velocity = 20;
		double time = 2.7;

		Projectile baseball = new Projectile(angle, velocity, time);
		
		for(int i = 0; i <= 10; i++) {
			baseball.setTime(i);
			double x = baseball.getX();
			double y = baseball.getY();
			System.out.println("x= " + x);
			System.out.println("y= " + y);
		}
	}

}

