package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;

import model.Model;
import model.ResearchModel;

public class CustomMouseListener implements MouseListener, MouseMotionListener, Serializable {

	private Model model;

	public CustomMouseListener(Model m) {
		model = m;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		model.registerClick(e);
	}

	public void mouseMoved(MouseEvent e) {
		if (model instanceof ResearchModel) {
			((ResearchModel) model).mouseMoved(e.getX(), e.getY());
		}

	}

	public Model getModel() {
		return model;
	}

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
	public void mousePressed(MouseEvent arg0) {
		// Intentionally empty
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// Intentionally empty
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// Intentionally empty
	}

}
