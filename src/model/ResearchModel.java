package model;

import java.awt.event.MouseEvent;

import controller.Code;
import controller.CodeListener;
import gameobject.Animal;
import gameobject.Camera;
import gameobject.GameObject;

public class ResearchModel extends Model implements GameState {

	// Used to determine if the animal is fully researched
	private boolean isWeighed = false;
	private boolean isMeasured = false;
	private boolean isPhotographed = false;
	// Used to determine if the user is holding an animal or nots
	private boolean isHolding = false;
	
	// Different research tools
	private Camera camera = new Camera(50, 50, 1, "images/camera.png");
	private Camera ruler = new Camera(50, 300, 1, "images/ruler.png");
	private Animal caught;
	// the EstuaryModel that gave us this ResearchModel
	private EstuaryModel goBack;
	
	private int right = 500;
	private int top = -100;

	public boolean isWeighed() {
		return isWeighed;
	}

	public void setWeighed(boolean isWeighed) {
		this.isWeighed = isWeighed;
	}

	public boolean isMeasured() {
		return isMeasured;
	}

	public void setMeasured(boolean isMeasured) {
		this.isMeasured = isMeasured;
	}

	public boolean isPhotographed() {
		return isPhotographed;
	}

	public void setPhotographed(boolean isPhotographed) {
		this.isPhotographed = isPhotographed;
	}

	// Constructor
	public ResearchModel(int frameWidth, int frameHeight, Animal animalCaught, EstuaryModel goBack, CodeListener listener) {
		super(frameWidth, frameHeight, listener);
		this.caught = animalCaught;
		this.goBack = goBack;
		instantiateYeet();
	}
	
	public void instantiateYeet() {
		// TODO: make this so its not hard coded
		this.caught.setxPos(right);
		this.caught.setyPos(top);
		
		addGameObject(this.caught);
		addGameObject(this.camera);
		addGameObject(this.ruler);
	}
	@Override
	public Model nextModel() {
		return this.goBack;
	}

	@Override
	public void registerClick(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		
		// Maybe put all these attributes in their respective object classes instead of defining them here?

		int xLeftBound;
		int xRightBound;
		int yUpBound;
		int yDownBound;

		xLeftBound = caught.getxPos(); // TODO figure out values for fish's size
		xRightBound = caught.getxPos() + 500;

		yUpBound = caught.getyPos();
		yDownBound = caught.getyPos() + 500;
		
		int camLeftBound = camera.getxPos();
		int camRightBound = camera.getxPos() + 100;
		
		int camUpBound = camera.getyPos();
		int camDownBound = camera.getyPos() + 100;
		
		int rulerLeftBound = ruler.getxPos();
		int rulerRightBound = ruler.getxPos() + 100;
		
		int rulerUpBound = ruler.getyPos();
		int rulerDownBound = ruler.getyPos() + 100;
		
		
		
		
		if (this.getHolding()) {
			this.caught.setxPos(mouseX - 250);
			this.caught.setyPos(mouseY - 250);
			if ((mouseX >= camLeftBound && mouseX <= camRightBound) && (mouseY >= camUpBound && mouseY <= camDownBound)) {
				this.caught.setxPos(right);
				this.caught.setyPos(top);
				
				this.camera.setxPos(9000);
				this.camera.setyPos(9000);
				this.setPhotographed(true);
				this.setHolding(false);
			
			}
			else if ((mouseX >= rulerLeftBound && mouseX <= rulerRightBound) && (mouseY >= rulerUpBound && mouseY <= rulerDownBound)) {
				this.setMeasured(true);
				this.caught.setxPos(0);
				this.caught.setyPos(0);
				this.setHolding(false);
				getListener().codeEmitted(Code.NEXT);
			}
			
		}
		else {
			if ((mouseX >= xLeftBound && mouseX <= xRightBound) && (mouseY >= yUpBound && mouseY <= yDownBound)) {
				setHolding(true);
				this.caught.setxPos(9000);
				this.caught.setyPos(9000);
				
			}
		}
	}

	private void measuring() {
		// TODO Auto-generated method stub

	}

	private void photographing() {
		// TODO Auto-generated method stub

	}

	private void weighing() {
		// TODO Auto-generated method stub

	}
	
	private void setHolding(boolean value) {
		this.isHolding = value;
	}
	
	private boolean getHolding() {
		return this.isHolding;
	}

	@Override
	public QuizModel timeUp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
