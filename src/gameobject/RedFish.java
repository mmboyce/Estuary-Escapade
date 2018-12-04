package gameobject;

public class RedFish extends Animal{

	public RedFish(int xPos, int yPos, int depth, int xSize, int ySize) {
		super(xPos, yPos, depth, xSize, ySize);
		this.setImagePath("images/RedFishLeft.png");
		this.setName("Red Drum");
		this.setWeight(20);
		this.setSpeed(12);
		this.setQuestion(new Question("Big Red Drum are reffered to as Red Bulls.",
				"What are large Red Drum called?","Red Bulls","Red Fish","Big Fish","Puppy Drum"));
		this.setPathLength(xSize * 22);
		this.setRealPic("images/reddrum.jpg");
	}

	@Override
	public void update() {
		this.setPathState(this.getPathLength()/this.getSpeed());
		if(this.pathCount % this.getPathState() < this.getPathState()/4) {
			this.setImagePath("images/RedFishLeft.png");
			this.setyPos(this.getyPos() - this.getSpeed()/2);
			this.setxPos(this.getxPos() - this.getSpeed());
		}else if (this.pathCount % this.getPathState() < this.getPathState()/2) {
			this.setImagePath("images/RedFishLeft.png");
			this.setyPos(this.getyPos() + this.getSpeed()/2);
			this.setxPos(this.getxPos() - this.getSpeed());
		}else if (this.pathCount % this.getPathState() < 3*this.getPathState()/4) {
			this.setImagePath("images/RedFishRight.png");
			this.setyPos(this.getyPos() + this.getSpeed()/2);
			this.setxPos(this.getxPos() + this.getSpeed());
		}else {
			this.setImagePath("images/RedFishRight.png");
			this.setyPos(this.getyPos() - this.getSpeed()/2);
			this.setxPos(this.getxPos() + this.getSpeed());
		}
		this.pathCount++;
	}

}