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
	private int xPosCamera = 0; // Where you clicked the camera at x-value
	private int yPosCamera = 0; //Where you clicked the camera at y-value
	private int expandX = 0; // distance to expand by in x direction
	private int expandY = 0; // distance to expand by in y direction
	private float alpha=0.0f; // for opacity of camera flash the f at the end makes it so that it does not have to typecast
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

	/**  
	 * void paint
	 * Paints the updated game objects to the screen
	 * and the effects from clicking with the tools
	 * @param g the graphics object used for the drawImage method
	 */

	@Override
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, getWidth(), getHeight(), (ImageObserver) this);
		timer.paint(g);
		for (GameObject object : this.map.keySet()) {
			if(object.isVisible()){
				g.drawImage(createImage(object.getImagePath()), object.getxPos(), object.getyPos(), object.getxSize(), object.getySize(),
						(ImageObserver) this);
			}
		}
		if (startFlash||stopFlash){
			System.out.println("flash");
			Graphics2D g2d = (Graphics2D) g;
			//set the opacity
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));//for the fade in and out
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);//blends the existing colors of the pixels

			g2d.setColor(Color.WHITE);
			g2d.fillRect(xPosCamera-expandX, yPosCamera-expandY, 3*expandX, 3*expandY);
			if (startFlash){
				alpha+=0.5f;
				expandX+=getWidth()/5;
				expandY+=getHeight()/5;
			}
			else if (stopFlash){
				alpha-=0.2f;
				expandX+=getWidth()/10;
				expandY+=getHeight()/10;
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
	 * @param imagePath: the path to the image taken from the game object this was made static because it does not rely on this object being instanciated visibility was set to package so that EstuaryPopup could access it
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

	public void passTimer(TimerImage t) {
		timer = t;
	}

	public QuizView timeUp(Question q) {
		return new QuizView(super.getWidth(), super.getHeight(), q, new ArrayList<GameObject>(), super.getListener());
	}

}
