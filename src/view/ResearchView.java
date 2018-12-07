package view;

import java.util.ArrayList;

import controller.CodeListener;
import gameobject.GameObject;

/**
 * The view for the Research screen
 * 
 * @author Miguel Fuentes
 * @author Andre Green
 */
public class ResearchView extends ObjectView {

	/**
	 * Construtor for the ResearchView
	 * 
	 * @see ObjectView
	 */
	public ResearchView(int width, int height, ArrayList<GameObject> objects, CodeListener listener) {
		super(width, height, objects, listener);
	}

	/* (non-Javadoc)
	 * @see view.View#nextView(java.util.ArrayList)
	 */
	@Override
	public View nextView(ArrayList<GameObject> objects) {
		// Returns the next model for transition purposes
		return new EstuaryView(getWidth(), getHeight(), objects, super.getListener());
	}

}
