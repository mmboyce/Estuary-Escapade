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
