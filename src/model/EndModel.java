package model;

import controller.CodeListener;

public class EndModel extends Model {
	// The players final score
	private int score;
	private boolean quizCorrect;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public EndModel(int frameWidth, int frameHeight, CodeListener listener, int score, boolean quizCorrect) {
		super(frameWidth, frameHeight, listener);
		this.score = score;
		this.quizCorrect = quizCorrect;
	}
	
	@Override
	public Model nextModel() {
		// Sets the next model back to the title screen
		return new TitleModel(super.getFrameWidth(), super.getFrameHeight(), getListener());
	}

	public boolean isQuizCorrect() {
		return quizCorrect;
	}

	public void setQuizCorrect(boolean quizCorrect) {
		this.quizCorrect = quizCorrect;
	}
}
