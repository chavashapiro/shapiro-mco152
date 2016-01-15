package shapiro.nypl;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NYPLFrame extends JFrame {

	private JPanel searchPanel;
	private JList<Result> results;
	private DefaultListModel<Result> model;
	private JPanel imagePanel;
	private JButton previous;
	private JLabel number;
	private JButton next;
	private JLabel image;
	private Item item;
	private Integer index;
	private NYPLFrame frame;
	private Search search;

	public NYPLFrame() {
		setTitle("NYPL Search");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		frame = this;
		index = 0;

		imagePanel = new JPanel(new BorderLayout());
		JPanel imageHeader = new JPanel();
		imageHeader.setLayout(new FlowLayout(FlowLayout.CENTER));
		previous = new JButton("Previous");
		previous.setEnabled(false);
		previous.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				index--;
				try {
					URL url = new URL(item.getNyplAPI().getResponse().getCapture()[index].getImageLinks()
							.getImageLink());
					ImageIcon icon = new ImageIcon(url);
					image.setIcon(icon);
					number.setText(index + 1 + "/" + item.getNyplAPI().getResponse().getNumResults());
					previous.setEnabled(index != 0);
					next.setEnabled(index + 1 < Integer.parseInt(item.getNyplAPI().getResponse().getNumResults()));
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		imageHeader.add(previous);
		number = new JLabel();
		imageHeader.add(number);
		next = new JButton("Next");
		next.setEnabled(false);
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				index++;
				try {
					URL url = new URL(item.getNyplAPI().getResponse().getCapture()[index].getImageLinks()
							.getImageLink());
					ImageIcon icon = new ImageIcon(url);
					image.setIcon(icon);
					number.setText(index + 1 + "/" + item.getNyplAPI().getResponse().getNumResults());
					next.setEnabled(index + 1 < Integer.parseInt(item.getNyplAPI().getResponse().getNumResults()));
					previous.setEnabled(index != 0);
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		imageHeader.add(next);
		imagePanel.add(imageHeader, BorderLayout.NORTH);
		image = new JLabel();
		JScrollPane scroll = new JScrollPane(image);
		imagePanel.add(scroll, BorderLayout.CENTER);
		container.add(imagePanel, BorderLayout.CENTER);

		searchPanel = new JPanel();
		searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
		JTextField searchBox = new JTextField();
		searchPanel.add(searchBox);
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clearList();
				String searchString = searchBox.getText();
				GetResultsThread thread = new GetResultsThread(frame, searchString, results, model, previous, number,
						next, image);
				thread.start();

			}

		});
		searchPanel.add(button);
		container.add(searchPanel, BorderLayout.NORTH);

		model = new DefaultListModel<Result>();
		results = new JList<Result>(model);
		results.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		results.setAlignmentX(Component.LEFT_ALIGNMENT);
		results.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				Result sendResult = search.getNyplAPI().getResponse().getResult()[results.getSelectedIndex()];
				GetImagesThread thread = new GetImagesThread(frame, sendResult, previous, number, next, image);
				thread.start();
			}

		});
		container.add(results, BorderLayout.WEST);

	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setSearch(Search search) {
		this.search = search;
	}

	public static void main(String[] args) {
		new NYPLFrame().setVisible(true);
	}

	public void clearList() {
		results.clearSelection();
		results.removeAll();
		model.removeAllElements();
	}

}
