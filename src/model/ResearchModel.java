package model;

import java.awt.event.MouseEvent;

import controller.Code;
import controller.CodeListener;
import gameobject.Animal;
import gameobject.Camera;
import gameobject.GameObject;

public class ResearchModel extends Model implements GameStateModel {

	// Used to determine if the animal is fully researched
	private boolean isWeighed = false;
	private boolean isMeasured = false;
	private boolean isPhotographed = false;
	// Used to determine if the user is holding an animal or nots
	private boolean isHolding = false;
	
	// Different research tools
	private Camera camera = new Camera(50, 50, 1, 100, 100, "images/camera.png");
	private Camera ruler = new Camera(50, 300, 1, 100, 100, "images/ruler.png");
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
		instantiateObjects();
	}
	
	public void instantiateObjects() {
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
		
		if (isHolding) {
			this.caught.setxPos(mouseX - 250);
			this.caught.setyPos(mouseY - 250);
			if (camera.clickedOn(mouseX, mouseY)) {
				this.caught.setxPos(right);
				this.caught.setyPos(top);
				
				this.camera.setxPos(9000);
				this.camera.setyPos(9000);
				this.setPhotographed(true);
				this.setHolding(false);
				
				if (this.isMeasured() && this.isPhotographed()) {
					doneResearching();
				}
			
			}
			else if (ruler.clickedOn(mouseX, mouseY)) {
				this.caught.setxPos(right);
				this.caught.setyPos(top);
				
				this.ruler.setxPos(9000);
				this.ruler.setyPos(9000);
				this.setMeasured(true);
				this.setHolding(false);

				
				if (this.isMeasured() && this.isPhotographed()) {
					doneResearching();
				}
				
			}
			
		}
		else {
			if (caught.clickedOn(mouseX, mouseY)) {
				setHolding(true);
				this.caught.setxPos(9000);
				this.caught.setyPos(9000);
				
			}
		}
	}
	
	private void doneResearching() {
		this.caught.setxPos(0);
		this.caught.setyPos(0);
		goBack.researched.add(caught);
		getListener().codeEmitted(Code.NEXT);
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
		return new QuizModel(getFrameWidth(), getFrameHeight(), goBack.researched, getListener());
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub		
	}

}
