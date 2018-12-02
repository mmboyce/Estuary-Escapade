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
import gameobject.Animal;

public class ResearchPopup extends JPanel implements ActionListener {
	JLabel name;
	JLabel funFact;
	JLabel weight;
	JLabel length;
	JButton exit;
	CodeListener listener;

	private final Font font = new Font("Arial", Font.PLAIN, 25);

	public ResearchPopup(Animal a, CodeListener cl) {
		listener = cl;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		name = new JLabel("Animal Name: " + a.getName());
		name.setFont(font);
		name.setHorizontalAlignment(JLabel.CENTER);
		funFact = new JLabel("<HTML>" + a.getQuestion().getFunFact() + "<HTML>");
		funFact.setFont(font);
		weight = new JLabel("Weight: " + a.getWeight() + "g");
		weight.setFont(font);
		length = new JLabel("Length: " + a.getWeight() + "m");
		length.setFont(font);
		exit = new JButton("Resume Game");
		exit.setFont(font);
		exit.addActionListener(this);
		
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

}
