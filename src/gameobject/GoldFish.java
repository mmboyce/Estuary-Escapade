package gameobject;

public class GoldFish extends Animal {
	private int pathstate = 0;
	private int pathlength = 40;
	public GoldFish(int xPos, int yPos, int depth) {		
		super(xPos, yPos, depth);
		
		this.setImagePath("0"); // TODO put imagePath here
		this.setName("danny"); // TODO put name here
		this.setWeight(0); // TODO put weight here
		this.setSize(0); // TODO put size here
		this.setxSpeed(2); // TODO put speed here
		this.setySpeed(3);
		this.setFunFact("This fish knows how to swim"); // TODO put funFact here
		this.setQuestion("Can this fish swim?"); // TODO put question here
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		this.setPathstate(this.getPathstate()+1%this.getPathlength());
		if(this.getPathstate() < 10) {
			this.setxPos(this.getxPos() + this.getxSpeed());
		}
		else if(this.getPathstate() < 20) {
			this.setyPos(this.getyPos() + this.getySpeed());
		}
		else if(this.getPathstate() < 30) {
			this.setxPos(this.getxPos() - this.getxSpeed());
		}
		else {
			this.setyPos(this.getyPos() - this.getySpeed());
		}
		System.out.println("Fish at x: " + super.getxPos() + " y: " + super.getyPos());
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
