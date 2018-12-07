package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import controller.Code;
import controller.CodeListener;
import gameobject.GameObject;
import gameobject.Question;

/**
 * The QuizView represents the screen for the game's quiz. This will include
 * the drawing of the question and 4 possible responses.
 * 
 * @author Dylan Martin
 * @author Miguel Fuentes
 * @author Andre Green
 */
public class QuizView extends View implements ActionListener {

	Question question;
	JButton response1;
	JButton response2;
	JButton response3;
	JButton response4;

	private Font font;

	/**
	 * Constructor for the QuizView
	 * 
	 * @param question The Question object containing quiz information
	 * @see View
	 */
	public QuizView(int width, int height, Question question, ArrayList<GameObject> objects, CodeListener listener) {
		super(width, height, objects, listener);
		this.question = question;
		font = new Font("Arial", Font.PLAIN, width / 20);

		JLabel title = new JLabel("<HTML>" + question.getQuestion() + "<HTML>");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.TOP);

		// This border is used to line up the question text
		Border border = title.getBorder();
		Border margin = new EmptyBorder(width / 100, width / 100, width / 100, width / 100);
		title.setBorder(new CompoundBorder(border, margin));
		title.setFont(font);
		title.setForeground(Color.white);

		ArrayList<String> answers = new ArrayList<String>(Arrays.asList(question.getAllAnswers()));
		Collections.shuffle(answers);

		response1 = buttonFactory(answers.get(0));
		response2 = buttonFactory(answers.get(1));
		response3 = buttonFactory(answers.get(2));
		response4 = buttonFactory(answers.get(3));

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(View.SEA_BLUE);
		add(title);
		add(response1);
		add(response2);
		add(response3);
		add(response4);
	}

	/* (non-Javadoc)
	 * @see view.View#nextView(java.util.ArrayList)
	 */
	@Override
	public View nextView(ArrayList<GameObject> objects) {
		return new EndView(getWidth(), getHeight(), objects, super.getListener(), -1, false);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String x = "<HTML>" + question.getCorrectAnswer() + "<HTML>";
		if (((JButton) e.getSource()).getText().equals(x)) {
			super.getListener().codeEmitted(Code.RIGHT);
		} else {
			super.getListener().codeEmitted(Code.WRONG);
		}
	}

	/**
	 * Constructs an EndView representative of how the player answered the quiz
	 * 
	 * @param objects The objects in the game
	 * @param score The score the player got
	 * @param quizCorrect If the quiz is correct
	 * @return The EndView representing the player's performance
	 */
	public View questionAnswered(ArrayList<GameObject> objects, int score, boolean quizCorrect) {
		return new EndView(getWidth(), getHeight(), objects, super.getListener(), score, quizCorrect);
	}

	/**
	 * Creates JButtons that have the text entered on them
	 * 
	 * @param text Text to be on the button
	 * @return The JButton with the text parameter on it.
	 */
	private JButton buttonFactory(String text) {
		JButton button = new JButton("<HTML>" + text + "<HTML>");
		button.setVerticalTextPosition(SwingConstants.CENTER);
		button.addActionListener(this);
		button.setFont(font);
		return button;
	}

}
