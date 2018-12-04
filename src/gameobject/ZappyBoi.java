package gameobject;

public class ZappyBoi extends Animal {

	public ZappyBoi(int xPos, int yPos, int depth, int xSize, int ySize) {
		super(xPos, yPos, depth, xSize, ySize);
		this.setImagePath("images/ZappyBoiRight.png");
		this.setName("American Eel");
		this.setWeight(7);
		this.setSpeed(4);
		this.setQuestion(new Question("The American Eel has to come to the surface for air every ten minutes.",
				"How often does the American Eel have to come to the surface for air? ", "Every 10 minutes",
				"Every 5 minutes", "Every hour", "Once a day"));
		this.setPathLength(this.getxSize() * 7 / this.getSpeed());
		this.setRealPic("images/americaneel.jpg");
	}

	@Override
	public void update() {
		int pathState = getPathState();
		int x = getxPos();
		int y = getyPos();
		int speed = getSpeed();
		int length = getPathLength();

		// our waypoints are located at each third of the way through our path.
		int wayPoint1 = length / 2 - 10;
		int wayPoint2 = length / 2;
		int wayPoint3 = length;

		if (!isMovingForward()) {
			// we multiply by -1 so that we will head the other way, this is
			// executed after we've reached the end of our path and must return.
			speed *= -1;
			wayPoint1 *= -1;
			wayPoint2 *= -1;
			wayPoint3 *= -1;
			this.setImagePath("images/ZappyBoiLeft.png");
			// we switch to a greater than sign because we are headed the
			// opposite direction
			if (pathState > wayPoint1) {
				setxPos(x + speed);
				if (this.pathCount % 8 == 0 || this.pathCount % 8 == 1) {
					this.setyPos(this.getyPos() + 2);
				} else if (this.pathCount % 8 == 4 || this.pathCount % 8 == 5) {
					this.setyPos(this.getyPos() - 2);
				}
			} else if (pathState > wayPoint2) {
				setyPos(y + speed);
			} else if (pathState > wayPoint3) {
				setxPos(x + (speed));
				if (this.pathCount % 8 == 0 || this.pathCount % 8 == 1) {
					this.setyPos(this.getyPos() + 2);
				} else if (this.pathCount % 8 == 4 || this.pathCount % 8 == 5) {
					this.setyPos(this.getyPos() - 2);
				}
			}
		} else {
			setImagePath("images/ZappyBoiRight.png");
			if (pathState < wayPoint1) {
				// swim right until waypoint1
				setxPos(x + speed);
				if (this.pathCount % 8 == 0 || this.pathCount % 8 == 1) {
					this.setyPos(this.getyPos() + 2);
				} else if (this.pathCount % 8 == 4 || this.pathCount % 8 == 5) {
					this.setyPos(this.getyPos() - 2);
				}
			} else if (pathState < wayPoint2) {
				// swim down until waypoint2
				setyPos(y + speed);
			} else if (pathState < wayPoint3) {
				// swim to waypoint3
				setxPos(x + (speed));
				if (this.pathCount % 8 == 0 || this.pathCount % 8 == 1) {
					this.setyPos(this.getyPos() + 2);
				} else if (this.pathCount % 8 == 4 || this.pathCount % 8 == 5) {
					this.setyPos(this.getyPos() - 2);
				}
			}
		}
		this.pathCount++;
		updatePosition();
	}

}
