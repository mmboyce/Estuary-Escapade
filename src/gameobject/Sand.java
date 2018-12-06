package gameobject;

/**
 * The Sand object is used to draw the land at the bottom of our background.
 * 
 * @author Dylan Martin
 * @author Miguel Fuentes
 */
public class Sand extends GameObject {

	/**
	 * This Constructor establishes the position, depth, and size of the sand.
	 * 
	 * @see GameObject#GameObject(int, int, int, int, int, String)
	 */
	public Sand(int xPos, int yPos, int depth, int xSize, int ySize) {
		super(xPos, yPos, depth, xSize, ySize, "");
		// TODO Auto-generated constructor stub
		this.setImagePath("images/SandBlock.png");
		this.setxSize(xSize);
		this.setySize(ySize);
		this.setxPos(xPos);
		this.setyPos(yPos);
	}

	/* (non-Javadoc)
	 * @see gameobject.GameObject#update()
	 */
	@Override
	public void update() {
		// this page intentionally left blank
	}

}
