package shapiro.weatherforecast;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ForecastReaderThread extends Thread {
	private ForecastPanel[][] forecast;

	public ForecastReaderThread(ForecastPanel[][] forecast2) {
		forecast = forecast2;
	}

	@Override
	public void run() {
		try {
			WeatherReader reader = new WeatherReader();
			GregorianCalendar today = new GregorianCalendar();
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			for (int row = 0; row < forecast.length; row++) {
				for (int column = 0; column < forecast[0].length; column++) {
					DayForecast thisDayForecast = reader.getForecast()[(row + 1)
							* (column + 1) - 1];
					forecast[row][column].setDate(formatter.format(today
							.getTime()));
					today.add(Calendar.DAY_OF_MONTH, 1);
					forecast[row][column].setMin(thisDayForecast.getTemp()
							.getMin());
					forecast[row][column].setMax(thisDayForecast.getTemp()
							.getMax());
					forecast[row][column].setDescription(thisDayForecast
							.getWeather()[0].getDescription());
					forecast[row][column]
							.setIcon(thisDayForecast.getWeather()[0].getIcon());
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
