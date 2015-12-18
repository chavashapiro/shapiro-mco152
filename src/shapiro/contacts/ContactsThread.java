package shapiro.contacts;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import com.google.gson.Gson;

public class ContactsThread extends Thread {
	private JList contactsList;
	private DefaultListModel model;

	public ContactsThread(JList contactsList, DefaultListModel model) {
		this.contactsList = contactsList;
		this.model = model;
	}

	@Override
	public void run() {
		try {
			URL url = new URL("http://jsonplaceholder.typicode.com/users");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			Gson gson = new Gson();
			Contact[] contacts = gson.fromJson(reader, Contact[].class);
			in.close();

			Arrays.sort(contacts);
			for (Contact contact : contacts) {
				model.addElement(contact.getName());
			}

			contactsList.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent evt) {
					if (evt.getClickCount() == 2) {
						new ContactInfoFrame(contacts, contactsList.getSelectedIndex()).setVisible(true);
					}
				}

			});
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
