package view;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.Collection;

import gameobject.Animal;

public class EstuaryView extends View {
	
	Collection<Animal> schoolOfFish;

	public EstuaryView(int width, int height,MouseListener m) {
		super(width,height,m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
	
	public void update() {
		// TODO Auto-generated method stub
	}

}
