package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Code;
import controller.CodeListener;

public class TitleNavigation extends JPanel implements ActionListener {

	JButton start;
	JButton exit;
	CodeListener CodeListener;

	public TitleNavigation(CodeListener cl) {
		CodeListener = cl;

		// This moves you to the EstuaryModel
		start = new JButton("Start");
		start.addActionListener(this);

		// This exits the game
		exit = new JButton("Exit");
		exit.addActionListener(this);

		setLayout(new FlowLayout());
		add(start);
		add(exit);
	}

	@Override
	public void actionPerformed(ActionEvent buttonPress) {
		JButton pressed = (JButton) buttonPress.getSource();
		if (pressed == start) {
			CodeListener.codeEmitted(Code.NEXT);
		} else if (pressed == exit) {
			CodeListener.codeEmitted(Code.EXIT);
		}
	}

}
