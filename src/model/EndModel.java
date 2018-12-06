package model;

import controller.CodeListener;

public class EndModel extends Model {
	// The players final score
	private int score;
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public EndModel(int frameWidth, int frameHeight, CodeListener listener) {
		super(frameWidth, frameHeight, listener);
	}
	
	public EndModel(int frameWidth, int frameHeight, CodeListener listener, int score) {
		super(frameWidth, frameHeight, listener);
		this.score = score;
	}

	@Override
	public Model nextModel() {
		// Sets the next model back to the title screen
		return new TitleModel(super.getFrameWidth(), super.getFrameHeight(), getListener());
	}
}
