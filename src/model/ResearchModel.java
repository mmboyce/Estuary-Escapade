package model;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import controller.Code;
import controller.CodeListener;
import gameobject.Animal;
import gameobject.Camera;
import gameobject.Measure;

/**
 * This model has to handle the positions of the various research tools, and
 * handle various popups
 * 
 * @author Miguel Fuentes
 * @author W Mathieu Mimms-Boyce
 * @author Devon Pirestani
 * @author Andre Green
 * @author Dylan Martin
 *
 */
public class ResearchModel extends Model implements GameStateModel {

	private static final long serialVersionUID = -3435910244830997851L;
	// Used to determine if the animal is fully researched
	private boolean isWeighed = false;
	private boolean isMeasured = false;
	private boolean isPhotographed = false;
	private boolean popupClosed;
	private boolean tutorialPopupClosed;
	private boolean tutorialMode;
	// Used to determine if the user is holding an animal or nots
	private boolean isHoldingCamera = false;
	private boolean isHoldingRuler = false;
	private boolean isHoldingScale = false;

	// Different research tools

	private Camera camera = new Camera(50, 50, 1, 100, 100);
	private Measure ruler = new Measure(50, 300, 1, 100, 100, "images/ruler.png");
	private Measure scale = new Measure(50, 550, 1, 100, 100, "images/scale.png");
	private Animal caught;
	// the EstuaryModel that gave us this ResearchModel
	private EstuaryModel goBack;

	// TODO figure out how to set this relationally based on screen size instead of
	// hard coding
	private int right = 500;
	private int top = 300;

	/**
	 * @return boolean isWeighed
	 */
	public boolean isWeighed() {
		return isWeighed;
	}

	/**
	 * Setter for isWighed
	 * 
	 * @param isWeighed
	 */
	public void setWeighed(boolean isWeighed) {
		this.isWeighed = isWeighed;
	}

	/**
	 * @return boolean isMeasured
	 */
	public boolean isMeasured() {
		return isMeasured;
	}

	/**
	 * Setter for isMeasured
	 * 
	 * @param isMeasured
	 */
	public void setMeasured(boolean isMeasured) {
		this.isMeasured = isMeasured;
	}

	/**
	 * @return boolean isPhotographed
	 */
	public boolean isPhotographed() {
		return isPhotographed;
	}

	/**
	 * Setter for isPhotographed
	 * 
	 * @param isWeighed
	 */
	public void setPhotographed(boolean isPhotographed) {
		this.isPhotographed = isPhotographed;
	}

	/**
	 * This calls the super class constructor, sets some popup booleans, sets
	 * animalCaught to keep track of which animal was caught and goBack to return to
	 * the same state you came from when done researching
	 * 
	 * @param frameWidth   width of the screen
	 * @param frameHeight  height of the screen
	 * @param animalCaught which animal was caught
	 * @param goBack       the {@link EstuaryView} that led to this state
	 * @param listener     the {@link CodeListener}
	 * @param tutorialMode whether or not the game is in tutorial mode
	 */
	public ResearchModel(int frameWidth, int frameHeight, Animal animalCaught, EstuaryModel goBack,
			CodeListener listener, boolean tutorialMode) {
		super(frameWidth, frameHeight, listener);
		popupClosed = false;
		this.tutorialMode = tutorialMode;
		tutorialPopupClosed = false;
		this.caught = animalCaught;
		this.setGoBack(goBack);
		instantiateObjects();
	}

	/**
	 * This sets the position of the {@link Animal} which was caught and adds
	 * everything to {@link Model.objects}
	 */
	public void instantiateObjects() {
		// TODO: make this so its not hard coded
		this.caught.setxPos(right);
		this.caught.setyPos(top);

		addGameObject(this.caught);
		addGameObject(this.camera);
		addGameObject(this.ruler);
		addGameObject(this.scale);
	}

	/**
	 * This resets things to get ready for more research then chooses a new
	 * {@link Animal} for the player to catch
	 */
	@Override
	public Model nextModel() {
		getGoBack().setPopupHappened(false);
		getGoBack().chooseTarget();
		return this.getGoBack();
	}

