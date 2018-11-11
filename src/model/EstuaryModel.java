package model;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import gameobject.*;

public class EstuaryModel extends Model implements GameState {

	Collection<Animal> schoolOfFish;
	Animal target;
	
	public EstuaryModel(int frameWidth, int frameHeight) {
		super(frameWidth, frameHeight);
		instantiateFish();
	}

	/* void instantiateFish
	 * 
	 * sets the target and loads all fish into the schoolOfFish
	 */
	private void instantiateFish() {
		// TODO add all fish to this
		target = new GoldFish(0,0,0);
		
		schoolOfFish = new ArrayList<Animal>();
		schoolOfFish.add(new GoldFish(10, 20, 0));
		schoolOfFish.add(target);
		
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
		Model model = new ResearchModel(super.getFrameWidth(), super.getFrameHeight(), target);
		
		schoolOfFish.remove(target);
		
		return model;
	}
	
	/* void updatePositions
	 * 
	 * moves each fish in the pattern they are expected to move
	 * 
	 */
	private void updatePositions() {
		for(Animal fish : schoolOfFish) {
			fish.update();
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
	public void registerClick(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		Animal clicked = null;
		
		int xLeftBound;
		int xRightBound;
		int yUpBound;
		int yDownBound;
		
		for(Animal fish : schoolOfFish) {
			xLeftBound = fish.getxPos() - 30; //TODO figure out values for fish's size
			xRightBound = fish.getxPos() + 30;
			
			yUpBound = fish.getyPos() - 30;
			yDownBound = fish.getyPos() + 30;
			
			if((mouseX >= xLeftBound && mouseX <= xRightBound)
					&& (mouseY >= yUpBound && mouseY <= yDownBound)) {
				clicked = fish;
				break;
			}
		}
		
		if(clicked != null) {
			animalCaught(clicked);
		}
		
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
			nextModel();
		}
		else {
		// TODO figure out what to do if it's the wrong animal
		}
	}

	
	public int timeUp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update() {
		// TODO complete this
		updatePositions();
	}

}
