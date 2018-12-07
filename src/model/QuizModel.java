package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import controller.CodeListener;
import gameobject.Animal;
import gameobject.Question;

/**
 * This Model makes an {@link ArrayList} of {@link Question}s from the animals
 * that were researched and picks one to ask the player
 * 
 * @author Miguel Fuentes
 * @author W Mathieu Mimms-Boyce
 * @author Andre Green
 */
public class QuizModel extends Model {
	private static final long serialVersionUID = -6748182971185109149L;
	// A collection of all the possible questions that can be asked on the quiz
	private ArrayList<Question> questionPool;
	// A list of the animals the player researched over the course of the game
	private List<Animal> researched;
	private Question question;

	/**
	 * This returns the question that we ask the player
	 * 
	 * @return question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @return questionPool
	 */
	public Collection<Question> getQuestionPool() {
		return questionPool;
	}

	/**
	 * This sets {@link questionPool}
	 * 
	 * @param questionPool
	 */
	public void setQuestionPool(ArrayList<Question> questionPool) {
		this.questionPool = questionPool;
	}

	/**
	 * This calls the super class constructor, makes the question pool, picks a
	 * question or creates a scap question if you did not catch any animals
	 * 
	 * @param frameWidth  width of screen
	 * @param frameHeight height of screen
	 * @param researched  list of animals researched
	 * @param listener    codelistener
	 */
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

	/**
	 * This should not be called but if something goes wrong and it is, you will end
	 * up with a score of -1
	 */
	@Override
	public Model nextModel() {
		// Transition to the end screen which displays the score
		return new EndModel(super.getFrameWidth(), super.getFrameHeight(), getListener(), -1, false);
	}

	/**
	 * This is how to transition out of this model, the {@link EndModel} that is
	 * created will differ if the question was correct or incorrect
	 * 
	 * @param questionCorrect
	 * @return endModel
	 */
	public Model questionAnswered(boolean questionCorrect) {
		if (questionCorrect) {
			return new EndModel(super.getFrameWidth(), super.getFrameHeight(), getListener(), questionPool.size() * 2,
					true);
		} else {
			return new EndModel(super.getFrameWidth(), super.getFrameHeight(), getListener(), questionPool.size(),
					false);
		}
	}

	/**
	 * This will check if the answer chosen was correct or not
	 * 
	 * @param answer
	 * @return answerCorrect
	 */
	public boolean checkAnswer(String answer) {
		return (question.getCorrectAnswer().equals(answer));
	}
}
