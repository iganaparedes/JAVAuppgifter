import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUImenu extends GUI implements ActionListener {

	JButton buttonLoad;
	JButton buttonOne;
	JButton buttonTwo;
	JButton buttonThree;
	JFrame frame = new JFrame();
	JPanel panelOne = new JPanel();
	JPanel panelTwo = new JPanel();
	JPanel panelThree = new JPanel();
	JLabel labelOne = new JLabel();
	JLabel labelTwo = new JLabel();
	ImageIcon image = new ImageIcon();
	JFileChooser fileChooser = new JFileChooser();
	Border border = BorderFactory.createLineBorder(Color.green, 5);
	BufferedImage origImage;

	public GUImenu() {

		panelOne.setBackground(Color.red);
		panelOne.setBounds(0, 0, 250, 250);

		panelTwo.setBackground(Color.green);
		panelTwo.setBounds(250, 0, 250, 250);

		panelThree.setBackground(Color.blue);
		panelThree.setBounds(0, 250, 500, 250);
		
		
		buttonOne = new JButton("Rotate");
		buttonOne.setFocusable(false);
		buttonOne.addActionListener(this);
		buttonOne.setActionCommand("resize");
	
		
		
		
		
		buttonTwo = new JButton("Color");
		buttonTwo.setFocusable(false);
		buttonTwo.addActionListener(this);
		
		buttonThree = new JButton("Size");
		buttonThree.setFocusable(false);
		buttonThree.addActionListener(this);
		
		

		panelOne.add(buttonOne);
		panelTwo.add(buttonTwo);
		panelThree.add(buttonThree);
		frame.add(panelOne);
		frame.add(panelTwo);
		frame.add(panelThree);
		buttonLoad = new JButton("click me");
		buttonLoad.setFocusable(false);
		buttonLoad.addActionListener(this);
		frame.setTitle("Welcome");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(800, 800);
		frame.setLayout(new FlowLayout());

		frame.add(buttonLoad);
		frame.add(labelOne);
		frame.add(labelTwo);

		frame.setVisible(true);
	}

	public void updateImg() {

		labelOne.setIcon(new ImageIcon(origImage));

	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == buttonLoad) {

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
			
			}
			
			
		}
		
			
			
			
		}
		
		
	

