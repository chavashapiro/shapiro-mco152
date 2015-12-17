package shapiro.weatherforecast;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class WeatherForecastFrame extends JFrame {
	private ForecastPanel[][] forecast;

	public WeatherForecastFrame() {
		setTitle("16 Day Weather Forecast for Queens County");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new GridLayout(2, 8));

		forecast = new ForecastPanel[2][8];
		for (int row = 0; row < forecast.length; row++) {
			for (int column = 0; column < forecast[0].length; column++) {
				forecast[row][column] = new ForecastPanel();
				forecast[row][column].setBorder(BorderFactory
						.createLineBorder(Color.BLACK));
				add(forecast[row][column]);
			}
		}

		ForecastReaderThread thread = new ForecastReaderThread(forecast);
		thread.start();
	}

	public static void main(String[] args) {
		new WeatherForecastFrame().setVisible(true);
	}
}
