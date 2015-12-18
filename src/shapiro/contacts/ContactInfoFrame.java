package shapiro.contacts;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContactInfoFrame extends JFrame {

	private JLabel name;
	private JLabel email;
	private JLabel phone;
	private JLabel street;
	private JLabel suite;
	private JLabel city;
	private JLabel zipcode;

	public ContactInfoFrame(Contact[] contacts, int index) {
		setTitle("Contact");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		Contact contact = contacts[index];

		name = new JLabel(contact.getName());
		name.setFont(new Font("Serif", Font.PLAIN, 26));
		panel.add(name);

		email = new JLabel(contact.getEmail());
		email.setFont(new Font("Serif", Font.PLAIN, 26));
		panel.add(email);

		phone = new JLabel(contact.getPhone());
		phone.setFont(new Font("Serif", Font.PLAIN, 26));
		panel.add(phone);

		street = new JLabel(contact.getAddress().getStreet());
		street.setFont(new Font("Serif", Font.PLAIN, 26));
		panel.add(street);

		suite = new JLabel(contact.getAddress().getSuite());
		suite.setFont(new Font("Serif", Font.PLAIN, 26));
		panel.add(suite);

		city = new JLabel(contact.getAddress().getCity());
		city.setFont(new Font("Serif", Font.PLAIN, 26));
		panel.add(city);

		zipcode = new JLabel(contact.getAddress().getZipcode());
		zipcode.setFont(new Font("Serif", Font.PLAIN, 26));
		panel.add(zipcode);

		container.add(panel, BorderLayout.CENTER);

	}

}
