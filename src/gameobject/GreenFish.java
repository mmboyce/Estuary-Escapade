package gameobject;

public class GreenFish extends Animal{
	public GreenFish(int xPos, int yPos, int depth, int xSize, int ySize) {
		super(xPos, yPos, depth, xSize, ySize);
		this.setImagePath("images/GreenFishRight.png");
		this.setName("Crusty");
		this.setWeight(10);
		this.setSpeed(3);
		this.setQuestion(new Question(" This animal cant swim.",
				"Can crabs swim?", "No",
				"Yes", "Sometimes","Only when in danger" ));
		this.setPathLength(100);
	}

	@Override
	public void update() {
		this.setPathState(this.getPathLength()/this.getSpeed());
		if(this.pathCount%this.getPathLength() < this.getPathLength()/2) {
			this.setImagePath("images/GreenFishRight.png");
			this.setxPos(this.getxPos()+this.getSpeed());
		}else {
			this.setImagePath("images/GreenFishLeft.png");
			this.setxPos(this.getxPos()-this.getSpeed());
		}
		this.pathCount++;
	}
}
