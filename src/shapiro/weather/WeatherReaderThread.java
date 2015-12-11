package shapiro.weather;

import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WeatherReaderThread extends Thread {

	private JTextField editZip;
	private JLabel temperature;
	private JLabel description;
	private JLabel icon;

	public WeatherReaderThread(JTextField editZip, JLabel temp, JLabel description, JLabel icon) {
		this.editZip = editZip;
		this.temperature = temp;
		this.description = description;
		this.icon = icon;
	}

	@Override
	public void run() {
		String zip = editZip.getText();
		try {
			WeatherReader reader = new WeatherReader(zip);
			double currentTemp = reader.getTemp();
			String currentDescription = reader.getDescription();
			ImageIcon currentIcon = new ImageIcon(new ImageIcon(reader.getIconUrl()).getImage().getScaledInstance(150,
					150, Image.SCALE_DEFAULT));

			temperature.setText(currentTemp + " degrees F");
			description.setText(currentDescription);
			icon.setIcon(currentIcon);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
