package gameobject;

public abstract class Animal extends GameObject {
	private String name;
	private int weight;
	private int speed;
	private Question question;

	// the fields below are for pathfinding.

	// how far we are along our path, should default to 0.
	private int pathState = 0;

	// how many steps are in our path
	// this should be assigned in the constructor of child classes
	private int pathLength;

	// this is so the fish knows which way to go
	protected int pathCount = 0;

	// true if we are heading to our last waypoint,
	// false if returning from last waypoint.
	private boolean movingForward = true;

	// Real information on animal real pic from Nat geo
	// and Aveage size
	private String realPic = "";
	private double avgSize = 0;

	public Animal(int xPos, int yPos, int depth, int xSize, int ySize) {
		/*
		 * This constructor will be used by children classes to use setters to assign
		 * the other values which should be constants.
		 */
		super(xPos, yPos, depth, xSize, ySize, "");
	}

	private Animal(int xPos, int yPos, int depth, String imagePath, String name, int xSize, int ySize, int weight,
			int size, int speed, Question question, int pathState, int pathLength, boolean movingForward) {
		super(xPos, yPos, depth, xSize, ySize, imagePath);

		this.name = name;
		this.weight = weight;
		this.speed = speed;
		this.question = question;
		this.pathState = pathState;
		this.pathLength = pathLength;
		this.movingForward = movingForward;

		/*
		 * the constructor for each animal should have these values as constants, i.e.
		 * the constructors should be something like crab(xPos, yPos) with setters
		 * inside to chage each field to what corresponds to the animal.
		 * 
		 * This constructor should not be used except for debugging purposes
		 */
	}

	/**
	 * void updatePosition
	 * 
	 * this is used to advance through our pathfinding.
	 */
	public void updatePosition() {
		int advancement;
		int pathState = getPathState();
		int pathLength = getPathLength();

		if (isMovingForward()) {
			advancement = (pathState + 1) % pathLength;
		} else {
			advancement = (pathState - 1) % pathLength;
		}

		setPathState(advancement);

		// if we reached the end of our path
		if (advancement == 0) {
			setMovingForward(!isMovingForward());
		}
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPathLength() {
		return pathLength;
	}

	public int getPathState() {
		return pathState;
	}

	public void setPathState(int pathState) {
		this.pathState = pathState;
	}

	public void setPathLength(int pathLength) {
		this.pathLength = pathLength;
	}

	public boolean isMovingForward() {
		return movingForward;
	}

	public void setMovingForward(boolean movingForward) {
		this.movingForward = movingForward;
	}

	public void setAvgSize(int AvgSize) {
		this.avgSize = AvgSize;
	}

	public double getAvgSize() {
		return avgSize;
	}

	public void setRealPic(String imagePath) {
		this.realPic = imagePath;
	}

	public String getRealPic() {
		return realPic;
	}
}
