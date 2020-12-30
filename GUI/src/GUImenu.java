import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GUImenu extends GUI implements ActionListener { //creates a new class that extends the main function in GUI.java, implements the ActionListener class that includes a method for the user to be able to perform actions and
	// declutters the superclass that is GUI.java and adds more methods and functions

	JButton buttonLoadImage;
	JButton buttonRotate;
	JButton buttonColor;
	JButton buttonResize;
	JFrame frame = new JFrame();
	JPanel panelButtonRotate = new JPanel();
	JPanel panelButtonColor = new JPanel();
	JPanel panelButtonResize = new JPanel();
	JLabel labelOne = new JLabel();
	JLabel labelTwo = new JLabel();
	ImageIcon image = new ImageIcon();
	JFileChooser fileChooser = new JFileChooser();
	Border border = BorderFactory.createLineBorder(Color.green, 5);
	BufferedImage origImage;

	public GUImenu() { //builds the GUI frame, sets values of each component

		panelButtonRotate.setBackground(Color.red);
		panelButtonColor.setBackground(Color.green);
		panelButtonResize.setBackground(Color.blue);
		
		buttonRotate = new JButton("rotate");
		buttonRotate.setFocusable(false);
		buttonRotate.addActionListener(this);
		buttonRotate.setActionCommand("Rotate");

		buttonColor = new JButton("color");
		buttonColor.setFocusable(false);
		buttonColor.addActionListener(this);
		buttonColor.setActionCommand("Color");

		buttonResize = new JButton("resize");
		buttonResize.setFocusable(false);
		buttonResize.addActionListener(this);
		buttonResize.setActionCommand("Resize");

		panelButtonRotate.add(buttonRotate);
		panelButtonColor.add(buttonColor);
		panelButtonResize.add(buttonResize);
		frame.add(panelButtonRotate);
		frame.add(panelButtonColor);
		frame.add(panelButtonResize);

		buttonLoadImage = new JButton("Load image");
		buttonLoadImage.setFocusable(false);
		buttonLoadImage.addActionListener(this);

		frame.setTitle("Welcome");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(800, 800);
		frame.setLayout(new FlowLayout());

		frame.add(buttonLoadImage);
		frame.add(labelOne);
		frame.add(labelTwo);
		
		frame.setVisible(true);
	}

	public void updateImg() { //sets the loaded image as default/original

		labelOne.setIcon(new ImageIcon(origImage));

	}

	public void updateWithImg(BufferedImage bufferedImage) { //sets the loaded image as updated when using ImageEdit functions

		labelOne.setIcon(new ImageIcon(bufferedImage));

	}

	@Override
	public void actionPerformed(ActionEvent e) {  //the actions that can be performed with the buttons that update the image

		if ((e.getSource() == buttonLoadImage)) {

			fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Please choose an image!");

			int openFile = fileChooser.showOpenDialog(null);

			if (openFile == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.println("You opened " + file);
				try {
					origImage = ImageIO.read(file);
					labelOne.setText("Here is your image!");
					updateImg();

				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		} else if (origImage != null) {

			System.out.println(e.getActionCommand());
			ImageEdit editImg = new ImageEdit();
			if (e.getActionCommand().equalsIgnoreCase("resize")) {

				updateWithImg(editImg.buttonResize(origImage));

			} else if (e.getActionCommand().equalsIgnoreCase("rotate")) {
				ImageEdit editImg2 = new ImageEdit();

				updateWithImg(editImg2.buttonRotate(origImage));

			} else if (e.getActionCommand().equalsIgnoreCase("color")) {
				ImageEdit editImg3 = new ImageEdit();

				updateWithImg(editImg3.buttonColor(origImage));

			}

		}
	}
}
