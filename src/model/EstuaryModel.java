package model;

import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;

import gameobject.*;

public class EstuaryModel extends Model implements GameState {

	Collection<Animal> schoolOfFish;
	Animal target;
	
	public EstuaryModel(int frameWidth, int frameHeight) {
		super(frameWidth, frameHeight);
		Animal goldfish = new GoldFish(5,5,1);
		schoolOfFish.add(goldfish);
	}

	@Override
	public Model nextModel() {
		// TODO Auto-generated method stub
		return null;
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
		Iterator itr = schoolOfFish.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
