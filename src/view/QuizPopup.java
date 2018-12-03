package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Code;
import controller.CodeListener;

public class QuizPopup extends JPanel implements ActionListener {
	JButton exit;
	JLabel text;
	CodeListener listener;

	private Font font;

	public QuizPopup(CodeListener cl, int width) {
		listener = cl;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		font = new Font("Arial", Font.PLAIN, width / 25);

		text = new JLabel(
				"<HTML>I hope you were paying attention to the fun facts because now you'll be quized on them."
						+ " If you get it right you'll double your score");
		text.setFont(font);
		this.add(text);

		exit = new JButton("Take Quiz");
		exit.setFont(font);
		exit.addActionListener(this);
		this.add(exit);
	}

	@Override
	public void actionPerformed(ActionEvent exitPressed) {
		listener.codeEmitted(Code.RESUME);
	}

}
