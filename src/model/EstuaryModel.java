package model;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import gameobject.Animal;
import gameobject.GoldFish;
import java.util.List;

import controller.Code;
import controller.CodeListener;
import gameobject.*;
import model.QuizModel;

public class EstuaryModel extends Model implements GameState {

	List<Animal> researched;
	Animal target;
	
	public EstuaryModel(int frameWidth, int frameHeight, CodeListener listener) {
		super(frameWidth, frameHeight,listener);
		instantiateFish();
	}

	/* void instantiateFish
	 * 
	 * sets the target and loads all fish into the schoolOfFish
	 */
	private void instantiateFish() {
		// TODO add all fish to this
		target = new GoldFish(0,0,0);
		
		researched = new ArrayList<Animal>();
		
		//addGameObject(new GoldFish(10, 20, 0)); Wanted only one animal for debugging
		addGameObject(target);

	}
	
	/*
	 * (non-Javadoc)
	 * @see model.Model#nextModel()
	 * 
	 * Model nextModel
	 * 
	 * Returns our researchModel and removes the target fish from the school
	 * 
	 * returns:
	 *  the researchModel for the fish we caught
	 */
	@Override
	public Model nextModel() {
		// TODO Auto-generated method stub
		Model model = new ResearchModel(super.getFrameWidth(), super.getFrameHeight(), target, this, getListener());
		
		researched.add(target);		
		
		return model;
	}
	
	/* void updatePositions
	 * 
	 * moves each fish in the pattern they are expected to move
	 * 
	 */
	private void updatePositions() {
		for(GameObject object : getGameObjects()) {
			object.update();
		}
	}
	
	/* void registerClick
	 * 
	 * checks where the user has clicked and checks for if they clicked the right fish
	 * 
	 * params: 
	 * 	MouseEvent E: the MouseEvent telling us where the click occurred
	 * 
	 */
	@Override
	public void registerClick(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		Animal clicked = null;
		
		int xLeftBound;
		int xRightBound;
		int yUpBound;
		int yDownBound;
		
		for(GameObject fish : getGameObjects()) {
			if(fish instanceof Animal) {
				xLeftBound = fish.getxPos(); //TODO figure out values for fish's size
				xRightBound = fish.getxPos() + 500;
				
				yUpBound = fish.getyPos();
				yDownBound = fish.getyPos() + 500;
				
				if((mouseX >= xLeftBound && mouseX <= xRightBound)
						&& (mouseY >= yUpBound && mouseY <= yDownBound)) {
					clicked = (Animal)fish;
					System.out.println("Clicked on the fish");
					break;
				}
			}
		}
		
		if(clicked != null) {
			animalCaught(clicked);
		}
		System.out.println("Mouse Clicked at x: " + mouseX + " y: " + mouseY);
	}
	
	/* void animalCaught
	 * 
	 * Evaluates if the right animal was clicked on, if it was we go to
	 * our next model
	 * 
	 * params:
	 * 	Animal animal: the animal clicked on
	 * 
	 */
	private void animalCaught(Animal animal) {
		if(animal.equals(target)) {
			getListener().codeEmitted(Code.NEXT);
		}
		else {
		// TODO figure out what to do if it's the wrong animal
		}
	}

	/*
	 * (non-Javadoc)
	 * @see model.GameState#timeUp()
	 * 
	 * QuizModel timeUp
	 * 
	 * Runs when we've run out of time and takes us to the QuizModel regarding
	 * 	all the animals we've studied.
	 * 
	 * returns:
	 * 	The QuizModel representing everything we've researched thus far.
	 */
	public QuizModel timeUp() {
		return new QuizModel(getFrameWidth(), getFrameHeight(), researched, getListener());
	}
	
	/* boolean allResearched
	 * 
	 * Checks to see if all fish have been researched.
	 * If this is true we should trigger our timeUp() call in the controller.
	 * 
	 * returns:
	 * 	True if 0 fish remain in the school of fish, else false.
	 * 
	 */
	public boolean allResearched() {
		int count = 0;
		for (Object o: getGameObjects()) {
			if(o instanceof Animal) {
				count++;
			}
		};
		return count == researched.size();
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see model.Model#update()
	 * 
	 * void update
	 * 
	 * Updates all data in the model such as fish pathfinding
	 */
	public void update() {
		// TODO complete this		
		updatePositions();
	}
}
