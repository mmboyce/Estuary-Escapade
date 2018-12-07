package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.CodeListener;
import gameobject.GameObject;

/**
 * This is the abstract View class which all the views extend, this includes
 * attributes that every view must have like dimmensions, time,
 * {@link GameObject GameObjects}, and a {@link CodeListener}.
 * 
 * @author w Mathieu Mimms-Boyce
 * @author Andre Green
 * @author Devon Pirestani
 * @author Miguel Fuentes
 */
public abstract class View extends JPanel {
	private int frameWidth;
	private int frameHeight;
	private ArrayList<GameObject> objects;
	private CodeListener listener;

	final static Color SEA_BLUE = Color.decode("#006994");

	/**
	 * Default constructor for View
	 * 
	 * @param width set screen width
	 * @param height set screen height
	 * @param objects set the list of GameObjects
	 * @param listener set CodeListener
	 */
	public View(int width, int height, ArrayList<GameObject> objects, CodeListener listener) {
		frameWidth = width;
		frameHeight = height;
		this.setListener(listener);
		this.objects = objects;

		setSize(frameWidth, frameHeight);
	}

	/**
	 * This method will be used to get the view that follows the current one.
	 * 
	 * @param objects
	 * @return The view that comes next
	 */
	public abstract View nextView(ArrayList<GameObject> objects);

	/**
	 * @return The width of the frame
	 */
	public int getFrameWidth() {
		return frameWidth;
	}

	/**
	 * @param frameWidth The width to set the frame to
	 */
	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}

	/**
	 * @return The height of the frame
	 */
	public int getFrameHeight() {
		return frameHeight;
	}

	/**
	 * @param frameHeight The height to set the frame to.
	 */
	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}

	/**
	 * @return The objects in the view
	 */
	public ArrayList<GameObject> getObjects() {
		return objects;
	}

	/**
	 * @param objects The objects to assign
	 */
	public void setObjects(ArrayList<GameObject> objects) {
		this.objects = objects;
	}

	/**
	 * @return The CodeListener of the view
	 */
	public CodeListener getListener() {
		return listener;
	}

	/**
	 * @param listener The listener to reassign to
	 */
	public void setListener(CodeListener listener) {
		this.listener = listener;
	}

}
