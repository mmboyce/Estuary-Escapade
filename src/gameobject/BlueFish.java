package gameobject;

public class BlueFish extends Animal{

	public BlueFish(int xPos, int yPos, int depth, int xSize, int ySize) {
		super(xPos, yPos, depth, xSize, ySize);
		this.setImagePath("images/BlueFishRight.png");
		this.setName("Blue Marlin");
		this.setSpeed(10);
		this.setWeight(250);
		this.setQuestion(new Question("Female Blue Marlins can weigh up to 3000 pounds", "How much can a female Blue Marlin weigh", "3000 lbs", "30 lbs", "300 lbs", "3 lbs"));
		this.setPathLength(xSize * 30);
		this.setRealPic("images/marlinblue.png");
	}

	@Override
	public void update() {
		this.setPathState(this.getPathLength()/this.getSpeed());
		if(this.pathCount % this.getPathState() < this.getPathState()/4) {
			this.setImagePath("images/BlueFishRight.png");
			this.setxPos(this.getxPos() + this.getSpeed());
			if (this.pathCount % 8 == 0 || this.pathCount % 8 == 1) {
				this.setyPos(this.getyPos() + 2);
			} else if (this.pathCount % 8 == 4 || this.pathCount % 8 == 5) {
				this.setyPos(this.getyPos() - 2);
			}
		}else if (this.pathCount % this.getPathState() < this.getPathState()/2) {
			this.setImagePath("images/BlueFishRight.png");
			this.setyPos(this.getyPos() + this.getSpeed()/2);
		}else if (this.pathCount % this.getPathState() < 3 * this.getPathState()/4) {
			this.setImagePath("images/BlueFishLeft.png");
			this.setyPos(this.getyPos() - this.getSpeed()/2);
		}else {
			this.setImagePath("images/BlueFishLeft.png");
			this.setxPos(this.getxPos() - this.getSpeed());
			if (this.pathCount % 8 == 0 || this.pathCount % 8 == 1) {
				this.setyPos(this.getyPos() + 2);
			} else if (this.pathCount % 8 == 4 || this.pathCount % 8 == 5) {
				this.setyPos(this.getyPos() - 2);
			}
		}
		this.pathCount++;
		
	}

}
