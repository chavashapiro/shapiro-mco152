package shapiro.weatherforecast;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ForecastPanel extends JPanel {
	private JLabel date;
	private JLabel max;
	private JLabel min;
	private JLabel description;
	private JLabel icon;

	public ForecastPanel() {

		setLayout(new FlowLayout());

		date = new JLabel();
		date.setAlignmentX(Component.CENTER_ALIGNMENT);
		date.setForeground(Color.MAGENTA);
		date.setFont(new Font("Serif", Font.PLAIN, 12));
		add(date);

		max = new JLabel();
		max.setAlignmentX(Component.CENTER_ALIGNMENT);
		max.setForeground(Color.MAGENTA);
		max.setFont(new Font("Serif", Font.PLAIN, 12));
		add(max);

		min = new JLabel();
		min.setAlignmentX(Component.CENTER_ALIGNMENT);
		min.setForeground(Color.MAGENTA);
		min.setFont(new Font("Serif", Font.PLAIN, 12));
		add(min);

		description = new JLabel();
		description.setAlignmentX(Component.CENTER_ALIGNMENT);
		description.setForeground(Color.MAGENTA);
		description.setFont(new Font("Serif", Font.PLAIN, 12));
		add(description);

		icon = new JLabel();
		icon.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(icon);
	}

	public void setDate(String dateString) {
		date.setText(dateString);
	}

	public void setMin(double minDouble) {
		min.setText("Min: " + minDouble);
	}

	public void setMax(double maxDouble) {
		max.setText("Max: " + maxDouble);
	}

	public void setDescription(String descriptionString) {
		description.setText(descriptionString);
	}

	public void setIcon(String iconString) throws MalformedURLException {
		StringBuilder iconBuilder = new StringBuilder();
		iconBuilder.append("http://openweathermap.org/img/w/");
		iconBuilder.append(iconString);
		iconBuilder.append(".png");
		URL iconUrl = new URL(iconBuilder.toString());
		ImageIcon currentIcon = new ImageIcon(new ImageIcon(iconUrl).getImage()
				.getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		icon.setIcon(currentIcon);
	}
}
