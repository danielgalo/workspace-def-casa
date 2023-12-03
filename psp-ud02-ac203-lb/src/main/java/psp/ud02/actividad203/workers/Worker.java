package psp.ud02.actividad203.workers;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Worker extends Thread {

	private String fileRead;
	private String outputFolder;
	private int maxWidth;
	private int maxHeight;

	/**
	 * @param fileRead
	 * @param outputFile
	 * @param maxWidth
	 * @param maxHeight
	 */
	public Worker(String fileRead, String outputFolder, int maxWidth, int maxHeight) {
		this.fileRead = fileRead;
		this.outputFolder = outputFolder;
		this.maxWidth = maxWidth;
		this.maxHeight = maxHeight;
	}

	@Override
	public void run() {

		if (isJPG(fileRead)) {
			// If the image is a JPG or JPEG, resize it
			resizeImage(maxWidth, maxHeight, fileRead);
		}

	}

	/**
	 * Resizes an image
	 * 
	 * @param newWidth
	 * @param newHeight
	 * @param imagePath
	 */
	private static synchronized void resizeImage(int newWidth, int newHeight, String imagePath) {
		try {
			// Read the original image
			File inputFile = new File(imagePath);
			BufferedImage originalImage = ImageIO.read(inputFile);

			if (originalImage != null) {
				// Create a new BufferedImage with the desired dimensions
				BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
				// Get the graphics context of the new image
				Graphics2D g2d = resizedImage.createGraphics();
				// Draw the original image onto the new image with scaling
				g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
				// Dispose of the graphics context to free up resources
				g2d.dispose();
				// Save the resized image to a file
				File outputFile = new File(inputFile.getName());
				ImageIO.write(resizedImage, "jpg", outputFile);
				System.out.println("Image resized and saved to: " + outputFile.getAbsolutePath());
			} else {
				System.out.println("Imagen es null");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param image
	 * @return
	 */
	private static synchronized boolean isJPG(String image) {

		boolean isJpg = Boolean.FALSE;

		if (image.endsWith(".jpg") || image.endsWith(".jpeg")) {
			isJpg = Boolean.TRUE;
		}
		return isJpg;
	}
}
