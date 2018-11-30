package view;

import java.awt.Graphics;
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

import java.awt.Graphics2D;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.RenderingHints;

public abstract class ObjectView extends View {

	HashMap<GameObject, BufferedImage> map = new HashMap<>();
	TimerImage timer;
	private boolean startFlash=false;
	private boolean stopFlash=false;
	private int xPosCamera = 0;
	private int yPosCamera = 0;
	private float alpha=0.0f; // for opacity of camera flash the f at the end makes it so that it does not have to typecast

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
	}

	/**  
	 * void paint
	 * Paints the updated game objects to the screen
	 * @param g the graphics object used for the drawImage method
	 */

	@Override
	public void paint(Graphics g) {
		g.drawImage(createImage("images/underwater.png"), 0, 0, getWidth(), getHeight(), (ImageObserver) this);
		
		for (GameObject object : this.map.keySet()) {
			
			g.drawImage(createImage(object.getImagePath()), object.getxPos(), object.getyPos(), object.getxSize(), object.getySize(),
					(ImageObserver) this);

		}
		if (startFlash||stopFlash){
			System.out.println("flash");
			Graphics2D g2d = (Graphics2D) g;
			//set the opacity
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));//for the fade in and out
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);//blends the existing colors of the pixels

			g2d.setColor(Color.RED);
			g2d.fillRect(xPosCamera, yPosCamera, 100, 100);
			if (startFlash){
				alpha+=0.5f;
			}
			else if (stopFlash){
				alpha-=0.05f;
			}
			
			if(alpha>=1.0f){
				alpha = 1.0f;
				startFlash = false;
				stopFlash = true;
			}
			else if(alpha<=0.0f){
				alpha=0.0f;
				stopFlash=false;
			}		
		}
		//timer.paint(g);
	}
	/**
	 * void flash
	 * Sets the startFlash boolean to true and that is used to paint a flash animation
	 * @return void
	 */
	public void flash(){
		startFlash=true;
		for (GameObject object : this.map.keySet()) {
			if(object instanceof Camera){
				xPosCamera = object.getxPos();
				yPosCamera = object.getyPos();
			}
		}
	}

	/**
	 * void update
	 * Updates the game objects array
	 * @param objects an arraylist of the game objects with updated attributes
	 */ 

	public void update(ArrayList<GameObject> objects) {
		setObjects(objects); // Update the objects attribute
	}

	/** BufferedImage createImage 
	 * Reads an image from the file system and returns it as a BufferedImage, or an IOException if not found
	 * @param imagePath: the path to the image taken from the game object
	 */ 

	private BufferedImage createImage(String imagePath) {
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
