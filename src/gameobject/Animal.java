package gameobject;

/**
 * Animal is an abstract {@link GameObject} for all fish represented in our game.
 * 
 * @author W Mathieu Mimms-Boyce
 * @author Miguel Fuentes
 */
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

	/**
	 * Default constructor for the Animal class.
	 * 
	 * @see GameObject#GameObject(int, int, int, int, int, String)
	 */
	public Animal(int xPos, int yPos, int depth, int xSize, int ySize) {
		/*
		 * This constructor will be used by children classes to use setters to assign
		 * the other values which should be constants.
		 */
		super(xPos, yPos, depth, xSize, ySize, "");
	}

	/**
	 * This should only be used for debugging purposes, as it is a very specific constructor.
	 * 
	 * @see Animal#Animal(int, int, int, int, int)
	 */
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
	 * updatePositon is used to have fish move along their pathfinding.
	 * This should be called in the update method of each fish.
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

	/**
	 * @return The {@link Question} object of the fish.
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @param question Changes the {@link Question} object of the fish.
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

	/**
	 * @return The name of the fish.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name What the fish will be renamed to.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return The weight of the fish.
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight The weight to set the fish to.
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return The speed of the fish.
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed How fast the fish will be set to.
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return The path length of the fish. This is how long the path is.
	 */
	public int getPathLength() {
		return pathLength;
	}

	/**
	 * @return The pathState of the fish. This is how far along the path the fish is.
	 */
	public int getPathState() {
		return pathState;
	}

	/**
	 * @param pathState What the pathState is going to be set to.
	 */
	public void setPathState(int pathState) {
		this.pathState = pathState;
	}

	/**
	 * @param pathLength What the pathLength is going to be set to.
	 */
	public void setPathLength(int pathLength) {
		this.pathLength = pathLength;
	}

	/**
	 * @return Whether the fish is moving forward along its path or not.
	 */
	public boolean isMovingForward() {
		return movingForward;
	}

	/**
	 * @param movingForward The moving status we want to set the fish to.
	 */
	public void setMovingForward(boolean movingForward) {
		this.movingForward = movingForward;
	}

	/**
	 * @param AvgSize The size (in feet) the fish will be set to.
	 */
	public void setAvgSize(double AvgSize) {
		this.avgSize = AvgSize;
	}

	/**
	 * @return The average size of the fish (in feet)
	 */
	public double getAvgSize() {
		return avgSize;
	}

	/**
	 * @param imagePath The photo of the fish to be displayed in the notead.
	 */
	public void setRealPic(String imagePath) {
		this.realPic = imagePath;
	}

	/**
	 * @return The photo of the fish displayed in the notepad
	 */
	public String getRealPic() {
		return realPic;
	}
}
