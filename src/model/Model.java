package model;

public abstract class Model {
	int frameWidth;
	int frameHeight;
	Model nextModel; // UML calls this a String but it makes more sense to be a model
	
	public Model(int frameWidth, int frameHeight, Model nextModel) {
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		this.nextModel = nextModel;
	}
	
	public abstract Model nextModel();
}
