package model;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controller.Code;
import controller.CodeListener;
import gameobject.Animal;
import gameobject.BlueFish;
import gameobject.Crab;
import gameobject.GameObject;
import gameobject.GoldFish;
import gameobject.GreenFish;
import gameobject.PufferFish;
import gameobject.PurpleFish;
import gameobject.RedFish;
import gameobject.Sand;
import gameobject.ZappyBoi;

public class EstuaryModel extends Model implements GameStateModel {
	// A list of all the animals the user researched
	List<Animal> researched;
	// The animal the user is currently researching
	Animal target;
	private boolean popupHappened;
	private boolean tutorialPopupHappened;
	private boolean tutorialMode;
	private final int spriteSize = this.getFrameHeight()/10;

	public EstuaryModel(int frameWidth, int frameHeight, CodeListener listener, boolean tutorialMode) {
		super(frameWidth, frameHeight, listener);
		popupHappened = false;
		tutorialPopupHappened = false;
		this.tutorialMode = tutorialMode;
		listener.codeEmitted(Code.STARTTIMER);
		researched = new ArrayList<Animal>();
		instantiateFish();
	    chooseTarget();
	}
	
	public void chooseTarget() {
		Random rand = new Random();
		target = (Animal) super.getGameObjects().get(rand.nextInt(super.getGameObjects().size()));
	}

	/*
	 * void instantiateFish
	 * 
	 * sets the target and loads all fish into the schoolOfFish
	 */
	private void instantiateFish() {
//		// Adds all the other objects to be rendered
//		int xpos = 0;
//		int ypos = getFrameHeight()*17/20;
//		do {
//			addGameObject(new Sand(xpos,ypos,1,spriteSize, spriteSize));
//			xpos += getFrameHeight()/10;
//		}while(xpos < getFrameWidth());

		
		// Adds all the fish that are in the estuary
		if (tutorialMode) {
			addGameObject(new GoldFish(this.getFrameWidth()/8, this.getFrameHeight()/6, 0, spriteSize, spriteSize));
		}
		else {
			addGameObject(new GoldFish(this.getFrameWidth()/8, this.getFrameHeight()/6, 0, spriteSize, spriteSize));
			addGameObject(new PufferFish(this.getFrameWidth()/3,this.getFrameHeight()/3,0,spriteSize,spriteSize));
			addGameObject(new Crab(this.getFrameWidth()/8,this.getFrameHeight()*9/10,0,spriteSize,spriteSize));
			addGameObject(new ZappyBoi(this.getFrameWidth()/4,this.getFrameHeight()*4/6,0,spriteSize,spriteSize));
			addGameObject(new GreenFish(this.getFrameWidth()/2,this.getFrameHeight()/4,0,spriteSize,spriteSize));
			addGameObject(new BlueFish(this.getFrameWidth() / 6,this.getFrameHeight()/5, 0, spriteSize, spriteSize));
			addGameObject(new RedFish(this.getFrameWidth()*5/6, this.getFrameHeight()/2, 0, spriteSize, spriteSize));
			addGameObject(new PurpleFish(this.getFrameWidth()*6/5, this.getFrameHeight()/3, 0, spriteSize, spriteSize));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.Model#nextModel()
	 * 
	 * Model nextModel
	 * 
	 * Returns our researchModel and removes the target fish from the school
	 * 
	 * returns: the researchModel for the fish we caught
	 */
	@Override
	public Model nextModel() {
		// sets the next model to the research model
		return new ResearchModel(super.getFrameWidth(), super.getFrameHeight(), target, this, getListener());
	}

	/*
	 * void updatePositions
	 * 
	 * moves each fish in the pattern they are expected to move
	 * 
	 */
	private void updatePositions() {
		// Iterates through every object and updates its position in the estuary model
		for (GameObject object : getGameObjects()) {
			object.update();
		}
	}

	/*
	 * void registerClick
	 * 
	 * checks where the user has clicked and checks for if they clicked the right
	 * fish
	 * 
	 * params: MouseEvent E: the MouseEvent telling us where the click occurred
	 * 
	 */
	@Override
	public void registerClick(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		Animal clicked = null;

		for (GameObject object : getGameObjects()) {
			if (object instanceof Animal) {
				if (object.clickedOn(mouseX, mouseY)) {
					clicked = (Animal) object;
					break;
				}
			}
		}

		if (clicked == target) {
			animalCaught(clicked);
		}
	}

	/*
	 * void animalCaught
	 * 
	 * Evaluates if the right animal was clicked on, if it was we go to our next
	 * model
	 * 
	 * params: Animal animal: the animal clicked on
	 * 
	 */
	private void animalCaught(Animal animal) {
		// determines that the animal clicked on is the target animal
//		if (animal.equals(target)) {
			this.target = animal;
			getListener().codeEmitted(Code.NEXT);
//		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.GameState#timeUp()
	 * 
	 * QuizModel timeUp
	 * 
	 * Runs when we've run out of time and takes us to the QuizModel regarding all
	 * the animals we've studied.
	 * 
	 * returns: The QuizModel representing everything we've researched thus far.
	 */
	public QuizModel timeUp() {
		return new QuizModel(getFrameWidth(), getFrameHeight(), researched, getListener());
	}

	/*
	 * boolean allResearched
	 * 
	 * Checks to see if all fish have been researched. If this is true we should
	 * trigger our timeUp() call in the controller.
	 * 
	 * returns: True if 0 fish remain in the school of fish, else false.
	 * 
	 */
	public boolean allResearched() {
		if (tutorialMode) {
			return 1 == researched.size();
		}
		else {
			return 8 == researched.size();
		}
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see model.Model#update()
	 * 
	 * void update
	 * 
	 * Updates all data in the model such as fish pathfinding
	 */
	public void update() {
		if(!popupHappened && tutorialPopupHappened ) {
			super.getListener().estuaryPopup(target);
			popupHappened = true;
		}
		
		if(!tutorialPopupHappened) {
			if (tutorialMode) {
				super.getListener().tutorialPopup1();
				tutorialPopupHappened = true;
		    }
		}
		
		
		updatePositions();
	}
	
	public void setPopupHappened(boolean b) {
		popupHappened = b;
	}
}
