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

public class ResearchPopup extends JPanel implements ActionListener {
	JLabel name;
	JLabel funFact;
	JLabel weight;
	JLabel length;
	JButton exit;
	CodeListener listener;
	int width;

	private Font font;

	public ResearchPopup(Animal a, CodeListener cl, int width) {
		listener = cl;
		this.width = width;

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		font = new Font("Arial", Font.PLAIN, width / 35);

		name = labelFactory(a.getName());
		funFact = labelFactory("Fun Fact: " + a.getQuestion().getFunFact());
		weight = labelFactory("Weight: " + a.getWeight() + " lbs");
		length = labelFactory("Length: " + a.getAvgSize() + " feet");
		exit = new JButton("Resume Game");
		exit.setFont(font);
		exit.addActionListener(this);

		this.setBorder(new EmptyBorder(0, width/20, 0, 0));
		this.add(Box.createVerticalStrut(width / 25));
		this.add(name);
		this.add(funFact);
		this.add(weight);
		this.add(length);
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
