package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.CodeListener;
import gameobject.GameObject;

public abstract class View extends JPanel {
	private int frameWidth;
	private int frameHeight;
	private ArrayList<GameObject> objects;
	private CodeListener listener;

	final static Color SEA_BLUE = Color.decode("#006994");

	public View(int width, int height, ArrayList<GameObject> objects, CodeListener listener) {
		frameWidth = width;
		frameHeight = height;
		this.setListener(listener);
		this.objects = objects;

		setSize(frameWidth, frameHeight);
	}

	// TODO consider not making this abstract and defining it as an epmty function
	// because most of the views leave this blank
	public abstract void update(ArrayList<GameObject> objects);

	public abstract View nextView(ArrayList<GameObject> objects);

	public void flash() {
		// left blank purposefully
	}

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

	public ArrayList<GameObject> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<GameObject> objects) {
		this.objects = objects;
	}

	public CodeListener getListener() {
		return listener;
	}

	public void setListener(CodeListener listener) {
		this.listener = listener;
	}

}
