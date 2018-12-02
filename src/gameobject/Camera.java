package gameobject;

public class Camera extends GameObject {

	public Camera(int xPos, int yPos, int depth, int xSize, int ySize, String imagePath) {
		super(xPos, yPos, depth, xSize, ySize, imagePath);
	}

	@Override
	public void update() {
		// This should be empty
	}

}
