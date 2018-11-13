package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

import gameobject.GameObject;

public abstract class ObjectView extends View {

	HashMap<GameObject, BufferedImage> map = new HashMap<>();

	public ObjectView(int width, int height, ArrayList<GameObject> objects) {
		super(width, height, objects);
		// TODO Auto-generated constructor stub
		for (GameObject currentObj : getObjects()) {
			BufferedImage img = createImage(currentObj.getImagePath()); // Read the image from the current game object
			map.put(currentObj, img); // Place the game object and the animation frames in the hash map as a key-value
										// pair
		}
	}

	@Override

	// void paint
	// Paints the updated game objects to the screen
	// params: Graphics g: the graphics object used for the drawImage method

	public void paint(Graphics g) {
		for (GameObject object : this.map.keySet()) {
			g.drawImage(map.get(object), object.getxPos(), object.getyPos(), (ImageObserver) this);
		}
	}

	// void update
	// Updates the game objects array
	// params: ArrayList<GameObject> objects: an arraylist of the game objects with
	// updated attributes

	public void update(ArrayList<GameObject> objects) {
		setObjects(objects); // Update the objects attribute
	}

	// BufferedImage createImage
	// Reads an image from the file system and returns it as a BufferedImage, or an
	// IOException if not found
	// params: String imagePath: the path to the image taken from the game object

	private BufferedImage createImage(String imagePath) {
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File(imagePath));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
