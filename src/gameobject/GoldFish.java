package gameobject;

public class GoldFish extends Animal {
	
	
	public GoldFish(int xPos, int yPos, int depth) {		
		super(xPos, yPos, depth);
		
		setImagePath("0"); // TODO put imagePath here
		setName("danny"); // TODO put name here
		setWeight(0); // TODO put weight here
		setSize(0); // TODO put size here
		setSpeed(5); // TODO put speed here
		setFunFact("This fish knows how to swim"); // TODO put funFact here
		setQuestion("Can this fish swim?"); // TODO put question here
		setPathLength(30);
		
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * @see gameobject.GameObject#update()
	 * 
	 * void update
	 * This uses the updatePosition of the Animal class to make a waypoint system for
	 * our goldfish. 
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
		
		if(!isMovingForward()) {
			// we multiply by -1 so that we will head the other way,  this is
			// executed after we've reached the end of our path and must return.
			speed *= -1;
			wayPoint1 *= -1;
			wayPoint2 *= -1;
			wayPoint3 *= -1;
			
			// we switch to a greater than sign because we are headed the
			// opposite direction
			if(pathState > wayPoint1) {
				setxPos(x + speed);
			}
			else if(pathState > wayPoint2) {
				setyPos(y + speed);
			}
			else if (pathState > wayPoint3) {
				setxPos(x + (speed / 2));
			}
		}
		else {
			if(pathState < wayPoint1) {
				// swim right until waypoint1
				setxPos(x + speed);
			}
			else if(pathState < wayPoint2) {
				// swim down until waypoint2
				setyPos(y + speed);
			}
			else if (pathState < wayPoint3) {
				// swim to waypoint3
				setxPos(x + (speed / 2));
			}
		}
		
		updatePosition();
	}

}
