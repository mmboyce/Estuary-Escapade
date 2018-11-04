package view;

import java.awt.Graphics;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class View extends JPanel {
	private int frameWidth;
	private int frameHeight;
	private JFrame frame;
	
	public View(MouseListener m) {
		frameWidth = 500;
		frameHeight = 300;
		
		frame = new JFrame();
		frame.addMouseListener(m);
		// do what else we need to do for initial view
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
	
	public abstract void update();

	public int getFrameWidth() {
		return frameWidth;
	}

	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}

	public int getFrameHeight() {
		return frameHeight;
	}

	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
