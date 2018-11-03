package model;

import java.awt.event.MouseEvent;
import java.util.Collection;
import gameobject.*;

public class EstuaryModel extends Model {

	Collection<Animal> schoolOfFish;
	Animal target;
	
	public EstuaryModel(int frameWidth, int frameHeight, Model nextModel) {
		super(frameWidth, frameHeight, nextModel);
		// TODO Auto-generated constructor stub
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

}
