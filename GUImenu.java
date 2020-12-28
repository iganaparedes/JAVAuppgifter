import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUImenu extends GUI implements ActionListener {

	JButton buttonOne;
	JFrame frame = new JFrame();
	JPanel panelOne = new JPanel();
	JLabel labelOne = new JLabel();
	ImageIcon image = new ImageIcon();
	JFileChooser fileChooser = new JFileChooser();

	BufferedImage origImage;

	public GUImenu() {

		buttonOne = new JButton("click me");
		buttonOne.addActionListener(this);
		frame.setTitle("Welcome");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(800, 800);
		frame.setLayout(new FlowLayout());

		labelOne.setText("Here is your image!");

		frame.add(buttonOne);
		frame.add(labelOne);

		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == buttonOne) {

			fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Please choose an image!");

			int openFile = fileChooser.showOpenDialog(null);

			if (openFile == JFileChooser.APPROVE_OPTION) {

				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.println("You opened " + file);
				try {
					origImage = ImageIO.read(file);
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			}

		}
	}

}
