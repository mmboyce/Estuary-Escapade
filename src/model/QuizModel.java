package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import controller.Code;
import controller.CodeListener;
import gameobject.Animal;
import gameobject.Question;

public class QuizModel extends Model {
	// A collection of all the possible questions that can be asked on the quiz
	private ArrayList<Question> questionPool;
	// A list of the animals the player researched over the course of the game
	private List<Animal> researched;
	private Question question;

	public Question getQuestion() {
		return question;
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

		try {
			question = questionPool.get(new Random().nextInt(questionPool.size()));
		} catch (Exception e) {
			question = new Question("You Did Not Catch Anything", "You did not catch anything, but what is 2+2", "4",
					"5", "6", "1002341234");
		}
	}

	@Override
	public Model nextModel() {
		// Transition to the end screen which displays the score
		return new EndModel(super.getFrameWidth(), super.getFrameHeight(), getListener(), -1);
	}

	public Model questionAnswered(boolean questionCorrect) {
		if (questionCorrect) {
			return new EndModel(super.getFrameWidth(), super.getFrameHeight(), getListener(), questionPool.size() * 2);
		} else {
			return new EndModel(super.getFrameWidth(), super.getFrameHeight(), getListener(), questionPool.size());
		}
	}

	public boolean checkAnswer(String answer) {
		return (question.getCorrectAnswer().equals(answer));
	}
}
