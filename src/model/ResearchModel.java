package model;

import java.awt.event.MouseEvent;

import gameobject.*;

public class ResearchModel extends Model implements GameState {

	// uml says doneWeighing etc. but boolean conventions say is wouldbe better
	boolean isWeighed;
	boolean isMeasured;
	boolean isPhotographed;
	Camera camera;
	Ruler ruler;
	Scale scale;
	
	public ResearchModel(int frameWidth, int frameHeight, Model nextModel) {
		super(frameWidth, frameHeight, nextModel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Model nextModel() {
		// TODO Auto-generated method stub
		return null;
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
	public int timeUp() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
