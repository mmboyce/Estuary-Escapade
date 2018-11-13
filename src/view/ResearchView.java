package view;

import java.awt.Graphics;
import java.util.ArrayList;

import gameobject.GameObject;

public class ResearchView extends ObjectView {

	public ResearchView(int width, int height, ArrayList<GameObject> objects) {
		super(width, height, objects);
	}

	@Override
	public View nextView(ArrayList<GameObject> objects) {
		// Returns the next model for transition purposes
		return new EstuaryView(getWidth(), getHeight(), objects);
	}
}
