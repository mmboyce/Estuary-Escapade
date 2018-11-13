package model;

import java.util.Collection;
import java.util.List;

import controller.CodeListener;
import gameobject.Animal;

public class QuizModel extends Model {
	// A collection of all the possible questions that can be asked on the quiz
	private Collection<String> questionPool;
	// A list of the animals the player researched over the course of the game
	private List<Animal> researched;

	public Collection<String> getQuestionPool() {
		return questionPool;
	}

	public void setQuestionPool(Collection<String> questionPool) {
		this.questionPool = questionPool;
	}

	// Constructor
	public QuizModel(int frameWidth, int frameHeight, List<Animal> researched, CodeListener listener) {
		super(frameWidth, frameHeight, listener);

		this.researched = researched;

		// Adds all the questions for the animals researched
		for (Animal caught : this.researched) {
			// TODO build upon this functionality
			questionPool.add(caught.getFunFact());
		}
	}

	@Override
	public Model nextModel() {

		Model model = new EndModel(super.getFrameWidth(), super.getFrameHeight(), getListener());
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
