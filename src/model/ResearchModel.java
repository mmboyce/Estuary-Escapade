package model;

import java.awt.event.MouseEvent;

import gameobject.*;

public class ResearchModel extends Model implements GameState {

	private boolean isWeighed;
	private boolean isMeasured;
	private boolean isPhotographed;
	private Camera camera;
	
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

	public ResearchModel(int frameWidth, int frameHeight) {
		super(frameWidth, frameHeight);
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
