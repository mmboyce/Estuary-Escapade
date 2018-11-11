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

	private void instantiateFish() {
		// TODO add all fish to this
		target = new GoldFish(0,0,0);
		
		schoolOfFish = new ArrayList<Animal>();
		schoolOfFish.add(new GoldFish(10, 20, 0));
		schoolOfFish.add(target);
		
	}
	
	@Override
	public Model nextModel() {
		// TODO Auto-generated method stub
		Model model = new ResearchModel(super.getFrameWidth(), super.getFrameHeight());
		return model;
	}
	
	private void updatePositions() {
		for(Animal fish : schoolOfFish) {
			fish.update();
		}
	}
	
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
	
	
	private Model animalCaught(Animal animal) {
		if(animal.equals(target)) {
			return nextModel();
		}
		
		return null;
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
