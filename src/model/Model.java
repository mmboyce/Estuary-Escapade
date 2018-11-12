package model;

import java.util.ArrayList;

import gameobject.GameObject;

public abstract class Model {
	private int frameWidth;
	private int frameHeight;
	private ArrayList<GameObject> objects;
	
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

	public Model(int frameWidth, int frameHeight) {
		this.objects = new ArrayList<GameObject>();
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
	}
	
	public ArrayList<GameObject> getGameObjects(){
		return objects;
	}
	
	public abstract Model nextModel();

	public abstract void update();

}
