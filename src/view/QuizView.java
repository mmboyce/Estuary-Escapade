package view;

import java.awt.Graphics;
import java.util.ArrayList;

import gameobject.GameObject;

public class QuizView extends View {

	public QuizView(int width, int height, ArrayList<GameObject> objects) {
		super(width, height, objects);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(ArrayList<GameObject> objects) {
		// TODO Auto-generated method stub

	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}

	@Override
	public View nextView(ArrayList<GameObject> objects) {
		// TODO Auto-generated method stub
		return null;
	}

}
