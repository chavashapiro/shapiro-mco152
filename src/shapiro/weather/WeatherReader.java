package shapiro.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class WeatherReader {
	private String zip;
	private String temp;
	private String description;
	private URL iconUrl;

	public WeatherReader(String zip) throws IOException {
		this.zip = zip;

		StringBuilder urlString = new StringBuilder();
		urlString.append("http://");
		urlString.append("http://api.openweathermap.org/data/2.5/weather?zip=");
		urlString.append(zip);
		urlString.append(",us&appid=2de143494c0b295cca9337e1e96b00e0&units=imperial");

		URL url = new URL(urlString.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();
		CurrentWeather weather = gson.fromJson(reader, CurrentWeather.class);
		in.close();
	}

}
