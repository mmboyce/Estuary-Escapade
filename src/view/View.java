package view;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import gameobject.GameObject;

public abstract class View extends JFrame {
	private int frameWidth;
	private int frameHeight;
	
	private final static String title = "Estuary Escapade";
	
	public View(int width, int height, MouseListener m) {
		super(title);
		frameWidth = width;
		frameHeight = height;

		setSize(frameWidth, frameHeight);
		//setUndecorated(true);
		addMouseListener(m);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// do what else we need to do for initial view
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
	
	public abstract void update(ArrayList<GameObject> objects);

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
