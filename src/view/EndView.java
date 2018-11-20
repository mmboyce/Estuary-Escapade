package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;

import controller.CodeListener;
import gameobject.GameObject;

public class EndView extends View {
	public EndView(int width, int height, ArrayList<GameObject> objects, CodeListener listener) {
		super(width, height, objects, listener);
		nameOfView="EndView";
		Integer score = 12; // TODO Get this score programatically instead of hard coding it
		String scoreStr = "Your Score is : " + score.toString();
		
		TitlePanel Score = new TitlePanel(scoreStr); // This will display the title and any art
		TitleNavigation nav = new TitleNavigation(listener); // This holds buttons for navigation

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
		return new TitleView("Estuary Escipade", getWidth(), getHeight(), super.getListener(), objects);
	}

}
