package gameobject;

public class PurpleFish extends Animal {
	int startingPos;

	public PurpleFish(int xPos, int yPos, int depth, int xSize, int ySize) {
		super(xPos, yPos, depth, xSize, ySize);
		this.startingPos = xPos;
		this.setImagePath("images/PurpleFishLeft.png");
		this.setRealPic("images/escolar.png");// Not sure of the royalties on this one LOL
		this.setName("Escolar");
		this.setSpeed(15);
		this.setAvgSize(2);
		this.setWeight(55);
		this.setQuestion(new Question("Escolar are found in waters that range from 300 to 3000 feet deep. ",
				"At what depth below would you be able to find a Escolar", "1000 feet", "10 feet", "5000 feet",
				"200 feet"));
		this.setPathLength(xSize * 15);
	}

	@Override
	public void update() {
		// creates a path for the fish that loops around the screen and updates the
		// fish's position
		if (this.pathCount > this.getPathLength() / this.getSpeed() * 2) {
			this.pathCount = 0;
			this.setxPos(this.startingPos);

		}
		if (this.pathCount % 8 == 0 || this.pathCount % 8 == 1) {
			this.setyPos(this.getyPos() + 2);
		} else if (this.pathCount % 8 == 4 || this.pathCount % 8 == 5) {
			this.setyPos(this.getyPos() - 2);
		}
		this.setxPos(this.getxPos() - this.getSpeed());
		this.pathCount++;
	}

}
