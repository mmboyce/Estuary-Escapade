package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;

import controller.CodeListener;
import gameobject.GameObject;

public class EndView extends View {
	public EndView(int width, int height, ArrayList<GameObject> objects, CodeListener listener,int scoreIn) {
		super(width, height, objects, listener);
		System.out.println("Entered End View"); // TODO figure out quiz popup then delete
		Integer score = scoreIn;
		String scoreStr = "Your Score is : " + score.toString();
		
		TitlePanel Score = new TitlePanel(scoreStr,width); // This will display the title and any art
		TitleNavigation nav = new TitleNavigation(listener,width); // This holds buttons for navigation

		setLayout(new BorderLayout());
		add(Score, BorderLayout.CENTER);
		add(nav, BorderLayout.SOUTH);
		setVisible(true);
	}

	@Override
	public void update(ArrayList<GameObject> objects) {
		// Intentionally blank
	}

	@Override
	public View nextView(ArrayList<GameObject> objects) {
		return new TitleView("Estuary Escapade", getWidth(), getHeight(), super.getListener(), objects);
	}

}
