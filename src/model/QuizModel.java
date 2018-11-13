package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import controller.CodeListener;
import gameobject.Animal;
import gameobject.Question;

public class QuizModel extends Model {
	// A collection of all the possible questions that can be asked on the quiz
	private ArrayList<Question> questionPool;
	// A list of the animals the player researched over the course of the game
	private List<Animal> researched;
	
	public Question getQuestion() {
		return questionPool.get(new Random().nextInt(questionPool.size()));
	}

	public Collection<Question> getQuestionPool() {
		return questionPool;
	}

	public void setQuestionPool(ArrayList<Question> questionPool) {
		this.questionPool = questionPool;
	}

	// Constructor
	public QuizModel(int frameWidth, int frameHeight, List<Animal> researched, CodeListener listener) {
		super(frameWidth, frameHeight, listener);
		this.researched = researched;
		questionPool = new ArrayList<Question>();

		// Adds all the questions for the animals researched
		for (Animal caught : this.researched) {
			questionPool.add(caught.getQuestion());
		}
	}

	@Override
	public Model nextModel() {
		return new EndModel(super.getFrameWidth(), super.getFrameHeight(), getListener());
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
