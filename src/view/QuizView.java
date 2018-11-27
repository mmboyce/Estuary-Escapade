package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import controller.Code;
import controller.CodeListener;
import gameobject.GameObject;
import gameobject.Question;

public class QuizView extends View implements ActionListener {

	Question question;
	JButton response1;
	JButton response2;
	JButton response3;
	JButton response4;

	public QuizView(int width, int height, Question question, ArrayList<GameObject> objects, CodeListener listener) {
		super(width, height, objects, listener);
		this.question = question;

		// TODO find a way to make the question multi-line if it is too long
		JLabel title = new JLabel(question.getQuestion());
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.TOP);

		// This border is used to line up the question text
		Border border = title.getBorder();
		Border margin = new EmptyBorder(75, 0, 0, 0);
		title.setBorder(new CompoundBorder(border, margin));
		title.setFont(new Font("Arial", Font.BOLD, 50));

		Font buttonFont = new Font("Arial", Font.PLAIN, 40);

		ArrayList<String> answers = new ArrayList<String>(Arrays.asList(question.getAllAnswers()));
		Collections.shuffle(answers);

		response1 = new JButton(answers.get(0));
		response1.addActionListener(this);
		response1.setFont(buttonFont);

		response2 = new JButton(answers.get(1));
		response2.addActionListener(this);
		response2.setFont(buttonFont);

		response3 = new JButton(answers.get(2));
		response3.addActionListener(this);
		response3.setFont(buttonFont);

		response4 = new JButton(answers.get(3));
		response4.addActionListener(this);
		response4.setFont(buttonFont);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(View.SEA_BLUE);
		add(title);
		add(response1);
		add(response2);
		add(response3);
		add(response4);

	}

	@Override
	public View nextView(ArrayList<GameObject> objects) {
		return new EndView(getWidth(), getHeight(), objects, super.getListener(),-1);
	}

	@Override
	public void update(ArrayList<GameObject> objects) {
		// Do nothing
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (((JButton) e.getSource()).getText() == question.getCorrectAnswer()) {
			super.getListener().codeEmitted(Code.RIGHT);
		} else {
			super.getListener().codeEmitted(Code.WRONG);
		}
	}

	public View questionAnswered(ArrayList<GameObject> objects, int score) {
		return new EndView(getWidth(), getHeight(), objects, super.getListener(),score);
	}

}
