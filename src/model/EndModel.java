package model;

import controller.CodeListener;

/**
 * This model holds the score and knows if the quiz was answered correctly
 * 
 * @author Miguel Fuentes
 * @author W Mathieu Mimms-Boyce
 * @author Andre Green
 *
 */
public class EndModel extends Model {

	private static final long serialVersionUID = -7351184289128317941L;
	// The players final score
	private int score;
	private boolean quizCorrect;

	/**
	 * @return score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets {@link score}
	 * 
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * This constructor calls the super constructor and sets score and quizCorrect
	 * 
	 * @param frameWidth  width of screen
	 * @param frameHeight height of screen
	 * @param listener    codelistener
	 * @param score       your score
	 * @param quizCorrect was the quiz answered correctly
	 */
	public EndModel(int frameWidth, int frameHeight, CodeListener listener, int score, boolean quizCorrect) {
		super(frameWidth, frameHeight, listener);
		this.score = score;
		this.quizCorrect = quizCorrect;
	}

	/**
	 * This goes back to the title
	 */
	@Override
	public Model nextModel() {
		// Sets the next model back to the title screen
		return new TitleModel(super.getFrameWidth(), super.getFrameHeight(), getListener());
	}

	/**
	 * @return quizCorrect
	 */
	public boolean isQuizCorrect() {
		return quizCorrect;
	}

	/**
	 * Sets {@link quizCorrect}
	 * 
	 * @param quizCorrect
	 */
	public void setQuizCorrect(boolean quizCorrect) {
		this.quizCorrect = quizCorrect;
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
