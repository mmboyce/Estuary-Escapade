package view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

import controller.CodeListener;
import gameobject.Camera;
import gameobject.GameObject;
import gameobject.Question;

/**
 * ObjectView is an abstract class that is representative of any view that 
 * draws {@link GameObject GameObjects}
 * 
 * @author Andre Green
 * @author Miguel Fuentes
 * @author Dylan Martin
 * @author Devon Pirestani
 */
public abstract class ObjectView extends View {

	HashMap<GameObject, BufferedImage> map = new HashMap<>();
	TimerImage timer;
	private boolean startFlash = false;
	private boolean stopFlash = false;
	private int xPosCamera = 0; // Where you clicked the camera at x-value
	private int yPosCamera = 0; // Where you clicked the camera at y-value
	private int expandX = 0; // distance to expand by in x direction
	private int expandY = 0; // distance to expand by in y direction
	private float alpha = 0.0f; // for opacity of camera flash the f at the end makes it so that it does not
								// have to typecast
	BufferedImage background;

	/**
	 * Constructor for the ObjectView
	 * 
	 * @see View
	 */
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
		if (this instanceof ResearchView) {
			background = createImage("images/whiteTiles.png");
		} else {
			background = createImage("images/underwater.png");
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, getWidth(), getHeight(), (ImageObserver) this);
		int xpos = 0;
		int ypos = getHeight() * 9 / 10;
		if (this instanceof EstuaryView) {
			// Renders in plants on the sand
			BufferedImage weed = createImage("images/GreenWeed.png");
			int imgHeight = getHeight() / 5;
			g.drawImage(weed, getWidth() / 4, ypos + (ypos / 20) - imgHeight, getWidth() / 10, imgHeight,
					(ImageObserver) this);
			g.drawImage(weed, getWidth() / 2, ypos + (ypos / 20) - imgHeight, getWidth() / 10, imgHeight,
					(ImageObserver) this);
			g.drawImage(weed, getWidth() / 4 * 3, ypos + (ypos / 20) - imgHeight, getWidth() / 10, imgHeight,
					(ImageObserver) this);
			// Renders in sand at the bottom of the screen
			BufferedImage sand = createImage("images/SandBlock.png");

			do {
				g.drawImage(sand, xpos, ypos, getHeight() / 10, getHeight() / 10, (ImageObserver) this);
				xpos += getHeight() / 10;
			} while (xpos < getWidth());

		}
		for (GameObject object : this.map.keySet()) {
			if (object.isVisible()) {
				g.drawImage(createImage(object.getImagePath()), object.getxPos(), object.getyPos(), object.getxSize(),
						object.getySize(), (ImageObserver) this);

				g.drawImage(createImage(object.getImagePath()), object.getxPos(), object.getyPos(), object.getxSize(),
						object.getySize(), (ImageObserver) this);
			}
		}
		timer.paint(g);
		if (startFlash || stopFlash) {
			Graphics2D g2d = (Graphics2D) g;
			// set the opacity
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));// for the fade in and out
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);// blends the
																										// existing
																										// colors of the
																										// pixels

			g2d.setColor(Color.WHITE);
			g2d.fillRect(xPosCamera - expandX, yPosCamera - expandY, 3 * expandX, 3 * expandY);
			if (startFlash) {
				alpha += 0.5f;
				expandX += getWidth() / 5;
				expandY += getHeight() / 5;
			} else if (stopFlash) {
				alpha -= 0.2f;
				expandX += getWidth() / 10;
				expandY += getHeight() / 10;
			}

			if (alpha >= 1.0f) {
				alpha = 1.0f;
				startFlash = false;
				stopFlash = true;
			} else if (alpha <= 0.0f) {
				alpha = 0.0f;
				stopFlash = false;
			}
		}
		timer.paint(g);

	}

	/**
	 * flash Sets the startFlash boolean to true and that is used to paint a
	 * flash animation
	 */
	public void flash() {
		startFlash = true;
		for (GameObject object : this.map.keySet()) {
			if (object instanceof Camera) {
				xPosCamera = object.getxPos();
				yPosCamera = object.getyPos();
			}
		}
	}

	/**
	 * Updates the game objects array
	 * 
	 * @param objects an arraylist of the game objects to be drawn
	 */
	public void update(ArrayList<GameObject> objects) {
		setObjects(objects); // Update the objects attribute
	}

	/**
	 * Reads an image from the file system and returns it
	 * as a BufferedImage, or null if not found
	 * <p> 
	 * <i>
	 * This was made static because it does not rely on this object being
	 * instantiated. Visibility was set to package so that EstuaryPopup 
	 * could access it
	 * </i>
	 * 
	 * @param imagePath The path to the image taken from the game object. 
	 */
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

	/**
	 * Sets the timer to t
	 * 
	 * @param t the timer for the game
	 */
	public void passTimer(TimerImage t) {
		timer = t;
	}

	/**
	 * When time expires durning an ObjectView you will be taken to the quiz
	 * 
	 * @param q The question object for the quiz
	 * @return The quiz with the proper question
	 */
	public QuizView timeUp(Question q) {
		return new QuizView(super.getWidth(), super.getHeight(), q, new ArrayList<GameObject>(), super.getListener());
	}

}
