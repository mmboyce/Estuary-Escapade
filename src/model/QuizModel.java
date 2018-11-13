package model;

import java.util.Collection;
import java.util.List;

import gameobject.Animal;

public class QuizModel extends Model {

	private Collection<String> questionPool;
	private List<Animal> researched;
	
	public Collection<String> getQuestionPool() {
		return questionPool;
	}

	public void setQuestionPool(Collection<String> questionPool) {
		this.questionPool = questionPool;
	}

	public QuizModel(int frameWidth, int frameHeight, List<Animal> researched) {
		super(frameWidth, frameHeight);
		
		this.researched = researched;
		
		for(Animal caught : this.researched) {
			// TODO build upon this functionality
			questionPool.add(caught.getFunFact());
		}
	}

	@Override
	public Model nextModel() {
		// TODO Auto-generated method stub
		Model model = new EndModel(super.getFrameWidth(), super.getFrameHeight());
		return model;
	}
	
	public boolean checkAnswer(String answer) {
		// stub
		
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
