import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageEdit extends GUImenu implements ActionListener {
	

	
	public void buttonOneResize(ActionEvent resize) {
	
		
		
		
		
		System.out.println(resize.getActionCommand());
		
		if (resize.getActionCommand().equalsIgnoreCase("resize")) {
			System.out.println("Button pressed!");
			System.out.println(resize.getActionCommand());
			updateImg();
			Image tmp = this.origImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		    BufferedImage dimg = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
		    Graphics2D g2d = dimg.createGraphics();
		    g2d.drawImage(tmp, 0, 0, null);
		    g2d.dispose();
		    this.image= dimg;
		    this.labelOne.setIcon(new ImageIcon(this.origImage));
		   
		}
			
	}
}

	
	
	
	
	
	
	


