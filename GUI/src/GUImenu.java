import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GUImenu extends GUI implements ActionListener {

	JMenuItem open = new JMenuItem("Open");
	JFileChooser fileChooser = new JFileChooser();
	int result;

	public GUImenu() {

		JFrame frame = new JFrame();
		frame.setTitle("Welcome");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu file = new JMenu("file");
		menuBar.add(file);

		file.add(open);

		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		result = fileChooser.showOpenDialog(null);

		JMenu help = new JMenu("Help");
		menuBar.add(help);
		JMenuItem about = new JMenuItem("About");
		help.add(about);

		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (result == JFileChooser.APPROVE_OPTION) {
			// user selects a file
		}

	}

}
