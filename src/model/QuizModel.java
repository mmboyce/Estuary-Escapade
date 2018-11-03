package model;

import java.util.Collection;

public class QuizModel extends Model {

	Collection questionPool;
	
	public QuizModel(int frameWidth, int frameHeight, Model nextModel) {
		super(frameWidth, frameHeight, nextModel);
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
