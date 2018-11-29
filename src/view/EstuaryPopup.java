package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Code;
import controller.CodeListener;
import gameobject.Animal;

public class EstuaryPopup extends JPanel implements ActionListener {
	BufferedImage animalImg;
	JButton exit;
	JLabel text;
	CodeListener listener;

	private final Font font = new Font("Arial", Font.PLAIN, 25);

	public EstuaryPopup(Animal a, CodeListener cl) {
		listener = cl;
		this.setLayout(new BorderLayout());
		
		animalImg = ObjectView.createImage(a.getImagePath());
		JLabel picLabel = new JLabel(new ImageIcon(animalImg));
		picLabel.setSize(300, 300);

		JPanel bottom = new JPanel(new FlowLayout());
		
		text = new JLabel("Find this fish and click on it to catch it");
		text.setFont(font);
		bottom.add(text);
		
		exit = new JButton("Resume Game");
		exit.setFont(font);
		exit.addActionListener(this);
		bottom.add(exit);
		
		this.add(picLabel, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent exitPressed) {
		listener.codeEmitted(Code.RESUME);
	}

}
