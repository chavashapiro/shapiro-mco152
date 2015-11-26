package shapiro.pi;

import javax.swing.JLabel;

public class PiCalculationThread extends Thread {

	private JLabel label;

	public PiCalculationThread(JLabel label) {
		this.label = label;
	}

	@Override
	public void run() {
		// code that execute on different thread not main
		PiCalculator calc = new PiCalculator(100000000L);
		this.label.setText(String.valueOf(calc.getPi()));
	}
}
