package shapiro.weather;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WeatherFrame extends JFrame {

	private JLabel header;
	private JLabel getZip;
	private JTextField editZip;
	private JButton getWeatherButton;
	private JLabel temperature;
	private JLabel description;
	private JLabel icon;

	public WeatherFrame() {
		setTitle("Weather");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		header = new JLabel("CURRENT WEATHER");
		header.setAlignmentX(Component.CENTER_ALIGNMENT);
		header.setForeground(Color.MAGENTA);
		header.setFont(new Font("Serif", Font.PLAIN, 32));
		add(header, BorderLayout.PAGE_START);

		getZip = new JLabel("Enter zip:");
		getZip.setAlignmentX(Component.CENTER_ALIGNMENT);
		getZip.setForeground(Color.MAGENTA);
		getZip.setFont(new Font("Serif", Font.PLAIN, 24));
		add(getZip);

		editZip = new JTextField();
		Dimension dim = new Dimension(200, 25);
		editZip.setMaximumSize(dim);
		editZip.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(editZip);

		getWeatherButton = new JButton("Get Weather");
		getWeatherButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		getWeatherButton.setForeground(Color.MAGENTA);
		getWeatherButton.setFont(new Font("Serif", Font.PLAIN, 20));
		add(getWeatherButton);

		temperature = new JLabel();
		temperature.setAlignmentX(Component.CENTER_ALIGNMENT);
		temperature.setForeground(Color.MAGENTA);
		temperature.setFont(new Font("Serif", Font.PLAIN, 24));
		add(temperature);

		description = new JLabel();
		description.setAlignmentX(Component.CENTER_ALIGNMENT);
		description.setForeground(Color.MAGENTA);
		description.setFont(new Font("Serif", Font.PLAIN, 24));
		add(description);

		icon = new JLabel();
		icon.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(icon);

		getWeatherButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WeatherReaderThread thread = new WeatherReaderThread(editZip, temperature, description, icon);
				thread.start();
			}

		});
	}

	public static void main(String[] args) {
		new WeatherFrame().setVisible(true);
	}
}
