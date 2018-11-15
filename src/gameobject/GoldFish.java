package gameobject;

public class GoldFish extends Animal {
	private int pathstate = 0;
	private int pathlength = 40;

	public GoldFish(int xPos, int yPos, int depth, int xSize, int ySize) {
		super(xPos, yPos, depth, xSize, ySize);

		setImagePath("images/Fish_east_2.png");
		setName("Greg"); // TODO put the name of the actual fish here
		setWeight(0); // TODO put real fish weight here
		setSpeed(5);
		setQuestion(new Question("This fish knows how to swim", "Does this fish know how to swim?", "Yes", "No",
				"Only on Tuesdays", "No, but it can fly!"));
		setPathLength(30);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gameobject.GameObject#update()
	 * 
	 * void update This uses the updatePosition of the Animal class to make a
	 * waypoint system for our goldfish.
	 */
	@Override
	public void update() {
		int pathState = getPathState();
		int x = getxPos();
		int y = getyPos();
		int speed = getSpeed();
		int length = getPathLength();

		// our waypoints are located at each third of the way through our path.
		int wayPoint1 = length / 3;
		int wayPoint2 = wayPoint1 * 2;
		int wayPoint3 = length;

		if (!isMovingForward()) {
			// we multiply by -1 so that we will head the other way, this is
			// executed after we've reached the end of our path and must return.
			speed *= -1;
			wayPoint1 *= -1;
			wayPoint2 *= -1;
			wayPoint3 *= -1;

			// we switch to a greater than sign because we are headed the
			// opposite direction
			if (pathState > wayPoint1) {
				setxPos(x + speed);
			} else if (pathState > wayPoint2) {
				setyPos(y + speed);
			} else if (pathState > wayPoint3) {
				setxPos(x + (speed / 2));
			}
		} else {
			if (pathState < wayPoint1) {
				// swim right until waypoint1
				setxPos(x + speed);
			} else if (pathState < wayPoint2) {
				// swim down until waypoint2
				setyPos(y + speed);
			} else if (pathState < wayPoint3) {
				// swim to waypoint3
				setxPos(x + (speed / 2));
			}
		}
		updatePosition();
		// System.out.println("Fish at x: " + super.getxPos() + " y: " +
		// super.getyPos()); Prints the position for debugging
	}

	public int getPathstate() {
		return pathstate;
	}

	public void setPathstate(int pathstate) {
		this.pathstate = pathstate;
	}

	public int getPathlength() {
		return pathlength;
	}

	public void setPathlength(int pathlength) {
		this.pathlength = pathlength;
	}
}