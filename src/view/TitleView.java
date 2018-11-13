package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;

import controller.CodeListener;
import gameobject.GameObject;

public class TitleView extends View{

	public TitleView(String title, int width, int height, CodeListener cl) {
		super(width, height);

		TitlePanel titleArt = new TitlePanel(title);
		TitleNavigation nav = new TitleNavigation(cl);
		
		setLayout(new BorderLayout());
		add(titleArt,BorderLayout.CENTER);
		add(nav,BorderLayout.SOUTH);
		setVisible(true);
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
		return new EstuaryView(super.getWidth(), super.getHeight(), objects);
	}

}
