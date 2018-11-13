package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;

import controller.CodeListener;
import gameobject.GameObject;

public class TitleView extends View {

	public TitleView(String title, int width, int height, CodeListener listener, ArrayList<GameObject> objects) {
		super(width, height, objects,listener);

		TitlePanel titleArt = new TitlePanel(title); // This will display the title and any art
		TitleNavigation nav = new TitleNavigation(listener); // This holds buttons for navigation

		setLayout(new BorderLayout());
		add(titleArt, BorderLayout.CENTER);
		add(nav, BorderLayout.SOUTH);
		setVisible(true);
	}

	@Override
	public void update(ArrayList<GameObject> objects) {

	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}

	@Override
	public View nextView(ArrayList<GameObject> objects) {
		// TODO Auto-generated method stub
		return new EstuaryView(getWidth(), getHeight(), objects, super.getListener());
	}

}
