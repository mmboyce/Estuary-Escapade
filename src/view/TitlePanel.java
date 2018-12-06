package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class TitlePanel extends JPanel {

	TitlePanel(String titleText, int width) {
		// TODO find art to put in the background of this instead of one solid color
		JLabel title = new JLabel(titleText);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.TOP);
		title.setFont(new Font("Arial", Font.BOLD, width/10));


		// This border is used to line up the title
		Border border = title.getBorder();
		Border margin = new EmptyBorder(width/100, 0, 0, 0);
		title.setBorder(new CompoundBorder(border, margin));

		setBackground(View.SEA_BLUE);
		add(title);
	}
}
