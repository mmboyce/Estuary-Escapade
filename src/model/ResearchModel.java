package model;

import java.awt.event.MouseEvent;

import controller.CodeListener;
import gameobject.Animal;
import gameobject.Camera;

public class ResearchModel extends Model implements GameState {

	// Used to determine if the animal is fully researched
	private boolean isWeighed;
	private boolean isMeasured;
	private boolean isPhotographed;

	// Different research tools
	private Camera camera;
	private Animal caught;
	// the EstuaryModel that gave us this ResearchModel
	private EstuaryModel goBack;

	public boolean isWeighed() {
		return isWeighed;
	}

	public void setWeighed(boolean isWeighed) {
		this.isWeighed = isWeighed;
	}

	public boolean isMeasured() {
		return isMeasured;
	}

	public void setMeasured(boolean isMeasured) {
		this.isMeasured = isMeasured;
	}

	public boolean isPhotographed() {
		return isPhotographed;
	}

	public void setPhotographed(boolean isPhotographed) {
		this.isPhotographed = isPhotographed;
	}

	// Constructor
	public ResearchModel(int frameWidth, int frameHeight, Animal caught, EstuaryModel goBack, CodeListener listener) {
		super(frameWidth, frameHeight, listener);
		this.caught = caught;
		this.goBack = goBack;
	}

	@Override
	public Model nextModel() {
		// TODO Auto-generated method stub
		return this.goBack;
	}

	private void startDrag(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private void releaseDrag(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private void measuring() {
		// TODO Auto-generated method stub

	}

	private void photographing() {
		// TODO Auto-generated method stub

	}

	private void weighing() {
		// TODO Auto-generated method stub

	}

	@Override
	public QuizModel timeUp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
