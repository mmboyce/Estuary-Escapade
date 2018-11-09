package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class TitlePanel extends JPanel{
	
	TitlePanel(String titleText){
		JLabel title = new JLabel(titleText);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.TOP);
		
		Border border = title.getBorder();
		Border margin = new EmptyBorder(75,0,0,0);
		title.setBorder(new CompoundBorder(border, margin));
		
		title.setFont(new Font("Arial", Font.BOLD, 70));
		
		setBackground(Color.decode("#6bd379"));
		add(title);
	}
}
