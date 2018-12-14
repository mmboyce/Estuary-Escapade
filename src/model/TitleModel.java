package model;

import controller.CodeListener;

/**
 * The title does not have any game objects so this model does not do much
 * besides transition and hold a title
 * 
 * @author Miguel Fuentes
 * @author W Mathieu Mimms-Boyce
 * @author Devon Pirestani
 * @author Andre Green
 *
 */
public class TitleModel extends Model {
	private static final long serialVersionUID = 2507800710350804056L;
	// The title of the game
	private String title;

	/**
	 * This gets the title
	 * 
	 * @return String the title of the game
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This sets the title
	 * 
	 * @param title The title of the game
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * This just calls the constructor of the super class {@link Model}
	 * 
	 * @param frameWidth  the width of the screen
	 * @param frameHeight the height of the screen
	 * @param listener    the codelistener
	 */
	public TitleModel(int frameWidth, int frameHeight, CodeListener listener) {
		super(frameWidth, frameHeight, listener);
	}

	@Override
	public Model nextModel() {
		// Transitions into the next model
		return new EstuaryModel(super.getFrameWidth(), super.getFrameHeight(), getListener(), false);
	}

	@Override
	public Model tutorialModel() {
		return new EstuaryModel(super.getFrameWidth(), super.getFrameHeight(), getListener(), true);
	}

	@Override
	public void update() {
		// Intentionally empty
	}

	@Override
	public void registerClick(int clickX, int clickY) {
		// Intentionally empty
	}
}
