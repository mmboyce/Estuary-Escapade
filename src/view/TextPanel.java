package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 * The panel used to display text at the end of the game on the
 * {@link EndView}
 * 
 * @author Miguel Fuentes
 * @author W Mathieu Mimmms-Boyce
 */
public class TextPanel extends JPanel {

	/**
	 * Constructor for the TextPanel
	 * 
	 * @param text The text to be displayed on the panel
	 * @param width The width of the panel
	 */
	TextPanel(String text, int width) {
		Font font = new Font("Arial", Font.BOLD, width / 15);

		JLabel title = new JLabel("<HTML>" + text + "<HTML>");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.TOP);
		title.setForeground(Color.white);

		// This border is used to line up the question text
		Border border = title.getBorder();
		Border margin = new EmptyBorder(width / 100, width / 100, width / 100, width / 100);
		title.setBorder(new CompoundBorder(border, margin));
		title.setFont(font);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(View.SEA_BLUE);
		add(title);
	}
}
