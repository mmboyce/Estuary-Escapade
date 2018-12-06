package model;

import controller.CodeListener;

public class TitleModel extends Model {
	// The title of the game
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// Constructor
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
}
