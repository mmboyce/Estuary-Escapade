package gameobject;

public class Crab extends Animal {
	public Crab(int xPos, int yPos, int depth, int xSize, int ySize) {
		super(xPos, yPos, depth, xSize, ySize);
		this.setImagePath("images/Crab_UW_F1.png");
		this.setName("Blue Crab");
		this.setWeight(10);
		this.setSpeed(10);
		this.setQuestion(new Question("The Blue Crab have teeth in its stomach.",
				"What do Blue Crabs have in their stomach?", "Teeth",
				"Eyes", "Claws","Hair" ));
		this.setPathLength(xSize*16/this.getSpeed());
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
