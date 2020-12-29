

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;

public class ImageEdit {

	public BufferedImage buttonRotate (BufferedImage origImage, double angle) {
		int w = origImage.getWidth();    
	    int h = origImage.getHeight();

	    BufferedImage rotated = new BufferedImage(w, h, origImage.getType());  
	    Graphics2D graphic = rotated.createGraphics();
	    graphic.rotate(Math.toRadians(angle), w/2, h/2);
	    graphic.drawImage(origImage, null, 0, 0);
	    graphic.dispose();
	    return rotated;


	}
	public BufferedImage buttonColor (BufferedImage origImage) {
		return origImage;

	    
	}
	public BufferedImage buttonResize(BufferedImage origImage) {


		Image tmp = origImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		System.out.println("Image resized!");
		return  dimg;
	
		}
	
	}

	

