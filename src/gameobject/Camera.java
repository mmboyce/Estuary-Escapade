package gameobject;

public class Camera extends GameObject {

	/**
	 * Default constructor for the Camera class.
	 * 
	 * @see GameObject#GameObject(int, int, int, int, int, String) This constructor
	 * sets everything the parent class does.
	 */
	public Camera(int xPos, int yPos, int depth, int xSize, int ySize) {
		super(xPos, yPos, depth, xSize, ySize,  "images/camera.png");
	}

	/* (non-Javadoc)
	 * @see gameobject.GameObject#update()
	 */
	@Override
	public void update() {
		// This should be empty
	}

}
