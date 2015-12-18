package shapiro.contacts;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class ContactsFrame extends JFrame {

	private JList contacts;
	private DefaultListModel model;

	public ContactsFrame() {
		setTitle("Contacts List");
		setSize(500, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		model = new DefaultListModel();
		contacts = new JList(model);
		contacts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contacts.setAlignmentX(Component.LEFT_ALIGNMENT);
		contacts.setFont(new Font("Serif", Font.PLAIN, 36));
		container.add(contacts, BorderLayout.CENTER);

		ContactsThread thread = new ContactsThread(contacts, model);
		thread.start();

	}

	public static void main(String[] args) {
		new ContactsFrame().setVisible(true);
	}

}
