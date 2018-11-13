package view;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;

import gameobject.Animal;
import gameobject.Camera;
import gameobject.GameObject;

public class ResearchView extends View {
	
	public ResearchView(int width, int height, ArrayList<GameObject> objects) {
		super(width, height, objects);
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

	@Override
	public View nextView(ArrayList<GameObject> objects) {
		// TODO Auto-generated method stub
		return null;
	}

}
