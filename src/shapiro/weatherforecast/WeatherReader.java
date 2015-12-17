package shapiro.weatherforecast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class WeatherReader {

	private WeatherForecast weather;

	public WeatherReader() throws IOException {

		String urlString = "http://api.openweathermap.org/data/2.5/forecast/daily?q=Queens&units=imperial&cnt=16&appid=2de143494c0b295cca9337e1e96b00e0";

		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();
		this.weather = gson.fromJson(reader, WeatherForecast.class);
		in.close();

	}

	public DayForecast[] getForecast() {
		return weather.getList();
	}

}
