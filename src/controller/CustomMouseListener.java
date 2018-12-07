package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;

import model.Model;
import model.ResearchModel;

/**
 * The CustomMouseListener helps the Controller modify the model based on where
 * the player clicks.
 * 
 * @author Miguel Fuentes
 */
public class CustomMouseListener implements MouseListener, MouseMotionListener, Serializable {

	private Model model;

	/**
	 * Default Constructor
	 * 
	 * @param m The model the Listener is Listening to
	 */
	public CustomMouseListener(Model m) {
		model = m;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Intentionally empty
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// Intentionally empty
	}

	/**
	 * @return The model the Listener is listening to
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * @param model The model to switch Listening to
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// Intentionally empty
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// Intentionally empty
	}

	@Override
	public void mousePressed(MouseEvent e) {
		model.registerClick(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		model.registerClick(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (model instanceof ResearchModel) {
			((ResearchModel) model).mouseMoved(e.getX(), e.getY());
		}
	}

}
