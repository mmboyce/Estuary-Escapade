package view;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import gameobject.Animal;
import gameobject.Camera;
import gameobject.GameObject;

public class ResearchView extends View {

	Animal caughtFish;
	Camera camera;
	
	public ResearchView(int width, int height,MouseListener m) {
		super(width, height, m);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
	
	@Override
	public void update(ArrayList<GameObject> objects) {
		// TODO Auto-generated method stub
	}

}
