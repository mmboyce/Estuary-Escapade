package controller;

/**
 * 	Code is an enumeration of codes that the model and view can cause transitions
 *  in the controller from one state to the next, or 
 *  {@link Code#FLASHSCREEN trigger events.}
 * 
 * @author Miguel Fuentes
 * @author Andre Green
 * @author Devon Pirestani
 * @see CodeListener#codeEmitted(Code)
 */
public enum Code {
	
	/**
	 * NEXT is a code emitted when it is time to transition from one Model/View 
	 * to the next.
	 */
	NEXT,
	
	/**
	 * EXIT is a code emitted when the play exits the game by clicking the exit
	 * button.
	 */
	EXIT, 
	
	/**
	 * TIMEUP is a code emitted when the timer has run out. It will take the player
	 * straight to the Quiz.
	 */
	TIMEUP, 
	
	/**
	 * STARTTIMER is a code emitted when the player hits the <b>Start</b>
	 * button and begins the game.
	 */
	STARTTIMER, 
	
	/**
	 * WRONG is a code emitted when the player answers the quiz incorrectly.
	 */
	WRONG, 
	
	/**
	 * RIGHT is a code emitted when the player answers the quiz correctly.
	 */
	RIGHT, 
	
	/**
	 * FLASHSCREEN is a code emitted when the camera takes the photograph
	 * of the fish, and causes a flash.
	 */
	FLASHSCREEN, 
	
	/**
	 * PAUSE is a code emitted when the timer should pause due to a popup
	 * appearing.
	 */
	PAUSE, 
	
	/**
	 * RESUME is a code emitted when the timer should resume due to a popup
	 * closing.
	 */
	RESUME, 
	
	/**
	 * TUTORIAL is a code emitted when the <b>How to Play</b> button is pressed.
	 * It starts the game in tutorial mode.
	 */
	TUTORIAL
}
