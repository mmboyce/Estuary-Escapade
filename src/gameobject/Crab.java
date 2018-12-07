package gameobject;

/**
 * The Crab is a Blue Crab
 * 
 * @author Dylan Martin
 * @see Animal
 */
public class Crab extends Animal {
	
	/**
	 * This Constructor establishes the position, depth, and size of the fish.
	 * Its other parameters are unique values corresponding to the fish.
	 * 
	 * @see Animal#Animal(int, int, int, int, int)
	 */
	public Crab(int xPos, int yPos, int depth, int xSize, int ySize) {
		super(xPos, yPos, depth, xSize, ySize);
		this.setImagePath("images/Crab_UW_F1.png");
		this.setRealPic("images/bluecrab.png");
		this.setName("Blue Crab");
		this.setWeight(5);
		this.setSpeed(10);
		this.setAvgSize(1);
		this.setQuestion(new Question("Blue Crabs have teeth in their stomach.",
				"What do Blue Crabs have in their stomach?", "Teeth", "Eyes", "Claws", "Hair"));
		this.setPathLength(xSize * 16 / this.getSpeed());
	}

	/* (non-Javadoc)
	 * @see gameobject.GameObject#update()
	 */
	@Override
	public void update() {
		// Creates the path for the crab, going back and fourth at the bottom of the
		// screen
		this.setPathState(this.getPathLength() / this.getSpeed());
		if (this.pathCount % this.getPathLength() < this.getPathLength() / 2) {
			this.setxPos(this.getxPos() + this.getSpeed());
		} else {
			this.setxPos(this.getxPos() - this.getSpeed());
		}
		this.pathCount++;
	}

}
