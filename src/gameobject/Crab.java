package gameobject;

public class Crab extends Animal {
	private int pathCount = 0;
	public Crab(int xPos, int yPos, int depth, int xSize, int ySize) {
		super(xPos, yPos, depth, xSize, ySize);
		this.setImagePath("images/Crab_UW_F1.png");
		this.setName("Crusty");
		this.setWeight(10);
		this.setSpeed(10);
		this.setQuestion(new Question(" This animal cant swim.",
				"Can crabs swim?", "No",
				"Yes", "Sometimes","Only when in danger" ));
		this.setPathLength(250);
	}

	@Override
	public void update() {
		this.setPathState(this.getPathLength()/this.getSpeed());
		if(this.pathCount%this.getPathLength() < this.getPathLength()/2) {
			this.setxPos(this.getxPos()+this.getSpeed());
		}else {
			this.setxPos(this.getxPos()-this.getSpeed());
		}
		this.pathCount++;
	}

}
