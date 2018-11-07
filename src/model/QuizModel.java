package model;

import java.util.Collection;

public class QuizModel extends Model {

	private Collection<String> questionPool;
	
	public Collection<String> getQuestionPool() {
		return questionPool;
	}

	public void setQuestionPool(Collection<String> questionPool) {
		this.questionPool = questionPool;
	}

	public QuizModel(int frameWidth, int frameHeight) {
		super(frameWidth, frameHeight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Model nextModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean checkAnswer(String answer) {
		// stub
		
		return false;
	}

}
