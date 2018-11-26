package model;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import controller.Code;
import controller.CodeListener;
import gameobject.Animal;
import gameobject.Crab;
import gameobject.GameObject;
import gameobject.GoldFish;
import gameobject.GreenFish;
import gameobject.PufferFish;
import gameobject.ZappyBoi;

public class EstuaryModel extends Model implements GameStateModel {
	// A list of all the animals the user researched
	List<Animal> researched;
	// The animal the user is currently researching
	Animal target;

	public EstuaryModel(int frameWidth, int frameHeight, CodeListener listener) {
		super(frameWidth, frameHeight, listener);
		listener.codeEmitted(Code.STARTTIMER);
		researched = new ArrayList<Animal>();
		instantiateFish();
	}

	/*
	 * void instantiateFish
	 * 
	 * sets the target and loads all fish into the schoolOfFish
	 */
	private void instantiateFish() {
		// Adds all the fish that are in the estuary
		target = new GoldFish(0, 0, 0, 100, 100);
		addGameObject(target);
		target = new PufferFish(600,400,0,100,100);
		addGameObject(target);
		target = new Crab(200,800,0,100,100);
		addGameObject(target);
		target = new ZappyBoi(400,600,0,100,100);
		addGameObject(target);
		target = new GreenFish(700,300,0,100,100);
		addGameObject(target);
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
					//System.out.println("Clicked on the fish");
					break;
				}
			}
		}

		if (clicked != null) {
			animalCaught(clicked);
		}
		//System.out.println("Mouse Clicked at x: " + mouseX + " y: " + mouseY); Print used for debugging
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
		if (animal.equals(target)) {
			getListener().codeEmitted(Code.NEXT);
		}
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
		// TODO we should check this somewhere currently we never check this
		int count = 0;
		for (Object o : getGameObjects()) {
			if (o instanceof Animal) {
				count++;
			}
		}
		return count == researched.size();
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
		// TODO decide if this is too redundant
		updatePositions();
	}
}
