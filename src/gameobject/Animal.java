package gameobject;

public abstract class Animal extends GameObject {	
	private String name;
	private int weight;
	private int size;
	private int speed;
	private String funFact;
	private String question;
	
	public Animal(int xPos, int yPos, int depth, String imagePath, String name, int weight,
			int size, int speed, String funFact, String question) {
		super(xPos, yPos, depth, imagePath);
		
		this.name = name;
		this.weight = weight;
		this.size = size;
		this.speed = speed;
		this.funFact = funFact;
		this.question = question;
		
		/* the constructor for each animal should have these values as constants,
		 * i.e. the constructors should be something like crab(xPos, yPos) with
		 *      setters inside to chage each field to what corresponds to the animal.
		 */
	}
	
	public void updatePosition() {
		//
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
	
}
