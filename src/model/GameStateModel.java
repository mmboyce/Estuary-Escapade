package model;

/**
 * This interface enforces Models having a way to transition to the quiz when
 * the time runs out
 * 
 * @author Miguel Fuentes
 */
public interface GameStateModel {
	/**
	 * This is used in game states where the timer is running so that the game will
	 * transition to the quiz once time runs out
	 * 
	 * @return QuizModel
	 */
	public QuizModel timeUp();
}
