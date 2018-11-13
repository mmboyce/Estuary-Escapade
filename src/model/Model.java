package model;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import controller.CodeListener;
import gameobject.GameObject;

public abstract class Model {
	private int frameWidth;
	private int frameHeight;
	private ArrayList<GameObject> objects;
	private CodeListener listener;
	
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

	public Model(int frameWidth, int frameHeight,CodeListener listener) {
		this.objects = new ArrayList<GameObject>();
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		this.setListener(listener);
	}
	
	public ArrayList<GameObject> getGameObjects(){
		return objects;
	}
	
	public void addGameObject(GameObject o) {
		objects.add(o);
	}
	
	public abstract Model nextModel();

	public abstract void update();

	public void registerClick(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public CodeListener getListener() {
		return listener;
	}

	public void setListener(CodeListener listener) {
		this.listener = listener;
	}

}
