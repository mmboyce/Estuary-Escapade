package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Code;
import controller.CodeListener;
import gameobject.Animal;

public class TutorialPopup extends JPanel implements ActionListener {
	JLabel name;
	JLabel funFact;
	JLabel weight;
	JLabel length;
	JButton exit;
	int which;
	CodeListener listener;
	int width;

	private Font font;

	public TutorialPopup(int which, CodeListener cl, int width) {
		listener = cl;
		this.width = width;
		this.which = which;

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		font = new Font("Arial", Font.PLAIN, width / 35);
		
		switch (this.which) {
		case 1:
			name = labelFactory("As a researcher, you will catch<br>"
					+ "and research certain animals one at time.<br><br>"
					+ "Tap on the correct one to catch it and you will bring it to the lab.<br><br>");
			break;
		case 2:
			name = labelFactory("<b><i>Drag each tool on top of the<br>"
					+ "	animal to gather data.</i></b><br><br>"
					+ "Be sure to remember the information you gather for the quiz later!<br><br>");
			break;
		}

		exit = new JButton("Continue");
		exit.setFont(font);
		exit.addActionListener(this);

		this.setBorder(new EmptyBorder(0, width/20, 0, 0));
		this.add(Box.createVerticalStrut(width / 25));
		this.add(name);
		this.add(exit);
	}

	@Override
	public void actionPerformed(ActionEvent exitPressed) {
		listener.codeEmitted(Code.RESUME);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		BufferedImage notebook = ObjectView.createImage("images/legal-pad.png");
		g.drawImage(notebook, 0, 0, width / 2, width / 2, null);
	}

	private JLabel labelFactory(String text) {
		JLabel label = new JLabel("<HTML>" + text + "<HTML>");
		label.setFont(font);
		return label;
	}

}
