package gameobject;

import java.awt.image.BufferedImage;
public class Ruler extends GameObject {

	public Ruler(int xPos, int yPos, int depth, int xSize, int ySize, String imagePath) {
		super(xPos, yPos, depth, xSize, ySize, imagePath);
	}

	public double measured(Animal animal) {
		// TODO This might or might not have to be empty, we have to figure out what we
		// want to do with this

		double size=animal.getAvgSize()+(Math.random()*2); //get average size of animal adds random number so its not always the same
		return size;
	}

	@Override
	public void update() {
		// This should be empty
	}

}