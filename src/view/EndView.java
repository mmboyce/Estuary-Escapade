package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import controller.CodeListener;
import gameobject.GameObject;

/**
 * The view at the end of the game. This draws the score the player received,
 * and lets them know if they answered correctly or not.
 * 
 * @author Miguel Fuentes
 * @author W Mathieu Mimms-Boyce
 */
public class EndView extends View {
	
	/**
	 * The constructor or the EndView
	 * 
	 * @param scoreIn The score the player received
	 * @param quizCorrect If the player answered correctly
	 * @see View
	 */
	public EndView(int width, int height, ArrayList<GameObject> objects, CodeListener listener, int scoreIn,
			boolean quizCorrect) {
		super(width, height, objects, listener);
		Integer score = scoreIn;
		String scoreStr = "<br>Your Score is : " + score.toString();
		String fishes = "1 fish<br>";

		// This conditional is to make sure our grammar correct when describing
		// how many fishes the player caught.
		if (quizCorrect) {
			score /= 2; // the amount of fishes collected
			if (score != 1) {
				// fishes is the plural of fish when you are talking about
				// multiple species of fishes.
				fishes = score.toString() + " fishes<br><br>";
			}
		}
		else if(score >= 2) {
			fishes = score.toString() + " fishes<br><br>";
		}

		if (score == 0 && quizCorrect) {
			// no fish caught
			scoreStr = "You answered correctly,<br>but you should try to research the fish in time!";
		} else if (score == 0) {
			// no fish caught
			scoreStr = "You answered the quiz incorrectly,<br>and you should try to research the in time!";
		} else if (quizCorrect) {
			scoreStr = "You answered the quiz correctly,<br>which doubles your score!<br><br>You caught " + fishes
					+ " x2 multiplier (right answer)<br>" + scoreStr;
		} else {
			scoreStr = "You answered the quiz incorrectly,<br>"
					+ "try to remember what you learned about the fish next time!<br><br>You caught " + fishes
					+ scoreStr;
		}

		TextPanel Score = new TextPanel(scoreStr, width / 2); // This will display the title and any art
		EndNavigation nav = new EndNavigation(listener, width); // This holds buttons for navigation

		setLayout(new BorderLayout());
		add(Score, BorderLayout.CENTER);
		add(nav, BorderLayout.SOUTH);
		setVisible(true);
	}

	/* (non-Javadoc)
	 * @see view.View#nextView(java.util.ArrayList)
	 */
	@Override
	public View nextView(ArrayList<GameObject> objects) {
		return new TitleView(ViewContainer.getTitle(), getWidth(), getHeight(), super.getListener(), objects);
	}

}
