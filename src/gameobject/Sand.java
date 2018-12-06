package gameobject;

public class Sand extends GameObject {

	public Sand(int xPos, int yPos, int depth, int xSize, int ySize) {
		super(xPos, yPos, depth, xSize, ySize, "");
		// TODO Auto-generated constructor stub
		this.setImagePath("images/SandBlock.png");
		this.setxSize(xSize);
		this.setySize(ySize);
		this.setxPos(xPos);
		this.setyPos(yPos);
	}

	@Override
	public void update() {

	}

}
