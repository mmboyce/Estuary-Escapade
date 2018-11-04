package model;

public abstract class Model {
	private int frameWidth;
	private int frameHeight;
	private Model nextModel; // UML calls this a String but it makes more sense to be a model
	
	public int getFrameWidth() {
		return frameWidth;
	}

	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}

	public int getFrameHeight() {
		return frameHeight;
	}

	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}

	public Model getNextModel() {
		return nextModel;
	}

	public void setNextModel(Model nextModel) {
		this.nextModel = nextModel;
	}

	public Model(int frameWidth, int frameHeight, Model nextModel) {
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		this.nextModel = nextModel;
	}
	
	public abstract Model nextModel();
}
