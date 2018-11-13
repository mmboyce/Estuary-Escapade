package gameobject;

public abstract class Animal extends GameObject {	
	private String name;
	private int weight;
	private int size;
	private int speed;
	private String funFact;
	private String question;
	
	// the fields below are for pathfinding.

	// how far we are along our path, should default to 0.
	private int pathState = 0;
	
	// how  many steps are in our path
	// this should be assigned in the constructor of child classes
	private int pathLength;
	
	// true if we are heading to our last waypoint,
	// false if returning from last waypoint.
	private boolean movingForward = true;
	
	public Animal(int xPos, int yPos, int depth) {
		/* This constructor will be used by children classes to use setters to
		 * assign the other values which should be constants.
		 */
		super(xPos, yPos, depth, "");
	}
	
  private Animal(int xPos, int yPos, int depth, String imagePath, String name,
			int weight, int size, int speed, String funFact, String question,
			int pathState, int pathLength, boolean movingForward) {
		super(xPos, yPos, depth, imagePath);
		
		this.name = name;
		this.weight = weight;
		this.size = size;
		this.speed = speed;
		this.funFact = funFact;
		this.question = question;
		this.pathState = pathState;
		this.pathLength = pathLength;
		this.movingForward = movingForward;
		
		/* the constructor for each animal should have these values as constants,
		 * i.e. the constructors should be something like crab(xPos, yPos) with
		 *      setters inside to chage each field to what corresponds to the animal.
		 *      
		 * This constructor should not be used except for debugging purposes
		 */
	}
	
	/*
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
		}
		else {
			advancement = (pathState - 1) % pathLength;
		}
		
		setPathState(advancement);
		
		// if we reached the end of our path
		if(advancement == 0) {
			setMovingForward(!isMovingForward());
		}
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
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
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getFunFact() {
		return funFact;
	}
	public void setFunFact(String funFact) {
		this.funFact = funFact;
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
}
