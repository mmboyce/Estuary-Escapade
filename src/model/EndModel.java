package model;

import controller.CodeListener;

public class EndModel extends Model {
	// The players final score
	private int score;
	// Is true if the player answers the quiz correctly
	private boolean quizCorrect;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isQuizCorrect() {
		return quizCorrect;
	}

	public void setQuizCorrect(boolean quizCorrect) {
		this.quizCorrect = quizCorrect;
	}

	public EndModel(int frameWidth, int frameHeight, CodeListener listener) {
		super(frameWidth, frameHeight, listener);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Model nextModel() {
		// Sets the next model back to the title screen
		Model model = new TitleModel(super.getFrameWidth(), super.getFrameHeight(), getListener());
		return model;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
