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

		JLabel title = new JLabel(question.getQuestion());
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.TOP);

		// This border is used to line up the title
		Border border = title.getBorder();
		Border margin = new EmptyBorder(75, 0, 0, 0);
		title.setBorder(new CompoundBorder(border, margin));
		title.setFont(new Font("Arial", Font.BOLD, 70));

		button1 = new JButton(question.getAllAnswers()[0]);
		button1.addActionListener(this);

		button2 = new JButton(question.getAllAnswers()[1]);
		button2.addActionListener(this);

		button3 = new JButton(question.getAllAnswers()[2]);
		button3.addActionListener(this);

		button4 = new JButton(question.getAllAnswers()[3]);
		button4.addActionListener(this);

		setBackground(View.SEA_BLUE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(title);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
	}

	@Override
	public void paint(Graphics g) {
		// Do Nothing
		super.paint(g);
	}

	@Override
	public View nextView(ArrayList<GameObject> objects) {
		// TODO Auto-generated method stub
		return new EndView(getWidth(), getHeight(), objects, super.getListener());
	}

	@Override
	public void update(ArrayList<GameObject> objects) {
		// Do nothing

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			System.out.println("CorrectAnswer");
		} else {
			System.out.println("IncorrectAnswer");
		}
		super.getListener().codeEmitted(Code.NEXT);
		;
	}

}
