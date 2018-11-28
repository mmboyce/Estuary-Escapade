package gameobject;

public class PurpleFish extends Animal{
	int startingPos;

	public PurpleFish(int xPos, int yPos, int depth, int xSize, int ySize) {
		super(xPos, yPos, depth, xSize, ySize);
		this.startingPos = xPos;
		this.setImagePath("images/PurpleFishLeft.png");
		this.setName("Escolar");
		this.setSpeed(15);
		this.setWeight(60);
		this.setQuestion(new Question("Escolar are found in waters that range from 300 to 3000 feet deep. ", 
				"At what depth below would you be able to find a Escolar","1000 feet","10 feet","5000 feet","200 feet"));
		this.setPathLength(xSize * 15);
		
	}

	@Override
	public void update() {
		if (this.pathCount > this.getPathLength()/this.getSpeed()*2) {
			this.pathCount = 0;
			this.setxPos(this.startingPos);
			
		}this.setxPos(this.getxPos() - this.getSpeed());
		this.pathCount++;
	}

}
