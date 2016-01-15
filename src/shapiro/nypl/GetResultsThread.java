package shapiro.nypl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import com.google.gson.Gson;

public class GetResultsThread extends Thread {

	private String searchstring;
	private JList<Result> resultsList;
	private DefaultListModel<Result> model;
	private JButton previous;
	private JLabel number;
	private JButton next;
	private JLabel image;
	private NYPLFrame frame;

	public GetResultsThread(NYPLFrame frame, String search, JList<Result> resultsList, DefaultListModel<Result> model,
			JButton previous, JLabel number, JButton next, JLabel image) {
		this.frame = frame;
		this.searchstring = search;
		this.resultsList = resultsList;
		this.model = model;
		this.previous = previous;
		this.number = number;
		this.next = next;
		this.image = image;
	}

	@Override
	public void run() {
		StringBuilder builder = new StringBuilder();
		builder.append("http://api.repo.nypl.org/api/v1/items/search?q=");
		builder.append(searchstring);
		builder.append("&publicDomainOnly=true");

		try {
			URL url = new URL(builder.toString());
			HttpURLConnection connection;
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Authorization", "Token token=\"4hnx9jfg0r3ihcco\"");

			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			Gson gson = new Gson();
			Search search = gson.fromJson(reader, Search.class);
			frame.setSearch(search);
			in.close();

			for (Result result : search.getNyplAPI().getResponse().getResult()) {
				model.addElement(result);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
