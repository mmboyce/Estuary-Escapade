package gameobject;

public abstract class GameObject {
	
	private int xPos;
	private int yPos;
	private int depth;
	private String imagePath;
	
	public GameObject(int xPos, int yPos, int depth, String imagePath) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.depth = depth;
		this.imagePath = imagePath;
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
	
	public abstract void update();
}
