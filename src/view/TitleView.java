package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class TitleView extends View {

	public TitleView(MouseListener m) {
		super(m);
		
		JFrame yeet = super.getFrame();
		Container dab = yeet.getContentPane();
		
		JLabel title = new JLabel("Estuary Escapade");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.TOP);
		Border border = title.getBorder();
		Border margin = new EmptyBorder(100,10,10,10);
		title.setBorder(new CompoundBorder(border, margin));
		title.setFont(new Font("Arial", Font.BOLD, 70));
		
		dab.setBackground(Color.decode("#6bd379"));
		dab.add(title);
	
		yeet.setVisible(true);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}

}
