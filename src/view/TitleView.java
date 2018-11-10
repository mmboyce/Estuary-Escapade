package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import controller.CodeListener;
import gameobject.GameObject;

public class TitleView extends View{

	public TitleView(int width, int height,MouseListener m, CodeListener cl) {
		super(width, height, m);
		
		TitlePanel titleArt = new TitlePanel(super.getTitle());
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

}
