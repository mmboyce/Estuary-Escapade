package gameobject;

public class GreenFish extends Animal{
	public GreenFish(int xPos, int yPos, int depth, int xSize, int ySize) {
		super(xPos, yPos, depth, xSize, ySize);
		// Initail image
		this.setImagePath("images/GreenFishRight.png");
		// Species Name weight and speed
		this.setName("American Shad");
		this.setWeight(10);
		this.setSpeed(7);
		this.setQuestion(new Question("American Shads are found in fresh water.",
				"Where are American Shads found?", "Fresh water",
				"Salt Water", "Seashore","All the Above" ));
		this.setPathLength(xSize*5/this.getSpeed());
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
