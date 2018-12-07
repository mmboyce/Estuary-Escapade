package view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Code;
import controller.CodeListener;

/**
 * The Navigation bar at the end of the game. 
 * 
 * @author Miguel Fuentes
 * @see TitleNavigation
 */
public class EndNavigation extends JPanel implements ActionListener {

	private JButton start;
	private JButton exit;
	private CodeListener codeListener;
	private Font font;

	/**
	 * Constructor for EndNavigation
	 * 
	 * @param cl The CodeListener
	 * @param width the width of the Navigation bar
	 */
	public EndNavigation(CodeListener cl, int width) {
		codeListener = cl;
		font = new Font("Arial", Font.PLAIN, width / 40);

		// This moves you to the EstuaryModel
		start = new JButton("Main Menu");
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

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
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
