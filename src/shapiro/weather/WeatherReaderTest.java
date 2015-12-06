package shapiro.weather;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class WeatherReaderTest {
	// I wrote this test to test the weather reader but it won't run after i
	// wrote it because the
	// temperature is constantly changing

	@Test
	public void testWeatherReader() throws IOException {
		WeatherReader reader = new WeatherReader("11367");
		Assert.assertEquals("scattered clouds", reader.getDescription());
		Assert.assertEquals("http://openweathermap.org/img/w/03d.png", reader
				.getIconUrl().toString());
		Assert.assertEquals(47.59, reader.getTemp(), .01);
	}
}
