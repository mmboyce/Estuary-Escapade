package view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Code;
import controller.CodeListener;

public class TitleNavigation extends JPanel implements ActionListener {

	private JButton start;
	private JButton exit;
	private CodeListener codeListener;
	private Font font;

	public TitleNavigation(CodeListener cl, int width) {
		codeListener = cl;
		font = new Font("Arial", Font.PLAIN, width/40);
		
		// This moves you to the EstuaryModel
		start = new JButton("Start");
		start.setFont(font);
		start.addActionListener(this);

		// This exits the game
		exit = new JButton("Exit");
		exit.setFont(font);
		exit.addActionListener(this);

		setLayout(new FlowLayout());
		add(start);
		add(exit);
	}

	@Override
	public void actionPerformed(ActionEvent buttonPress) {
		JButton pressed = (JButton) buttonPress.getSource();
		if (pressed == start) {
			codeListener.codeEmitted(Code.NEXT);
		} else if (pressed == exit) {
			codeListener.codeEmitted(Code.EXIT);
		}
	}

}
