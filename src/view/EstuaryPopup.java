package view;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controller.Code;
import controller.CodeListener;
import gameobject.Animal;

public class EstuaryPopup extends JPanel implements ActionListener {
	BufferedImage animalImg;
	JButton exit;
	JLabel text;
	CodeListener listener;

	private Font font;

	public EstuaryPopup(Animal a, CodeListener cl, int width) {
		listener = cl;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		font = new Font("Arial", Font.PLAIN, width / 50);

		animalImg = ObjectView.createImage(a.getImagePath());
		JLabel picLabel = new JLabel(new ImageIcon(animalImg));
		Border margin = new EmptyBorder(width/9, 0, width/9, 0);
		picLabel.setBorder(margin);
		picLabel.setVerticalAlignment(JLabel.CENTER);

		JPanel bottom = new JPanel(new FlowLayout());

		text = new JLabel("Find this fish and click on it to catch it");
		text.setFont(font);
		bottom.add(text);

		exit = new JButton("Resume Game");
		exit.setFont(font);
		exit.addActionListener(this);
		bottom.add(exit);

		this.add(picLabel);
		this.add(bottom);
	}

	@Override
	public void actionPerformed(ActionEvent exitPressed) {
		listener.codeEmitted(Code.RESUME);
	}

}