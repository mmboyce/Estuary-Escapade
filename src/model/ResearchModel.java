package model;

import java.awt.event.MouseEvent;

import controller.Code;
import controller.CodeListener;
import gameobject.Animal;
import gameobject.Camera;
import gameobject.Measure;
import gameobject.GameObject;

public class ResearchModel extends Model implements GameStateModel {

	// Used to determine if the animal is fully researched
	private boolean isWeighed = false;
	private boolean isMeasured = false;
	private boolean isPhotographed = false;
	private boolean popupClosed;
	// Used to determine if the user is holding an animal or nots
	private boolean isHolding = false;
	private boolean isHoldingCamera=false;
	private boolean isHoldingRuler=false;
	private boolean isHoldingScale=false;

	// Different research tools
	// TODO decide what functionality we should have from camera and if it should be
	// move
	private Camera camera = new Camera(50, 50, 1, 100, 100, "images/camera.png");
	// TODO decide if we want to make a ruler class or not
	private Measure ruler = new Measure(50, 300, 1, 100, 100, "images/ruler.png");
	private Measure scale = new Measure(50, 550, 1, 100, 100, "images/scale.png");
	private Animal caught;
	// the EstuaryModel that gave us this ResearchModel
	private EstuaryModel goBack;

	// TODO figure out how to set this relationally based on screen size instead of
	// hard coding
	private int right = 500;
	private int top = 300;

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
	public ResearchModel(int frameWidth, int frameHeight, Animal animalCaught, EstuaryModel goBack,
			CodeListener listener) {
		super(frameWidth, frameHeight, listener);
		popupClosed = false;
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
		addGameObject(this.scale);
	}

	@Override
	public Model nextModel() {
		goBack.setPopupHappened(false);
		goBack.chooseTarget();
		return this.goBack;
	}
	/**
	 * void registerClick
	 * takes x and y location of click and compares it to the locations of the different objects on the screen. When the values are equal it holds the object. 
	 * @param e a mouse event
	 * 
	 */
	@Override
	public void registerClick(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();

		if (isHoldingCamera||isHoldingRuler||isHoldingScale) {
			if (caught.clickedOn(mouseX, mouseY)) {
				if(isHoldingCamera){
					getListener().codeEmitted(Code.FLASHSCREEN);
					this.camera.setVisible(false);
					this.setPhotographed(true);
					this.setCameraHolding(false);
				} 
				else if (isHoldingRuler) {
					this.ruler.setVisible(false);
					this.setMeasured(true);
					this.setRulerHolding(false);
				}
				else if (isHoldingScale) {
					this.scale.setVisible(false);
					this.setWeighed(true);
					this.setScaleHolding(false);
				}
				if (this.isMeasured() && this.isPhotographed() && this.isWeighed()) {
					doneResearching();
				}
			}
		} 
		else {
			if (camera.clickedOn(mouseX, mouseY)) {
				setCameraHolding(true);
			}
			else if (ruler.clickedOn(mouseX, mouseY)) {
				setRulerHolding(true);
			}
			else if (scale.clickedOn(mouseX, mouseY)) {
				setScaleHolding(true);
			}
		}
	}
	/**
	 * void mouseMoved
	 * if hold a tool moving the mouse changes the location of that object
	 * @param mouseX
	 * @param mouseY
	 */
	public void mouseMoved(int mouseX, int mouseY) {
		if (isHoldingCamera) {
			this.camera.setxPos(mouseX - camera.getxSize() / 2);
			this.camera.setyPos(mouseY - camera.getySize() / 2);
		}
		if (isHoldingRuler) {
			this.ruler.setxPos(mouseX - ruler.getxSize() / 2);
			this.ruler.setyPos(mouseY - ruler.getySize() / 2);
		}
		if (isHoldingScale) {
			this.scale.setxPos(mouseX - scale.getxSize() / 2);
			this.scale.setyPos(mouseY - scale.getySize() / 2);
		}
	}

	private void doneResearching() {
		goBack.researched.add(caught);
		goBack.getGameObjects().remove(caught);
		super.getListener().researchPopup(caught);
		popupClosed = true;
		if(goBack.allResearched()){
			super.getListener().codeEmitted(Code.TIMEUP);
		}
	}
	
	public void debugDoneResearching() {
		doneResearching();
	}


	public void setCameraHolding(boolean value) {
		this.isHoldingCamera = value;
	}
	public void setRulerHolding(boolean value) {
		this.isHoldingRuler = value;
	}
	public void setScaleHolding(boolean value) {
		this.isHoldingScale = value;
	}
	public boolean getHolding() {
		return this.isHolding;
	}

	@Override
	public QuizModel timeUp() {
		// Transition to the QuizModel
		return new QuizModel(getFrameWidth(), getFrameHeight(), goBack.researched, getListener());
	}

	@Override
	public void update() {
		if(popupClosed) {
			super.getListener().codeEmitted(Code.NEXT);
		}
	}
	
	public Measure getRuler() {
		return ruler;
	}

	public Measure getScale() {
		return scale;
	}

	public Camera getCamera() {
		return camera;
	}

}