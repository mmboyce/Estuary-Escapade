package gameobject;

/**
 * The Camera tool used to photograph the fish.
 * 
 * @author W Mathieu Mimms-Boyce
 * @author Migue Fuentes
 */
public class Camera extends GameObject {

	/**
	 * Default constructor for the Camera class.
	 * 
	 * @see GameObject#GameObject(int, int, int, int, int, String)
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
