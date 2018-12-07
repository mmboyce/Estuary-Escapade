package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Box;
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

/**
 * The ResearchPopup represents popups that will appear during the research
 * scene. This is our notebook with the <b>funfact</b> displayed.
 * 
 * @author Dylan Martin
 * @author Miguel Fuentes
 * @author W Mathieu Mimms-Boyce
 */
public class ResearchPopup extends JLabel implements ActionListener {
	BufferedImage realAnimalImg;
	JLabel name;
	JLabel funFact;
	JLabel weight;
	JLabel length;
	JButton exit;
	CodeListener listener;
	int width;
	int height;

	private Font font;

	/**
	 * Constructor for the ResearchPopup
	 * 
	 * @param a The animal to display in the popup
	 * @param cl The CodeListener
	 * @param width the width of the popup
	 * @param height the height of the popup
	 */
	public ResearchPopup(Animal a, CodeListener cl, int width, int height) {
		listener = cl;
		this.width = width;
		this.height = height;

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		font = new Font("Arial", Font.PLAIN, width / 35);

		realAnimalImg = ObjectView.createImage(a.getRealPic());
		JLabel picLabel = new JLabel(new ImageIcon(realAnimalImg));
		Border margin = new EmptyBorder(width / 40, 0, realAnimalImg.getHeight() / 200, 0);
		picLabel.setBorder(margin);
		picLabel.setVerticalAlignment(JLabel.CENTER);
		
		name = labelFactory("<i>" + a.getName() + "</i>");
		funFact = labelFactory("<br><b>Fun Fact: " + a.getQuestion().getFunFact() + "</b>");
		weight = labelFactory("<br><i>Weight: " + a.getWeight() + " lbs</i>");
		length = labelFactory("<i>Length: " + a.getAvgSize() + " feet</i>");
		exit = new JButton("Resume Game");
		exit.setFont(font);
		exit.addActionListener(this);

		this.add(picLabel);
		this.setBorder(new EmptyBorder(0, width / 20, 0, 0));
		this.add(Box.createVerticalStrut(width / 60));
		this.add(name);
		this.add(funFact);
		this.add(weight);
		this.add(length);
		this.add(exit);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent exitPressed) {
		listener.codeEmitted(Code.RESUME);
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		BufferedImage notebook = ObjectView.createImage("images/legal-pad.png");
		g.drawImage(notebook, 0, 0, width / 2, height, null);
	}

	/**
	 * Creates a JLabel of the popup's text.
	 * 
	 * @param text The text of the popup
	 * @return The new JLabel
	 */
	private JLabel labelFactory(String text) {
		JLabel label = new JLabel("<HTML>" + text + "<HTML>");
		label.setFont(font);
		return label;
	}

}
