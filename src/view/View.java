package view;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gameobject.GameObject;

public abstract class View extends JPanel {
	private int frameWidth;
	private int frameHeight;
	
	public View(int width, int height) {
		
		frameWidth = width;
		frameHeight = height;

		setSize(frameWidth, frameHeight);
		
		// do what else we need to do for initial view
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
	
	public abstract void update(ArrayList<GameObject> objects);
	
	public abstract View nextView(ArrayList<GameObject> objects);

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

}
