package model;

import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;

import controller.CodeListener;
import gameobject.GameObject;

public abstract class Model implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9220995213767240931L;
	// The size of the window
	private int frameWidth;
	private int frameHeight;
	private int time;
	private boolean timerRunning;
	// A list of all the objects in the model
	private ArrayList<GameObject> objects;
	// Listens for codes to trigger actions
	transient private CodeListener listener;

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

	// Constructor
	public Model(int frameWidth, int frameHeight, CodeListener listener) {
		this.objects = new ArrayList<GameObject>();
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		this.setListener(listener);
	}

	public ArrayList<GameObject> getGameObjects() {
		return objects;
	}

	public void addGameObject(GameObject o) {
		objects.add(o);
	}

	public abstract Model nextModel();

	public void update() {
	};

	public void registerClick(MouseEvent e) {
	}

	public CodeListener getListener() {
		return listener;
	}

	public void setListener(CodeListener listener) {
		this.listener = listener;
	}

	public Model tutorialModel() {
		return null;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public boolean isTimerRunning() {
		return timerRunning;
	}

	public void setTimerRunning(boolean timerRunning) {
		this.timerRunning = timerRunning;
	}

}
