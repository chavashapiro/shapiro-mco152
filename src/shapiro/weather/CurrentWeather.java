package shapiro.weather;

public class CurrentWeather {
	private Weather[] weather;
	private Main main;

	public CurrentWeather() {

	}

	public Weather getWeather() {
		return weather[0];
	}

	public Main getMain() {
		return main;
	}
}
