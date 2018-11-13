package view;

import java.util.ArrayList;

import controller.CodeListener;
import gameobject.GameObject;

public class ResearchView extends ObjectView {

	public ResearchView(int width, int height, ArrayList<GameObject> objects, CodeListener listener) {
		super(width, height, objects,listener);
	}

	@Override
	public View nextView(ArrayList<GameObject> objects) {
		// Returns the next model for transition purposes
		return new EstuaryView(getWidth(), getHeight(), objects, super.getListener());
	}
}
