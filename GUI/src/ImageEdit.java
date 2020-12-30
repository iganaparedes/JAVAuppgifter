
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class ImageEdit {

	public BufferedImage buttonRotate(BufferedImage origImage) { //sets the function for rotating the image

		int width = origImage.getWidth();
		int height = origImage.getHeight();

		BufferedImage dest = new BufferedImage(height, width, origImage.getType());

		Graphics2D graphics2D = dest.createGraphics();
		graphics2D.translate((height - width) / 2, (height - width) / 2);
		graphics2D.rotate(Math.PI / 2, height / 2, width / 2);
		graphics2D.drawRenderedImage(origImage, null);

		System.out.println("Image rotated!");
		return dest;

	}

	public BufferedImage buttonColor(BufferedImage origImage) { //sets the function for changing the image color to grayscale
		int width = origImage.getWidth();
		int height = origImage.getHeight();

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int p = origImage.getRGB(x, y);
				int a = (p >> 24) & 0xff;
				int r = (p >> 16) & 0xff;
				int g = (p >> 8) & 0xff;
				int b = (p >> 0) & 0xff;
				int avg = (r + g + b) / 3;
				p = (a << 24) | (avg << 16) | (avg << 8) | avg;
				origImage.setRGB(x, y, p);

			}
		}
		System.out.println("Image grayscaled!");
		return origImage;

	}

	public BufferedImage buttonResize(BufferedImage origImage) { //sets the function for changing image size

		Image tmp = origImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();

		System.out.println("Image resized!");
		return dimg;

	}

}
