package gameobject;

import java.io.Serializable;

/**
 * GameObject is an abstract class representing items that are drawn to the screen.
 * This includes any {@link Animal} collected in the game, the research tools, 
 * and some environment assets.
 * 
 * @author      W Mathieu Mimms-Boyce
 * @author      Miguel Fuentes
 */
public abstract class GameObject implements Serializable{

	private int xPos;
	private int yPos;
	private int depth;
	private int xSize;
	private int ySize;
	private boolean visible;
	private String imagePath;

	
	/**
	 * The constructor for GameObject.
	 * 
	 * @param xPos The x cooridnate of the object.
	 * <p>
	 * <code>xPos = 0;</code>
	 * <p>
	 * defaults to the upper left corner.
	 * @param yPos The y coordinate of the object.
	 * <p>
	 * <code>yPos = 0;</code>
	 * <p>
	 * defaults to the upper left corner.
	 * @param depth The order the object will be drawn.
	 * <p>
	 * <code>depth = 0;</code>
	 * <p>
	 * is drawn first with higher numbers being drawn last.
	 * @param xSize The horizontal scale of the object.
	 * @param ySize The vertical scale of the object.
	 * @param imagePath The path to the sprite of the object.
	 */
	public GameObject(int xPos, int yPos, int depth, int xSize, int ySize, String imagePath) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.depth = depth;
		this.xSize = xSize;
		this.ySize = ySize;
		this.imagePath = imagePath;
		setVisible(true);
	}

	
	
	/**
	 * clickedOn evaluates whether coordinates passed on have resulted in the object
	 * being clicked on. The parameters passed in check the object's size to evaluate
	 * whether the click fell within its bounds or not.
	 * 
	 * @param clickX The x coordinate of the click
	 * @param clickY The y coordinate of the click
	 * @return <code>true</code> if the object was clicked on, else <code>false</code>
	 */
	public boolean clickedOn(int clickX, int clickY) {
		// Given a click x and y this returns a boolean for whether or not this object
		// was clicked on
		if (!visible) {
			return false;
		}
		return ((clickX >= xPos && clickX <= xPos + xSize) && (clickY >= yPos && clickY <= yPos + ySize));
	}

	
	/**
	 * @return The <code>depth</code> of the object.
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * @param depth The <code>depth</code> the object will be set to.
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	
	/**
	 * @return The object's <code>imagePath</code>.
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath The <code>imagePath</code> the object is setting.
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * @return The <code>xPos</code> of the object.
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * @param xPos The <code>xPos</code> the object is being moved to.
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	/**
	 * @return The <code>yPos</code> of the object.
	 */
	public int getyPos() {
		return yPos;
	}

	/**
	 * @param yPos The <code>yPos</code> the object is being moved to.
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	/**
	 * @return The <code>xSize</code> of the object.
	 */
	public int getxSize() {
		return xSize;
	}

	/**
	 * @param xSize The <code>xSize</code> is being scaled to.
	 */
	public void setxSize(int xSize) {
		this.xSize = xSize;
	}

	/**
	 * @return The <code>ySize</code> of the object.
	 */
	public int getySize() {
		return ySize;
	}

	/**
	 * @param ySize The <code>ySize</code> is being scaled to.
	 */
	public void setySize(int ySize) {
		this.ySize = ySize;
	}
	
	/**
	 * @return The <code>visibility</code> of the object.
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * @param visible The <code>visibility</code> is being changed to.
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}


	/**
	 * This method will be called on every tick of our timer in the
	 * {@link controller.Controller}. However the object is expected to change
	 * per tick is to be defined in this method.
	 * <p>
	 * If the object does not move, its update method should be empty.
	 */
	public abstract void update();

}
