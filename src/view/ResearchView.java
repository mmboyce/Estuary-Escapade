package view;

import java.awt.Graphics;
import java.awt.event.MouseListener;

import gameobject.Animal;
import gameobject.Camera;

public class ResearchView extends View {

	Animal caughtFish;
	Camera camera;
	
	public ResearchView(int width, int height,MouseListener m) {
		super(width,height,m);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

}
