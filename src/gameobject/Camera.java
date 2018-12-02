package gameobject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Camera extends GameObject {

	public Camera(int xPos, int yPos, int depth, int xSize, int ySize, String imagePath) {
		super(xPos, yPos, depth, xSize, ySize, imagePath);
	}

	@Override
	public void update() {
		// This should be empty
	}

}
