package model;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;

import gameobject.Animal;
import gameobject.GoldFish;

public class EstuaryModel extends Model implements GameState {

	Collection<Animal> schoolOfFish;
	Animal target;
	
	public EstuaryModel(int frameWidth, int frameHeight) {
		super(frameWidth, frameHeight);
		schoolOfFish = new ArrayList<Animal>();
		Animal goldfish = new GoldFish(5,5,1);
		schoolOfFish.add(goldfish);
	}

	@Override
	public Model nextModel() {
		// TODO Auto-generated method stub
		Model model = new ResearchModel(super.getFrameWidth(), super.getFrameHeight());
		return model;
	}
	
	private void updatePosition() {
		// TODO Auto-generated method stub

	}
	
	private void registerClick(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	private void animalCaught() {
		// TODO Auto-generated method stub

	}

	public int timeUp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
