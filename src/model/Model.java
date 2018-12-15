package model;

import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;

import controller.CodeListener;
import gameobject.GameObject;

/**
 * This is the abstract Model class which all the models extend, this includes
 * attributes that every model must have like dimmensions, time,
 * {@link GameObject}s, and {@link CodeListener}
 * 
 * @author Miguel Fuentes
 * @author W Mathieu Mimms-Boyce
 * @author Devon Pirestani
 */
public abstract class Model implements Serializable {
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

	/**
	 * @return frameWidth as int
	 */
	public int getFrameWidth() {
		return frameWidth;
	}

	/**
	 * This sets the width in the model
	 * 
	 * @param frameWidth width of the screen
	 */
	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}

	/**
	 * @return frameHeight as int
	 */
	public int getFrameHeight() {
		return frameHeight;
	}

	/**
	 * This sets the height in the model
	 * 
	 * @param frameHeight setter
	 */
	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}

	/**
	 * All of the subclasses call this constructor to set the base attributes
	 * 
	 * @param frameWidth  set screen width
	 * @param frameHeight set screen height
	 * @param listener    set codelistener
	 */
	public Model(int frameWidth, int frameHeight, CodeListener listener) {
		this.objects = new ArrayList<GameObject>();
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		this.setListener(listener);
	}

	/**
	 * @return GameObjects, an ArrayList of {@link GameObject}
	 */
	public ArrayList<GameObject> getGameObjects() {
		return objects;
	}

	/**
	 * @param o adds the {@link GameObject} to the {@link ArrayList}
	 */
	public void addGameObject(GameObject o) {
		objects.add(o);
	}

	/**
	 * This is used to transition from model to model
	 * 
	 * @return Model next model in the game
	 */
	public abstract Model nextModel();

	/**
	 * This is intentionally empty because the default behavior is to not do
	 * anything
	 */
	public abstract void update();

	/**
	 * This takes a {@link MouseEvent}, this is intentionally empty because not
	 * every model will have to handle clicks
	 * 
	 * @param clickX
	 * @param clickY
	 */
	public abstract void registerClick(int clickX, int clickY);

	/**
	 * @return listener
	 */
	public CodeListener getListener() {
		return listener;
	}

	/**
	 * @param listener setter
	 */
	public void setListener(CodeListener listener) {
		this.listener = listener;
	}

	/**
	 * This will transition from model to model in tutorial mode
	 * 
	 * @return next Model in the game in tutorial mode
	 */
	public Model tutorialModel() {
		return null;
	}

	/**
	 * @return int time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * This sets the time
	 * 
	 * @param time
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * @return boolean timerRunning
	 */
	public boolean isTimerRunning() {
		return timerRunning;
	}

	/**
	 * This sets if the timer is running
	 * 
	 * @param timerRunning
	 */
	public void setTimerRunning(boolean timerRunning) {
		this.timerRunning = timerRunning;
	}

}
