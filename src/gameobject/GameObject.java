package gameobject;

public abstract class GameObject {

	private int xPos;
	private int yPos;
	private int depth;
	private int xSize;
	private int ySize;
	private String imagePath;

	public GameObject(int xPos, int yPos, int depth, int xSize, int ySize, String imagePath) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.depth = depth;
		this.xSize = xSize;
		this.ySize = ySize;
		this.imagePath = imagePath;
	}

	public boolean clickedOn(int clickX, int clickY) {
		return ((clickX >= xPos && clickX <= xPos + xSize) && (clickY >= yPos && clickY <= yPos + ySize));
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getxSize() {
		return xSize;
	}

	public void setxSize(int xSize) {
		this.xSize = xSize;
	}

	public int getySize() {
		return ySize;
	}

	public void setySize(int ySize) {
		this.ySize = ySize;
	}

	public abstract void update();
}
