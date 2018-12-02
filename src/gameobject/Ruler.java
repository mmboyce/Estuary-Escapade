package gameobject;

import java.awt.image.BufferedImage;
public class Ruler extends GameObject {

	public Ruler(int xPos, int yPos, int depth, int xSize, int ySize, String imagePath) {
		super(xPos, yPos, depth, xSize, ySize, imagePath);
	}

	@Override
	public void update() {
		// This should be empty
	}

}