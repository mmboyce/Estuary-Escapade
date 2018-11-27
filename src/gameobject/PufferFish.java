package gameobject;

public class PufferFish extends Animal {
	// Constructor
	public PufferFish(int xPos, int yPos, int depth, int xSize, int ySize) {
		super(xPos, yPos, depth, xSize, ySize);
		this.setImagePath("images/PuffDaddyRight.png");
		this.setName("Bill");
		this.setWeight(3);
		this.setSpeed(7);
		this.setQuestion(new Question(" This fish blows up like a baloon when threatened.",
				"What does this fish do when threatened?", "Blow up like a baloon",
				"swin away", "dance","start quoting lines from spongebob" ));
		this.setPathLength(500);
	}

	@Override
	public void update() {
		this.setPathState(this.getPathLength()/this.getSpeed());
		if (this.pathCount % this.getPathState() < this.getPathState()/4) {
			this.setImagePath("images/PuffDaddyRight.png");
			this.setxPos(this.getxPos()+this.getSpeed());
		}else if (this.pathCount % this.getPathState() < this.getPathState()/2) {
			this.setyPos(this.getyPos()+this.getSpeed()/2);
		}else if (this.pathCount % this.getPathState() < 3*this.getPathState()/4) {
			this.setImagePath("images/PuffDaddyLeft.png");
			this.setxPos(this.getxPos()-this.getSpeed());
		}else {
			this.setyPos(this.getyPos()-this.getSpeed()/2);
		}
		this.updatePosition();
		this.pathCount++;
	}
}
