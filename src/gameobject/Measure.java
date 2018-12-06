package gameobject;

/**
 * The Measure class is used to represent both our Ruler and our Scale.
 * 
 * @author Andre Green
 */
public class Measure extends GameObject {

	/**
	 * Default constructor for the Measure class.
	 * <p>
	 * <b>Unlike other {@link GameObject} classes, this one should have its
	 * imagePath set by the parameter.</b>
	 * 
	 * @see GameObject#GameObject(int, int, int, int, int, String)
	 */
	public Measure(int xPos, int yPos, int depth, int xSize, int ySize, String imagePath) {
		super(xPos, yPos, depth, xSize, ySize, imagePath);
	}

	@Override
	public void update() {
		// This should be empty
	}

}