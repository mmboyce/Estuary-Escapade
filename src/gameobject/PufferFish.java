package gameobject;

/**
 * The PufferFish is a Northern Puffer. 
 * 
 * @author W Mathieu Mimms-Boyce
 * @author Dylan Martin
 * @see Animal
 */
public class PufferFish extends Animal {
	
	/**
	 * This Constructor establishes the position, depth, and size of the fish.
	 * Its other parameters are unique values corresponding to the fish.
	 * 
	 * @see Animal#Animal(int, int, int, int, int)
	 */
	public PufferFish(int xPos, int yPos, int depth, int xSize, int ySize) {
		super(xPos, yPos, depth, xSize, ySize);
		this.setImagePath("images/PuffDaddyRight.png");
		this.setRealPic("images/northernpuffer.png");
		this.setName("Northern Puffer");
		this.setWeight(2);
		this.setAvgSize(1);
		this.setSpeed(7);
		this.setQuestion(new Question("The Northern Puffer blows up like a balloon when threatened.",
				"What does the Northern Puffer do when threatened?", "Blow up like a balloon", "Swim away",
				"Squirt ink", "Bite"));
		this.setPathLength(xSize * 20);
		this.setAvgSize(2);
	}

	/* (non-Javadoc)
	 * @see gameobject.GameObject#update()
	 */
	@Override
	public void update() {
		// Creates the puffer fish path and updates its position and sprite
		// The path is a square
		this.setPathState(this.getPathLength() / this.getSpeed());
		if (this.pathCount % this.getPathState() < this.getPathState() / 4) {
			this.setImagePath("images/PuffDaddyRight.png");
			this.setxPos(this.getxPos() + this.getSpeed());
			if (this.pathCount % 8 == 0 || this.pathCount % 8 == 1) {
				this.setyPos(this.getyPos() + 2);
			} else if (this.pathCount % 8 == 4 || this.pathCount % 8 == 5) {
				this.setyPos(this.getyPos() - 2);
			}
		} else if (this.pathCount % this.getPathState() < this.getPathState() / 2) {
			this.setyPos(this.getyPos() + this.getSpeed() / 2);
		} else if (this.pathCount % this.getPathState() < 3 * this.getPathState() / 4) {
			this.setImagePath("images/PuffDaddyLeft.png");
			this.setxPos(this.getxPos() - this.getSpeed());
			if (this.pathCount % 8 == 0 || this.pathCount % 8 == 1) {
				this.setyPos(this.getyPos() + 2);
			} else if (this.pathCount % 8 == 4 || this.pathCount % 8 == 5) {
				this.setyPos(this.getyPos() - 2);
			}
		} else {
			this.setyPos(this.getyPos() - this.getSpeed() / 2);
		}
		this.updatePosition();
		this.pathCount++;
	}
}
