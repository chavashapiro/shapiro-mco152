package shapiro.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.eclipse.jetty.server.Server;

public class ChatFrame extends JFrame {
	private JTextArea textArea;
	private JPanel panel;

	public ChatFrame() {
		setTitle("Chat");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		add(scroll, BorderLayout.CENTER);

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		JTextField textField = new JTextField();
		panel.add(textField);
		JButton button = new JButton("Send");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					URL url = new URL("http://192.168.117.111:8080");
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.setDoOutput(true);
					OutputStream out = connection.getOutputStream();
					PrintWriter writer = new PrintWriter(out);
					String message = textField.getText();
					writer.println(message);

					writer.flush();

					connection.getInputStream();
					textField.setText("");
					textArea.append("me:" + message + "\n");
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		panel.add(button);
		add(panel, BorderLayout.SOUTH);

		Server server = new Server(8080);
		server.setHandler(new P2PHandler(textArea));
		try {
			server.start();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ChatFrame frame = new ChatFrame();
		frame.setVisible(true);
	}
}
