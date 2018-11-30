package gameobject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Camera extends GameObject {

	public Camera(int xPos, int yPos, int depth, int xSize, int ySize, String imagePath) {
		super(xPos, yPos, depth, xSize, ySize, imagePath);
	}

	public BufferedImage photograph(Animal animal) {
		// TODO This might or might not have to be empty, we have to figure out what we
		// want to do with this
		BufferedImage bufferedImage;
		try {
			// Try to read the file
			bufferedImage = ImageIO.read(new File(animal.getRealPic()));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update() {
		// This should be empty
	}

}
