package view;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import gameobject.Animal;
import gameobject.GameObject;

public class EstuaryView extends View {
	
	HashMap<GameObject, BufferedImage> map = new HashMap<>();
	ArrayList<GameObject> objects;
	
	// void EstuaryView (constructor)
	// constructs the estuaryview by populating an arraylist with game objects and then iterating over it to extract the images for animation
	// params:
	//     int width: width of the view window
	//     int height: height of the view window
	//     MouseListener m: mouse listener to verify clicks 
	//     ArrayList<GameObject> objects: an arraylist of game objects, mostly estuary animals, to load the images.

	public EstuaryView(int width, int height, ArrayList<GameObject> objects) {
		super(width, height);
		this.objects = objects;
		
		for(GameObject currentObj : objects) {
			System.out.println(currentObj);
			BufferedImage img = createImage(currentObj.getImagePath()); // Read the image from the current game object
	    	map.put(currentObj, img); // Place the game object and the animation frames in the hash map as a key-value pair
		}
	}

	@Override
	
	// void paint
	// Paints the updated game objects to the screen
	// params: Graphics g: the graphics object used for the drawImage method

	
	public void paint(Graphics g) {
		for(GameObject object : this.map.keySet()) {
			g.drawImage(map.get(object), object.getxPos(), object.getyPos(),(ImageObserver)this);
		}
	}
	
	// void update
	// Updates the game objects array
	// params: ArrayList<GameObject> objects: an arraylist of the game objects with updated attributes
	
	public void update(ArrayList<GameObject> objects) {
		this.objects = objects; // Update the objects attribute
		this.repaint(); // Call paint
	}
	
	// BufferedImage createImage
	// Reads an image from the file system and returns it as a BufferedImage, or an IOException if not found
	// params: String imagePath: the path to the image taken from the game object
  
    private BufferedImage createImage(String imagePath){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File(imagePath));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }

	@Override
	public View nextView(ArrayList<GameObject> objects) {
		// TODO Auto-generated method stub
		return null;
	}}
