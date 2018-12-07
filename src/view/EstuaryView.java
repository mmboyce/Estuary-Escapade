package view;

import java.util.ArrayList;

import controller.CodeListener;
import gameobject.GameObject;

/**
 * Represents the Estuary environment portion of the game
 * 
 * @author Miguel Fuentes
 * @author Dylan Martin
 * @author Devon Pirestani
 * @author Andre Green
 */
public class EstuaryView extends ObjectView {

	/**
	 * Constructor for the EstuaryView
	 * 
	 * @see ObjectView
	 */
	public EstuaryView(int width, int height, ArrayList<GameObject> objects, CodeListener listener) {
		super(width, height, objects, listener);
	}

	/* (non-Javadoc)
	 * @see view.View#nextView(java.util.ArrayList)
	 */
	@Override
	public View nextView(ArrayList<GameObject> objects) {
		// Returns the next model for transition purposes
		return new ResearchView(getFrameWidth(), getFrameHeight(), objects, super.getListener());
	}

}
