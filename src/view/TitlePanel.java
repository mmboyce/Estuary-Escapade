package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class TitlePanel extends JPanel {

	TitlePanel(String titleText, int width) {
		Font font = new Font("Arial", Font.BOLD, width / 15);

		JLabel title = new JLabel("<HTML>" + titleText + "<HTML>");
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