	/**
	 * This will select a tool if the start of a user's drag touches it and deselect
	 * a tool once the user stops dragging
	 * 
	 * @param e a mouse event
	 * 
	 */
	@Override
	public void registerClick(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();

		if (isHoldingCamera || isHoldingRuler || isHoldingScale) {
			if (caught.clickedOn(mouseX, mouseY)) {
				if (isHoldingCamera) {
					getListener().codeEmitted(Code.FLASHSCREEN);
					this.camera.setVisible(false);
					this.setPhotographed(true);
					this.setCameraHolding(false);
				} else if (isHoldingRuler) {
					this.ruler.setVisible(false);
					this.setMeasured(true);
					this.setRulerHolding(false);
				} else if (isHoldingScale) {
					this.scale.setVisible(false);
					this.setWeighed(true);
					this.setScaleHolding(false);
				}
				if (this.isMeasured() && this.isPhotographed() && this.isWeighed()) {
					doneResearching();
				}
			}
		} else {
			if (camera.clickedOn(mouseX, mouseY)) {
				setCameraHolding(true);
			} else if (ruler.clickedOn(mouseX, mouseY)) {
				setRulerHolding(true);
			} else if (scale.clickedOn(mouseX, mouseY)) {
				setScaleHolding(true);
			}
		}
	}

	/**
	 * This will update the position of a tool if you are holding it as the mouse
	 * moves
	 * 
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

	/**
	 * This moves the animal you have finished researching to
	 * {@link EstuaryModel.researched} and sends a code to put up a popup with the
	 * {@link Animal}'s info
	 */
	private void doneResearching() {
		getGoBack().researched.add(caught);
		getGoBack().getGameObjects().remove(caught);
		super.getListener().researchPopup(caught);
		popupClosed = true;
	}

	/**
	 * This will skip the research, this is for debugging purposes
	 */
	public void debugDoneResearching() {
		setMeasured(true);
		setPhotographed(true);
		setWeighed(true);
		doneResearching();
	}

	/**
	 * Setter for isHoldingCamera
	 * 
	 * @param holdingCamera
	 */
	public void setCameraHolding(boolean holdingCamera) {
		this.isHoldingCamera = holdingCamera;
	}

	/**
	 * Setter for isHoldingRuler
	 * 
	 * @param holdingRuler
	 */
	public void setRulerHolding(boolean holdingRuler) {
		this.isHoldingRuler = holdingRuler;
	}

	/**
	 * Setter for isHoldingScale
	 * 
	 * @param holdingScale
	 */
	public void setScaleHolding(boolean holdingScale) {
		this.isHoldingScale = holdingScale;
	}

	/**
	 * This transitions the Quiz and passes the {@link ArrayList} of {@link Animal}s
	 * which have been researched to the {@link QuizModel}
	 */
	public QuizModel timeUp() {
		// Transition to the QuizModel
		return new QuizModel(getFrameWidth(), getFrameHeight(), getGoBack().researched, super.getListener());
	}

	/**
	 * This handles the popups on this screen
	 */
	@Override
	public void update() {
		if (tutorialMode) {
			if (popupClosed && getGoBack().allResearched()) {
				super.getListener().codeEmitted(Code.TIMEUP);
			} else if (popupClosed) {
				super.getListener().codeEmitted(Code.NEXT);
			}
			if (!tutorialPopupClosed) {
				super.getListener().tutorialPopup2();
				tutorialPopupClosed = true;
			}
		} else if (popupClosed && getGoBack().allResearched()) {
			super.getListener().codeEmitted(Code.TIMEUP);
		} else if (popupClosed) {
			super.getListener().codeEmitted(Code.NEXT);
		}
	}

	/**
	 * @return ruler
	 */
	public Measure getRuler() {
		return ruler;
	}

	/**
	 * @return scale
	 */
	public Measure getScale() {
		return scale;
	}

	/**
	 * @return camera
	 */
	public Camera getCamera() {
		return camera;
	}

	/**
	 * @return goBack
	 */
	public EstuaryModel getGoBack() {
		return goBack;
	}

	/**
	 * This sets the model which will be returned to once the research is done
	 * 
	 * @param goBack Previous model
	 */
	public void setGoBack(EstuaryModel goBack) {
		this.goBack = goBack;
	}

}