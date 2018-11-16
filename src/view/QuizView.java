package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;

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

		// TODO find a way to shuffle the order of questions and still keep track of the
		// correct answer
		button1 = new JButton(question.getAllAnswers()[0]);
		button1.addActionListener(this);
		button1.setFont(buttonFont);

		button2 = new JButton(question.getAllAnswers()[1]);
		button2.addActionListener(this);
		button2.setFont(buttonFont);

		button3 = new JButton(question.getAllAnswers()[2]);
		button3.addActionListener(this);
		button3.setFont(buttonFont);

		button4 = new JButton(question.getAllAnswers()[3]);
		button4.addActionListener(this);
		button4.setFont(buttonFont);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(View.SEA_BLUE);
		add(title);
		add(button1);
		add(button2);
		add(button3);
		add(button4);

	}

	@Override
	public View nextView(ArrayList<GameObject> objects) {
		return new EndView(getWidth(), getHeight(), objects, super.getListener());
	}

	@Override
	public void update(ArrayList<GameObject> objects) {
		// Do nothing
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO make this keep track of the correct answer as it gets shuffled, also do
		// something to increase the score if the answer is correct
		if (e.getSource() == button1) {
			System.out.println("CorrectAnswer");
		} else {
			System.out.println("IncorrectAnswer");
		}
		super.getListener().codeEmitted(Code.NEXT);
	}

}
