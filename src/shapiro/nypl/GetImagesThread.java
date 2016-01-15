package shapiro.nypl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.google.gson.Gson;

public class GetImagesThread extends Thread {

	private Result result;
	private JButton previous;
	private JLabel number;
	private JButton next;
	private JLabel image;
	private NYPLFrame frame;

	public GetImagesThread(NYPLFrame frame, Result result, JButton previous, JLabel number, JButton next, JLabel image) {
		this.result = result;
		this.previous = previous;
		this.number = number;
		this.next = next;
		this.image = image;
		this.frame = frame;
	}

	@Override
	public void run() {

		try {
			HttpURLConnection connection;
			URL url = new URL(result.getApiItemURL());
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Authorization", "Token token=\"4hnx9jfg0r3ihcco\"");

			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			Gson gson = new Gson();
			Item item = gson.fromJson(reader, Item.class);
			frame.setItem(item);
			in.close();

			int index = 0;
			frame.setIndex(index);
			URL imageUrl = new URL(item.getNyplAPI().getResponse().getCapture()[index].getImageLinks().getImageLink());
			ImageIcon currentIcon = new ImageIcon(imageUrl);
			image.setIcon(currentIcon);
			number.setText(index + 1 + "/" + item.getNyplAPI().getResponse().getNumResults());
			next.setEnabled(index + 1 < Integer.parseInt(item.getNyplAPI().getResponse().getNumResults()));

			previous.setEnabled(index != 0);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
