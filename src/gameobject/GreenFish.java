package gameobject;

public class GreenFish extends Animal {
	public GreenFish(int xPos, int yPos, int depth, int xSize, int ySize) {
		super(xPos, yPos, depth, xSize, ySize);
		// Initail image
		this.setImagePath("images/GreenFishRight.png");
		this.setRealPic("images/americanshad.png");
		// Species Name weight and speed
		this.setName("American Shad");
		this.setWeight(5);
		this.setAvgSize(2);
		this.setSpeed(7);
		this.setQuestion(new Question("American Shads are found in freshwater.", "Where are American Shads found?",
				"Fresh water", "Salt Water", "Seashore", "All the Above"));
		this.setPathLength(xSize * 10 / this.getSpeed());
	}

	@Override
	public void update() {
		// creates the path that goes back and fourth horizontally at the top right of
		// the screen.
		this.setPathState(this.getPathLength() / this.getSpeed());
		if (this.pathCount % this.getPathLength() < this.getPathLength() / 2) {
			this.setImagePath("images/GreenFishRight.png");
			this.setxPos(this.getxPos() + this.getSpeed());
			if (this.pathCount % 8 == 0 || this.pathCount % 8 == 1) {
				this.setyPos(this.getyPos() + 2);
			} else if (this.pathCount % 8 == 4 || this.pathCount % 8 == 5) {
				this.setyPos(this.getyPos() - 2);
			}
		} else {
			this.setImagePath("images/GreenFishLeft.png");
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
