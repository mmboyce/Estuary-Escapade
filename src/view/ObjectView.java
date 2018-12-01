package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;

import controller.CodeListener;
import gameobject.GameObject;
import gameobject.Question;

public abstract class ObjectView extends View {

	HashMap<GameObject, BufferedImage> map = new HashMap<>();
	TimerImage timer;
	BufferedImage background;

	public ObjectView(int width, int height, ArrayList<GameObject> objects, CodeListener listener) {
		super(width, height, objects, listener);
		this.setBackground(View.SEA_BLUE);

		for (GameObject currentObj : getObjects()) {
			// Read the image from the current game object
			BufferedImage img = createImage(currentObj.getImagePath());
			// Place the game object and the animation frames in the hash map as a key-value
			// pair
			map.put(currentObj, img);
		}
		background = createImage("images/underwater.png");
	}

	// void paint
	// Paints the updated game objects to the screen
	// params: Graphics g: the graphics object used for the drawImage method

	@Override
	public void paint(Graphics g) {

		g.drawImage(createImage("images/underwater.png"), 0, 0, getWidth(), getHeight(), (ImageObserver) this);
		// Start of experimental code
		int xpos = 0;
		int ypos = getHeight()*9/10;
		// Renders in plants on the sand
		BufferedImage weed = createImage("images/GreenWeed.png");
		int imgHeight = getHeight()/5;
		g.drawImage(weed, getWidth()/4, ypos + (ypos / 20) - imgHeight, getWidth() / 10, imgHeight,
				(ImageObserver) this);
		g.drawImage(weed, getWidth()/2, ypos + (ypos / 20) - imgHeight, getWidth() / 10, imgHeight,
				(ImageObserver) this);
		g.drawImage(weed, getWidth()/4*3, ypos + (ypos / 20) - imgHeight, getWidth() / 10, imgHeight,
				(ImageObserver) this);
		// Renders in sand at the bottom of the screen
		BufferedImage sand = createImage("images/SandBlock.png");
		
		do {
			g.drawImage(sand, xpos, ypos, getHeight() / 10, getHeight() / 10, (ImageObserver) this);
			xpos += getHeight() / 10;
		} while (xpos < getWidth());

		// End of experimental code
		for (GameObject object : this.map.keySet()) {

			g.drawImage(createImage(object.getImagePath()), object.getxPos(), object.getyPos(), object.getxSize(),
					object.getySize(), (ImageObserver) this);


			g.drawImage(createImage(object.getImagePath()), object.getxPos(), object.getyPos(), object.getxSize(),
					object.getySize(), (ImageObserver) this);
		}

		try {
			timer.paint(g);
		}
		catch (Exception e) {};

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
	// this was made static because it does not rely on this object being instanciated
	// visibility was set to package so that EstuaryPopup could access it

	static BufferedImage createImage(String imagePath) {
		BufferedImage bufferedImage;
		try {
			// Try to read the file
			bufferedImage = ImageIO.read(new File(imagePath));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void passTimer(TimerImage t) {
		timer = t;
	}

	public QuizView timeUp(Question q) {
		return new QuizView(super.getWidth(), super.getHeight(), q, new ArrayList<GameObject>(), super.getListener());
	}

}
