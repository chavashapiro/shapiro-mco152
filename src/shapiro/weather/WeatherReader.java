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
	private double temp;
	private String description;
	private URL iconUrl;
	private CurrentWeather weather;

	public WeatherReader(String zip) throws IOException {
		this.zip = zip;

		StringBuilder urlString = new StringBuilder();
		urlString.append("http://api.openweathermap.org/data/2.5/weather?zip=");
		urlString.append(zip);
		urlString
				.append(",us&appid=7b82d3b32c91d0f6460ccdcdb396ea33&units=imperial");

		URL url = new URL(urlString.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();
		this.weather = gson.fromJson(reader, CurrentWeather.class);
		in.close();

		this.temp = weather.getMain().getTemp();
		this.description = weather.getWeather().getDescription();
		StringBuilder iconBuilder = new StringBuilder();
		iconBuilder.append("http://openweathermap.org/img/w/");
		iconBuilder.append(weather.getWeather().getIcon());
		iconBuilder.append(".png");
		this.iconUrl = new URL(iconBuilder.toString());
	}

	public double getTemp() {
		return this.temp;
	}

	public String getDescription() {
		return this.description;
	}

	public URL getIconUrl() {
		return this.iconUrl;
	}

}
